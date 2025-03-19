package Lineage2Calculator.Utils;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * A class that loads environment variables from a `.env` file and sets them
 * as system properties before the Spring Boot application starts.
 * <p>
 * Implements the {@link EnvironmentPostProcessor} interface, which allows for
 * modifying the application's environment at an early stage, before the Spring
 * application context is fully loaded.
 * </p>
 */
public class DotenvLoaderPostProcessor implements EnvironmentPostProcessor {

    /**
     * A method that modifies the Spring Boot application environment before
     * loading the context.
     * <p>
     * In this implementation, it loads environment variables from a `.env` file
     * using the Dotenv library and adds them as system properties.
     * </p>
     *
     * @param environment  the Spring Boot application environment to be modified
     * @param application  the Spring Boot application instance for further initialization
     */
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

        Dotenv dotenv = Dotenv.configure().load();

        dotenv.entries().forEach(entry -> {environment.getSystemProperties().put(entry.getKey(), entry.getValue());
        });

    }
}
