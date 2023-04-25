package seminar2;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean isFullness() {
        return fullness;
    }

    public void setFullness(boolean fullness) {
        this.fullness = fullness;
    }

    public void eat() {
        setFullness(true);
        System.out.printf("%s покушал. \n", name);
    }

    public void fullnessInfo() {
        System.out.println("Cat " + this.name + " сыт - это " + fullness);
    }
}
