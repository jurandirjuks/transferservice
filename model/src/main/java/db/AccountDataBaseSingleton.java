package db;

public class AccountDataBaseSingleton {

    private static AccountDataBase accountDataBase;

    public static AccountDataBase get(){
        if(accountDataBase == null){
            accountDataBase = new AccountDataBase();
        }
        return accountDataBase;
    }


}
