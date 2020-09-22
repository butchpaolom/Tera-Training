import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShrinkerAPI extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		URLProcessor urlProcessor = new URLProcessor(request, this);
		JSONObject obj = new JSONObject();
		PrintWriter out = response.getWriter();
		String url = urlProcessor.getURL();
		if (url!=null&&!url.isEmpty()) {
			String newUrl = urlProcessor.generateURL();
			obj.put("url", newUrl);
			obj.put("sourceURL", url);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
		}
		else {
			response.setStatus(400);
			obj.put("Error", "Missing parameter");
		}
		out.print(obj);
		out.flush();
	}
	
}