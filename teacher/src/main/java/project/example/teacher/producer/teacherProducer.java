package project.example.teacher.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.String.format;


@Slf4j
@Service
@RequiredArgsConstructor
public class teacherProducer {


    private final KafkaTemplate<String, String> kafkatemplate;

      public void sendMessage(String msg) {
          log.info(format("sending the msg::%s",msg));
          kafkatemplate.send("request",msg);
      }
      }
