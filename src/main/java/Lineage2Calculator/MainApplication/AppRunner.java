package Lineage2Calculator.MainApplication;

import Lineage2Calculator.ApplicationFacade;

/**
 * A class responsible for initializing and running the application.
 */
public class AppRunner {

/**
 * The facade instance used to manage application startup.
 */
    private final ApplicationFacade applicationFacade;

/**
 * Constructs an {@code AppRunner} object with the specified instance of {@link ApplicationFacade}.
 */
    public AppRunner(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

/**
 * Starts the application by delegating execution to the {@link ApplicationFacade}.
 */
    public void run() {
        applicationFacade.runApplication();
    }
}
