package org.example.model;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class ByFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        User u = new User();
        u.setName("快乐水");
        u.setPassword("可乐");
        return u;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
