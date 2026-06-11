package c01_02_toolkit_and_workflow.lesson_02_oop.task05_03_00_dwarffortresshierarchy;

class Character {
    private String name; // имя
    private int health; // текущее здоровье
    private int maxHealth; // максимальное здоровье

    public Character(String name, int health, int maxHealth) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setHealth(int health) {
        if (health > maxHealth) {
            this.health = maxHealth;
        } else if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    public void eat() { // есть (увеличивает здоровье)
        int add = Utilities.calcActualIncrease(getHealth(), 5, getMaxHealth());
        setHealth(getHealth() + add);
        System.out.println(getName() + " поел. Здоровье увеличено на " + add + " ед. Здоровье: " + getHealth());
    }

    public void sleep() { // спать(увеличивает здоровье)
        int add = Utilities.calcActualIncrease(getHealth(), 7, getMaxHealth());
        setHealth(getHealth() + add);
        System.out.println(getName() + " спит и восстанавливает " + add + " ед. здоровья. Здоровье: " + getHealth());
    }

    public void printInfo() {
        System.out.println("Метод не переопределен в наследнике.");
    }
}

class Item {
    private String name; // название предмета
    private double weight; // вес
    private int durability; // текущая прочность
    private int maxDurability; // максимальная прочность

    public Item(String name, double weight, int durability, int maxDurability) {
        this.name = name;
        this.weight = weight;
        this.durability = durability;
        this.maxDurability = maxDurability;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getDurability() {
        return durability;
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    public void setDurability(int durability) {
        if (durability > maxDurability) {
            this.durability = maxDurability;
        } else if (durability < 0) {
            this.durability = 0;
        } else {
            this.durability = durability;
        }
    }

    public void repair() { // ремонтировать(увеличивает прочность)
        int add = Utilities.calcActualIncrease(getDurability(), 5, getMaxDurability());
        setDurability(getDurability() + add);
        System.out.println(getName() + " отремонтирован. Прочность увеличена на " + add + " ед. Прочность: " + getDurability());
    }

    public void printInfo() {
        System.out.println("Метод не переопределен в наследнике.");
    }
}

class Dwarf extends Character {
    private int age;
    private String profession;
    private int strength;
    private String personality;

    public Dwarf(String name, int health, int maxHealth, int age, String profession, int strength, String personality) {
        super(name, health, maxHealth);
        this.age = age;
        this.profession = profession;
        this.strength = strength;
        this.personality = personality;
    }

    public int getAge() {
        return age;
    }

    public String getProfession() {
        return profession;
    }

    public int getStrength() {
        return strength;
    }

    public String getPersonality() {
        return personality;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public void train() { // тренироваться(увеличивает силу)
        int add = 5;
        setStrength(getStrength() + add);
        System.out.println(getName() + " тренируется. Сила повышена на " + add + " ед. Сила: " + getStrength());
    }

    public void drinkAle() { // выпить Эль(изменяет характер)
        setPersonality("Пьяный и веселый");
        System.out.println(getName() + " выпил кружку эля! Характер изменился на: " + getPersonality());
    }

    // переопределенный родительский метод
    public void printInfo() {
        System.out.println("Дварф: " + getName() + ", возраст: " + getAge() + ", профессия: " + getProfession() + ", здоровье: " + getHealth() + ", сила: " + getStrength() + ", характер: " + getPersonality());
    }
}

class Animal extends Character {
    private String species;
    private String color;
    private String sound;

    public Animal(String name, int health, int maxHealth, String species, String color, String sound) {
        super(name, health, maxHealth);
        this.species = species;
        this.color = color;
        this.sound = sound;
    }

    public String getSpecies() {
        return species;
    }

    public String getColor() {
        return color;
    }

    public String getSound() {
        return sound;
    }

    public void makeSound() { // издать звук
        System.out.println(getName() + ": " + getSound());
    }

    // переопределенный родительский метод
    public void printInfo() {
        System.out.println("Животное: " + getName() + ", вид: " + getSpecies() + ", здоровье: " + getHealth() + ", цвет: " + getColor() + ", издает звук: " + getSound());
    }
}

class Weapon extends Item {
    private String weaponType;
    private String material;
    private int damage;

    public Weapon(String name, double weight, int durability, int maxDurability, String weaponType, String material, int damage) {
        super(name, weight, durability, maxDurability);
        this.weaponType = weaponType;
        this.material = material;
        this.damage = damage;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public String getMaterial() {
        return material;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void applyPoison() { // нанести яд(увеличивает урон)
        int add = 5;
        setDamage(getDamage() + add);
        System.out.println(getName() + " покрыт ядом. Урон увеличен на " + add + " ед. Урон: " + getDamage());
    }

    // переопределенный родительский метод
    public void printInfo() {
        System.out.println("Оружие " + getName() + ", тип: " + getWeaponType() + ", урон: " + getDamage() + ", вес: " + getWeight() + ", материал: " + getMaterial() + ", прочность: " + getDurability());
    }
}

class Utilities {
    public static int calcActualIncrease(int current, int amount, int maxLimit) {
        if (current >= maxLimit) {
            return 0;
        }
        if (current + amount > maxLimit) {
            return maxLimit - current;
        }
        return amount;
    }
}

public class DwarfFortressHierarchy {
    public static void main(String[] args) {
        Dwarf tror = new Dwarf("Трор", 49, 100, 185, "Воин", 78, "Упрямый");
        Dwarf gimli = new Dwarf("Гимли", 65, 100, 160, "Кузнец", 85, "Трудолюбивый");

        Weapon axe = new Weapon("Гнев Хельхейма", 5.3, 78, 100, "Топор", "Сталь", 55);
        Weapon hammer = new Weapon("Каменное сердце", 7.3, 76, 100, "Молот", "Железо", 64);

        Animal moonWolf = new Animal("Лунный волк", 65, 100, "Волк", "Серый", "Ауууууууу!");
        Animal fireBear = new Animal("Огненный медведь", 83, 100, "Медведь", "Красный", "Рррррррр!");

        gimli.sleep();
        gimli.eat();
        gimli.train();
        gimli.drinkAle();

        axe.repair();
        axe.applyPoison();

        moonWolf.sleep();
        moonWolf.eat();
        moonWolf.makeSound();

        Dwarf[] dwarfs = {tror, gimli};
        for(int i = 0; i < dwarfs.length; i++) {
            dwarfs[i].printInfo();
        }

        Weapon[] weapons = {axe, hammer};
        for(int i = 0; i < weapons.length; i++) {
            weapons[i].printInfo();
        }

        Animal[] animals = {moonWolf, fireBear};
        for(int i = 0; i < animals.length; i++) {
            animals[i].printInfo();
        }
    }
}


