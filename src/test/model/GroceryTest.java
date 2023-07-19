package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GroceryTest {
    private Category fruit;
    private Grocery banana;
    private Grocery strawberry;
    private Grocery milk;

    @BeforeEach
    void runBefore(){
        fruit = new Category("Fruit", null);
        banana = new Grocery("Bananas", 5);
        strawberry = new Grocery("Strawberries", 8);
        milk = new Grocery("Milk",2);
    }

}