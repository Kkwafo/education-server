package model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // Nombre del logro
    private String description;  // Descripción del logro

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;  // Jugador asociado al logro

    // Constructor vacío
    public Achievement() {}

    // Constructor con parámetros
    public Achievement(String name, String description, Player player) {
        this.name = name;
        this.description = description;
        this.player = player;
    }

    // Otros métodos de la clase, si es necesario
}
