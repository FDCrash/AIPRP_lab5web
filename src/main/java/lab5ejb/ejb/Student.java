package lab5ejb.ejb;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
    private String fio;
    private String department;
    private String group;

    @Builder
    public Student(String fio, String department, String group) {
        this.fio = fio;
        this.department = department;
        this.group = group;
    }
}
