package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private List<String> achievements;
    private int level;


    public Player() {}

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters y setters
}
