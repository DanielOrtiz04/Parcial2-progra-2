public class PaymentStrategyFactory {
    public static PaymentStrategy createPaymentStrategy(String type, String... args) {
        switch (type.toLowerCase()) {
            case "creditcard":
                return new CreditCardStrategy(args[0], args[1], args[2]); // Número de tarjeta, CVV, Expiración
            case "paypal":
                return new PayPalStrategy(args[0], args[1]); // Email, Contraseña
            case "crypto":
                return new CryptoStrategy(args[0]); // Dirección de criptomonedas
            case "banktransfer":
                return new BankTransferStrategy(args[0], args[1], args[2]); // Banco, Número de cuenta, Titular
            default:
                throw new IllegalArgumentException("Tipo de pago no soportado: " + type);
        }
    }
}
