package Lineage2Calculator.Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

/**
 * Configures and manages access to the {@link EntityManagerFactory}, which is used
 * to create objects of {@link EntityManager}.
 *
 * <p>
 *     The {@code JpaConfig} uses the database connection configured by the {@link DatabaseConnection} class
 *     to initialize {@code EntityManagerFactory}.
 * </p>
 * <p>
 *     The static block retrieves the instance of {@link EntityManagerFactory}
 *     from the {@link DatabaseConnection} class. It guarantees that the initialization
 *     occurs only once while {@code JpaConfig} class is loaded.
 * </p>
 */
public class JpaConfig {

/**
 * Instance of EntityManagerFactory, that is used for interacting with the database.
 */
    protected static final EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = DatabaseConnection.getEntityManagerFactory();
    }

/**
 * Creates and return new {@link EntityManager} instance.
 * <p>
 *     The {@code EntityManager} is used for CRUD operation on entities from database.
 * </p>
 *
 * @return a new {@link EntityManager} instance
 */
    public static EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

/**
 * Closes the {@link EntityManagerFactory} if it is still open.
 */
    private static void emfClose() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}
