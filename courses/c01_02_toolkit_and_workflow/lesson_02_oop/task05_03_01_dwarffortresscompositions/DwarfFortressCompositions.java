package c01_02_toolkit_and_workflow.lesson_02_oop.task05_03_01_dwarffortresscompositions;

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

    public void attack() {
        System.out.println(getName() + " наносит урон!");
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

    public void printInfo() {
        System.out.println("Метод не переопределен в наследнике.");
    }
}

class Dwarf extends Character {
    private int age;
    private String profession;
    private int strength;
    private Weapon inHandsWeapon;

    public Dwarf(String name, int health, int maxHealth, int age, String profession, int strength) {
        super(name, health, maxHealth);
        this.age = age;
        this.profession = profession;
        this.strength = strength;
        this.inHandsWeapon = null; // изначально оружия у Дварфа нет
    }

    public int getStrength() {
        return strength;
    }

    public int getAge() {
        return age;
    }

    public String getProfession() {
        return profession;
    }

    public Weapon getInHandsWeapon() {
        return inHandsWeapon;
    }

    // Взять оружие
    public void takeWeapon(Weapon weapon) {
        if (weapon == null) {
            return;
        }
        this.inHandsWeapon = weapon;
        System.out.println(getName() + " взял в руки " + weapon.getName() + "!");
    }

    // переопределенный родительский метод
    // атака с использованием оружия
    public void attack() {
        if (inHandsWeapon == null || inHandsWeapon.isBroken()) {
            System.out.println(getName() + " бьет кулаками! Урон: 10");
            return;
        }
        int totalDamage = inHandsWeapon.getDamage() + getStrength() / 10;
        System.out.println(getName() + " атакует с помощью " + inHandsWeapon.getName() + ". Общий урон: " + totalDamage + " (урон оружия: " + inHandsWeapon.getDamage() + " + бонус силы: " + getStrength() / 10 + ")");
        // Оружие теряет прочность при использовании
        inHandsWeapon.setDurability(inHandsWeapon.getDurability() - 5);
        if (inHandsWeapon.isBroken()) {
            System.out.println("Оружие " + inHandsWeapon.getName() + " сломалось!");
        } else {
            System.out.println("Прочность " + inHandsWeapon.getName() + " упала до " + inHandsWeapon.getDurability());
        }
    }

    // переопределенный родительский метод
    public void printInfo() {
        System.out.println("Дварф: " + getName() + ", возраст: " + getAge() + ", профессия: " + getProfession() + ", здоровье: " + getHealth() + ", сила: " + getStrength());
        if (inHandsWeapon != null) {
            System.out.println("В руках: " + inHandsWeapon.getName() + " (урон: " + inHandsWeapon.getDamage() + ")");
        } else {
            System.out.println("Оружия в руках нет.");
        }
    }
}

class Animal extends Character {
    private String species;

    public Animal(String name, int health, int maxHealth, String species) {
        super(name, health, maxHealth);
        this.species = species;
    }

    // переопределенный родительский метод
    public void attack() {
        System.out.println(getName() + " кусает врага!");
    }

    // переопределенный родительский метод
    public void printInfo() {
        System.out.println("Животное: " + getName() + ", вид: " + species + ", здоровье: " + getHealth());
    }
}

class Weapon extends Item {
    private String weaponType;
    private int damage;

    public Weapon(String name, double weight, int durability, int maxDurability, String weaponType, int damage) {
        super(name, weight, durability, maxDurability);
        this.weaponType = weaponType;
        this.damage = damage;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isBroken() {
        return getDurability() <= 0;
    }

    // переопределенный родительский метод
    public void printInfo() {
        System.out.println("Оружие: " + getName() + ", тип: " + getWeaponType() + ", урон: " + getDamage() + ", прочность: " + getDurability());
    }
}

class WarParty {
    private String partyName;
    private Character[] members;
    private int memberCount;

    public WarParty(String partyName, int maxMembers) {
        this.partyName = partyName;
        this.members = new Character[maxMembers];
        this.memberCount = 0;
    }

    public void addMember(Character character) {
        if (memberCount < members.length) {
            members[memberCount] = character;
            memberCount++;
            System.out.println(character.getName() + " вступил в отряд '" + partyName + "'!");
        } else {
            System.out.println("Отряд " + partyName + " переполнен!");
        }
    }

    public void attackAll() {
        System.out.println("Отряд " + partyName + " атакует!");
        for (int i = 0; i < memberCount; i++) {
            members[i].attack();
        }
    }

    public void printPartyInfo() {
        System.out.println("Отряд " + partyName + " :");
        for (int i = 0; i < memberCount; i++) {
            members[i].printInfo();
        }
    }
}

public class DwarfFortressCompositions {
    public static void main(String[] args) {
        Dwarf tror = new Dwarf("Трор", 49, 100, 185, "Воин", 78);
        Dwarf gimli = new Dwarf("Гимли", 65, 100, 160, "Кузнец", 85);

        Weapon axe = new Weapon("Гнев Хельхейма", 5.3, 78, 100, "Топор", 55);
        Weapon hammer = new Weapon("Каменное сердце", 7.3, 76, 100, "Молот", 64);

        Animal moonWolf = new Animal("Лунный волк", 65, 100, "Волк");
        Animal fireBear = new Animal("Огненный медведь", 83, 100, "Медведь");

        // Композиция 1:
        tror.takeWeapon(axe);
        gimli.takeWeapon(hammer);

        tror.attack();
        gimli.attack();

        // Композиция 2
        WarParty warParty = new WarParty("Горные стражи", 5);
        warParty.addMember(tror);
        warParty.addMember(gimli);
        warParty.addMember(moonWolf);
        warParty.addMember(fireBear);

        warParty.printPartyInfo();

        warParty.attackAll();
    }
}


