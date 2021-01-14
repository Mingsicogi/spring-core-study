package mins.study.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InternallyWorkingConfiguration {

    @Bean
    public ClientService clientService1() {
        System.out.println("Called clientService1");
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao());
        return clientService;
    }

    @Bean
    public ClientService clientService2() {
        System.out.println("Called clientService2");
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao());
        return clientService;
    }

    @Bean
    public ClientDao clientDao() {
        System.out.println("Called clientDao");
        return new ClientDaoImpl();
    }
}

interface ClientService {

}

class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }
}

interface ClientDao {

}

class ClientDaoImpl implements ClientDao {

}


