package Demo01.demov1.Models;

import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private int Devyear;
    private Double price;
    private String url;

    public Product( String productName, Double price, int Devyear, String url) {
        this.productName = productName;
        this.price = price;
        this.Devyear = Devyear;
        this.url = url;
    }

    public Product() {}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", year=" + Devyear +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getDevyear() {
        return Devyear;
    }

    public void setDevyear(int Devyear) {
        this.Devyear = Devyear;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
