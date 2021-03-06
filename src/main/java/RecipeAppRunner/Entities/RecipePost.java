package RecipeAppRunner.Entities;

import RecipeAppRunner.Enums.Categories;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;


import javax.persistence.*;

import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipePost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Name;

    @ElementCollection
    private Set<String> ingredients;

    @ElementCollection
    private List<String> instructions;

    @ManyToOne
    private Profile author;

    private Double rating;

    private Integer estimatedTimeInMinutes;

    @Enumerated(EnumType.STRING)
    private Categories category;

    private String videoLink;


}