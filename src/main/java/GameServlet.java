import domain.Question;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.GameService;
import service.GameServiceImpl;

import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    private final GameService gameService = new GameServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String scene = req.getParameter("scene");

        if (scene == null) {
            scene = "start";
        }



        Question question = gameService.findById(scene);

        if (question == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        req.setAttribute("sceneText", question.getText());
        req.setAttribute("choices", question.getChoices());
        req.setAttribute("isEnding", question.isEnding());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/scene.jsp");
        dispatcher.forward(req, resp);
    }
}