public class PayPalStrategy implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean pay(double amount) {
        // Lógica para procesar pago con PayPal
        System.out.println("Procesando pago de Q" + amount + " con PayPal: " + email);
        return true; // Retorna true si el pago es exitoso
    }
}
