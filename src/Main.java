public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(15000);

        try {
            while (true) {
                try {
                    account.withDraw(6000);
                    System.out.println("Снято 6000 сом.Оставшаяся сумма: " + account.getAmount() + " сом.");
                } catch (LimitException e) {
                    System.out.println("Попытка вывести сумму, превышающую остаток.");
                    System.out.println("Оставшаяся сумма на счету: " + e.getRemainingAmount() + " сом.");
                    account.withDraw(e.getRemainingAmount()); // Снимаем только доступную сумму
                    break; // Завершаем бесконечный цикл
                }
            }
        } catch (LimitException e) {
            System.out.println("Unexpected LimitException occurred: " + e.getMessage());
        }
    }
}