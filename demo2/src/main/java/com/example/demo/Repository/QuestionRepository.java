package Repository;

import Models.Questions;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Questions,String> {

}
