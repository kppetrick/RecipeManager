package RecipeAppRunner.Controllers;

import RecipeAppRunner.Entities.Profile;
import RecipeAppRunner.Entities.RecipePost;
import RecipeAppRunner.Enums.Categories;
import RecipeAppRunner.Services.RecipePostServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api/recipeposts")
@Slf4j // for logging
public class RecipePostController {
    @Autowired
    RecipePostServices recipePostServices;

    //private final RecipePostServices recipePostServices;

    public RecipePostController(RecipePostServices recipePostServices) {
        this.recipePostServices = recipePostServices;
    }

    @PostMapping// let's decide on a common url convention - Christian
    public ResponseEntity<RecipePost> createRecipePost(@RequestBody RecipePost recipe){
        log.info("createRecipePost called");

        RecipePost newRecipePost = recipePostServices.createRecipePost(recipe);
        log.info(String.format("new RecipePost %s by %s successfully created and saved", newRecipePost.getName(), "null user")); // put this back after we have Profiles: recipe.getAuthor().getUsername()
        return new ResponseEntity<>(newRecipePost, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> HelloWorld()
    {
        return new ResponseEntity<>("Hello World" , HttpStatus.OK);
    }

    @PutMapping("/{id}/{rating}")
    public ResponseEntity<?>  updateRatingController(@PathVariable  Long id , @PathVariable  Double rating) {
        log.info("In the controller , updating the Rating of " + id);
        recipePostServices.updateRating(id, rating);
        return new ResponseEntity<>("UPDATED ", HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public void deleteRecipe(@PathVariable("id") Long id){
        recipePostServices.deleteRecipeById(id);

    }
}
