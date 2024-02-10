package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ExampleClassTest {

//    tu oznaczamy którą klasę testujemy
    @InjectMocks
    ExampleClass exampleClass;

//    a tu zaznaczamy którą klasę zaślepiamy
    @Mock //lub @Spy- zależy co chcemy osiagnac
    OtherExampleClass otherExampleClass;

    @Test
    void someTest(){
//        symulacja zachowania zaślepionego obiektu i ten zaślepiony obiekt moze miec
//        narzucone przeze mnie zachowania zamiast "coś" zawraca "great"
        Mockito.when(otherExampleClass.otherClassMethod()).thenReturn("great");


//        tu testujemy metodę z klasy ExampleClass
        exampleClass.exampleClassMethod();

//sprawdzenie czy obiekt zamockowany @Mock przechodził w teście przez interakcje
//        np.jeśli był i miał być to test zakończy się powodzeniem
//        !!Stuby nie podlegają takiej weryfikacji
//        Mockito.verify();
    }



}