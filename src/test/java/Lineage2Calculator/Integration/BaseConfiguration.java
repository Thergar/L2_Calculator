package Lineage2Calculator.Integration;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.mockito.internal.creation.SuspendMethod;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Tag("integration")
@Testcontainers
@Transactional
public class BaseConfiguration {

    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:17.4")
            .withDatabaseName("L2_test")
            .withUsername("postgres")
            .withPassword("postgres")
            .withInitScript("L2_towns_dump_test.sql");

    @BeforeAll
    static void setUp() {
        postgreSQLContainer.start();
        System.setProperty("spring.datasource.url", postgreSQLContainer.getJdbcUrl());
        System.setProperty("spring.datasource.username", postgreSQLContainer.getUsername());
        System.setProperty("spring.datasource.password", postgreSQLContainer.getPassword());
    }

    @AfterAll
    static void tearDown() {
        if (postgreSQLContainer != null & postgreSQLContainer.isRunning()) {
            postgreSQLContainer.stop();
        }
    }
}
