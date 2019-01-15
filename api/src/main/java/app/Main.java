package app;

import resource.TransferResource;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8080);
        post("/transfer","application/json",TransferResource.serveLoginPage);
    }
}
