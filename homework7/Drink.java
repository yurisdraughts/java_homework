public class Drink extends Product {
    private float volume; // мл

    public float getVolume() {
        return volume;
    }

    public Drink(String name, float price, float volume) {
        super(name, price);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Drink [name=" + getName() + ", price=" + getPrice() + ", volume=" + volume + "]";
    }
    
}
