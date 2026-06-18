package c01_02_toolkit_and_workflow.lesson_09_workingwithfiles.task03_workingwithfile;

public class Cat {
    private String name;
    private double weight;
    private int purrFrequency;

    public Cat(String name, double weight, int purrFrequency) {
        this.name = name;
        this.weight = weight;
        this.purrFrequency = purrFrequency;
    }

    // Метод для вывода информации о коте
    public void printInfo() {
        System.out.println("Кот: " + name + ", масса: " + weight + " кг, мурлыканье: " + purrFrequency + " Гц");
    }
}
