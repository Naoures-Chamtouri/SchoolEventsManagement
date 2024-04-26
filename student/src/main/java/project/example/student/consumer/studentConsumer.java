package project.example.student.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class studentConsumer {

    @KafkaListener(topics = "Response", groupId = "school_teacher")
    public void consumeEvent(String resp) {
        log.info(format("Response :: %s", resp));
    }
}
