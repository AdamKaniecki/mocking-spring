package org.example;

public class InjectedServiceImpl implements InjectedService{
    @Override
    public String firstMetod(Dog inputDog) {
        return "coś w kodzie źródłowym " + inputDog;
    }
}
