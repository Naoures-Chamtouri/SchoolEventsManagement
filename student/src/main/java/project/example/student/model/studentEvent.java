package project.example.student.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class studentEvent {

    @Id
    @GeneratedValue
    private Integer student_eventId;
    @ManyToOne
    @JoinColumn(name = "studentId")
    @JsonBackReference
    private Student student;
}
