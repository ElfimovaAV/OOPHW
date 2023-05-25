package seminar6;

public class Program {

    public static void main(String[] args) {

        System.out.println("Укажите заказ:");
        Order order = new Order("", "", 0, 0);
        order.inputFromConsole();
        SaveOrderToJson saveOrderToJson = new SaveOrderToJson();
        saveOrderToJson.saveAs(order);
        SaveOrderToXml saveOrderToXml = new SaveOrderToXml();
        saveOrderToXml.saveAs(order);

    }

}
