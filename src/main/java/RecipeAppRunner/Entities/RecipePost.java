package RecipeAppRunner.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;


import javax.persistence.*;

import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
public class RecipePost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Name;


    @OneToMany(mappedBy = "ingredients", cascade = ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @OrderBy
    @JsonBackReference
    private Set<Ingredients> ingredients;

    public RecipePost() {
    }

    public RecipePost(Long id, String name, Set<Ingredients> ingredients) {
        this.id = id;
        Name = name;
        this.ingredients = ingredients;
    }
}