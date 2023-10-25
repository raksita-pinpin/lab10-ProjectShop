package ku.shop;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

//รักษิตา รัตนาลังการ 6310450654
public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;


    @Given("the store is ready to service customers")
    public void the_store_is_ready_to_service_customers() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product {string} with price {float} and stock of {int} exists")
    public void a_product_exists(String name, double price, int stock) {
        catalog.addProduct(name, price, stock);
    }

    @When("I buy {string} with quantity {int}")
    public void i_buy_with_quantity(String name, int quantity) {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quantity);
    }

    @Then("total should be {float}")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }



    private ProductManager productManager = new ProductManager();

    @When("a customer buys {int} {string} products")
    public void a_customer_buys_products(Integer quantity, String productName) {
        productManager.purchaseProduct(productName, quantity);
    }

    @Then("the stock of {string} should be {int}")
    public void the_stock_of_should_be(String productName, Integer expectedStock) {
        int currentStock = productManager.getStock(productName);
        Assertions.assertEquals(expectedStock, currentStock);
    }


}

