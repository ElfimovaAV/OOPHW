package seminar7.observer;

public class Master implements Observer {

    private String name;
    private double salary;
    private String lookforposition;

    public Master(String name, String lookforposition) {
        this.name = name;
        salary = 80000;
        this.lookforposition = lookforposition;;
    }

    @Override
    public void receiveOffer(String nameCompany, String vacancy, double salary) {
        if (lookforposition == vacancy) {
            if (this.salary < salary) {
                System.out.printf("Специалист %s >>> Мне нужна эта работа! [%s - %s - %f]\n",
                        name, nameCompany, vacancy, salary);
                this.salary = salary;
            } else {
                System.out.printf("Специалист %s >>> Я найду работу получше! [%s - %s - %f]\n",
                        name, nameCompany, vacancy, salary);
            }
        } else {
            System.out.printf("Специалист %s >>> мне не подходит вакансия [%s - %s]\n", name, nameCompany, vacancy);
        }
    }
}
