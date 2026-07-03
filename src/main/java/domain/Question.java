package domain;

import java.util.List;

import java.util.List;

public class Question {
    private String id;
    private String text;
    private List<Choice> choices;
    private boolean ending;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public List<Choice> getChoices() { return choices; }
    public void setChoices(List<Choice> choices) { this.choices = choices; }

    public boolean isEnding() { return ending; }
    public void setEnding(boolean ending) { this.ending = ending; }
}
