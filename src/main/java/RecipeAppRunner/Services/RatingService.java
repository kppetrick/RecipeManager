package RecipeAppRunner.Services;

import RecipeAppRunner.Entities.Rating;
import RecipeAppRunner.Entities.RecipePost;
import RecipeAppRunner.Repositories.RatingRepo;
import RecipeAppRunner.Repositories.RecipePostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    RatingRepo ratingRepo;

    @Autowired
    RecipePostRepo recipePostRepo;

    @Autowired
    RecipePostServices recipePostServices;

    public void rate(Rating rating) {
        RecipePost recipePost = recipePostRepo.findById(rating.getRecipePost().getId()).orElseThrow(() -> new RuntimeException("Post Not Found"));
        // still need to implement logic for not allowing double ratings


        ratingRepo.save(rating);
        recipePostServices.updateRating(recipePost.getId(), recipePostServices.calculateRating(recipePost.getId()));

        recipePostRepo.save(recipePost);
    }

    public List<Rating> getAllRatingsForRecipePost(RecipePost recipePost){
        return ratingRepo.findAllByRecipePost(recipePost);
    }

}
