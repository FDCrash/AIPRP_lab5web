package lab5ejb.ejb;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Stateless
public class EJB_LAB implements EJB_LABRemote{
    private static final long serialVersionUID = 1L;

    private String fio;
    private String department;
    private String group;

    private static final List<Student> students
            = new ArrayList<>(Arrays.asList(
            Student.builder().fio("ivanov").department("Marketing").group("10").build(),
            Student.builder().fio("petrov").department("Marketing").group("10").build(),
            Student.builder().fio("mishin").department("Smith").group("12").build(),
            Student.builder().fio("vasin").department("Programmer").group("14").build(),
            Student.builder().fio("sidorov").department("Professor").group("12").build()
    ));

    @Override
    public String getStudInfo(String fio) {
        for(Student student:students){
            if(student.getFio().equals(fio)){
                return student.getDepartment() + " " + student.getGroup();
            }
        }
        return "";
    }

    @Override
    public void addStudent(String fio,String department,String group) {
        students.add(Student.builder()
                .fio(fio)
                .department(department)
                .group(group)
                .build());
    }

    @Override
    public void deleteStud(String fio) {
        for(Student student: students) {
            if (student.getFio().equals(fio)){
                students.remove(student);
                break;
            }
        }
    }

    @Override
    public List<String> getAllStuds(){
        List<String> strings= new ArrayList<>();
        for(Student student:students){
            strings.add(student.getFio()+ " " + student.getGroup() + " " + student.getDepartment());
        }
        return strings;
    }

    @Override
    public Integer getNumberOfStud(int groupId){
        int n=0;
        for(Student student: students){
            if(Integer.valueOf(student.getGroup())==groupId){
                n++;
            }
        }
        return n;
    }

    @Override
    public String getNumberOnDepart(String departmentName){
        StringBuilder s= new StringBuilder();
        for(Student student: students){
            if(student.getDepartment().equals(departmentName)) {
                s.append(student.getFio()).append("\n");
            }
        }
        return s.toString();
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
