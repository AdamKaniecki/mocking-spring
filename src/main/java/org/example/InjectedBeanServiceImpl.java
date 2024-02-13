package org.example;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InjectedBeanServiceImpl implements InjectedBeanService {
    @Override
    public boolean secondMethod() {
        System.out.println("coś tam");
        return false;
    }
}
