package Kiosk;

public class Item extends Menu{

    private int price;

    private String category;


    public Item(String name, int price, String description, String category){
        super(name, description);
        this. price = price;
        this. category = category;
    }



    public int getPrice() {
        return price;}

    public String getCategory() {
        return category;}
}