package ku.shop;

import java.util.HashMap;
import java.util.Map;

//รักษิตา รัตนาลังการ 6310450654
public class ProductManager {
    private Map<String, Integer> stock;

    public ProductManager() {
        stock = new HashMap<>();
        stock.put("Bread", 10); // Initial stock quantity
    }

    public void purchaseProduct(String productName, int quantity) {
        // Logic to simulate the purchase and update the stock
        int currentStock = stock.get(productName);
        stock.put(productName, currentStock - quantity);
    }

    public int getStock(String productName) {
        // Logic to retrieve the current stock of the product
        return stock.get(productName);
    }

}
