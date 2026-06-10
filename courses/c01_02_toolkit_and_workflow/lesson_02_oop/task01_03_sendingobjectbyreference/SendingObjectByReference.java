package c01_02_toolkit_and_workflow.lesson_02_oop.task01_03_sendingobjectbyreference;

class Dwarf {
    String name;
    int health;
}

public class SendingObjectByReference {
    static void printDwarf(Dwarf d, String refName) {
        System.out.println(refName + ": имя " + d.name + ", здоровье " + d.health + ".");
    }

    public static void main(String[] args) {
        Dwarf gimli = new Dwarf();
        gimli.name = "Гимли";
        gimli.health = 95;

        // Демонстрация побочного эффекта
        Dwarf gimliRef = gimli; // создаем вторую ссылку на тот же объект

        System.out.println("До изменения:");
        printDwarf(gimli, "gimli");
        printDwarf(gimliRef, "gimliRef");

        gimliRef.health = 82;

        System.out.println("После изменения gimliRef.health = 82:");
        printDwarf(gimli, "gimli");
        printDwarf(gimliRef, "gimliRef");
        System.out.println("Здоровье изменилось у обеих ссылок (побочный эффект).");
    }
}
