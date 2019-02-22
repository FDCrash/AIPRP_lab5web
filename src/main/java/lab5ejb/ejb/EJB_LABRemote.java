package lab5ejb.ejb;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface EJB_LABRemote {
    String getStudInfo(String fio);
    void addStudent(String fio,String department,String group);
    void deleteStud(String fio);
    List<String> getAllStuds();
    Integer getNumberOfStud(int groupId);
    String getNumberOnDepart(String departmentName);
}
