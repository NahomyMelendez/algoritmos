/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoalgoritmos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La clase JavaFileAnalyzer analiza un archivo .java, extrae los métodos definidos
 * y permite al usuario visualizar los métodos y sus complejidades a través de un menú interactivo.
 * 
 * @autor Personal
 */
public class JavaFileAnalyzer {

      /**
     * Método principal que ejecuta el análisis del archivo y presenta un menú de opciones.
     * 
     * @param args los argumentos de la línea de comandos
     */
    public static void main(String[] args) {
      String filePath = "Ejemplo.java";
        CircularList methodList = new CircularList();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            StringBuilder fileContent = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
            reader.close();

            Pattern pattern = Pattern.compile("(public|private|protected|static|\\s)\\s+\\w+\\s+\\w+\\(.*?\\)\\s*\\{");
            Matcher matcher = pattern.matcher(fileContent);
            while (matcher.find()) {
                int methodStart = matcher.start();
                int methodEnd = findMethodEnd(fileContent, methodStart);
                String methodBody = fileContent.substring(methodStart, methodEnd);
                String methodName = matcher.group();
                methodList.add(methodName.trim(), methodBody);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar el menú con los métodos y su complejidad
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Mostrar métodos");
            System.out.println("2. Mostrar complejidades");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    methodList.displayMethods();
                    break;
                case 2:
                    methodList.displayComplexities();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 3);

        scanner.close();
    }

    /**
     * Encuentra el final del método en el archivo.
     *
     * @param fileContent Contenido completo del archivo.
     * @param start Índice de inicio del método.
     * @return Índice del final del método.
     */
    private static int findMethodEnd(StringBuilder fileContent, int start) {
        int openBraces = 0;
        int closeBraces = 0;
        int index = start;

        while (index < fileContent.length()) {
            char ch = fileContent.charAt(index);
            if (ch == '{') {
                openBraces++;
            } else if (ch == '}') {
                closeBraces++;
                if (openBraces == closeBraces) {
                    return index + 1;
                }
            }
            index++;
        }
        return fileContent.length();
    }
    }
    

