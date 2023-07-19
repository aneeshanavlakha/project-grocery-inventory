package model;

import java.util.ArrayList;
import java.util.List;

// Contains a list of all existing categories
// User can add new ones, up to the max number of categories
public class AllCategories {
    private static int MAX_NUMBER_CATEGORIES = 8;
    private static Category fruit;
    private static Category vegetables;
    private static Category dairy;
    private static Category protein;
    private static Category bulk;

    private List<Category> listOfCategories;

    public AllCategories() {
        listOfCategories = new ArrayList<Category>();
        listOfCategories.add(fruit);
        listOfCategories.add(vegetables);
        listOfCategories.add(dairy);
        listOfCategories.add(protein);
        listOfCategories.add(bulk);   //will added stuff change this in the future?
    }

    public List<Category> getListOfCategories() {
        return this.listOfCategories;
    }

    //REQUIRES: this category is <= MAX_NUMBER_CATEGORIES //how to implement?
    //MODIFIES: this
    //EFFECTS: creates a new category
    //         if the index of new category is > MAX,
    //         removed category from list and returns false
    //         else add this category to list of categories
    public boolean createNewCategory(Category category) {
        listOfCategories.add(category);
        if (listOfCategories.indexOf(category) > MAX_NUMBER_CATEGORIES) {
            listOfCategories.remove(category);
            return false;
        } else {return true}
    }

}
