package seminar7.observer;

import static seminar7.observer.Vacancy.ELECTRICIANS;

public class Program {

    public static void main(String[] args) {

        JobAgency jobAgency = new JobAgency();
        Company geekBrains = new Company("GeekBrains", 70000, jobAgency);
        Company google = new Company("Google", 100000, jobAgency);
        Company yandex = new Company("Yandex", 150000, jobAgency);

        Master ivanov = new Master("Ivanov", "DEVELOPER");
        Master petrov = new Master("Petrov", "TESTER");
        Student sidorov = new Student("Sidorov", "ELECTRICIANS");
        Manager korolev = new Manager("Korolev", "DIRECTOR");

        jobAgency.registerObserver(ivanov);
        jobAgency.registerObserver(petrov);
        jobAgency.registerObserver(sidorov);
        jobAgency.registerObserver(korolev);

        for(int i = 0; i < 10; i++){
            geekBrains.needEmployee();
            google.needEmployee();
            yandex.needEmployee();
        }

    }

}
