package project.example.student.response;


import lombok.*;
import project.example.student.model.School;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class eventResponse {
    private List<School> Events;
}
