package project.example.school.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    private Integer eventId;
    private String eventName;
    private String eventDescription;
    private LocalDate eventDate;

    @ManyToOne
    @JoinColumn(name = "schoolId")
    @JsonBackReference
    private School school;
}
