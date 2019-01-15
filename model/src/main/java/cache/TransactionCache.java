package cache;

import entities.Transaction;

import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TransactionCache {

    private static ConcurrentLinkedQueue<Transaction> depositCache = new ConcurrentLinkedQueue<>();

    public void save(Transaction transaction) {
        depositCache.add(transaction);
    }

    public Optional<Transaction> get(){
        if(depositCache.isEmpty())
            return Optional.empty();

        return Optional.of(depositCache.poll());
    }
}
