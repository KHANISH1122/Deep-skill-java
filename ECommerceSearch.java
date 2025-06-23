import java.util.ArrayList;
import java.util.List;

class Product {
    private int id;
    private String name;
    private String category;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public void display() {
        System.out.println("Product ID: " + id + ", Name: " + name + ", Category: " + category);
    }
}

class ProductCatalog {
    private List<Product> inventory;

    public ProductCatalog() {
        inventory = new ArrayList<>();
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public List<Product> searchByKeyword(String keyword) {
        List<Product> results = new ArrayList<>();
        for (Product product : inventory) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    product.getCategory().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(product);
            }
        }
        return results;
    }
}

public class ECommerceSearch {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(new Product(1, "iPhone 15", "Electronics"));
        catalog.addProduct(new Product(2, "Nike Running Shoes", "Footwear"));
        catalog.addProduct(new Product(3, "Dell XPS 13", "Electronics"));
        catalog.addProduct(new Product(4, "Wooden Dining Table", "Furniture"));

        List<Product> results = catalog.searchByKeyword("elect");
        for (Product product : results) {
            product.display();
        }
    }
}
