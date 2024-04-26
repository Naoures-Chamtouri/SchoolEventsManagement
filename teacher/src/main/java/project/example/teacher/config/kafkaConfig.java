package project.example.teacher.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableKafka
public class kafkaConfig {
    @Bean
    public NewTopic eventTopic(){
        return TopicBuilder.name("request").build();
    }
}
