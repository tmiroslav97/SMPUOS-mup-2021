package rs.uns.acs.ftn.HealthService.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String mongodb_host;

    @Value("${spring.data.mongodb.port}")
    private String mongodb_port;

    @Value("${spring.data.mongodb.database}")
    private String mongodb_database;


    @Override
    protected String getDatabaseName() {
        return this.mongodb_database;
    }


}
