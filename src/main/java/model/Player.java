package model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private int level = 1;  // Nivel inicial
    private int progress = 0;  // Progreso inicial

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "player")
    private List<Achievement> achievements = new ArrayList<>();  // Lista inicializada

    // Constructor vacío
    public Player() {}

    // Constructor con parámetros
    public Player(String username, String password) {
        this.username = username;
        setPassword(password);
    }

    // Establecer y cifrar la contraseña
    public void setPassword(String password) {
        // Usar un método de cifrado adecuado aquí
        this.password = password;  // Debe ser cifrada
    }

    public void incrementProgress() {
        this.progress++;
    }}
