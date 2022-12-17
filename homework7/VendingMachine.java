import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    private Map<Integer, Product> products;
    private float moneyRecieved;
    private int numberOfProducts;

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public float getMoneyRecieved() {
        return moneyRecieved;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    // public void setProducts(Map<Integer, Product> products) {
    //     this.products = products;
    // }

    public void setMoneyRecieved(float moneyRecieved) {
        this.moneyRecieved = moneyRecieved;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    protected Scanner sc = new Scanner(System.in);

    public VendingMachine(Map<Integer, Product> products) {
        this.products = products;
        this.moneyRecieved = 0.0f;
        this.numberOfProducts = 0;
    }

    public void addProduct(Product product) {
        numberOfProducts = numberOfProducts + 1;
        products.put(numberOfProducts, product);
    }

    public Integer getProductKey(String name) {
        for (Map.Entry<Integer, Product> entry : getProducts().entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void buy() {
        System.out.println("Enter product name:");
        String name = sc.nextLine(); // Покупатель вводит имя товара.

        Integer chosenProductKey = getProductKey(name);

        if (chosenProductKey != null) {
            System.out.println(products.get(chosenProductKey).getPrice()); // Автомат высвечивает стоимость товара.
    
            moneyRecieved = moneyRecieved + products.get(chosenProductKey).getPrice(); // Покупатель его оплачивает.
            products.remove(chosenProductKey);
            numberOfProducts = numberOfProducts - 1; // Из лотка выпадает заказанный товар.
        } else {
            System.err.println("Product with that name doesn't exist!");
        }
    }

    @Override
    public String toString() {
        return "VendingMachine [products=" + products + ", moneyRecieved=" + moneyRecieved + ", numberOfProducts="
                + numberOfProducts + "]";
    }
}