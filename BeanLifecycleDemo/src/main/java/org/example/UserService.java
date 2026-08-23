package org.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class UserService implements BeanNameAware, ApplicationContextAware {
    public UserService(){
        System.out.println("User Constructor called");
    }


    @Override                                          //callback methods
    public void setBeanName(String name) {
        System.out.println("Bean name is"+ name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        System.out.println("ApplicationContext name is"+ applicationContext);
    }
}

//callback methods-spring calls the method
//spring is calling this method(we are not doing it manually)
//after bean is created and dependencies are injected , then aware interfaces are called
//lets say we are not implementing BeanNameAware then spring will skip this step