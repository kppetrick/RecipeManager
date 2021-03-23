package RecipeAppRunner.Repositories;

import RecipeAppRunner.Entities.Rating;
import RecipeAppRunner.Entities.RecipePost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends CrudRepository<Rating, Long> {

    List<Rating> findAllByRecipePost(RecipePost recipePost);

}
