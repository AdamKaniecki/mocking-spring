package org.example;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ExampleBeanServiceImpl implements ExampleBeanService {

    private InjectedBeanService injectedBeanService;

    @Override
    public boolean firstMethod() {
        return injectedBeanService.secondMethod();
    }
}
