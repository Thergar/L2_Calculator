package Lineage2Calculator.Utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Utility class responsible for managing the creation and configuration
 * of the {@link EntityManagerFactory} instance used for database connection.
 * <p>
 *     Reads database connection properties from the {@code database.properties}
 *     file located in the {@code resources} directory.
 * </p>
 */
public class DatabaseConnection {

    private static EntityManagerFactory entityManagerFactory;

/**
 * Retrieves single instance of {@link EntityManagerFactory}.
 * <p>
 *     If the instance has not been created yet, it initializes it
 *     using the database configurations specified in the {@code database.properties} file.
 * </p>
 *
 * @return The {@link EntityManagerFactory} instance.
 * @throws RuntimeException if the {@code database.properties} cannot be found or read.
 */
    public static EntityManagerFactory getEntityManagerFactory() {

        Properties properties = loadDatabaseProperties();

                Map<String, String> configOverrides = new HashMap<>();
                configOverrides.put("javax.persistence.jdbc.url", properties.getProperty("db.url"));
                configOverrides.put("javax.persistence.jdbc.user", properties.getProperty("db.user"));
                configOverrides.put("javax.persistence.jdbc.password", properties.getProperty("db.password"));

                return entityManagerFactory = Persistence.createEntityManagerFactory("L2Persistence", configOverrides);
    }

    private static Properties loadDatabaseProperties() {

        Properties properties = new Properties();

        try(InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("database.properties")) {

            if (input == null) {
                throw new IOException("Unable to find database.properties file");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
