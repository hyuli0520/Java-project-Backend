package backend.project.main;

public class ControlDemo {
    public static void main(String[] args) {
        TV t = new TV();
        t.turnOn();
        t.turnOff();
        t.repair();
        Control.reset();

        Computer com = new Computer();
        com.turnOn();
        com.turnOff();
        com.repair();
//        com.reset(); // 오류

        Notebook n = new Notebook();
        n.turnOn();
        n.turnOff();
        n.inMyBag();
        n.repair();
    }
}
