package project.example.student.model;


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
public class Student {

    @Id
    @GeneratedValue
    private Integer studentId;
    private String firstName;
    private String lastName;
    private Integer schoolId;
    @OneToMany(mappedBy="student",
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<studentEvent> Events;


}
