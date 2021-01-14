package mins.study.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LookUpMethodInjectionConfiguration {

    @Bean
    public CommandManager add() {
        return new CommandManager() {
            @Override
            protected Command createCommand() {
                return () -> System.out.println("Add Processing... ...");
            }
        };
    }

    @Bean
    public CommandManager sub() {
        return new CommandManager() {
            @Override
            protected Command createCommand() {
                return () -> System.out.println("sub Processing... ...");
            }
        };
    }

    @Bean
    public CommandManager mul() {
        return new CommandManager() {
            @Override
            protected Command createCommand() {
                return () -> System.out.println("mul Processing... ...");
            }
        };
    }

    public abstract static class CommandManager {

        Command command;

        public void executeCommand() {
            if(command == null) {
                this.command = createCommand();
            }

            command.execute();
        }

        protected abstract Command createCommand();
    }
}

interface Command {
    void execute();
}
