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
@Slf4j // for logging
public class RecipePostController {
    @Autowired
    RecipePostServices recipePostServices;

    //private final RecipePostServices recipePostServices;

    public RecipePostController(RecipePostServices recipePostServices) {
        this.recipePostServices = recipePostServices;
    }

    @PostMapping()// let's decide on a common url convention - Christian
    public ResponseEntity<RecipePost> createRecipePost(String name, Set<String> ingredients, List<String> instructions,
                                                       Profile author, Integer estimatedTimeInMinutes,
                                                       Categories category, String videoLink){
        log.info("createRecipePost called");

        RecipePost newRecipePost = recipePostServices.createRecipePost(name, ingredients, instructions, author, estimatedTimeInMinutes, category, videoLink);
        log.info(String.format("new RecipePost %s by %s successfully created and saved", newRecipePost.getName(), newRecipePost.getAuthor().getUsername()));
        return new ResponseEntity<>(newRecipePost, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> HelloWorld()
    {
        return new ResponseEntity<>("Hello World" , HttpStatus.OK);
    }

    @PutMapping("/update/{id}/{rating}")
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
