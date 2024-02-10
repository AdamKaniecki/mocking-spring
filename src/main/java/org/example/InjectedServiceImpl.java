package org.example;

public class InjectedServiceImpl implements InjectedService{
    @Override
    public String firstMethod(String s) {
        return "coś w kodzie źródłowym " + s;
    }
}
