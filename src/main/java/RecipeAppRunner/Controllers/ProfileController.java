package RecipeAppRunner.Controllers;


import RecipeAppRunner.Services.ProfileServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j // for logging
public class ProfileController {

    private final ProfileServices profileServices;

    public ProfileController(ProfileServices profileServices) {
        this.profileServices = profileServices;
    }

    @DeleteMapping(path = "{id}")
    public void deleteProfile(@PathVariable("id") Long id){
        profileServices.deleteProfileById(id);
    }
}
