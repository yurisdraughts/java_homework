import java.util.Map;

public class HotDrinksVM extends SpecializedVM {

    public HotDrinksVM(Map<Integer, Product> products) {
        super(products, "Горячие напитки");
    }

    public Integer getProductKey(String name, float volume, int temperature) {
        for (Map.Entry<Integer, Product> entry : getProducts().entrySet()) {
            if (entry.getValue() instanceof HotDrink
                    && entry.getValue().getName().equals(name)
                    && ((Drink) entry.getValue()).getVolume() == volume
                    && ((HotDrink) entry.getValue()).getTemperature() == temperature) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void buy() {
        System.out.println("Enter the name of a hot drink (ex. \"Americano\"):");
        String name = sc.nextLine();
        System.out.println("Enter the volume of a hot drink (ex. \"140,0\"):");
        float volume = sc.nextFloat();
        System.out.println("Enter the temperature of a hot drink (ex. \"91\"):");
        int temperature = sc.nextInt();

        Integer chosenProductKey = getProductKey(name, volume, temperature);

        if (chosenProductKey != null) {
            System.out.println(getProducts().get(chosenProductKey).getPrice()); // Автомат высвечивает стоимость товара.
    
            setMoneyRecieved(getMoneyRecieved() + getProducts().get(chosenProductKey).getPrice()); // Покупатель его оплачивает.
            getProducts().remove(chosenProductKey);
            setNumberOfProducts(getNumberOfProducts() - 1); // Из лотка выпадает заказанный товар.
        } else {
            System.err.println("We don't have a hot drink with that name, volume or temperature!");
        }
    }

}
