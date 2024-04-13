package model;

import jakarta.persistence.Entity;

@Entity
public class LiquidIngredient extends Ingredient {
    // Constructor vacío
    public LiquidIngredient() {
        super();
    }

    // Constructor con parámetros
    public LiquidIngredient(String name, double quantity) {
        super(name, quantity);
    }

    // Métodos adicionales si es necesario
}
