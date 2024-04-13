package controllers;

import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.PlayerService;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerPlayer(@RequestBody Player player) {
        boolean registered = playerService.registerPlayer(player);
        return registered ? new ResponseEntity<>("Player registered successfully.", HttpStatus.CREATED) : new ResponseEntity<>("Failed to register player.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<Player> loginPlayer(@RequestBody Player player) {
        Player loggedInPlayer = playerService.loginPlayer(player);
        return loggedInPlayer != null ? new ResponseEntity<>(loggedInPlayer, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/{id}/progress")
    public ResponseEntity<String> getPlayerProgress(@PathVariable Long id) {
        String progress = playerService.getPlayerProgress(id);
        return progress != null ? new ResponseEntity<>(progress, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
