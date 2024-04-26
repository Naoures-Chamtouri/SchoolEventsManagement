package project.example.school.consumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import project.example.school.model.Event;

import static java.text.MessageFormat.format;


@Service
@Slf4j
public class schoolConsumer {



    @KafkaListener(topics="event",groupId = "school_teacher")
    public void consumeEvent(Event event){
        log.info(format("consuming the msg::%s",event.toString()));

    }

}
