package com.example.druid8082.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author: liaozhenyu
 * @date: 2022/09/26
 **/

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="oaEntityManagerFactory",
        transactionManagerRef="oaTransactionManager",
        basePackages= OaDataSourceConfig.JPA_PACKAGE)
public class OaDataSourceConfig {

    static final String JPA_PACKAGE = "com.example.druid8082.repository";
    static final String ENTITY_LOCATION = "com.example.druid8082.entity";

    @Autowired
    private JpaProperties jpaProperties;

    @Bean("oaDataSource")
    @ConfigurationProperties(prefix = "oa.datasource.druid")
    public DataSource oaDataSource() {
        return new DruidDataSource();
    }

    @Bean("oaEntityManagerFactory")
    public EntityManagerFactory oaEntityManagerFactory(@Qualifier("oaDataSource") DataSource oaDataSource) {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(oaDataSource);
        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factory.setJpaPropertyMap(jpaProperties.getProperties());
        adapter.setShowSql(jpaProperties.isShowSql());
        factory.setJpaVendorAdapter(adapter);
        factory.setPackagesToScan(OaDataSourceConfig.ENTITY_LOCATION);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean("oaTransactionManager")
    public PlatformTransactionManager oaTransactionManager(@Qualifier("oaEntityManagerFactory") EntityManagerFactory oaEntityManagerFactory) {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(oaEntityManagerFactory);
        return manager;
    }

}
