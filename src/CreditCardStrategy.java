public class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;
    private String cvv;
    private String expirationDate;

    public CreditCardStrategy(String cardNumber, String cvv, String expirationDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean pay(double amount) {
        // Lógica para procesar pago con tarjeta de crédito
        System.out.println("Procesando pago de Q" + amount + " con tarjeta de crédito: " + cardNumber);
        return true; // Retorna true si el pago es exitoso
    }
}
