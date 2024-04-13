package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public abstract class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double quantity; // Cantidad en la unidad correspondiente

    // Constructor vacío
    public Ingredient() {}

    // Constructor con parámetros
    public Ingredient(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    // Métodos adicionales si es necesario
}
