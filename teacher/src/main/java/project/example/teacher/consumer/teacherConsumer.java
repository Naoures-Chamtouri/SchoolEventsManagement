package project.example.teacher.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;


@Service
@Slf4j

public class teacherConsumer {

    @KafkaListener(topics="Response",groupId = "school_teacher")
    public void consumeEvent(String resp){
        log.info(format("Response :: %s",resp));
















        Integer key = extractKeyFromResponse(resp);
        if (key != null) {
            log.info("Extracted key from response: {}", key);

        }
    }


























    private Integer extractKeyFromResponse(String resp) {
        Pattern pattern = Pattern.compile("Request Adding event accepted\\.key: : (\\d+)");
        Matcher matcher = pattern.matcher(resp);
        if (matcher.find()) {
            String keyStr = matcher.group(1);
            return Integer.parseInt(keyStr);
        }
        return null;
    }
}