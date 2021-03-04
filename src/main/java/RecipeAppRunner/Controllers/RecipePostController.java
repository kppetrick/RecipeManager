package RecipeAppRunner.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j // for logging
public class RecipePostController {

    @GetMapping
    public ResponseEntity<?> HelloWorld()
    {
        return new ResponseEntity<>("Hello World" , HttpStatus.OK);
    }
}
