package RecipeAppRunner.Entities;

import RecipeAppRunner.Enums.Categories;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipePost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Name;

    private Set<String> ingredients;

    private List<String> instructions;

    @ManyToOne
    private Profile author;

    private Double rating;

    private Integer estimatedTimeInMinutes;

    @Enumerated(EnumType.STRING)
    private Categories category;

    private String videoLink;


}