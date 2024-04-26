package project.example.teacher.dto;

import lombok.*;
import java.time.LocalDate;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class eventDTO {


    private Integer eventId;
    private String eventName;
    private String eventDescription;
    private LocalDate eventDate;


    private Integer schoolId;

}
