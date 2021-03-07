package RecipeAppRunner.Services;


import RecipeAppRunner.Entities.RecipePost;
import lombok.extern.slf4j.Slf4j;
import RecipeAppRunner.Repositories.RecipePostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j // for logging
public class RecipePostServices{

  //  @Autowired
  //  private RecipePostRepo recipeRepo ;
   private final RecipePostRepo recipePostRepo;

    @Autowired
    public RecipePostServices(RecipePostRepo recipePostRepo) {
        this.recipePostRepo = recipePostRepo;
    }

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


 
    public void deleteRecipeById(Long id) {
        boolean recipeExists = recipePostRepo.existsById(id);
        if (!recipeExists){
            throw new IllegalStateException(
                    "Recipe with id " + id + " does not exist."
            );
        }
        recipePostRepo.deleteById(id);
    }

}
