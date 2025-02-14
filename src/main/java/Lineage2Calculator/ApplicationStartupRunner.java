package Lineage2Calculator;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * The {@code ApplicationStartupRunner} class responsible for executing application logic
 * during the Spring Boot startup.
 * <p>
 *     Implements the {@link ApplicationRunner} interface, which allows running additional processes after
 *     the Spring context has been initialized, but before the application is fully up and running.
 * </p>
 */
@Component
public class ApplicationStartupRunner implements ApplicationRunner {

    /**
     * The application's facade responsible for managing primary operations.
     */
    private final ApplicationFacade applicationFacade;

    /**
     * Constructor accepting the application's facade dependency.
     *
     * @param applicationFacade the application facade instance.
     */
    public ApplicationStartupRunner(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    /**
     * Method executed after the application has started, invoking logic from the application facade.
     * <p>
     * This is where you can run additional startup processes or logic, such as
     * data initialization or the execution of algorithms. In this case, the
     * {@code findPath()} method from the facade is invoked.
     * </p>
     *
     * @param args the arguments passed during application startup
     */
    @Override
    public void run(ApplicationArguments args) {

        applicationFacade.findPath();
    }
}
