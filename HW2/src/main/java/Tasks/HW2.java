package Tasks;

import Orders.Order;
import Other.Address;
import Products.Apple;
import Products.Orange;
import Products.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HW2 {

    public static void main(String[] args) throws IOException{

        String[] title = {"1title", "2title", "3title"};
        String[] color = {"white", "pink","green"};
        String[] country = {"China", "France", "German", "Russian Federation"};
        String[] city = {"Beijing", "Paris", "Berlin", "Moscow"};
        String[] street = {"Hot road", "Cold road", "Kukold road"};
        final int house = 100;
        final int floor = 100;
        final int flat = 4;
        final int Price = 1000;
        final int Weight = 500;
        final int Order = 100;

        List<Order> orders = new ArrayList<>();
        Random random = new Random();

        for (int currentNumberofOrder = 0; currentNumberofOrder < Order; currentNumberofOrder++){

            int randomIndexForCountry = random.nextInt(country.length);
            int randomIndexForCity = random.nextInt(city.length);
            int randomIndexForStreet = random.nextInt(street.length);
            int randomHouse = random.nextInt(house);
            int randomFloor = random.nextInt(floor);
            int randomFlat = random.nextInt(flat);
            Address address = new Address(
                    country[randomIndexForCountry],
                    city[randomIndexForCity],
                    street[randomIndexForStreet],
                    randomHouse,
                    randomFloor,
                    randomFlat
            );

            int randomPrice = random.nextInt(Price);
            int randomWeight = random.nextInt(Weight);
            int indexForRandomTitle = random.nextInt(title.length);
            int indexForRandomColor = random.nextInt(color.length);
            boolean randomWithBones = random.nextBoolean();

            Orange orange = new Orange(randomPrice, title[indexForRandomTitle], randomWeight, randomWithBones);
            Apple apple = new Apple(randomPrice, title[indexForRandomTitle], randomWeight, color[indexForRandomColor]);
            List<Product> products = new ArrayList<>();
            products.add(apple);
            products.add(orange);
            Order order = new Order(products, address);
            orders.add(order);

            ObjectMapper mapper = new ObjectMapper();
            FileWriter fileWriter = new FileWriter("src/orders.json");
            mapper.writeValue(fileWriter, orders);
            FileReader fileReader = new FileReader("src/orders.json");
            orders = mapper.readValue(fileReader, List.class);
            System.out.println(orders);


        }
    }
}
