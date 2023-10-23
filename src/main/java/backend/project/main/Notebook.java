package backend.project.main;

public class Notebook extends Computer implements Portable{
    public void inMyBag() {
        System.out.println("노트북은 가방에 있다.");
    }

    public void turnOn() {
        System.out.println("노트북 전원 on");
    }

    public void turnOff() {
        System.out.println("노트북 전원 off");
    }

    public void repair() {
        System.out.println("노트북 수리");
    }
}
