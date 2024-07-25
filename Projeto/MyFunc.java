package Projeto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MyFunc {
    private static Scanner scanner = new Scanner(System.in);

    public static int recebeInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número inteiro: ");
            }
        }
    }

    public static double recebeDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número decimal: ");
            }
        }
    }

    public static String recebeString() {
        return scanner.nextLine();
    }

    public static Date recebeData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            try {
                return sdf.parse(scanner.nextLine());
            } catch (ParseException e) {
                System.out.print("Entrada inválida. Digite a data no formato dd/MM/yyyy: ");
            }
        }
    }

    public static boolean recebeBoolean() {
        while (true) {
            String entrada = scanner.nextLine().toLowerCase();
            if (entrada.equals("sim") || entrada.equals("s")) {
                return true;
            } else if (entrada.equals("não") || entrada.equals("nao") || entrada.equals("n")) {
                return false;
            } else {
                System.out.print("Entrada inválida. Digite 'sim' ou 'não': ");
            }
        }
    }
}

