package project.example.teacher.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter

public class teacherDto {

    private Integer teacherId;
    private String firstName;
    private String lastName;
    private Integer schoolId;

    @Override
    public String toString() {
        return "{" +
                "teacherId=" + teacherId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", schoolId=" + schoolId +
                '}';
    }
}
