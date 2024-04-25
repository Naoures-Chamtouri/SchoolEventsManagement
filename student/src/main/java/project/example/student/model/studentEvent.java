package project.example.student.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class studentEvent {
    private Integer student_eventId;
    private Integer studentId;

//    @ManyToOne
//    @JoinColumn(name = "studentId")
//    @JsonBackReference
//    private Event event;
}
