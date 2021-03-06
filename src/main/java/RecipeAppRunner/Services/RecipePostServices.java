package RecipeAppRunner.Services;

import RecipeAppRunner.Entities.RecipePost;
import RecipeAppRunner.Repositories.RecipePostRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j // for logging
public class RecipePostServices{

    @Autowired
    private RecipePostRepo recipeRepo ;

    public RecipePost updateRating(Long id , Double newRating)
    {
        log.info("Looking for recipe with id " + id + "in the db" );
        RecipePost recipe= recipeRepo.findRecipePostById(id);
        log.info("Recipe with id found " + id + "in the db" );
        if(recipe!=null) {
                     recipe.setRating(newRating);
                     recipeRepo.save(recipe);
            return recipe;
        }
        else {
            log.warn("The customer could not be found, returned null - Make sure to handle this null");
            return null;
        }
    }


}
