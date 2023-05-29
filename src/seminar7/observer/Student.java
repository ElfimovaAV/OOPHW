package seminar7.observer;

public class Student implements Observer {

    private String name;
    private double salary;
    private String lookforposition;
    public Student(String name, String lookforposition) {
        this.name = name;
        this.lookforposition = lookforposition;
        salary = 5000;
    }


    @Override
    public void receiveOffer(String nameCompany, String vacancy, double salary) {
        if (lookforposition == vacancy) {
            if (this.salary < salary) {
                System.out.printf("Студент %s >>> Мне нужна эта работа! [%s - %s - %f]\n",
                        name, nameCompany, vacancy, salary);
                this.salary = salary;
            } else {
                System.out.printf("Студент %s >>> Я найду работу получше! [%s - %s - %f]\n",
                        name, nameCompany, vacancy, salary);
            }
        }
        else{
            System.out.printf(" Студент %s >>> мне не подходит вакансия [%s - %s]\n", name, nameCompany, vacancy);
        }
    }
}
