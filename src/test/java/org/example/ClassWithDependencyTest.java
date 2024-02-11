package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class ClassWithDependencyTest {

    @InjectMocks
    ClassWithDependency classWithDependency;

    @Mock
    InjectedService injectedService;

    @ParameterizedTest
    @MethodSource
    void sampleMethod(String val1, String val2) {
//        given
//najlepiej stosować tę konwencję when-then
       Mockito.when(injectedService.firstMethod()).thenReturn(val1);
       Mockito.when(injectedService.thirdMethod()).thenReturn(val2);


//        when
        String result = classWithDependency.secondMethod();
        Assertions.assertEquals("test1test2", result);

//        then
//        sprawdzenie mockito ile razy dana metoda na zaślepce została wykonana(czy została wykonana 1 raz), jeśli raz
//        to test zakończony powodzeniem
        Mockito.verify(injectedService, Mockito.times(1)).firstMethod();
        Mockito.verify(injectedService, Mockito.times(1)).thirdMethod();


    }

//Arguments z paczki junit-params
static Stream<Arguments> sampleMethod(){
        return Stream.of(
                    Arguments.of("test1","test2"),
                    Arguments.of("test3","test4"),
                    Arguments.of("test5","test6"),
                    Arguments.of("test7","test8")
        );
}

}