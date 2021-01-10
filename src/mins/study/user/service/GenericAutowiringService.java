package mins.study.user.service;

import mins.study.user.config.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class GenericAutowiringService {

    @Autowired
    Storage<String> stringStorage;

    @Autowired
    Storage<Integer> integerStorage;

    @Value("${ehcache.name}")
    String cacheName;

    public void printInstanceType() {
        System.out.println(stringStorage.getType().getName());
        System.out.println(integerStorage.getType().getName());
        System.out.println(cacheName);
    }
}
