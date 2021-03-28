package RecipeAppRunner.Controllers;

import RecipeAppRunner.Entities.RecipePost;
import RecipeAppRunner.Services.RecipePostServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/recipeposts")
@Slf4j // for logging
public class RecipePostController {
    @Autowired
    RecipePostServices recipePostServices;

    public RecipePostController(RecipePostServices recipePostServices) {
        this.recipePostServices = recipePostServices;
    }
    @GetMapping("/hello")
    public ResponseEntity<?> HelloWorld() {
        return new ResponseEntity<>("Hello World" , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RecipePost> createRecipePost(@RequestBody RecipePost recipe){
        log.info("createRecipePost called");

        RecipePost newRecipePost = recipePostServices.createRecipePost(recipe);
        //log.info(String.format("new RecipePost %s by %s successfully created and saved", newRecipePost.getName(), newRecipePost.getAuthor().getUsername()));
        return new ResponseEntity<>(newRecipePost, HttpStatus.CREATED);
    }

    @GetMapping("/recipePost/{id}") //will update when discussed with group
    // Gunjan - added the {id} as to pass the pathvariable to the method needed in URL
    public ResponseEntity<?> readRecipePost(@PathVariable Long id){
        log.info("readRecipePost is called");
        RecipePost recipePost = recipePostServices.readRecipePost(id);
        return new ResponseEntity<>(recipePost, HttpStatus.OK);
        // need to review with group about proper syntax for the Recipe Post above
    }

    @GetMapping
    public ResponseEntity<?> readAllRecipes(){
        log.info("All the Recipes being pulled from DB");
        List<RecipePost> recipes = recipePostServices.readAllRecipe();
        return new ResponseEntity<>(recipes, HttpStatus.OK);

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
