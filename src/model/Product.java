package model;

public class Product {
    private Integer id;
    private String name;
    private String description;

    public Product(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }

    public Product(Integer id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return String.format("Created product: %d, %s, %s", this.id, this.name, this.description);
    }
}
