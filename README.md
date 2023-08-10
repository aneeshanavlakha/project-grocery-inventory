# My Personal Project: Grocery Inventory

## Project Description

**What will the application do?** <br>
This application will keep inventory of groceries you have at home.<br>
It lets you track the *name* and *quantity* of groceries you use every day to 
see an *updated count* of which and how many of each you have left. <br>

Possible features include: 
- Setting alerts for low groceries 
- Setting the desired or minimum amount of each grocery per week 
- Adding new groceries 
- Organizing groceries into categories e.g, Dairy, Dry Items, Fruits, Vegetables, Proteins etc. 
- Tracking which grocery has gone bad instead of been used up 
- Seeing a chart of each grocery's usage frequency, frequency of going bad etc.

X: Grocery (with name and quantity) <br>
Y: List of groceries divided into sub-categories (with current quantity
and alerts for the ones that are running low)

**Who will use it?**<br>
It can be used by anyone who keeps groceries in their home.

**Why is this project of interest to me?** <br>
As a student that lives alone, I am in charge of keeping tab on my groceries 
and eating habits i.e., what groceries I consume the most, least and how often.
I often find myself lost on which groceries I have left and how many. 
I think that this application will help me, and others in my situation, 
keep tabs on our food and also allow us to keep tabs on our eating habits 
in order to maintain a healthy diet and plan for each end-of-week grocery haul.

## User Stories

Phase 1:
- As a user, I want to be able to create a new grocery and add it to an inventory of groceries //GUI
- As a user, I want to be able to set the name and quantity of a new grocery //GUI
- As a user, I want to be able to access my inventory of groceries //GUI
- As a user, I want to be able to edit and view the total value spent on groceries so far //GUI
- As a user, I want to be able to set lower limits for each grocery //GUI
- As a user, I want to be able to receive alerts for when my groceries go below their limit

Phase 2:
- As a user, I want to be able to have the option to save my inventory to file        //GUI
- As a user, I want to be able to have the option load my saved inventory from file   //GUI


# Instructions for Grader

- You can generate the first required action related to adding Xs to a Y by...
  - Clicking the "Add" button on the Home page, or selecting the "Add Grocery" tab in the panel on the right side
  - It will direct you to the Add Grocery page  
    - Enter a grocery name (String), quantity (int) and the minimum amount (int)
    - Click the "Save" button to save changes to inventory

- You can generate the second required action related to adding Xs to a Y by...
  - Clicking the "Remove" button on the Home page, or selecting the "Remove Grocery" tab in the panel on the right side
      - It will direct you to the Remove Grocery page
        - Select the grocery you want to remove from the inventory by clicking on it's row in the table
          - To select one grocery, click it with your mouse
          - To select multiple inconsecutive groceries, hold ctrl or command key and mouse select the groceries 
          - To select multiple consecutive groceries, hold shift key and mouse select first and last grocery in range
        - Click the "Remove" button to save changes to inventory

- You can locate my visual component by...
  - Going to the "Change Value" tab
  - Entering a new value i.e., amount of money spent on groceries (int) and clicking the "Save" button
  - You may continue to change the value as many times as you want

- You can save the state of my application by
  - Clicking "Save" button in the Add Grocery and Change Value tabs
  - CLicking "Remove" button in Remove Grocery tab

- You can reload the state of my application by...
  - Clicking "Refresh Inventory" button in the Home tab and Remove Grocery tab

## Phase 4: Task 2
Wed Aug 09 15:45:56 PDT 2023
Event log cleared.
Wed Aug 09 15:46:10 PDT 2023
Added new grocery Carrot with quantity 32 and minimum amount 2
Wed Aug 09 15:46:15 PDT 2023
Removed grocery : pea.
Wed Aug 09 15:46:19 PDT 2023
Changed inventory value to 80

## Phase 4: Task 3
I'd refactor my design to ensure my event is not logged twice.

Another thing I'd do is remove some of the code duplication between the HomeTab class and RemoveGroceryTab class, 
especially in the setTable() and saveButton() methods. The setTable() method implementation is pretty much identical 
in both classes, and I think that either adding them into a common abstract class, perhaps in Tab would help reduce 
some of the duplication. However, none of the other subclasses of Tab use those methods, so I'd have to figure out 
how to fix that.

Same goes from the loadTabs() method in the GroceryInventoryUI class. The section of code where I am adding tabs and 
setting their indices
i.e., 
  sidebar.add(homeTab, HOME_TAB_INDEX);
  sidebar.setTitleAt(HOME_TAB_INDEX, "Home");
has a lot of duplication - the method calls to sidebar.add() and sidebar.setTitle() repeated with different parameters. 
I'd extract the 2 methods into a new method, perhaps createSidebar() that takes parameters
JPanel, int, and String. Then I'd simply call createSidebar for each tab.  
Eg:
  public void createSidebar(JPanel panel, int index, String name) {
  sidebar.add(panel, index);
  sidebar.setTitleAt(index, name);
  } 
and in loadTabs() :
  createSidebar(homeTab, HOME_TAB_INDEX, "Home");
etc.

















