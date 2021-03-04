package RecipeAppRunner.Entities;

import javax.persistence.*;

public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String item;
    private Double quantity;
    private String measurement;
    @ManyToOne
    @JoinColumn(name = "id")
    private RecipePost recipePost;

    public Ingredients() {
    }

    public Ingredients(Long id, String item, Double quantity, String measurement) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.measurement = measurement;
    }
}
