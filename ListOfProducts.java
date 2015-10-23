/**
 * Create a class Product to hold products, which have name (string) and price (decimal number). Read from a text file
 * named "Input.txt" a list of products. Each product will be in format name + space + price. You should hold the
 * products in objects of class Product. Sort the products by price and write them in format price + space + name in
 * a file named "Output.txt".
 */

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class ListOfProducts {

    public static void main(String[] args) throws IOException {
        Locale englishLocale = new Locale("en", "US");
        Locale.setDefault(englishLocale);
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("Input.txt");
            BufferedReader textReader = new BufferedReader(fileReader);
            String lineContent = textReader.readLine().trim();

            while (lineContent != "" && lineContent != null) {
                String[] productDetails = lineContent.split(" ");
                String productName = productDetails[0];
                BigDecimal productPrice = new BigDecimal(productDetails[1]);
                Product product = new Product(productName, productPrice);
                products.add(product);
                lineContent = textReader.readLine();
            }

            Collections.sort(products);
            FileWriter fileWriter = new FileWriter("Output.txt");
            BufferedWriter textWriter = new BufferedWriter(fileWriter);

            for (Product product : products) {
                String productInfo = String.format("%.2f %s", product.getPrice(), product.getName());
                textWriter.write(productInfo);
                textWriter.newLine();
            }

            textReader.close();
            textWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error. Missing file");
        } catch (NullPointerException ex) {
            System.out.println("Error. File is empty");
        }
    }
}
