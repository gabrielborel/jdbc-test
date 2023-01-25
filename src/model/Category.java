package model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private Integer id;
    private String name;
    private List<Product> products = new ArrayList<Product>();

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void addProduct(Product p) {
        this.products.add(p);
    }

    public List<Product> getProducts() {
        return this.products;
    }
}
