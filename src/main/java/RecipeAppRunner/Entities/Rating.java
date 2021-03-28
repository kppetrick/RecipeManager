package RecipeAppRunner.Entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;
    private Integer value;

    @NotNull
    @ManyToOne(fetch = LAZY)
    private RecipePost recipePost;
    @ManyToOne(fetch = LAZY)
    private Profile profile;


}
