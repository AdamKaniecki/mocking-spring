package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {TestBeanConfiguration.class})
@ContextConfiguration(classes = {BeanConfiguration.class})
class CapacityCalculationServiceImplTest {

    @Autowired
    private CapacityCalculationService capacityCalculationService;
    @Autowired
    private  WidthCalculationService widthCalculationService;
    @Autowired
    private  HeightCalculationService heightCalculationService;
    @Autowired
    private  DepthCalculationService depthCalculationService;;

//    na etapie setUp podnosimy SpringContext i sprawdzamy czy te beany nie są nullami
    @BeforeEach
    void setUp(){
       Assertions.assertNotNull(capacityCalculationService);
       Assertions.assertNotNull(widthCalculationService);
       Assertions.assertNotNull(heightCalculationService);
       Assertions.assertNotNull(depthCalculationService);
    }

//    metoda która daje nam jakieś dane wejściowe
    private InputData someInputData(){
    return InputData.builder()
            .depth("1")
            .width("2")
            .height("3")
            .build();
    }

    @Test
    void someCalculation() {
//        given
        final var inputData = someInputData();
//when
        final var result = capacityCalculationService.someCalculation(inputData);
//        then
        Assertions.assertEquals(new BigDecimal("6"), result);
    }



}