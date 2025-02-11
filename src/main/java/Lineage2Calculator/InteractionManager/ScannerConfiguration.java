package Lineage2Calculator.InteractionManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

/**
 * Configuration class for application-wide beans.
 */
@Configuration
public class ScannerConfiguration {

    /**
     * Provides a shared {@link Scanner} instance for user input.
     *
     * @return a new {@link Scanner} instance bound to System.in.
     */
    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
