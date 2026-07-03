package domain;

public class Choice {
    private String text;
    private String nextQuestionId;

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getNextQuestionId() {
        return nextQuestionId;
    }
    public void setNextQuestionId(String nextQuestionId) {
        this.nextQuestionId = nextQuestionId;
    }
}
