package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data
@AllArgsConstructor
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String problemStatement;
    private String input;
    private String expectedOutput;


    public Challenge() {}

    public Challenge(String problemStatement, String input, String expectedOutput) {
        this.problemStatement = problemStatement;
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

}
