package ch06;

public class Order {
    public String orderID;
    public String phoneNumber;
    public String address;
    public String orderDate;
    public String orderTime;
    public int price;
    public String menuID;


    public Order(String orderID, String phoneNumber, String address, String orderDate, String orderTime, int price, String menuID) {
        this.orderID = orderID;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.price = price;
        this.menuID = menuID;
    }

    public void printOrder() {
        System.out.println("주문 접수 번호 : " + this.orderID);
        System.out.println("주문 핸드폰 번호 : " + this.phoneNumber);
        System.out.println("주문 집 주소 : " + this.address);
        System.out.println("주문 날짜 : " + this.orderDate);
        System.out.println("주문 시간 : " + this.orderTime);
        System.out.println("주문 가격 : " + this.price);
        System.out.println("메뉴 번호 : " + this.menuID);
    }

    public static void main(String[] args) {
        Order order = new Order("202011020003", "01023450001", "서울시 강남구 역삼동 111-303",
                "20201102", "130258", 35000, "0003");

        order.printOrder();
    }


}
