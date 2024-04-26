package project.example.school.consumer;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import project.example.school.model.Event;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;


@Service
@Slf4j
@Getter
@Setter
public class schoolConsumer {


    private Integer schoolReq;


    @KafkaListener(topics="request",groupId = "school_teacher")
    public void consumeEvent(String request){
        log.info(format("new request :: %s",request));






















       Integer id=extractSchoolId(request);
       if(id>0){
           schoolReq=id;
       }

       System.out.println(schoolReq);


    }

    private Integer extractSchoolId(String request) {
        // Define a regular expression to match the schoolId pattern
        Pattern pattern = Pattern.compile("schoolId=(\\d+)");
        Matcher matcher = pattern.matcher(request);
        if (matcher.find()) {
            String schoolIdStr = matcher.group(1);
            return Integer.parseInt(schoolIdStr);
        }

        return null;
    }

}
