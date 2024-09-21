public class CryptoStrategy implements PaymentStrategy {
    private String walletAddress;

    public CryptoStrategy(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public boolean pay(double amount) {
        // Lógica para procesar pago con criptomonedas
        System.out.println("Procesando pago de Q" + amount + " con criptomonedas a la billetera: " + walletAddress);
        return true; // Retorna true si el pago es exitoso
    }
}
