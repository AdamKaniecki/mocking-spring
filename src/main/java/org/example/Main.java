package org.example;

public class Main {
    public static void main(String[] args) {
     InjectedBeanServiceImpl injectedBeanService = new InjectedBeanServiceImpl();
     ExampleBeanService exampleBeanService = new ExampleBeanServiceImpl();
     exampleBeanService.setInjectedBeanService(injectedBeanService);
        System.out.println(exampleBeanService.sampleMethod());
    }
}
