package project.example.teacher.controller;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EventDTO {
    private String eventName;
    private String eventDescription;
    private LocalDate eventDate;
    private Integer schoolId;
}
