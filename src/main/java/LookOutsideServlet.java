import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/start/look/outside")
public class LookOutsideServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/scene.jsp";
        String sceneText = "You have gone outside, it was cold at this season of year.. You need to decide what to do";
        req.setAttribute("sceneText",sceneText);
        req.setAttribute("isEnding", false);

        Map<String, String> choices = Map.of(
                "Run away", req.getContextPath() + "/start/look/outside/run",
                "Go to the forest", req.getContextPath() + "/start/look/outside/forest"
        );
        req.setAttribute("choices", choices);

        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
        dispatcher.forward(req, resp);

    }
}
