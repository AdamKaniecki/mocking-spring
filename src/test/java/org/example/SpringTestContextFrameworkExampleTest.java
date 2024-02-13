package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = ConfigScanBean.class)
public class SpringTestContextFrameworkExampleTest {

    @Autowired
    ExampleBeanService exampleBeanService;

    @BeforeEach
    public void setUp(){
        Assertions.assertNotNull(exampleBeanService);
    }

    @Test
    void testFirstMethod(){
        boolean result = exampleBeanService.firstMethod();
        Assertions.assertFalse(result);
    }


}
