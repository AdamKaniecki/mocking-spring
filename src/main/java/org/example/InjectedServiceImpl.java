package org.example;

public class InjectedServiceImpl implements InjectedService{
    @Override
    public String firstMetod(String inputString, String s) {
        return "coś w kodzie źródłowym " + inputString;
    }
}
