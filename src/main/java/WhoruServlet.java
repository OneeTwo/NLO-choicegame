import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/start/look/outside/forest/unknown/contact/whoru")
public class WhoruServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/scene.jsp";
        String sceneText = "A creature suddenly became aggressive. For a moment, everything around me fell silent. " +
                "Then it rushed toward me with incredible speed. I tried to run, but my legs refused to move. " +
                "Its dark eyes were fixed on me as if it already knew what would happen next. " +
                "A few seconds later, everything went black... it was my last night.";
        req.setAttribute("sceneText",sceneText);
        req.setAttribute("isEnding", true);

        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
        dispatcher.forward(req, resp);

    }
}