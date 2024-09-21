public class BankTransferStrategy implements PaymentStrategy {
    private String bankName;
    private String accountNumber;
    private String accountHolderName;

    public BankTransferStrategy(String bankName, String accountNumber, String accountHolderName) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
    }

    @Override
    public boolean pay(double amount) {
        // Lógica para procesar una transferencia bancaria
        System.out.println("Procesando transferencia bancaria de " + amount + " a través del banco " + bankName
                + " con el número de cuenta " + accountNumber
                + " a nombre de " + accountHolderName + ".");
        return true; // Retorna true si el pago es exitoso
    }
}
