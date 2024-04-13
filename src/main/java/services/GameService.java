package services;

import model.Challenge;
import model.Player;
import model.Recipe;

import java.util.List;

public interface GameService {
    List<Recipe> getAllRecipes();
    Recipe getRecipeById(Long id);
    List<Challenge> getAllChallenges();
    Challenge getChallengeById(Long id);
    boolean startGame(Player player);
    boolean submitChallenge(Player player, Challenge challenge, String solution);

    boolean verifyStudentCode(String code, int level);

}
