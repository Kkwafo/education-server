package model;

import jakarta.persistence.Entity;

@Entity
public class SolidIngredient extends Ingredient {
    // Constructor vacío
    public SolidIngredient() {
        super();
    }

    // Constructor con parámetros
    public SolidIngredient(String name, double quantity) {
        super(name, quantity);
    }

    // Métodos adicionales si es necesario
}
