package c01_02_toolkit_and_workflow.lesson_02_oop.task01_02_dwarffortress;

class Dwarf {
    String name;
    int age;
    String profession;
    int health;
    int strength;
    String personality;
}

class Weapon {
    String name;
    String weaponType;
    String material;
    int damage;
    double weight;       // в кг
    int durability;
}

class Animal {
    String name;
    String species;
    int age;
    int health;
    String color;
    double speed;
}

public class DwarfFortress {
    static void printDwarf(Dwarf d) {
        System.out.println("Имя: " + d.name + ", возраст " + d.age + ", профессия: " + d.profession + ", здоровье: " + d.health + ", сила: " + d.strength + ", особенность: " + d.personality + ".");
    }

    static void printWeapon(Weapon w) {
        System.out.println("Имя: " + w.name + ", тип: " + w.weaponType + ", урон: " + w.damage + ", вес: " + w.weight + ", материал: " + w.material + ", прочность: " + w.durability + ".");
    }

    static void printAnimal(Animal a) {
        System.out.println("Имя: " + a.name + ", тип: " + a.species + ", возраст: " + a.age + ", здоровье: " + a.health + ", цвет: " + a.color + ", скорость: " + a.speed + ".");
    }

    public static void main(String[] args) {
        Dwarf tror = new Dwarf();
        tror.name = "Трор";
        tror.age = 185;
        tror.profession = "Воин";
        tror.health = 100;
        tror.strength = 90;
        tror.personality = "Упрямый";

        Dwarf gimli = new Dwarf();
        gimli.name = "Гимли";
        gimli.age = 160;
        gimli.profession = "Кузнец";
        gimli.health = 95;
        gimli.strength = 75;
        gimli.personality = "Трудолюбивый";

        Weapon axe = new Weapon();
        axe.name = "Гнев Хельхейма";
        axe.weaponType = "Топор";
        axe.damage = 55;
        axe.weight = 5.3;
        axe.material = "Сталь";
        axe.durability = 78;

        Weapon hammer = new Weapon();
        hammer.name = "Каменное сердце";
        hammer.weaponType = "Молот";
        hammer.damage = 64;
        hammer.weight = 7.3;
        hammer.material = "Железо";
        hammer.durability = 76;

        Animal moonWolf = new Animal();
        moonWolf.name = "Лунный волк";
        moonWolf.species = "Волк";
        moonWolf.age = 3;
        moonWolf.health = 65;
        moonWolf.color = "Серый";
        moonWolf.speed = 42.3;

        Animal fireBear = new Animal();
        fireBear.name = "Огненный медведь";
        fireBear.species = "Медведь";
        fireBear.age = 8;
        fireBear.health = 83;
        fireBear.color = "Красный";
        fireBear.speed = 32.3;

        Dwarf[] dwarfs = {tror, gimli};
        Weapon[] weapons = {axe, hammer};
        Animal[] animals = {moonWolf, fireBear};

        System.out.println("Дварфы:");
        for(int i = 0; i < dwarfs.length; i++) {
            printDwarf(dwarfs[i]);
        }

        System.out.println("Оружие:");
        for (int i = 0; i < weapons.length; i++) {
            printWeapon(weapons[i]);
        }

        System.out.println("Животные:");
        for (int i = 0; i < animals.length; i++) {
            printAnimal(animals[i]);
        }
    }
}

