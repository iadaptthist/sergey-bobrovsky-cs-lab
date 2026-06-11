package c01_02_toolkit_and_workflow.lesson_02_oop.task01_02_e_dwarffortressaddmethods;

class Dwarf {
    String name;
    int age;
    String profession;
    int health;
    int strength;
    String personality;

    Dwarf(String name, int age, String profession, int health, int strength, String personality) {
        this.name = name;
        this.age = age;
        this.profession = profession;
        this.health = health;
        this.strength = strength;
        this.personality = personality;
    }

    void rest() { // отдыхать(увеличивает здоровье)
        int add = Utilities.calcActualIncrease(this.health, 5, 100);
        this.health += add;
        System.out.println(this.name + " отдыхает и восстанавливает " + add + " ед. здоровья. Здоровье: " + this.health);
    }

    void train() { // тренироваться(увеличивает силу)
        int add = 5;
        this.strength += add;
        System.out.println(this.name + " тренируется. Сила повышена на " + add + " ед. Сила: " + this.strength);
    }

    void drinkAle() { // выпить Эль(изменяет характер)
        this.personality = "Пьяный и веселый";
        System.out.println(this.name + " выпил кружку эля! Характер изменился на: " + this.personality);
    }

    void printDwarfInfo() {
        System.out.println("Имя: " + this.name + ", возраст: " + this.age + ", профессия: " + this.profession + ", здоровье: " + this.health + ", сила: " + this.strength + ", характер: " + this.personality);
    }
}

class Weapon {
    String name;
    String weaponType;
    String material;
    int damage;
    double weight;       // в кг
    int durability;

    Weapon(String name, String weaponType, String material, int damage, double weight, int durability) {
        this.name = name;
        this.weaponType = weaponType;
        this.material = material;
        this.damage = damage;
        this.weight = weight;
        this.durability = durability;
    }

    void repair() { // ремонтировать(увеличивает прочность)
        int add = Utilities.calcActualIncrease(this.durability, 5, 100);
        this.durability += add;
        System.out.println(this.name + "(" + this.weaponType + ")" + " отремонтирован. Прочность увеличена на " + add + " ед. Прочность: " + this.durability);
    }

    void sharpen() { // наточить(увеличивает урон)
        if (this.weaponType.equals("Топор")) {
            int add = 5;
            this.damage += add;
            System.out.println(this.name + "(" + this.weaponType + ")" + " наточен. Урон увеличен на " + add + " ед. Урон: " + this.damage);
        } else {
            System.out.println(this.name + " нельзя наточить (тип оружия: " + this.weaponType + ")");
        }
    }

    void applyPoison() { // нанести яд(увеличивает урон)
        int add = 5;
        this.damage += add;
        System.out.println(this.name + "(" + this.weaponType + ")" + " покрыт ядом. Урон увеличен на " + add + " ед. Урон: " + this.damage);
    }

    void printWeaponInfo() {
        System.out.println("Имя: " + this.name + ", тип: " + this.weaponType + ", урон: " + this.damage + ", вес: " + this.weight + ", материал: " + this.material + ", прочность: " + this.durability);
    }
}

class Animal {
    String name;
    String species;
    int age;
    int health;
    String color;
    double speed;
    String sound;

    Animal(String name, String species, int age, int health, String color, double speed, String sound) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.health = health;
        this.color = color;
        this.speed = speed;
        this.sound = sound;
    }

    void eat() { // есть(увеличивает здоровье)
        int add = Utilities.calcActualIncrease(this.health, 5, 100);
        this.health += add;
        System.out.println(this.name + " поел. Здоровье увеличено на " + add + " ед. Здоровье: " + this.health);
    }

    void sleep() { // спать(увеличивает здоровье)
        int add = Utilities.calcActualIncrease(this.health, 7, 100);
        this.health += add;
        System.out.println(this.name + " спит и восстанавливает " + add + " ед. здоровья. Здоровье: " + this.health);
    }

    void makeSound() { // издать звук
        System.out.println(this.name + ": " + this.sound);
    }

    void printAnimalInfo() {
        System.out.println("Имя: " + this.name + ", вид: " + this.species + ", возраст: " + this.age + ", здоровье: " + this.health + ", цвет: " + this.color + ", скорость: " + this.speed + ", издает звук: " + this.sound);
    }
}

class Utilities {
    static int calcActualIncrease(int current, int amount, int maxLimit) {
        if (current >= maxLimit) {
            return 0;
        }
        // Если превышаем лимит, возвращаем только остаток до лимита
        if (current + amount > maxLimit) {
            return maxLimit - current;
        }
        // Иначе возвращаем запрошенное количество
        return amount;
    }
}

public class DwarfFortressAddMethods {
    public static void main(String[] args) {
        Dwarf tror = new Dwarf("Трор", 185, "Воин", 49, 78, "Упрямый");
        Dwarf gimli = new Dwarf("Гимли", 160, "Кузнец", 65, 85, "Трудолюбивый");

        Weapon axe = new Weapon("Гнев Хельхейма", "Топор", "Сталь", 55, 5.3, 78);
        Weapon hammer = new Weapon("Каменное сердце", "Молот", "Железо", 64, 7.3, 76);

        Animal moonWolf = new Animal("Лунный волк", "Волк", 3, 65, "Серый", 42.3, "Ауууууууу!");
        Animal fireBear = new Animal("Огненный медведь", "Медведь", 8, 83, "Красный", 32.3, "Рррррррр!");

        gimli.train();
        gimli.rest();
        gimli.drinkAle();

        axe.repair();
        axe.sharpen();
        axe.applyPoison();

        moonWolf.makeSound();
        moonWolf.eat();
        moonWolf.sleep();

        Dwarf[] dwarfs = {tror, gimli};
        for(int i = 0; i < dwarfs.length; i++) {
            dwarfs[i].printDwarfInfo();
        }

        Weapon[] weapons = {axe, hammer};
        for(int i = 0; i < weapons.length; i++) {
            weapons[i].printWeaponInfo();
        }

        Animal[] animals = {moonWolf, fireBear};
        for(int i = 0; i < animals.length; i++) {
            animals[i].printAnimalInfo();
        }
    }
}


