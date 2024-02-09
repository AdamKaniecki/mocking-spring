package org.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith((MockitoExtension.class))
class ExampleClassTest {

//    tu oznaczamy którą klasę testujemy
    @InjectMocks
    ExampleClass exampleClass;

//    a tu zaznaczamy którą klasę zaślepiamy
    @Mock
    OtherExampleClass otherExampleClass;

}