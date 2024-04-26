package project.example.school.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class schoolProducer {

    private final KafkaTemplate<String, String> kafkatemplate;

    public void sendResponse(String msg) {
        log.info(format("sending the msg::%s",msg));
        kafkatemplate.send("Response",msg);
    }
}
