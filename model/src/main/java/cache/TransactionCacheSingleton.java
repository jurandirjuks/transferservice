package cache;

public class TransactionCacheSingleton {

    private static TransactionCache transactionCache;

    public static TransactionCache get(){
        if(transactionCache==null){
            transactionCache = new TransactionCache();
        }
        return transactionCache;
    }
}
