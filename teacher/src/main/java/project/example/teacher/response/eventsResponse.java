package project.example.teacher.response;


import lombok.*;
import project.example.teacher.model.School;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class eventsResponse {
    private List<School> Events;
}
