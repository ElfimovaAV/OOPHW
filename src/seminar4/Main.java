/*a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
        b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
        поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        c. Для хранения фруктов внутри коробки можно использовать ArrayList;
        d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
        вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
        e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
        подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
        Можно сравнивать коробки с яблоками и апельсинами;
        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
        Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
        Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
        g. Не забываем про метод добавления фрукта в коробку.
 */

package seminar4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Box<Apple> redApples = new Box<>();
        Box<Apple> freshApples = new Box<>();
        Box<Orange> oranges = new Box<>();
        System.out.println("Box of redApples: ");
        System.out.println(redApples);
        System.out.println("Box of freshApples: ");
        System.out.println(freshApples);
        System.out.println("Box of oranges: ");
        System.out.println(oranges);

        redApples.addFruit(new Apple());
        redApples.addFruit(new Apple(), 20);
        oranges.addFruit(new Orange());
        oranges.addFruit(new Orange(), 15);
        System.out.println("Box of redApples: ");
        System.out.println(redApples);
        System.out.println("Box of oranges: ");
        System.out.println(oranges);
        System.out.println();
        System.out.println("The box of red apples is heavier then the box of oranges, it's " + redApples.compare(oranges));
        System.out.println();
        System.out.println("Pour apples from the box of red apples to the box of fresh apples ");
        redApples.pourToOtherBox(freshApples);
        System.out.println("Box of redApples: ");
        System.out.println(redApples);
        System.out.println("Box of freshApples: ");
        System.out.println(freshApples);
    }
}
abstract class Fruit{
    private final String typeOfFruit;
    private final float weight;

    public float getWeight() {
        return weight;
    }
    public String getTypeOfFruit() {return typeOfFruit;}

    public Fruit(String typeOfFruit, float weight) {
        this.typeOfFruit = typeOfFruit;
        this.weight = weight;
    }
}

class Apple extends Fruit {

    public Apple() {
        super( "Apple", 1.0f);
    }


    @Override
    public float getWeight() {
        return 1.0f;
    }

    @Override
    public String getTypeOfFruit() {
        return "Apple";
    }
}

class Orange extends Fruit {

    public Orange() {
        super( "Orange", 1.5f);
    }

    @Override
    public float getWeight() {
        return 1.5f;
    }

    @Override
    public String getTypeOfFruit() {
        return "Orange";
    }
}


class Box<T extends Fruit>{

    ArrayList<T> fruits;
    private float boxWeight;
    private String boxTypeOfFruit;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public int getNumberOfFruits() {
        return fruits.size();
    }

    public void setFruits(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public float getBoxWeight() {
        return boxWeight;
    }
    public String getBoxTypeOfFruit() {
        return boxTypeOfFruit;
    }


    public void addFruit(T fruit){
        fruits.add(fruit);
        boxWeight += fruit.getWeight();
        boxTypeOfFruit = fruit.getTypeOfFruit();
    }

    public void addFruit(T fruit, int n){
        for (int i = 0; i < n; i++) {
            addFruit(fruit);
        }
    }

    public void removeFruit(T fruit){
        fruits.remove(fruit);
        boxWeight -= fruit.getWeight();
        if (boxWeight == 0f) {
            boxTypeOfFruit = null;
        }
    }

    public void removeFruit(T fruit, int n){
        for (int i = 0; i < n; i++) {
            removeFruit(fruit);
        }
    }


    public void pourToOtherBox (Box<T> otherBox) {
        if (otherBox == this) {
            return;
        }
        for (T fruit : this.fruits) {
            otherBox.addFruit(fruit);
        }
        this.fruits.clear();
        this.boxWeight = 0f;
        this.boxTypeOfFruit = null;
    }

    public boolean compare(Box<?> otherBox){
        return (Math.abs(this.boxWeight - otherBox.getBoxWeight()) < 0.01f);
    }


    @Override
    public String toString() {
        return "Box{fruits=" + boxTypeOfFruit +
                ", boxWeight=" + boxWeight +
                ", number of fruits=" + getNumberOfFruits() + '\'' +
                '}';
    }
}

