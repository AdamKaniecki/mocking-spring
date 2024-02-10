package org.example;

public class ClassWithDependency implements ServiceWithDependency{

    private InjectedService injectedService;

    @Override
    public void setInjectedService(InjectedService injectedService) {
        this.injectedService = injectedService;
    }

    @Override
    public boolean secondMethod() {
        return injectedService.firstMetod();
    }
}
