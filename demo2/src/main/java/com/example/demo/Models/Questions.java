package Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "questions")
public class Questions {
    @Id
    private String id;
    private String questionText;
    private List<String> options;
    private String correct_option;
    Questions(){
        //Empty COnstructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCorrect_option() {
        return correct_option;
    }

    public void setCorrect_option(String correct_option) {
        this.correct_option = correct_option;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "id='" + id + '\'' +
                ", question='" + questionText + '\'' +
                ", options=" + options +
                ", correct_option='" + correct_option + '\'' +
                '}';
    }
}
