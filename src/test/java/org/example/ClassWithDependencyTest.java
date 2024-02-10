package org.example;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ClassWithDependencyTest {

    @InjectMocks
    ClassWithDependency classWithDependency;

    @Mock
    InjectedService injectedService;

    @Test
    void sampleMethod() {
//        given
//do metody firstMetod wszedł pies czyli cokolwiek i firstMethod zwraca "coś w testach"
//        ewentualnie może być zapis ArgumentMatchers.any(Dog.class)- da taki sam efekt
        Mockito.when(injectedService.firstMetod(ArgumentMatchers.any())).thenReturn("coś w testach");
//        when
        String result1 = classWithDependency.secondMethod(new Dog());
        String result2 = classWithDependency.secondMethod(new Dog());
        String result3 = classWithDependency.secondMethod(new Dog());
        String result4 = classWithDependency.secondMethod(new Dog());
        String result5 = classWithDependency.secondMethod(new Dog());
//        then

        assertEquals(result1, "coś w testach");

    }




}