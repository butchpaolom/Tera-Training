import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.LinkedHashMap;

public class ShrinkerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		if (id == null) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect(getURL(id));
		}
	}

	@SuppressWarnings("unchecked")
	private String getURL(String id) {
		ServletContext servletContext = getServletConfig().getServletContext();
		synchronized (servletContext) {
			LinkedHashMap<String, String> urlIDS = (LinkedHashMap<String, String>) servletContext.getAttribute("urlIDS");
			return null != urlIDS ? urlIDS.containsKey(id) ? urlIDS.get(id) : null : "/";
		}
	}
}