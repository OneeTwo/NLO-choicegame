import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/start/look/outside/forest/analysis/brave/final")
public class FinalServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/scene.jsp";
        String sceneText = "As the strange light grew brighter, the truth became clear. The being was not an enemy but a messenger from a distant civilization. It revealed a threat that could one day endanger both Earth and countless worlds beyond it.\n" +
                "\n" +
                "For reasons no one could fully explain, I was able to understand them. What began as a terrifying encounter became the first contact between humanity and intelligent life from the stars.\n" +
                "\n" +
                "In the years that followed, I became the bridge between two worlds. Together, humanity and its new allies prevented a global catastrophe and opened the door to a new era of peace and discovery.\n" +
                "\n" +
                "The future of Earth changed forever because of a strange blue light above a silent forest.";
        req.setAttribute("sceneText",sceneText);
        req.setAttribute("isEnding", true);

        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
        dispatcher.forward(req, resp);

    }
}