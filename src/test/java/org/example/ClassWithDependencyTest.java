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
//jeśli dodamy eq("wartość), anyString lub "wartość2" no to Mockito wtedy sprawdza co było podane do metody firstMethod
//        i stubbing działa jeśli ustalenia pokrywają się z kodem źródłowym
        Mockito.when(injectedService.firstMetod(eq("coś w testach1"), anyString())).thenReturn("coś w testach");
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