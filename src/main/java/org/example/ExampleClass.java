package org.example;


// żeby przetestować tę klasę:
public class ExampleClass {
//    musimy zaślepić tę klasę
    private OtherExampleClass otherExampleClass;


    public void exampleClassMethod(){
//        musimy zaślepić to zachowanie
        otherExampleClass.otherClassMethod();

    }
}
