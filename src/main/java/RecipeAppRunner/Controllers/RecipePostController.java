package RecipeAppRunner.Controllers;

import RecipeAppRunner.Services.RecipePostServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j // for logging
public class RecipePostController {
    @Autowired
    RecipePostServices recipePostServices;

    private final RecipePostServices recipePostServices;

    public RecipePostController(RecipePostServices recipePostServices) {
        this.recipePostServices = recipePostServices;
    }

    @GetMapping
    public ResponseEntity<?> HelloWorld()
    {
        return new ResponseEntity<>("Hello World" , HttpStatus.OK);
    }

    @PutMapping("/update/{id}/{rating}")
    public ResponseEntity<?>  updateRatingController(@PathVariable  Long id , @PathVariable  Double rating)
    {
        log.info("In the controller , updating the Rating of " + id);
        recipePostServices.updateRating(id,rating);
        return new ResponseEntity<>("UPDATED ", HttpStatus.OK);

    @DeleteMapping(path = "{id}")
    public void deleteRecipe(@PathVariable("id") Long id){
        recipePostServices.deleteRecipeById(id);

    }
}
