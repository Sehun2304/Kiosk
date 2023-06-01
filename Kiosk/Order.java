package Kiosk;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Order {
    private List<Item> cart;

    public Order() {
        cart = new ArrayList<>();
    }
    public void addcart(Item item){
        cart.add(item);
        System.out.println(item.getName()+"이(가) 장바구니에 추가되었습니다");
    }

    public void viewcart(){
        System.out.println("장바구니");
        int total = 0;
        for (Item item:cart){
            System.out.println(item.getName()+item.getPrice());
            total+=item.getPrice();
        }
        System.out.println(total);
        System.out.println("1.주문"+"\t"+"\t"+"2.취소");



        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("2")){
            Kiosk.displayMainMenu();}
        else if (input.equals("1")){
            orderCart();
        }
        else System.out.println("오류입니다");
            viewcart();
    }
    public void orderCart(){
        System.out.println("주문 완료");
        System.out.println("대기번호는"+1+"번"+"입니다.");
        cart.clear();
        Kiosk.displayMainMenu();

    }
    public void clearCart(){
        System.out.println("주문을 취소하시겠습니까?");
        System.out.println("1.네"+"\t"+"\t"+"2.아니오");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("1")) {
            cart.clear();
            System.out.println("주문이 취소되었습니다");
            Kiosk.displayMainMenu();}
        else if(input.equals("2")){
            viewcart();
        }
        else {
            System.out.println("오류입니다");
            clearCart();
        }


    }
}
