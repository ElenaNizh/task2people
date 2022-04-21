public enum Education {

    ELEMENTARY("Начальное"),
    SECONDARY("Среднее"),
    FURTHER("Среднее повышенной квалификации"),
    HIGHER("Высшее"),
    RETIREE("Пенсионер");


    String description;

    Education(String description) {
        this.description = description;
    }
}