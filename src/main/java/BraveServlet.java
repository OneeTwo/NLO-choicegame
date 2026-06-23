import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/start/look/outside/forest/analysis/brave")
public class BraveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/scene.jsp";
        String sceneText = "What if I'm the only one who can see it? Should I use this opportunity to my advantage?";
        req.setAttribute("sceneText",sceneText);
        req.setAttribute("isEnding", false);

        Map<String, String> choices = Map.of(
        "Time to change", req.getContextPath() + "/start/look/outside/forest/analysis/brave/final"
        );
        req.setAttribute("choices", choices);

        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
        dispatcher.forward(req, resp);

    }
}