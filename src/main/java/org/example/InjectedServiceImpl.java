package org.example;

public class InjectedServiceImpl implements InjectedService{
    @Override
    public String firstMetod(String inputString) {
        return "coś w kodzie źródłowym " + inputString;
    }
}
