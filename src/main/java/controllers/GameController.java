package controllers;

import model.Challenge;
import model.Player;
import model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.GameService;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/recipes")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = gameService.getAllRecipes();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Recipe recipe = gameService.getRecipeById(id);
        return recipe != null ? new ResponseEntity<>(recipe, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/challenges")
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        List<Challenge> challenges = gameService.getAllChallenges();
        return new ResponseEntity<>(challenges, HttpStatus.OK);
    }

    @GetMapping("/challenges/{id}")
    public ResponseEntity<Challenge> getChallengeById(@PathVariable Long id) {
        Challenge challenge = gameService.getChallengeById(id);
        return challenge != null ? new ResponseEntity<>(challenge, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/start")
    public ResponseEntity<String> startGame(@RequestBody Player player) {
        boolean started = gameService.startGame(player);
        return started ? new ResponseEntity<>("Game started successfully.", HttpStatus.OK) : new ResponseEntity<>("Failed to start the game.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitChallenge(@RequestBody Player player, @RequestBody Challenge challenge, @RequestBody String solution) {
        boolean success = gameService.submitChallenge(player, challenge, solution);
        return success ? new ResponseEntity<>("Challenge submitted successfully.", HttpStatus.OK) : new ResponseEntity<>("Challenge submission failed.", HttpStatus.BAD_REQUEST);
    }
}
