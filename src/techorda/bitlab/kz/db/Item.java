package techorda.bitlab.kz.db;

public class Item {
    Long id;
    String name;
    String description;
    double price;

    public Item(){}

    public Item(Long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < description.length(); i++) {
            if (description.charAt(i) == ',') {
                s.append("<br>");
            }
            else s.append(description.charAt(i));
        }
        return s.toString();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
