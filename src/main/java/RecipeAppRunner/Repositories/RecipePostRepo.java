package RecipeAppRunner.Repositories;

import RecipeAppRunner.Entities.RecipePost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipePostRepo extends CrudRepository<RecipePost, Long> {
}
