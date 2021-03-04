package RecipeAppRunner.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;


import javax.persistence.*;

import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
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

    private Enum category;

    private String videoLink;

    public RecipePost() {
    }

}