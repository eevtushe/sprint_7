package apitests.package2;

public class Order {

    // Обязательные поля
    private final String firstName;
    private final String lastName;
    private final String address;
    private final int metroStation;
    private final String phone;
    private final int rentTime;
    private final String deliveryDate;
    private final String comment;

    // Необязательное поле
    private final String[] color;

    // Дальше идет конструктор
    public Order(String firstName, String lastName, String address, int metroStation,
                 String phone, int rentTime, String deliveryDate, String comment, String[] color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }
}

