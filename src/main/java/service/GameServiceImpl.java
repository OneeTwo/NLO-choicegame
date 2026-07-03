package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Question;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GameServiceImpl implements GameService {
    private final List<Question> cachedQuestions;

    public GameServiceImpl() {
        this.cachedQuestions = loadQuestions();
    }

    @Override
    public Question findById(String id) {
        List<Question> questions = loadQuestions();

        for (Question question : cachedQuestions) {
            if (question.getId().equals(id)) {
                return question;
            }
        }

        return null;
    }

    public List<Question> loadQuestions() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("questions.json");

            return mapper.readValue(inputStream,
                    new TypeReference<List<Question>>() {}
            );

        } catch (IOException e) {
            System.err.println("Wrong reading file: " + e.getMessage());
            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
