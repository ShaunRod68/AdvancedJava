package Controller;

import Models.Questions;
import Models.Result;
import Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @GetMapping("/ping")
    public String ping() {
        return "Quiz API is working!";
    }

    @GetMapping("/questions")
    public List<Questions> getQuestions(){
        return quizService.getAllQuestions();
    }
    @GetMapping("/submit")
    public Result submitQuiz(
            @RequestBody Result result
    ){
        return quizService.saveResult(result);
    }
}
