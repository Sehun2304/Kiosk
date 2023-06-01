package Kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Kiosk.Menu;
import Kiosk.Item;
import Kiosk.Order;

public class Kiosk {

    private static List<Menu> mainMenu;

    private static List<Item> itemMenu;

    private static Order order;


  public static void main(String[] args) {

      mainMenu = new ArrayList<>();
      itemMenu = new ArrayList<>();
      order = new Order();

      initializeMainMenu();
      initializeItemMenu();
      displayMainMenu();

    }

    private static void initializeMainMenu(){
      mainMenu.add(new Menu("1.Coffee","최고급 원두를 사용한 커피"));
      mainMenu.add(new Menu(("2.Tea"+"\t"),"고품질 찻잎을 이용해서 만들어요"));
      mainMenu.add(new Menu("3.Dessert","음료랑 같이 먹기 좋은 디저트"));
    }


    private static void initializeItemMenu(){
      itemMenu.add(new Item("아메리카노",3200,"에스프레소에 물 탔어요","Coffee"));
      itemMenu.add(new Item("에스프레소",2900,"에스프레소에 물 안탔어요","Coffee"));
      itemMenu.add(new Item("카페라떼",3700,"에스프레소에 우유 탔어요","Coffee"));
      itemMenu.add(new Item("콜드브루",3700,"찬물로 우려냈어요","Coffee"));
      itemMenu.add(new Item("아이스티",2500,"차가운 차에요","Tea"));
      itemMenu.add(new Item("그린티",3200,"녹차말고 그린티주세요","Tea"));
      itemMenu.add(new Item("콤부차",3500,"다이어트에 좋대요","Tea"));
      itemMenu.add(new Item("버블티",4300,"가격에 버블이 있어요","Tea"));
      itemMenu.add(new Item("플레인와플",2300,"기본 말고 플레인으로 주세요","Bread"));
      itemMenu.add(new Item("허니카라멜브레드",4600,"꿀,카라멜 그리고 빵","Bread"));
      itemMenu.add(new Item("프레즐",2300,"달달한 빵보단 짭짤한 빵","Bread"));
      itemMenu.add(new Item("블루베리베이글",1900,"베이글 그런데 블루베리를 더한","Bread"));
    }

    public static void displayMainMenu(){
        System.out.println("|"+"\t"+"EdiyaCoffee"+"\t"+"\t"+"|");
        for (Menu menu: mainMenu){
            System.out.println(menu.getName()+"\t"+"|"+"\t"+menu.getDescription());}
        System.out.println("4.Order"+"\t"+"\t"+"|"+"\t"+"장바구니를 확인 후 주문합니다.");
        System.out.println("5.Cancel"+"\t"+"|"+"\t"+"진행중인 주문을 취소합니다");
        System.out.println("선택하고 싶으신 메뉴의 번호를 입력하세요");
        System.out.print("입력"+"\t"+"\t"+"    |"+"   ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch(input){
            case "1":
                displayItemMenu("Coffee");
                break;
            case "2":
                displayItemMenu("Tea");
                break;
            case "3":
                displayItemMenu("Bread");
                break;
            case "4":
                order.viewcart();
                break;
            case "5":
                order.clearCart();
                break;

            default:
                System.out.println("오류입니다");
                displayMainMenu();
        }
    }

    private static void displayItemMenu(String category){
        System.out.println("|"+"\t"+"Category"+"\t"+"|");
        for (Item item : itemMenu){
            if (item.getCategory().equals(category)){
                System.out.println(item.getName()+"\t"+"|"+"\t"+item.getPrice()+"\t"+"|"+"\t"+item.getDescription());
            }
        }
        System.out.println("구매하고 싶으신 메뉴의 이름을 입력해주세요");
        System.out.println("메뉴로 돌아가고 싶으시면 0을 입력해주세요");
        System.out.print("입력"+"\t"+"\t"+"    |"+"   ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("0")){
            displayMainMenu();
        }else {
            for (Item item : itemMenu){
                if(item.getName().equals(input)){
                    confirmItem(item);
                    return;

                }
            }
            System.out.println("오류입니다");
            displayItemMenu(category);
        }

    }
    private static void confirmItem(Item item) {
        System.out.println(item.getName() + "을 담으시겠습니까?");
        System.out.println("1.네"+"\t"+"\t"+"2.아니오");


        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("1")) {
            order.addcart(item);
            displayMainMenu();
        } else if (input.equals("2")) {
            displayMainMenu();
        } else {
            System.out.println("오류입니다");
            confirmItem(item);
        }
    }


        }









