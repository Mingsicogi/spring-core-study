package mins.study.user.service;

import mins.study.user.config.Storage;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericAutowiringService {

    @Autowired
    Storage<String> stringStorage;

    @Autowired
    Storage<Integer> integerStorage;

    public void printInstanceType() {
        System.out.println(stringStorage.getType().getName());
        System.out.println(integerStorage.getType().getName());
    }
}
