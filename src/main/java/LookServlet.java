import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet("/start/look")
public class LookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/scene.jsp";
        String sceneText = "You see a glowing object above the forest.";
        req.setAttribute("sceneText",sceneText);

        Map<String, String> choices = Map.of(
                "Stay at home", req.getContextPath() + "/start/look/home",
                "Go outside", req.getContextPath() + "/start/look/outside"
        );
        req.setAttribute("choices", choices);

        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
        dispatcher.forward(req, resp);
    }
}
