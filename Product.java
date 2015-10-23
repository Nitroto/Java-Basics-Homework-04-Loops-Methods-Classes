import java.math.BigDecimal;

public class Product implements Comparable<Product> {

    private String name;
    private BigDecimal price;

    public Product(String productName, BigDecimal productPrice){
        this.setName(productName);
        this.setPrice(productPrice);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String productName){
        this.name = productName;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    public void setPrice(BigDecimal productPrice){
        this.price = productPrice;
    }

    @Override
    public int compareTo(Product product) {
        return this.getPrice().compareTo(product.getPrice());
    }
}
