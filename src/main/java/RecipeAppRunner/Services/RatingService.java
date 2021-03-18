package RecipeAppRunner.Services;

import RecipeAppRunner.Entities.Rating;
import RecipeAppRunner.Entities.RecipePost;
import RecipeAppRunner.Repositories.RatingRepo;
import RecipeAppRunner.Repositories.RecipePostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    @Autowired
    RatingRepo ratingRepo;

    @Autowired
    RecipePostRepo recipePostRepo;

    public void rate(Rating rating) {
        RecipePost recipePost = recipePostRepo.findById(rating.getRecipePost().getId()).orElseThrow(() -> new RuntimeException("Post Not Found"));
        // still need to implement logic for not allowing double ratings

        ratingRepo.save(rating);
        recipePostRepo.save(recipePost);
    }
}
