public class HotDrink extends Drink {
    private int temperature;

    public int getTemperature() {
        return temperature;
    }

    public HotDrink(String name, float price, float volume, int temperature) {
        super(name, price, volume);
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Drink [name=" + getName() + ", price=" + getPrice() + ", volume=" + getVolume() + ", temperature=" + temperature + "]";
    }
    
}
