package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stepNumber; // Número del paso, por ejemplo, 1, 2, 3, etc.
    private String description; // Descripción del paso

    public Step() {}

    public Step(int stepNumber, String description) {
        this.stepNumber = stepNumber;
        this.description = description;
    }
}
