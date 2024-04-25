package project.example.teacher.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class School {


    @Id
    @GeneratedValue
    private Integer schoolId;
    private String schoolName;
    private String schoolLocation;

    @OneToMany(mappedBy="school",
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Event> events;

}