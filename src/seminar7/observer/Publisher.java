package seminar7.observer;

public interface Publisher {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    abstract void sendOffer(String nameCompany, String vacancy, double salary);

}
