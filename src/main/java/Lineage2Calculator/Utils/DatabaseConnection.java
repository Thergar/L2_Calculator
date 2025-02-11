package Lineage2Calculator.Utils;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Utility class responsible for managing the creation and configuration
 * of the {@link EntityManagerFactory} instance used for database connection.
 * <p>
 *     Reads database connection properties from the {@code database.properties}
 *     file located in the {@code resources} directory.
 * </p>
 */
@Configuration
public class DatabaseConnection {


    /**
     * Configures the {@link LocalContainerEntityManagerFactoryBean}, which is
     * the JPA-specific extension of the {@link EntityManagerFactory}.
     *
     * @param dataSource the {@link DataSource} used for database connectivity.
     * @return a configured instance of {@link LocalContainerEntityManagerFactoryBean}.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        // Set the datasource for database connection
        factoryBean.setDataSource(dataSource);
        // Set the package(s) to scan for JPA entities
        factoryBean.setPackagesToScan("Lineage2Calculator");

        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return factoryBean;
    }

    /**
     * Configures the transaction manager for JPA, enabling declarative transaction management
     * using annotations like {@code @Transactional} throughout the application.
     *
     * @param entityManagerFactory the {@link EntityManagerFactory} used for managing JPA entities.
     * @return a configured {@link JpaTransactionManager}.
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
