import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String scene = req.getParameter("scene");

        if (scene == null || scene.equals("start")) {
            String sceneText = "You woke up at night because of a strange blue light...";
            req.setAttribute("sceneText",sceneText);
            req.setAttribute("question", "What could it be?");
            req.setAttribute("showQuestion", true);

            Map<String, String> choices = Map.of(
                    "Look through the window", req.getContextPath() + "/game?scene=look",
                    "Go outside", req.getContextPath() + "/game?scene=outside",
                    "Hide under the blanket", req.getContextPath() + "/game?scene=hide"
            );
            req.setAttribute("choices", choices);
        }

        else if (scene.equals("home")) {
            String sceneText = "You decided to stay at home and ignore the strange light. " +
                    "Later that night, a meteorite struck your house, leaving no chance of survival.";
            req.setAttribute("sceneText",sceneText);
            req.setAttribute("isEnding", true);
        }

        else if (scene.equals("look")) {
            String sceneText = "You see a glowing object above the forest.";
            req.setAttribute("sceneText",sceneText);
            req.setAttribute("isEnding", false);

            Map<String, String> choices = Map.of(
                    "Stay at home", req.getContextPath() + "/game?scene=home",
                    "Go outside", req.getContextPath() + "/game?scene=lookOutside"
            );
            req.setAttribute("choices", choices);
        }

        else if (scene.equals("outside")) {
            String sceneText = "You followed the strange light deep into the forest. \n" +
                    "You were abducted by the unknown beings that night. \n" +
                    "Many years later, in a distant place far from Earth, you were killed.";
            req.setAttribute("sceneText",sceneText);
            req.setAttribute("isEnding", true);
        }

        else if (scene.equals("lookOutside")) {
            String sceneText = "You have gone outside, it was cold at this season of year.. You need to decide what to do";
            req.setAttribute("sceneText",sceneText);
            req.setAttribute("isEnding", false);

            Map<String, String> choices = Map.of(
                    "Run away", req.getContextPath() + "/game?scene=run",
                    "Go to the forest", req.getContextPath() + "/game?scene=forest"
            );
            req.setAttribute("choices", choices);
        }

        else if (scene.equals("hide")) {
            String sceneText =  "You hid under the blanket and ignored the strange light. \n" +
                    "By morning it was gone, and the mystery remained unsolved forever.";
            req.setAttribute("sceneText",sceneText);
            req.setAttribute("isEnding", true);
        }

        else if (scene.equals("run")) {
            String sceneText = "You run home and never discover the truth.";
            req.setAttribute("sceneText",sceneText);
            req.setAttribute("isEnding", true);
        }

        else if (scene.equals("forest")) {
            String sceneText = "You have been walking through the forest for 10 minutes. " +
                    "The blue light shines somewhere ahead, but the deeper you go, " +
                    "the quieter it becomes. No birds, no wind, no sounds at all.";
            req.setAttribute("sceneText",sceneText);
            req.setAttribute("isEnding", false);

            Map<String, String> choices = Map.of(
                    "Start analysing", req.getContextPath() + "/game?scene=analysis",
                    "Go deeper (there's no way back)", req.getContextPath() + "/game?scene=unknown"
            );
            req.setAttribute("choices", choices);
        }

        else if (scene.equals("analysis")) {
            String sceneText = "Is this possible? I am seeing things that science cannot explain.";
            req.setAttribute("sceneText",sceneText);
            req.setAttribute("isEnding", false);

            Map<String, String> choices = Map.of(
                    "Run away", req.getContextPath() + "/game?scene=run",
                    "What if this is a threat to all humanity?",
                    req.getContextPath() + "/game?scene=brave"
            );
            req.setAttribute("choices", choices);
        }

        else if (scene.equals("unknown")) {
            String sceneText = "You don't know what's going on, but your mind keeps telling you: \"Everything feels wrong.\" " +
                    "You have just seen a strange being on your right.";
            req.setAttribute("sceneText",sceneText);
            req.setAttribute("isEnding", false);

            Map<String, String> choices = Map.of(
                    "Run away", req.getContextPath() + "/game?scene=run",
                    "Contact them", req.getContextPath() + "/game?scene=contact"
            );
            req.setAttribute("choices", choices);
        }

        else if (scene.equals("contact")) {
            String sceneText = "Okay... I should say something";
            req.setAttribute("sceneText",sceneText);
            req.setAttribute("isEnding", false);

            Map<String, String> choices = Map.of(
                    "Hello?", req.getContextPath() + "/game?scene=greet",
                    "Who are you..?", req.getContextPath() + "/game?scene=whoru"
            );
            req.setAttribute("choices", choices);
        }

        else if (scene.equals("greet")) {
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
        }

        else if (scene.equals("whoru")) {
            String sceneText = "A creature suddenly became aggressive. For a moment, everything around me fell silent. " +
                    "Then it rushed toward me with incredible speed. I tried to run, but my legs refused to move. " +
                    "Its dark eyes were fixed on me as if it already knew what would happen next. " +
                    "A few seconds later, everything went black... it was my last night.";
            req.setAttribute("sceneText",sceneText);
            req.setAttribute("isEnding", true);
        }

        else if (scene.equals("brave")) {
            String sceneText = "What if I'm the only one who can see it? Should I use this opportunity to my advantage?";
            req.setAttribute("sceneText",sceneText);
            req.setAttribute("isEnding", false);

            Map<String, String> choices = Map.of(
                    "Time to change", req.getContextPath() + "/game?scene=final"
            );
            req.setAttribute("choices", choices);
        }

        else if (scene.equals("final")) {
            String sceneText = "As the strange light grew brighter, the truth became clear. The being was not an enemy but a messenger from a distant civilization. It revealed a threat that could one day endanger both Earth and countless worlds beyond it.\n" +
                    "\n" +
                    "For reasons no one could fully explain, I was able to understand them. What began as a terrifying encounter became the first contact between humanity and intelligent life from the stars.\n" +
                    "\n" +
                    "In the years that followed, I became the bridge between two worlds. Together, humanity and its new allies prevented a global catastrophe and opened the door to a new era of peace and discovery.\n" +
                    "\n" +
                    "The future of Earth changed forever because of a strange blue light above a silent forest.";
            req.setAttribute("sceneText",sceneText);
            req.setAttribute("isEnding", true);
        }

        else {
            req.setAttribute("sceneText", "Scene not found.");
            req.setAttribute("isEnding", true);
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/scene.jsp");
        dispatcher.forward(req, resp);
    }
}