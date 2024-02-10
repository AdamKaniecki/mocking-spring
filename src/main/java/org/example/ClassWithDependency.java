package org.example;

public class ClassWithDependency implements ServiceWithDependency{

    private InjectedService injectedService;

    @Override
    public void setInjectedService(InjectedService injectedService) {
        this.injectedService = injectedService;
    }

    @Override
    public String secondMethod(Dog inputDog) {
        return injectedService.firstMetod(inputDog);
    }
}
