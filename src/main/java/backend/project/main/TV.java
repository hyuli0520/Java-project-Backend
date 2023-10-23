package backend.project.main;

public class TV implements Control {
    public void turnOn() {
        System.out.println("전원on");
    }

    public void turnOff() {
        System.out.println("전원off");
    }

    void versionPrint() {
        System.out.println(VERSION);
    }
}
