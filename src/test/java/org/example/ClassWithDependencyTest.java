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
       Mockito.when(injectedService.firstMethod()).thenReturn("test1");
       Mockito.when(injectedService.thirdMethod()).thenReturn("test2");


//        when
        String result = classWithDependency.secondMethod();
        Assertions.assertEquals("test2test1", result);

//        then
//        sprawdzenie mockito ile razy dana metoda na zaślepce została wykonana(czy została wykonana 1 raz), jeśli raz
//        to test zakończony powodzeniem
        Mockito.verify(injectedService, Mockito.times(1)).firstMethod();
        Mockito.verify(injectedService, Mockito.times(1)).thirdMethod();


    }




}