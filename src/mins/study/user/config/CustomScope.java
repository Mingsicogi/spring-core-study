package mins.study.user.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CustomScope implements Scope {

    // Synchronized Map => scopes can be used by multiple bean factories at the same time.
    private Map<String, Object> scopedObjects = Collections.synchronizedMap(new HashMap<>());
    private Map<String, Runnable> destructionCallbacks = Collections.synchronizedMap(new HashMap<>());

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {

        if(!scopedObjects.containsKey(name)) {
            System.out.println("Custom Scope ===> Created(Get) | name : " + name);
            scopedObjects.put(name, objectFactory.getObject());
            return scopedObjects.get(name);
        } else {
            System.out.println("Custom Scope ===> Get | name : " + name);
            return scopedObjects.get(name);
        }

    }

    @Override
    public Object remove(String name) {

        System.out.println("Custom Scope ===> remove | name : " + name);

        destructionCallbacks.remove(name);
        return scopedObjects.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

        System.out.println("Custom Scope ===> registerDestructionCallback | name : " + name);

        destructionCallbacks.put(name, callback);
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return "custom";
    }
}
