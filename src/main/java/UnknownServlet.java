import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/start/look/outside/forest/unknown")
public class UnknownServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/scene.jsp";
        String sceneText = "You don't know what's going on, but your mind keeps telling you: \"Everything feels wrong.\" " +
                            "You have just seen a strange being on your right.";
        req.setAttribute("sceneText",sceneText);
        req.setAttribute("isEnding", false);

        Map<String, String> choices = Map.of(
                "Run away", req.getContextPath() + "/start/look/outside/run",
                "Contact them", req.getContextPath() + "/start/look/outside/forest/unknown/contact"
        );
        req.setAttribute("choices", choices);

        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
        dispatcher.forward(req, resp);

    }
}