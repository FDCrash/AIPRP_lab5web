import lab5ejb.ejb.EJB_LAB;
import lab5ejb.ejb.EJB_LABRemote;

import javax.ejb.EJB;

public class Main {

    @EJB
    private static EJB_LABRemote ejb_lab = new EJB_LAB();

    public static void main(String[] args) {
        System.out.println();
        System.out.println(ejb_lab.getNumberOnDepart("Marketing"));
        ejb_lab.getAllStuds().forEach(System.out::println);
        System.out.println();
        System.out.println("Информация о студенте Иванове: " + ejb_lab.getStudInfo("ivanov"));
        System.out.println();
        ejb_lab.addStudent("New", "new", "10");
        System.out.println();
        ejb_lab.getAllStuds().forEach(System.out::println);
        System.out.println();
        ejb_lab.deleteStud("New");
        System.out.println();
        ejb_lab.getAllStuds().forEach(System.out::println);
        System.out.println();
        System.out.println(ejb_lab.getNumberOfStud(10));

    }
}
