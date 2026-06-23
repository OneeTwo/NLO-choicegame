import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/start/look/outside/forest/unknown/contact/greet")
public class GreetServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/scene.jsp";
        String sceneText = "You started communicating with the unknown being. " +
                "\"To be honest, I had no idea what it was talking about. " +
                "It was the smartest creature I had ever met because it spoke English. " +
                "For a moment, I thought it might actually be an alien, a being from outer space. " +
                "It spoke too fast and then suddenly switched to Spanish or French. I was disappointed. " +
                "After the creature somehow read my mind—or perhaps my verbal signals—it instantly fell silent" +
                " and stared at me for a minute. " +
                "Then, an overwhelming force made me fall asleep. I had never felt anything like it before...\"" +
                " The next morning, the main character had disappeared, and to this day no one knows what happened to him.";
        req.setAttribute("sceneText",sceneText);
        req.setAttribute("isEnding", true);

        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
        dispatcher.forward(req, resp);

    }
}