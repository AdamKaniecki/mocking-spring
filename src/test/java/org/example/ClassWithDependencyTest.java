package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class ClassWithDependencyTest {

    @InjectMocks
    ClassWithDependency classWithDependency;

    @Mock
    InjectedService injectedService;

    @Test
    void sampleMethod() {
//        given
//najlepiej stosować tą konwencje when-then
       Mockito.when(injectedService.firstMethod()).thenReturn("some value");


//        when
        String result = classWithDependency.secondMethod();
        Assertions.assertEquals("some value", result);

//        then


    }




}