package project.example.teacher.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class teacherEvent {

    @Id
    @GeneratedValue
    private Integer teacher_eventId;
    @ManyToOne
    @JoinColumn(name = "teacherId")
    @JsonBackReference
    private Teacher teacher;
}
