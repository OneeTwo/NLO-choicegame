import domain.Question;
import org.junit.jupiter.api.Test;
import service.GameService;
import service.GameServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class GameServiceImplTest {
    private final GameService gameService = new GameServiceImpl();

    @Test
    void shouldFindStartQuestionById() {
        Question question = gameService.findById("start");

        assertNotNull(question);
        assertEquals("start", question.getId());
        assertFalse(question.isEnding());
        assertNotNull(question.getChoices());
        assertFalse(question.getChoices().isEmpty());
    }

    @Test
    void shouldReturnNullForUnknownId() {
        Question question = gameService.findById("wrong_id");

        assertNull(question);
    }
}
