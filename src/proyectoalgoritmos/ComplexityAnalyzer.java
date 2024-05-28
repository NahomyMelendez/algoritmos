/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoalgoritmos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La clase ComplexityAnalyzer proporciona métodos para estimar la complejidad
 * de un método en Java analizando su cuerpo. Calcula la complejidad basándose
 * en el número de bucles, sentencias if y llamadas a métodos dentro del cuerpo
 * del método.
 *
 * @autor Personal
 */
public class ComplexityAnalyzer {

    /**
     * Estima la complejidad del método dado su cuerpo como una cadena de texto.
     *
     * @param methodBody El cuerpo del método a analizar.
     * @return Una cadena que describe la complejidad del método en términos de
     * notación O.
     */
    public static String estimateComplexity(String methodBody) {
        int loopCount = countLoops(methodBody);
        int nestedLoopCount = countNestedLoops(methodBody);
        int ifCount = countIfStatements(methodBody);
        int methodCalls = countMethodCalls(methodBody);
        
        
        String complexity = "O(1)"; // Por defecto es O(1)

        if (loopCount > 0) {
            complexity = "O(n^  " + loopCount + ")";
        }

        if (ifCount > 0) {
            complexity += " (con  " + ifCount + "  condiciones)";
        }

        if (methodCalls > 0) {
            complexity += " (con  " + methodCalls + "  llamadas a métodos)";
        }

        return complexity;
    }

    /**
     * Cuenta el número de bucles (for, while, do-while) en el cuerpo del
     * método.
     *
     * @param methodBody El cuerpo del método a analizar.
     * @return El número de bucles en el cuerpo del método.
     */
    public static int countLoops(String methodBody) {
        int loopCount = 0;
        Pattern loopPattern = Pattern.compile("(for|while|do)\\s*\\(");
        Matcher loopMatcher = loopPattern.matcher(methodBody);
        while (loopMatcher.find()) {
            loopCount++;
        }
        return loopCount;
    }

    /**
     * Cuenta el número de sentencias if en el cuerpo del método.
     *
     * @param methodBody El cuerpo del método a analizar.
     * @return El número de sentencias if en el cuerpo del método.
     */
    public static int countIfStatements(String methodBody) {
        int ifCount = 0;
        Pattern ifPattern = Pattern.compile("\\bif\\s*\\(");
        Matcher ifMatcher = ifPattern.matcher(methodBody);
        while (ifMatcher.find()) {
            ifCount++;
        }
        return ifCount;
    }

    /**
     * Cuenta el número de bucles anidados (for, while, do-while) en el cuerpo del
     * método.
     *
     * @param methodBody El cuerpo del método a analizar.
     * @return El número de bucles anidados en el cuerpo del método.
     */
    public static int countNestedLoops(String methodBody) {
        int nestedLoopCount = 0;
        int depth = 0;
        Pattern loopPattern = Pattern.compile("\\b(for|while|do)\\b");
        Matcher loopMatcher = loopPattern.matcher(methodBody);

        while (loopMatcher.find()) {
            depth++;
            if (depth > nestedLoopCount) {
                nestedLoopCount = depth;
            }
        }

        return nestedLoopCount;
    }
    
    /**
     * Cuenta el número de llamadas a métodos en el cuerpo del método.
     *
     * @param methodBody El cuerpo del método a analizar.
     * @return El número de llamadas a métodos en el cuerpo del método.
     */
    public static int countMethodCalls(String methodBody) {
        int methodCallCount = 0;
        Pattern methodCallPattern = Pattern.compile("\\b\\w+\\s*\\(");
        Matcher methodCallMatcher = methodCallPattern.matcher(methodBody);
        while (methodCallMatcher.find()) {
            String match = methodCallMatcher.group();
            if (!match.matches("\\b(if|for|while|do|switch)\\s*\\(")) {
                methodCallCount++;
            }
        }
        return methodCallCount;
    }

}
