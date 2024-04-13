package Utils;

public class CodeValidationUtil {

    // Constantes para las expresiones regulares utilizadas en las validaciones

    /**
     * Expresión regular para verificar que una palabra sigue el estilo camelCase.
     * La palabra no puede comenzar con un número y debe tener letras mayúsculas para palabras compuestas.
     */
    private static final String CAMEL_CASE_PATTERN = "^[a-z]+(?:[A-Z][a-z]*)*$";

    /**
     * Expresión regular para verificar la declaración de una variable.
     * Permite "let", "var" o "const" seguido de una variable en camelCase
     * y una asignación a cualquier valor.
     */
    private static final String VARIABLE_DECLARATION_PATTERN = "(let|var|const)\\s+[a-zA-Z_][a-zA-Z0-9_]*\\s*=\\s*[^;]+;";

    /**
     * Expresión regular para verificar las declaraciones de asignaciones de ingredientes.
     * Permite una variable en camelCase con una propiedad, asignada a otra variable en camelCase con una propiedad.
     */
    private static final String INGREDIENT_ASSIGNMENT_PATTERN = "[a-zA-Z_][a-zA-Z0-9_]*\\.[a-zA-Z_][a-zA-Z0-9_]*\\s*=\\s*[a-zA-Z_][a-zA-Z0-9_]*\\.[a-zA-Z_][a-zA-Z0-9_]*;";

    /**
     * Expresión regular para verificar la declaración de retorno.
     * Permite que el retorno sea de cualquier variable.
     */
    private static final String RETURN_STATEMENT_PATTERN = "return\\s+[a-zA-Z_][a-zA-Z0-9_]*\\s*;";

    /**
     * Expresión regular para verificar una función.
     * Permite una declaración de función con cualquier cantidad de argumentos y un cuerpo.
     */
    private static final String FUNCTION_PATTERN = "function\\s+[a-zA-Z_][a-zA-Z0-9_]*\\s*\\([^)]*\\)\\s*\\{[^}]*\\}";

    /**
     * Expresión regular para verificar la declaración de una variable dentro de un bloque `do`.
     * Permite `let`, `var` o `const` seguido de una variable en camelCase.
     */
    private static final String VARIABLE_DECLARATION_IN_DO_PATTERN = "(let|var|const)\\s+[a-zA-Z_][a-zA-Z0-9_]*\\s*=\\s*[^;]+;";

    /**
     * Expresión regular para verificar el bloque `do` que contiene una función y una declaración de variable.
     */
    private static final String DO_BLOCK_PATTERN = "do\\s*\\{.*?" + FUNCTION_PATTERN + ".*?" + VARIABLE_DECLARATION_IN_DO_PATTERN + ".*?\\}\\s*while\\s*\\(.*?\\);";

    /**
     * Expresión regular para verificar un bloque `do while` con una función y una variable.
     * Permite un bloque `do` con una función y una declaración de variable, seguido de una condición `while`.
     */
    private static final String DO_WHILE_PATTERN = "do\\s*\\{.*?" + FUNCTION_PATTERN + ".*?" + VARIABLE_DECLARATION_IN_DO_PATTERN + ".*?\\}\\s*while\\s*\\(.*?\\);";

    /**
     * Valida si el código de un bloque `do while` cumple con la estructura esperada.
     *
     * @param code El código de un bloque `do while` a verificar.
     * @return true si el código cumple con la estructura esperada, false de lo contrario.
     */
    public static boolean validateDoWhileStructure(String code) {
        return code.matches(DO_WHILE_PATTERN);
    }

    /**
     * Valida si el código contiene una declaración `while` con cualquier condición.
     *
     * @param code El código a verificar.
     * @return true si el código contiene una declaración `while` con cualquier condición, false de lo contrario.
     */
    public static boolean validateWhilePattern(String code) {
        return code.matches("while\\s*\\([^)]*\\)\\s*;");
    }

    /**
     * Verifica si el código contiene una expresión `while` con cualquier condición arbitraria.
     *
     * @param code El código a verificar.
     * @return true si el código contiene una expresión `while` con cualquier condición arbitraria, false de lo contrario.
     */
    public static boolean validateAnyWhileCondition(String code) {
        return code.matches("while\\s*\\([^)]*\\)\\s*;");
    }
    /**
     * Verifica el contenido de una función para asegurarse de que sigue la estructura esperada.
     *
     * @param code El código de la función a verificar.
     * @return true si el código sigue la estructura esperada, false de lo contrario.
     */
    public static boolean validateFunctionContent(String code) {
        // Verifica la declaración de variables en el bloque de código
        if (!code.matches(VARIABLE_DECLARATION_PATTERN)) {
            return false;
        }

        // Verifica las asignaciones de ingredientes en el bloque de código
        if (!code.matches(INGREDIENT_ASSIGNMENT_PATTERN)) {
            return false;
        }

        // Verifica la declaración de retorno en el bloque de código
        if (!code.matches(RETURN_STATEMENT_PATTERN)) {
            return false;
        }

        // Si todas las verificaciones anteriores son correctas, entonces el contenido de la función es válido
        return true;
    }

}
