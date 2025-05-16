package lad.com.alura.conversormoneda;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;

public class Principal {
    public static void main(String[] args) {
        Map<String, Moneda> monedas = ConversorApp.obtenerMonedasFiltradas();//llama al metodo y retorna un map "USD": Moneda("USD", 1)

        if (monedas.isEmpty()) {
            System.out.println("No se pudo cargar información de monedas. Intenta más tarde.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            exibirMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> convertir(scanner, monedas, "USD", "ARS");
                case 2 -> convertir(scanner, monedas, "ARS", "USD");
                case 3 -> convertir(scanner, monedas, "USD", "BRL");
                case 4 -> convertir(scanner, monedas, "BRL", "USD");
                case 5 -> convertir(scanner, monedas, "USD", "COP");
                case 6 -> convertir(scanner, monedas, "COP", "USD");
                case 7 -> System.out.println("Gracias por usar el conversor de monedas.");
                default -> System.out.println("Elija una opción válida.");
            }

        } while (opcion != 7);

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("\nBienvenido/a al Conversor de Moneda");
        System.out.println("1. Dólar (USD) a Peso Argentino (ARS)");
        System.out.println("2. Peso Argentino (ARS) a Dólar (USD)");
        System.out.println("3. Dólar (USD) a Real Brasileño (BRL)");
        System.out.println("4. Real Brasileño (BRL) a Dólar (USD)");
        System.out.println("5. Dólar (USD) a Peso Colombiano (COP)");
        System.out.println("6. Peso Colombiano (COP) a Dólar (USD)");
        System.out.println("7. Salir");
        System.out.println("****************");
        System.out.print("Seleccione una opción: \n");
        System.out.println("****************");
    }

    public static void convertir(Scanner scanner, Map<String, Moneda> monedas, String desde, String hacia) {
        System.out.print("Ingrese el monto en " + desde + ": ");
        double monto = scanner.nextDouble();

        Moneda monedaDesde = monedas.get(desde);
        Moneda monedaHacia = monedas.get(hacia);

        // Conversión basada en el valor relativo al USD
        double tasaConversion = monedaHacia.getTasa() / monedaDesde.getTasa();
        double resultado = monto * tasaConversion;

        System.out.printf("El valor %.2f (%s) corresponde al valor final de %.2f (%s)\n",
                monto, desde, resultado, hacia);
    }
}