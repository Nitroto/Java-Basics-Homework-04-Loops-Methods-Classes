/**
 * Create a class Product to hold products, which have name (string) and price (decimal number). Read from a text file
 * named "Products.txt" a list of product with prices and keep them in a list of products. Each product will be in
 * format name + space + price. You should hold the products in objects of class Product. Read from a text file named
 * "Order.txt" an order of products with quantities. Each order line will be in format product + space + quantity.
 * Calculate and print in a text file "Output.txt" the total price of the order. Ensure you close correctly all used resources.
 */

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;


public class OrderOfProducts {

    public static void main(String[] args) throws IOException {
        Locale englishLocale = new Locale("en", "US");
        Locale.setDefault(englishLocale);
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileReader productsReader = new FileReader("Products.txt");
            BufferedReader textReader = new BufferedReader(productsReader);
            String productContent = textReader.readLine().trim();

            while (productContent != "" && productContent != null) {
                String[] productDetails = productContent.split(" ");
                String productName = productDetails[0];
                BigDecimal productPrice = new BigDecimal(productDetails[1]);
                Product product = new Product(productName, productPrice);
                products.add(product);
                productContent = textReader.readLine();
            }

            productsReader.close();
            textReader.close();

            BigDecimal totalPrice = new BigDecimal(0);
            FileReader ordersReader = new FileReader("Order.txt");
            BufferedReader orderReader = new BufferedReader(ordersReader);
            String orderContent = orderReader.readLine();

            while (orderContent != "" && orderContent != null) {
                String[] orderDetails = orderContent.split(" ");
                for (Product product : products) {
                    if (product.getName().equals(orderDetails[1])) {
                        BigDecimal quantity = new BigDecimal(orderDetails[0]);
                        totalPrice = totalPrice.add(quantity.multiply(product.getPrice()));
                    }
                }
                orderContent = orderReader.readLine();
            }

            ordersReader.close();
            orderReader.close();

            FileWriter fileWriter = new FileWriter("Output.txt");
            BufferedWriter billWriter = new BufferedWriter(fileWriter);

            DecimalFormat format = new DecimalFormat("#.##");
            String bill = format.format(totalPrice);
            billWriter.write(bill);

            billWriter.close();
            fileWriter.close();


        } catch (FileNotFoundException e) {
            System.out.println("Error. Missing file");
        } catch (NullPointerException ex) {
            System.out.println("Error. File is empty");
        }
    }

}
