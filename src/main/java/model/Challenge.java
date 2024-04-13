package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String problemStatement; // Descripción del problema
    private String input; // Entrada del problema
    private String expectedOutput; // Salida esperada
    private String description; // Descripción del desafío
    private String correctSolution; // Solución correcta para el desafío
    private String isDoughReadyCondition;


    // Constructor que inicializa todos los campos de la clase
    public Challenge(String problemStatement, String input, String expectedOutput, String description, String correctSolution) {
        this.problemStatement = problemStatement;
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.description = description;
        this.correctSolution = correctSolution;
    }

    // Método para obtener la solución correcta
    public String getCorrectSolution() {
        return correctSolution;
    }
}
