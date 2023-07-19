package model;

import org.junit.jupiter.api.BeforeEach;

class GroceryTest {
    private Inventory fruit;
    private Grocery banana;
    private Grocery strawberry;
    private Grocery milk;

    @BeforeEach
    void runBefore(){
        fruit = new Inventory("Fruit", null);
        banana = new Grocery("Bananas", 5);
        strawberry = new Grocery("Strawberries", 8);
        milk = new Grocery("Milk",2);
    }

}