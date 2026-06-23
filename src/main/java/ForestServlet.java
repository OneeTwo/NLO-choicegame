import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/start/look/outside/forest")
public class ForestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/scene.jsp";
        String sceneText = "You have been walking through the forest for 10 minutes. " +
                "The blue light shines somewhere ahead, but the deeper you go, " +
                "the quieter it becomes. No birds, no wind, no sounds at all.";
        req.setAttribute("sceneText",sceneText);
        req.setAttribute("isEnding", false);

        Map<String, String> choices = Map.of(
                "Start analysing", req.getContextPath() + "/start/look/outside/forest/analysis",
                "Go deeper (there's no way back)", req.getContextPath() + "/start/look/outside/forest/unknown"
        );
        req.setAttribute("choices", choices);

        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
        dispatcher.forward(req, resp);

    }
}