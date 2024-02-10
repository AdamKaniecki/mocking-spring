package org.example;

public class Main {
    public static void main(String[] args) {
        InjectedService injectedService = new InjectedServiceImpl();
        ServiceWithDependency serviceWithDependency = new ClassWithDependency();
        serviceWithDependency.setInjectedService(injectedService);
    }
}
