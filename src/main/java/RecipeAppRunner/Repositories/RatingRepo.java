package RecipeAppRunner.Repositories;

import RecipeAppRunner.Entities.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepo extends CrudRepository<Rating, Long> {
}
