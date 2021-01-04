package mins.study.user.config;

import java.util.concurrent.atomic.AtomicInteger;

public interface CommonConfiguration {

    AtomicInteger callCounter = new AtomicInteger(0);

    default void print() {
        System.out.println(String.format("==== Common Configuration : %s ====", callCounter.addAndGet(1)));
    }
}
