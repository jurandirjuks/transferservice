package app;

import job.Job;
import resource.TransferResource;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        startJob();


        port(8080);
        post("/transfer","application/json",TransferResource.transfer);
    }

    private static void startJob() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Job(),0,1, TimeUnit.SECONDS);
    }
}
