import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/start/look/outside/forest/analysis")
public class AnalysisServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/scene.jsp";
        String sceneText = "Is this possible? I am seeing things that science cannot explain.";
        req.setAttribute("sceneText",sceneText);
        req.setAttribute("isEnding", false);

        Map<String, String> choices = Map.of(
                "Run away", req.getContextPath() + "/start/look/outside/run",
                "What if this is a threat to all humanity?",
                req.getContextPath() + "/start/look/outside/forest/analysis/brave"
        );
        req.setAttribute("choices", choices);

        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
        dispatcher.forward(req, resp);

    }
}