package org.example;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ClassWithDependencyTest {

    @InjectMocks
    ClassWithDependency classWithDependency;

    @Mock
    InjectedService injectedService;

    @Test
    void sampleMethod(){
//        given
        Mockito.when(injectedService.firstMetod()).thenReturn(true);
//        when
boolean result = classWithDependency.secondMethod();
//        then
        assertTrue(result);

    }


}