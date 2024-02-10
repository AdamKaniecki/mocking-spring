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
// jeśli metoda firstMetod zostanie wywołana z konktretną wartością to wtedy stubbing zadziała, a jak nie to
//        Mockito zwróci nulla i test się nie powiedzie
        Mockito.when(injectedService.firstMetod("coś w testach1")).thenReturn("coś w testach");
//        when
        String result1 = classWithDependency.secondMethod("coś w testach1");
        String result2 = classWithDependency.secondMethod("coś w testach2");
        String result3 = classWithDependency.secondMethod("coś w testach3");
        String result4 = classWithDependency.secondMethod("coś w testach4");
        String result5 = classWithDependency.secondMethod("coś w testach5");
//        then

        assertEquals(result1, "coś w testach");

    }




}