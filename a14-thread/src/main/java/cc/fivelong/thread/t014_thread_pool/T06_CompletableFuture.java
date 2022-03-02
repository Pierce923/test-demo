package cc.fivelong.thread.t014_thread_pool;

import java.util.concurrent.CompletableFuture;

public class T06_CompletableFuture {

    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {return "aa";});


    }

}
