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
//jeśli metoda firstMethod przyjmie jakiegoś Stringa to Stubber zwróci wartość "some value
        Mockito.doReturn("some value")
                .when(injectedService)
                        .firstMethod(ArgumentMatchers.anyString());

//jeśli Stubber zwróci wartość "some value" to zalicz wynik tesu
//        when
        String result = classWithDependency.secondMethod();
        Assertions.assertEquals("some value", result);

//        then


    }




}