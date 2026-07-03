package service;

import domain.Question;

public interface GameService {
    Question findById(String id);
}
