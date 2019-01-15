package exceptions;

public class NoFundsException extends Exception {

    public NoFundsException(){
        super("It is not allowed to make a transfer with insufficient balance");
    }

}
