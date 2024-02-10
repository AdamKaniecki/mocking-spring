package org.example;

public class InjectedServiceImpl implements InjectedService{
    @Override
    public String firstMethod() {
        return "kod1 ";
    }

    @Override
    public String thirdMethod() {
        return "kod2 ";
    }
}
