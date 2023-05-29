package seminar7.observer;

public class Manager implements Observer{
    private String name;
    private double salary;

    private String lookforposition;

    public Manager(String name, String lookforposition) {
        this.name = name;
        salary = 120000;
        this.lookforposition = lookforposition;;
    }

    @Override
    public void receiveOffer(String nameCompany, String vacancy, double salary) {
        if (lookforposition == vacancy) {
            if (this.salary < salary) {
                System.out.printf("Руководитель %s >>> Мне нужна эта работа! [%s - %s - %f]\n",
                        name, nameCompany, vacancy, salary);
                this.salary = salary;
            } else {
                System.out.printf("Руководитель %s >>> Я найду работу получше! [%s - %s - %f]\n",
                        name, nameCompany, vacancy, salary);
            }
        } else {
            System.out.printf("Руководитель %s >>> мне не подходит вакансия [%s - %s]\n", name, nameCompany, vacancy);
        }
    }
}
