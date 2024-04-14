package controllers;

import static Utils.CodeValidationTestUtil.DO_WHILE_PATTERN;
import static org.junit.jupiter.api.Assertions.*;

import Utils.CodeValidationUtil;
import org.junit.jupiter.api.Test;

class CodeValidationUtilTest {



    @Test
    void testLevel2DoWhile() {
        String validCode2 = "do {\n" +
                "    function exampleFunction(param) {\n" +
                "        console.log(\"This is an example\");\n" +
                "    }\n" +
                "    let myVar = \"Hello\";\n" +
                "} while (myVar === \"Hello\");";

        System.out.println("Valid code: " + validCode2);
        System.out.println("Pattern: " + DO_WHILE_PATTERN);

        boolean matches = validCode2.matches(DO_WHILE_PATTERN);
        System.out.println("Does the code match the pattern? " + matches);

        // Verifica que el código cumple con la estructura esperada de un bloque do-while.
        assertTrue(matches);
    }



}
