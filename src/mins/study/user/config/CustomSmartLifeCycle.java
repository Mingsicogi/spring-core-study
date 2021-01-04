package mins.study.user.config;

import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomSmartLifeCycle implements SmartLifecycle {

    private boolean isStarted = false;

    @Override
    public void start() {
        System.out.println(">>>>>>>>>>> Start CustomSmartLifeCycle");
        this.isStarted = true;
    }

    @Override
    public void stop() {
        System.out.println(">>>>>>>>>>> Start CustomSmartLifeCycle");
        this.isStarted = false;
    }

    @Override
    public boolean isRunning() {
        return this.isStarted;
    }

    @Override
    public int getPhase() {
        return Integer.MAX_VALUE;
    }
}
