package model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "recipe_id")
    private List<SolidIngredient> solidIngredients;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "recipe_id")
    private List<LiquidIngredient> liquidIngredients;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "recipe_id")
    private List<Step> steps;

    // Constructor vacío
    public Recipe() {
        this.solidIngredients = new ArrayList<>();
        this.liquidIngredients = new ArrayList<>();
        this.steps = new ArrayList<>();
    }

    // Constructor con parámetros
    public Recipe(String name, List<SolidIngredient> solidIngredients, List<LiquidIngredient> liquidIngredients, List<Step> steps) {
        this.name = name;
        this.solidIngredients = solidIngredients;
        this.liquidIngredients = liquidIngredients;
        this.steps = steps;
    }

    // Métodos para agregar y remover ingredientes sólidos
    public void addSolidIngredient(SolidIngredient solidIngredient) {
        this.solidIngredients.add(solidIngredient);
    }

    public void removeSolidIngredient(SolidIngredient solidIngredient) {
        this.solidIngredients.remove(solidIngredient);
    }

    // Métodos para agregar y remover ingredientes líquidos
    public void addLiquidIngredient(LiquidIngredient liquidIngredient) {
        this.liquidIngredients.add(liquidIngredient);
    }

    public void removeLiquidIngredient(LiquidIngredient liquidIngredient) {
        this.liquidIngredients.remove(liquidIngredient);
    }

    // Métodos para agregar y remover pasos
    public void addStep(Step step) {
        this.steps.add(step);
    }

    public void removeStep(Step step) {
        this.steps.remove(step);
    }

    // Validar que las listas de ingredientes y pasos no estén vacías
    public boolean isValid() {
        return !solidIngredients.isEmpty() && !liquidIngredients.isEmpty() && !steps.isEmpty();
    }
}
