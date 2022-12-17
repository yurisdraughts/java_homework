import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        HotDrinksVM hdvm = new HotDrinksVM(new TreeMap<>());
        System.out.println(hdvm);
        System.out.println();
        
        hdvm.addProduct(new HotDrink("Espresso", 60, 50, 90));
        hdvm.addProduct(new HotDrink("Americano", 60, 140, 91));
        hdvm.addProduct(new HotDrink("Cappuccino", 80, 140, 92));
        hdvm.addProduct(new HotDrink("Double espresso", 105, 100, 93));
        hdvm.addProduct(new HotDrink("Latte", 99, 180, 94));
        System.out.println(hdvm);
        System.out.println();
        
        hdvm.buy();
        System.out.println();
        System.out.println(hdvm);
    }
}
