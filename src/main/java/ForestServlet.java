import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/start/look/outside/forest")
public class ForestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/scene.jsp";
        String sceneText = "You have been walking through the forest for 10 minutes. " +
                "The blue light shines somewhere ahead, but the deeper you go, " +
                "the quieter it becomes. No birds, no wind, no sounds at all.";
        req.setAttribute("sceneText",sceneText);

        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
        dispatcher.forward(req, resp);
    }
}