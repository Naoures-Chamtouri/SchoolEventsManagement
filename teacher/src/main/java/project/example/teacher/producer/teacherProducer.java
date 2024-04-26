package project.example.teacher.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import project.example.teacher.controller.EventDTO;
import project.example.teacher.model.Event;


@Service
@RequiredArgsConstructor
public class teacherProducer {


    private final KafkaTemplate<String, EventDTO> kafkatemplate;

      public void sendMessage(EventDTO event){
          Message<EventDTO> message= MessageBuilder.withPayload(event).setHeader(KafkaHeaders.TOPIC,"event").build();
          kafkatemplate.send(message);
      }
}
