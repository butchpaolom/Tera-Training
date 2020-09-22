import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class URLProcessor {
	private HttpServletRequest request;
	private String url;
	private HttpServlet servlet;

	public URLProcessor(HttpServletRequest request, HttpServlet servlet) throws JSONException, IOException {
		this.request = request;
		this.servlet = servlet;
		this.url = getParsedURL();
		new Thread(()->deleteYoungest()).start();
	}

	public String getURL() throws JSONException, IOException {
		return url;
	}

	private String getParsedURL() {
		if (request.getParameter("url") != null) {
			return request.getParameter("url");
		} else {
			try {
				return parseString(getBody()).getString("url");
			} catch (Exception e) {
				return null;
			}
		}
	}

	public String generateURL() {
		String randomID = generateAndPreventCollision();
		ServletContext servletContext = servlet.getServletConfig().getServletContext();

		synchronized (servletContext) {
			LinkedHashMap<String, String> urlIDS = getOrCreateURLIDS(servletContext);
			urlIDS.put(randomID, url);
			servletContext.setAttribute("urlIDS", urlIDS);
		}

		return getServerAndPort() + "/?id=" + randomID;
	}

	private String generateAndPreventCollision() {
		String id = getRandomString();
		ServletContext servletContext = servlet.getServletConfig().getServletContext();
		synchronized (servletContext) {
			LinkedHashMap<String, String> urlIDS = getOrCreateURLIDS(servletContext);
			return urlIDS.containsKey(id) ? generateAndPreventCollision() : id;
		}
	}

	private String getBody() throws IOException {
		return request.getReader().lines().collect(Collectors.joining());
	}

	private JSONObject parseString(String body) {
		return new JSONObject(body);
	}

	private String getRandomString() {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 6) {
			int index = (int) (rnd.nextFloat() * chars.length());
			salt.append(chars.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	private String getServerAndPort() {
		String server = request.getServerName();
		int port = request.getServerPort();
		return server + ":" + port;
	}

	@SuppressWarnings("unchecked")
	private LinkedHashMap<String, String> getOrCreateURLIDS(ServletContext servletContext) {
		Object urlIDS = servletContext.getAttribute("urlIDS");
		return urlIDS == null ? new LinkedHashMap<String, String>() : (LinkedHashMap<String, String>) urlIDS;
	}

	private void deleteYoungest() {
		ServletContext servletContext = servlet.getServletConfig().getServletContext();
		synchronized (servletContext) {
			LinkedHashMap<String, String> urlIDS = getOrCreateURLIDS(servletContext);
			if (urlIDS.size() > 25_000) {
				Object key = urlIDS.keySet().iterator().next();
				urlIDS.remove(key);
			}
		}
	}
}
