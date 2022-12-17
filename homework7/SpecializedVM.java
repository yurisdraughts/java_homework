import java.util.Map;
public class SpecializedVM extends VendingMachine {
    private String type;

    public SpecializedVM(Map<Integer, Product> products, String type) {
        super(products);
        this.type = type;
    }

    @Override
    public String toString() {
        return "VendingMachine [type=" + type + ", products=" + getProducts() + ", moneyRecieved=" + getMoneyRecieved()
                + ", numberOfProducts="
                + getNumberOfProducts() + "]";
    }

}
