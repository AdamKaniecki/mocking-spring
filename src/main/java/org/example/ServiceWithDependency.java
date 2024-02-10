package org.example;

public interface ServiceWithDependency {

    void setInjectedService(InjectedService injectedService);
    boolean secondMethod();
}
