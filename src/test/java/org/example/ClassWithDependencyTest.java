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
import static org.mockito.ArgumentMatchers.anyString;
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
//    jeśli metoda w kodzie źródłowym przyjmie jakiegokolwiek Stringa to rzuć  wyjątek
        Mockito.when(injectedService.firstMetod(ArgumentMatchers.anyString())).thenThrow(
                new RuntimeException("my exception")
        );
//        przy wywołaniu metody secondMethod w teście jeśli został wyrzucony odpowiedni wyjątek to zalicz test

//        when
        Assertions.assertThrows(RuntimeException.class,()-> classWithDependency.secondMethod());

//        then


    }




}