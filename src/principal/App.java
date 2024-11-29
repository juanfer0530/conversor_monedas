package principal;

import java.util.Scanner;
import modelo.ConversorMoneda;
import modelo.moneda;

public class App {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        ConversorMoneda conversor = new ConversorMoneda("YOUR-API-KEY");//<-- Ingresa tu API Key

        while (true) {
            try {
                System.out.println("****************************************************");
                System.out.println("Bienvenido a el conversor de monedas");
                System.out.println("****************************************************");
                System.out.println("Selecciona una opción de conversión:");
                System.out.println("1. USD (United States Dolar) --> COP (Colombian Peso)");
                System.out.println("2. COP (Colombian Peso) --> USD (United States Dolar)");
                System.out.println("3. EUR (Euro) --> COP (Colombian Peso)");
                System.out.println("4. COP (Colombian Peso) --> EUR (Euro)");
                System.out.println("5. USD (United States Dolar) --> EUR (Euro)");
                System.out.println("6. EUR (Euro) --> USD (United States Dolar)");
                System.out.println("0. Salir del programa");
                System.out.println("****************************************************");
                
                int opcion = scanner.nextInt();
                            scanner.nextLine();
                String codigoMonedaBase;
                String codigoMonedaFinal;

                            switch (opcion) {
                                case 1:
                                    codigoMonedaBase = "USD";
                                    codigoMonedaFinal = "COP";
                                    break;
                                case 2:
                                    codigoMonedaBase = "COP";
                                    codigoMonedaFinal = "USD";
                                    break;
                                case 3:
                                    codigoMonedaBase = "EUR";
                                    codigoMonedaFinal = "COP";
                                    break;
                                case 4:
                                    codigoMonedaBase = "COP";
                                    codigoMonedaFinal = "EUR";
                                    break;
                                case 5:
                                    codigoMonedaBase = "USD";
                                    codigoMonedaFinal = "EUR";
                                    break;
                                case 6:
                                    codigoMonedaBase = "EUR";
                                    codigoMonedaFinal = "USD    ";
                                    break;
                                case 0:
                                    System.out.println("Has salido del programa.");
                                    scanner.close();
                                    return; // Salir del programa
                                default:
                                    System.out.println("Opción no válida. Intenta nuevamente.");
                                    continue;
                            }

                System.out.println("Ingresa la cantidad que quieres convertir");
                double cantidad = scanner.nextDouble();
                                    scanner.nextLine();
                
                moneda resultado = conversor.convertir(codigoMonedaBase, codigoMonedaFinal, cantidad);
                System.out.println(resultado);

                System.out.println("¿Quieres realizar otra conversion?");
                System.out.println("(Presione 9 para continuar) (Presiona 0 oara salir)");
                    int respuesta = scanner.nextInt();
                                    scanner.nextLine();

                    if (respuesta == 0) {
                        System.out.println("Saliendo del programa...");
                        break;
                    }else if (respuesta == 9) {
                        continue;
                    }
            
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
