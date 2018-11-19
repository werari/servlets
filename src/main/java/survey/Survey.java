package survey;

import java.util.List;

public class Survey {
    private Integer id;
    private String title;
    private String description;
    private List<SurveyQuestion> questions;

    public Survey(Integer id, String title, String description, List<SurveyQuestion> questions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.questions = questions;
    }

    public Survey(String title, String description, List<SurveyQuestion> questions) {
        this.title = title;
        this.description = description;
        this.questions = questions;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<SurveyQuestion> getQuestions() {
        return questions;
    }
}
