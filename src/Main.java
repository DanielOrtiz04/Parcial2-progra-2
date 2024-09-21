import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Selecciona el método de pago:");
            System.out.println("1. Tarjeta de crédito");
            System.out.println("2. PayPal");
            System.out.println("3. Criptomonedas");
            System.out.println("4. Transferencia bancaria");

            int opcion = scanner.nextInt();
            PaymentStrategy strategy = null;

            switch (opcion) {
                case 1:
                    // Solicitar datos de tarjeta de crédito
                    System.out.println("Ingresa el número de la tarjeta:");
                    String cardNumber = scanner.next();
                    System.out.println("Ingresa el código de seguridad (CVV):");
                    String cvv = scanner.next();
                    System.out.println("Ingresa la fecha de expiración (MM/AA):");
                    String expiration = scanner.next();
                    strategy = PaymentStrategyFactory.createPaymentStrategy("creditcard", cardNumber, cvv, expiration);
                    break;
                case 2:
                    // Solicitar datos de PayPal
                    System.out.println("Ingresa el email de PayPal:");
                    String email = scanner.next();
                    System.out.println("Ingresa la contraseña de PayPal:");
                    String password = scanner.next();
                    strategy = PaymentStrategyFactory.createPaymentStrategy("paypal", email, password);
                    break;
                case 3:
                    // Solicitar datos de criptomonedas
                    System.out.println("Ingresa la dirección de la billetera de criptomonedas:");
                    String cryptoAddress = scanner.next();
                    strategy = PaymentStrategyFactory.createPaymentStrategy("crypto", cryptoAddress);
                    break;
                case 4:
                    // Solicitar datos de transferencia bancaria
                    System.out.println("Ingresa el nombre del banco:");
                    String bankName = scanner.next();
                    System.out.println("Ingresa el número de cuenta:");
                    String accountNumber = scanner.next();
                    System.out.println("Ingresa el nombre del titular de la cuenta:");
                    String accountHolderName = scanner.next();
                    strategy = PaymentStrategyFactory.createPaymentStrategy("banktransfer", bankName, accountNumber, accountHolderName);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    continue; // Reiniciar el bucle si la opción es inválida
            }

            if (strategy != null) {
                processor.setPaymentStrategy(strategy);

                // Solicitar el monto del pago
                System.out.println("Ingresa el monto a pagar:");
                double amount = scanner.nextDouble();

                processor.processPayment(amount);
            }

            // Preguntar si se desea hacer otra transacción
            System.out.println("¿Deseas realizar otra transacción? (s/n):");
            String respuesta = scanner.next().toLowerCase();

            if (!respuesta.equals("s")) {
                continuar = false;
                System.out.println("Gracias por usar el sistema de pagos.");
            }
        }
    }
}

