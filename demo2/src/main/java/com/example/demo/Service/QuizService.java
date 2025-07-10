package Service;

import Models.Questions;
import Models.Result;
import Repository.QuestionRepository;
import Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ResultRepository resultRepository;
    public List<Questions> getAllQuestions(){
        return questionRepository.findAll();
    }
    public Result saveResult(Result result){
        return resultRepository.save(result);
    }
}
