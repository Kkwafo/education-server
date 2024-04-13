package services.impl;

import model.Challenge;
import model.Player;
import model.Recipe;
import org.springframework.stereotype.Service;
import repository.ChallengeRepository;
import repository.PlayerRepository;
import repository.RecipeRepository;
import services.GameService;
import Utils.CodeValidationUtil;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final RecipeRepository recipeRepository;
    private final ChallengeRepository challengeRepository;
    private final PlayerRepository playerRepository;

    public GameServiceImpl(RecipeRepository recipeRepository, ChallengeRepository challengeRepository, PlayerRepository playerRepository) {
        this.recipeRepository = recipeRepository;
        this.challengeRepository = challengeRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe.orElse(null);
    }

    @Override
    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    @Override
    public Challenge getChallengeById(Long id) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        return challenge.orElse(null);
    }

    @Override
    public boolean startGame(Player player) {
        // Iniciar el progreso del jugador (establecer nivel inicial, receta inicial, etc.)
        player.setLevel(1); // Establecer nivel inicial
        player.setProgress(0); // Establecer progreso inicial
        playerRepository.save(player);
        return true;
    }

    @Override
    public boolean submitChallenge(Player player, Challenge challenge, String solution) {
        // Validar la solución proporcionada por el jugador
        if (challenge.getCorrectSolution().equals(solution)) {
            // Actualizar el progreso del jugador
            player.incrementProgress();
            playerRepository.save(player);
            return true;
        }
        return false;
    }

    @Override
    public boolean verifyStudentCode(String code, int level) {
        // Verifica el nivel del estudiante
        switch (level) {
            case 0:
                return validateLevelZeroCode(code);

            case 1:
                // Verifica el código para el nivel 1
                return validateLevelOneCode(code);

            case 2:
                // Verifica el código para el nivel 2
                return validateLevelTwoCode(code);

            default:
                // Si el nivel no es reconocido, devuelve false
                return false;
        }
    }

    /**
     * Valida el código de nivel 0.
     *
     * @param code El código a validar.
     * @return true si el código es válido, false de lo contrario.
     */
    private boolean validateLevelZeroCode(String code) {
        // Verifica si el código contiene una función makeBread
        if (!code.contains("function")) {
            return false;
        }

        // Verificación de la función makeBread
        if (!CodeValidationUtil.validateFunctionContent(code)) {
            return false;
        }

        // Verifica la presencia de llaves al principio y al final de la función
        if (!code.contains("{") || !code.contains("}")) {
            return false;
        }

        // Si todas las validaciones son exitosas, devuelve true
        return true;
    }
    /**
     * Valida el código del estudiante para el nivel 1.
     * @param code El código del estudiante.
     * @return true si el código es válido para el nivel 1, false de lo contrario.
     */
    private boolean validateLevelOneCode(String code) {
        // Implementa la lógica para validar el código en el nivel 1
        // Ejemplo: Verificar si el código cumple con ciertas reglas específicas del nivel 1
        return code.matches("Reglas específicas del nivel 1");
    }


    /**
     * Valida el código del estudiante para el nivel 2.
     * @param code El código del estudiante.
     * @return true si el código es válido para el nivel 2, false de lo contrario.
     */
    private boolean validateLevelTwoCode(String code) {
        // Verifica si el código contiene un bloque "do while" con una función y una declaración de variable
        if (!Utils.CodeValidationUtil.validateDoWhileStructure(code)) {
            return false; // El código no cumple con la estructura de "do while"
        }

        // Verifica el contenido de la función para asegurarse de que sigue la estructura esperada
        if (!Utils.CodeValidationUtil.validateFunctionContent(code)) {
            return false; // La función dentro del bloque "do while" no cumple con la estructura esperada
        }

        // Puedes agregar más validaciones específicas del nivel 2 aquí, si es necesario

        // Si todas las validaciones pasan, devuelve true
        return true;
    }


}
