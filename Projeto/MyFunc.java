package Projeto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MyFunc {
    // Scanner para leitura de entradas do usuário
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Lê um número inteiro da entrada do usuário.
     * Continua solicitando a entrada até que um valor válido seja fornecido.
     * @return O número inteiro fornecido pelo usuário.
     */
    public static int recebeInt() {
        while (true) {
            try {
                // Tenta converter a entrada para inteiro
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Se a conversão falhar, informa o usuário e solicita nova entrada
                System.out.print("Entrada inválida. Digite um número inteiro: ");
            }
        }
    }

    /**
     * Lê um número decimal da entrada do usuário.
     * Continua solicitando a entrada até que um valor válido seja fornecido.
     * @return O número decimal fornecido pelo usuário.
     */
    public static double recebeDouble() {
        while (true) {
            try {
                // Tenta converter a entrada para decimal
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Se a conversão falhar, informa o usuário e solicita nova entrada
                System.out.print("Entrada inválida. Digite um número decimal: ");
            }
        }
    }

    /**
     * Lê uma linha de texto da entrada do usuário.
     * @return A string fornecida pelo usuário.
     */
    public static String recebeString() {
        // Lê e retorna a linha de texto fornecida pelo usuário
        return scanner.nextLine();
    }

    /**
     * Lê uma data da entrada do usuário no formato dd/MM/yyyy.
     * Continua solicitando a entrada até que uma data válida seja fornecida.
     * @return A data fornecida pelo usuário.
     */
    public static Date recebeData() {
        // Define o formato esperado para a data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            try {
                // Tenta analisar a data com o formato definido
                return sdf.parse(scanner.nextLine());
            } catch (ParseException e) {
                // Se a análise falhar, informa o usuário e solicita nova entrada
                System.out.print("Entrada inválida. Digite a data no formato dd/MM/yyyy: ");
            }
        }
    }

    /**
     * Lê uma resposta booleana da entrada do usuário.
     * Aceita respostas como "sim", "s", "não", "nao", "n".
     * Continua solicitando a entrada até que uma resposta válida seja fornecida.
     * @return O valor booleano correspondente à entrada fornecida.
     */
    public static boolean recebeBoolean() {
        while (true) {
            String entrada = scanner.nextLine().toLowerCase();
            // Verifica se a entrada corresponde a 'true'
            if (entrada.equals("sim") || entrada.equals("s")) {
                return true;
            } 
            // Verifica se a entrada corresponde a 'false'
            else if (entrada.equals("não") || entrada.equals("nao") || entrada.equals("n")) {
                return false;
            } 
            else {
                // Se a entrada não for válida, informa o usuário e solicita nova entrada
                System.out.print("Entrada inválida. Digite 'sim' ou 'não': ");
            }
        }
    }
}

