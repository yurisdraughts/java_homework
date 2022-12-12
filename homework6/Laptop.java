import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Laptop {
    private String name;
    private int price; // рубли
    private int randomAccessMemory; // гигабайты
    private int hardDrive; // гигабайты
    private int processorCores;
    private String operatingSystem;
    private String graphicsCard;
    private float screenDiagonal; // дюймы
    private boolean touchscreen;

    public Laptop(int price, String name, int randomAccessMemory, int hardDrive, int processorCores,
            String operatingSystem, String graphicsCard, float screenDiagonal, boolean touchscreen) {
        this.price = price;
        this.name = name;
        this.randomAccessMemory = randomAccessMemory;
        this.hardDrive = hardDrive;
        this.processorCores = processorCores;
        this.operatingSystem = operatingSystem;
        this.graphicsCard = graphicsCard;
        this.screenDiagonal = screenDiagonal;
        this.touchscreen = touchscreen;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getRandomAccessMemory() {
        return randomAccessMemory;
    }

    public int getHardDrive() {
        return hardDrive;
    }

    public int getProcessorCores() {
        return processorCores;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public float getScreenDiagonal() {
        return screenDiagonal;
    }

    public boolean hasTouchscreen() {
        return touchscreen;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "LAPTOP [NAME=" + name + ", PRICE=" + price + ", RAM=" + randomAccessMemory
                + ", HARDDRIVE=" + hardDrive + ", CORES=" + processorCores + ", OS="
                + operatingSystem + ", GRAPHICS_CARD=" + graphicsCard + ", SCREEN_DIAGONAL=" + screenDiagonal
                + ", TOUCHSCREEN=" + touchscreen + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + price;
        result = prime * result + randomAccessMemory;
        result = prime * result + hardDrive;
        result = prime * result + processorCores;
        result = prime * result + ((operatingSystem == null) ? 0 : operatingSystem.hashCode());
        result = prime * result + ((graphicsCard == null) ? 0 : graphicsCard.hashCode());
        result = prime * result + Float.floatToIntBits(screenDiagonal);
        result = prime * result + (touchscreen ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Laptop other = (Laptop) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (price != other.price)
            return false;
        if (randomAccessMemory != other.randomAccessMemory)
            return false;
        if (hardDrive != other.hardDrive)
            return false;
        if (processorCores != other.processorCores)
            return false;
        if (operatingSystem == null) {
            if (other.operatingSystem != null)
                return false;
        } else if (!operatingSystem.equals(other.operatingSystem))
            return false;
        if (graphicsCard == null) {
            if (other.graphicsCard != null)
                return false;
        } else if (!graphicsCard.equals(other.graphicsCard))
            return false;
        if (Float.floatToIntBits(screenDiagonal) != Float.floatToIntBits(other.screenDiagonal))
            return false;
        if (touchscreen != other.touchscreen)
            return false;
        return true;
    }

    public static Map<Object, Set<Laptop>> filterByProperty(Set<Laptop> laptops) {
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - объём оперативной памяти,");
        System.out.println("2 - объём жёсткого диска,");
        System.out.println("3 - число ядер процессора,");
        System.out.println("4 - операционная система,");
        System.out.println("5 - диагональ экрана,");
        System.out.println("6 - наличие сенсорного экрана.");

        String code = sc.nextLine();
        System.out.println();

        Map<Object, Set<Laptop>> result = new TreeMap<>();

        if (code.equals("1")) {
            for (Laptop laptop : laptops) {
                if (result.containsKey(laptop.randomAccessMemory)) {
                    result.get(laptop.randomAccessMemory).add(laptop);
                } else {
                    Object key = (Object) laptop.randomAccessMemory;
                    result.put(key, new HashSet<Laptop>());
                    result.get(laptop.randomAccessMemory).add(laptop);
                }
            }
        } else if (code.equals("2")) {
            for (Laptop laptop : laptops) {
                if (result.containsKey(laptop.hardDrive)) {
                    result.get(laptop.hardDrive).add(laptop);
                } else {
                    Object key = (Object) laptop.hardDrive;
                    result.put(key, new HashSet<Laptop>());
                    result.get(laptop.hardDrive).add(laptop);
                }
            }
        } else if (code.equals("3")) {
            for (Laptop laptop : laptops) {
                if (result.containsKey(laptop.processorCores)) {
                    result.get(laptop.processorCores).add(laptop);
                } else {
                    Object key = (Object) laptop.processorCores;
                    result.put(key, new HashSet<Laptop>());
                    result.get(laptop.processorCores).add(laptop);
                }
            }
        } else if (code.equals("4")) {
            for (Laptop laptop : laptops) {
                if (result.containsKey(laptop.operatingSystem)) {
                    result.get(laptop.operatingSystem).add(laptop);
                } else {
                    Object key = (Object) laptop.operatingSystem;
                    result.put(key, new HashSet<Laptop>());
                    result.get(laptop.operatingSystem).add(laptop);
                }
            }
        } else if (code.equals("5")) {
            for (Laptop laptop : laptops) {
                if (result.containsKey(laptop.screenDiagonal)) {
                    result.get(laptop.screenDiagonal).add(laptop);
                } else {
                    Object key = (Object) laptop.screenDiagonal;
                    result.put(key, new HashSet<Laptop>());
                    result.get(laptop.screenDiagonal).add(laptop);
                }
            }
        } else if (code.equals("6")) {
            for (Laptop laptop : laptops) {
                if (result.containsKey(laptop.touchscreen)) {
                    result.get(laptop.touchscreen).add(laptop);
                } else {
                    Object key = (Object) laptop.touchscreen;
                    result.put(key, new HashSet<Laptop>());
                    result.get(laptop.touchscreen).add(laptop);
                }
            }
        } else {
            System.out.println("Ошибка ввода!");
        }

        return result;
    }

    public static Map<Object, Set<Laptop>> filterByMinValue(Set<Laptop> laptops) {
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - объём оперативной памяти,");
        System.out.println("2 - объём жёсткого диска,");
        System.out.println("3 - число ядер процессора,");
        System.out.println("4 - диагональ экрана.");

        String code = sc.nextLine();
        System.out.println();

        Map<Object, Set<Laptop>> result = new TreeMap<>();

        if (code.equals("1")) {
            for (Laptop laptop : laptops) {
                if (result.containsKey(laptop.randomAccessMemory)) {
                    result.get(laptop.randomAccessMemory).add(laptop);
                } else {
                    Object key = (Object) laptop.randomAccessMemory;
                    result.put(key, new HashSet<Laptop>());
                    result.get(laptop.randomAccessMemory).add(laptop);
                }
            }
        } else if (code.equals("2")) {
            for (Laptop laptop : laptops) {
                if (result.containsKey(laptop.hardDrive)) {
                    result.get(laptop.hardDrive).add(laptop);
                } else {
                    Object key = (Object) laptop.hardDrive;
                    result.put(key, new HashSet<Laptop>());
                    result.get(laptop.hardDrive).add(laptop);
                }
            }
        } else if (code.equals("3")) {
            for (Laptop laptop : laptops) {
                if (result.containsKey(laptop.processorCores)) {
                    result.get(laptop.processorCores).add(laptop);
                } else {
                    Object key = (Object) laptop.processorCores;
                    result.put(key, new HashSet<Laptop>());
                    result.get(laptop.processorCores).add(laptop);
                }
            }
        } else if (code.equals("4")) {
            for (Laptop laptop : laptops) {
                if (result.containsKey(laptop.screenDiagonal)) {
                    result.get(laptop.screenDiagonal).add(laptop);
                } else {
                    Object key = (Object) laptop.screenDiagonal;
                    result.put(key, new HashSet<Laptop>());
                    result.get(laptop.screenDiagonal).add(laptop);
                }
            }
        } else {
            System.out.println("Ошибка ввода!");
            return result;
        }

        if (code.equals("4")) return getMinValueFloat(result);
        else return getMinValueInteger(result);
    }

    private static Map<Object, Set<Laptop>> getMinValueFloat(Map<Object, Set<Laptop>> result) {
        System.out.println("Введите минимальное значение (дробная часть при наличии должна быть отделена запятой):");

        final Float minValue;
        try {
            minValue = sc.nextFloat();
            System.out.println();
        } catch (InputMismatchException ime) {
            System.out.println();
            System.out.println("Ошибка ввода!");
            return result;
        }

        result = result.entrySet().stream()
                .filter(map -> (Float) map.getKey() >= minValue)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

        return result;
    }

    private static Map<Object, Set<Laptop>> getMinValueInteger(Map<Object, Set<Laptop>> result) {
        System.out.println("Введите минимальное значение (целое число):");

        final Integer minValue;
        try {
            minValue = sc.nextInt();
            System.out.println();
        } catch (InputMismatchException ime) {
            System.out.println();
            System.out.println("Ошибка ввода!");
            return result;
        }

        result = result.entrySet().stream()
                .filter(map -> (Integer) map.getKey() >= minValue)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

        return result;
    }

    private static Scanner sc = new Scanner(System.in);
}