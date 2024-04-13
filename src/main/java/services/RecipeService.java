package services;

import model.Recipe;
import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();
    Recipe getRecipeById(Long id);
    Recipe createRecipe(Recipe recipe);
    Recipe updateRecipe(Long id, Recipe updatedRecipe);
    boolean deleteRecipe(Long id);
}
