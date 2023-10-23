package backend.project.main;

public class Computer implements Control{
    public void turnOn() {
        System.out.println("컴퓨터 전원 on");
    }

    public void turnOff() {
        System.out.println("컴퓨터 전원 off");
    }

    public void repair() {
        System.out.println("컴퓨터 수리");
    }
}
