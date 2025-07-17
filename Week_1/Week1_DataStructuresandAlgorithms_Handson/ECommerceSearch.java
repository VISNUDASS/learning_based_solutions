import java.util.Arrays;
import java.util.Comparator;

class Product {
    String productId;
    String productName;
    String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return "[" + productId + " | " + productName + " | " + category + "]";
    }
}

public class ECommerceSearch {

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);

            if (cmp == 0)
                return products[mid];
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P101", "Laptop", "Electronics"),
            new Product("P102", "Shoes", "Fashion"),
            new Product("P103", "Book", "Education"),
            new Product("P104", "Phone", "Electronics"),
            new Product("P105", "Watch", "Fashion")
        };

        System.out.println("=== Linear Search ===");
        Product result1 = linearSearch(products, "Phone");
        System.out.println("Result: " + (result1 != null ? result1 : "Not Found"));

        // Sort products for binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("\n=== Binary Search ===");
        Product result2 = binarySearch(products, "Phone");
        System.out.println("Result: " + (result2 != null ? result2 : "Not Found"));
    }
}
