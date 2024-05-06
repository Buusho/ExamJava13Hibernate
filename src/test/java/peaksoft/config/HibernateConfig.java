package peaksoft.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfig {

    public static Properties properties() {
        Properties properties = new Properties();
        properties.setProperty(Environment.JAKARTA_JDBC_DRIVER, "org.postgresql.Driver");
        properties.setProperty(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/examjava13");
        properties.setProperty(Environment.JAKARTA_JDBC_USER, "postgres");
        properties.setProperty(Environment.JAKARTA_JDBC_PASSWORD, "1234");
        properties.setProperty(Environment.HBM2DDL_AUTO, "create");
        properties.setProperty(Environment.SHOW_SQL, "true");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

        return properties;
    }

    public static EntityManagerFactory entityManagerFactory() {
        Configuration configuration = new Configuration();
        configuration.addProperties(properties());

     //   configuration.addAnnotatedClass(Rent_info.class);

        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }

}
