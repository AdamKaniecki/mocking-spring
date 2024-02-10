package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassWithDependencyTest {


    @Test
    void secondMethod() {

//       given

        ServiceWithDependency serviceWithDependency = new ClassWithDependency();
//        tu na potrzeby testów mogę wstrzyknąć inną implementację InjectedService
        serviceWithDependency.setInjectedService(new StubInjectedBeanService());


//        when
        boolean result = serviceWithDependency.secondMethod();

//        then
        Assertions.assertEquals(true, result);

    }


    //klasa która tak jak InjectedServiceImpl implementuje InjectedService, ale implementacja
// metody firstMethod jest inna (true-false)
    static class StubInjectedBeanService implements InjectedService {

        @Override
        public boolean firstMetod() {
            return true;
        }
    }
}