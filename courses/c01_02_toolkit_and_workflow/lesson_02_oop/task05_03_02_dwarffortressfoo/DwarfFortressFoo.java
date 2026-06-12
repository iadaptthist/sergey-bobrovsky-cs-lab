package c01_02_toolkit_and_workflow.lesson_02_oop.task05_03_02_dwarffortressfoo;

import java.util.Random;

/**
 * Почему получился такой вывод?
 * Массив characters имеет тип Character[] и содержит объекты Dwarf и Animal. Когда мы вызываем characters[i].foo(), Java смотрит на тип объекта (а не на тип переменной) и вызывает соответствующий метод foo().
 * Если объект — Dwarf, вызывается foo() из класса Dwarf.
 * Если объект — Animal, вызывается foo() из класса Animal.
 */
class Character {
    public void foo() {
        System.out.println("Метод foo() вызван из класса Character");
    }
}

class Dwarf extends Character {
    // переопределение родительского метода
    public void foo() {
        System.out.println("Метод foo() вызван из класса Dwarf");
    }
}

class Animal extends Character {
    // переопределение родительского метода
    public void foo() {
        System.out.println("Метод foo() вызван из класса Animal");
    }
}

public class DwarfFortressFoo {
    public static void main(String[] args) {
        Character[] characters = new Character[500];
        Random random = new Random();

        for(int i = 0; i < characters.length; i++) {
            // случайно создаем либо Dwarf, либо Animal.
            if(random.nextBoolean()) {
                characters[i] = new Dwarf();
            } else {
                characters[i] = new Animal();
            }
        }

        for(int i = 0; i < characters.length; i++) {
            characters[i].foo();
        }
    }
}

