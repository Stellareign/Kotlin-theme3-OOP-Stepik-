package tasks.task_3_20_bankAccount

open class BankAccount (private var balance: Int = 0) {

    fun deposit(amount: Int){
        if(amount > 0) {
            balance += amount;
        }
    }
    protected fun withdraw(amount: Int){
        if(amount < 0 || amount < balance) {
            balance -= amount;
        }
    }
    fun getBalance() : Int = balance;

}