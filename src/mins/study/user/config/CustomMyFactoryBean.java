package mins.study.user.config;

import org.springframework.beans.factory.FactoryBean;

public class CustomMyFactoryBean implements FactoryBean<CustomBeanObject> {

    @Override
    public CustomBeanObject getObject() throws Exception {
        return new CustomBeanObject();
    }

    @Override
    public Class<?> getObjectType() {
        return CustomBeanObject.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
