import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Homework {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();

        laptops.add(new Laptop(39_999, "Xiaomi RedmiBook 15 JYU4525RU", 8, 256, 2, "Windows 11 Домашняя", "Intel UHD Graphics", 15.6f, false));

        laptops.add(new Laptop(29_999, "ASUS VivoBook 14 F415EA-UB34", 8, 128, 1, "Windows 10 Домашняя S-режим", "Intel UHD Graphics", 14.0f, false));
        
        laptops.add(new Laptop(47_999, "HP 15-dy2067ms 4W2K2UA", 12, 256, 4, "Windows 11 Домашняя S-режим", "Intel Iris Xe Graphics", 15.6f, true));

        laptops.add(new Laptop(62_999, "HUAWEI MateBook D 15 BoM-WFQ9 5500U/16+512 Mystic Silver", 16, 512, 6, "Windows 11 Домашняя", "Radeon Graphics", 15.6f, false));

        laptops.add(new Laptop(61_999, "Thunderobot 911 Air D (JT0098E06RU)", 8, 256, 6, "не установлена", "GeForce GTX 1650 4GB", 15.6f, false));

        System.out.println("===== Первый фильтр =====");
        Map<Object, Set<Laptop>> filteredLaptops = Laptop.filterByProperty(laptops);
        print(filteredLaptops);
        
        System.out.println("===== Второй фильтр =====");
        Map<Object, Set<Laptop>> filteredLaptops2 = Laptop.filterByMinValue(laptops);
        print(filteredLaptops2);
    }

    private static void print(Map<Object, Set<Laptop>> map) {
        for (Map.Entry<Object, Set<Laptop>> entry : map.entrySet()) {
            System.out.println(entry);
            System.out.println();
        }
    }
}