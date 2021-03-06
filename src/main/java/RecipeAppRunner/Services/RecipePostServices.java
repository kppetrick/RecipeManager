package RecipeAppRunner.Services;

import RecipeAppRunner.Repositories.RecipePostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipePostServices{

    private final RecipePostRepo recipePostRepo;

    @Autowired
    public RecipePostServices(RecipePostRepo recipePostRepo) {
        this.recipePostRepo = recipePostRepo;
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
