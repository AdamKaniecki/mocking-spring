package org.example;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Marker.class)
public class TestBeanConfiguration {
//konfiguracja aplikacji testowej ale rzadko się robi tym sposobem
    @Mock
    private DepthCalculationService depthCalculationService;


    public TestBeanConfiguration() {
        try (AutoCloseable autoCloseable = MockitoAnnotations.openMocks(this)) {
            System.out.println("correctly opened mocks");
        } catch (Exception e) {
            System.out.println("unable to open mocks: " + e);
            throw new RuntimeException(e);

        }
    }
        @Bean
        public DepthCalculationService depthCalculationService(){
            return depthCalculationService;
        }


        @Bean
    public WidthCalculationService widthCalculationService(){
        return Mockito.mock(WidthCalculationService.class);
        }

    }

