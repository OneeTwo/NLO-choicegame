import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/start")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/start.jsp";
        String sceneText = "You woke up at night because of a strange blue light...";
        req.setAttribute("sceneText",sceneText);

        String question = "What could it be?";
        req.setAttribute("question",question);

        Boolean showQuestion = true;
        req.setAttribute("showQuestion",showQuestion);

        Map<String, String> choices = Map.of(
                "Look through the window", req.getContextPath() + "/start/look",
                "Go outside", req.getContextPath() + "/start/outside",
                "Hide under the blanket", req.getContextPath() + "/start/hide"
        );
        req.setAttribute("choices", choices);

        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
        dispatcher.forward(req, resp);
    }
}
