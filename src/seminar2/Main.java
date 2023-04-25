package seminar2;

public class Main {
    public static void main(String[] args) {
        //котики
        Cat[] cats = {
                new Cat("Barsik", 5),
                new Cat("Bobby", 6),
                new Cat("Pushok", 7),
                new Cat("Murka", 3),
                new Cat("Tishka", 5),
                new Cat("Bayun", 7),
                new Cat("Busya", 4),
                new Cat("Simka", 3),
                new Cat("Vasya", 5),
                new Cat("Erast", 6),
                new Cat("Milka", 4),
                new Cat("Grisha", 8),
                new Cat("Anfiska", 3),
                new Cat("Fishka", 4),
        };

        Plate plate = new Plate(50);
        int portion = 50;
        plate.info();
        System.out.println();


        for (Cat cat : cats) {
            if (plate.getFood() < cat.getAppetite()) {
                plate.addFood(portion);
                System.out.printf("В тарелке мало еды, добавили в тарелку %d едыю \n", portion);
            }
            plate.setFood(plate.getFood() - cat.getAppetite());
            cat.eat();
            cat.fullnessInfo();
            plate.info();
        }
    }
}
