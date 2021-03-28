package RecipeAppRunner.Controllers;

import RecipeAppRunner.Entities.Rating;
import RecipeAppRunner.Services.RatingService;
import RecipeAppRunner.Services.RecipePostServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ratings")
@AllArgsConstructor
public class RatingController {

    @Autowired
    RatingService ratingService;

    @Autowired
    RecipePostServices recipePostServices;
    // make a method that updates the post's rating

    @PostMapping
    public ResponseEntity<Void> rate(@RequestBody Rating rating){
        ratingService.rate(rating);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
