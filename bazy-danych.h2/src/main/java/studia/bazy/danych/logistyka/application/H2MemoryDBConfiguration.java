package studia.bazy.danych.logistyka.application;

import javax.sql.DataSource;

@Configuration
@Profile("H2")
public class H2MemoryDBConfiguration {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .build();
    }

}
