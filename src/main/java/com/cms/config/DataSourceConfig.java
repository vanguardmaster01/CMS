import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataSourceConfig {
    @Bean
    @Qualifier("cmsDataSource")
    public DataSource cmsDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(cmsDriverName);
        dataSourceBuilder.url(cmsUrl);
        dataSourceBuilder.username(cmsUserName);
        dataSourceBuilder.password(cmsPassword);
        return dataSourceBuilder.build();
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, JpaProperties jpaProperties,
            @Qualifier("cmsDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.package1") // Specify the entity package for DataSource 1
                .properties(jpaProperties.getProperties())
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory2(
            EntityManagerFactoryBuilder builder, JpaProperties jpaProperties,
            @Qualifier("dataSource2") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.package2") // Specify the entity package for DataSource 2
                .properties(jpaProperties.getProperties())
                .build();
    }
}