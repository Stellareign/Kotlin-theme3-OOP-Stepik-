package tasks.task_3_20_bankAccount

class SpecialBankAccount(val balance: Int) : BankAccount(balance) {
    fun specialWithdraw(amount: Int){
        withdraw(amount);
    }
}