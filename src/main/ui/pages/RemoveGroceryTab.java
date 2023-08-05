package ui.pages;

import model.Grocery;
import model.Inventory;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class RemoveGroceryTab extends Tab {
    private static String IMG_PATH = "data/projectimage.jpg";
    private JButton reloadButton;

    private JTable itemTable;
    private DefaultTableModel tableModel;


    public RemoveGroceryTab(Inventory inventory) {
        super(inventory);
        centerPanel.setLayout(new BorderLayout());
        setUpPanel();
    }

    // EFFECTS: !!
    public void setUpPanel() {
        centerPanel.removeAll();
        JScrollPane scrollPane = setTable();
        makeSelectionModelList();
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.revalidate();
        centerPanel.repaint();
    }


    private JScrollPane setTable() {
        tableModel = new DefaultTableModel(new Object[]{"Name", "Quantity", "Minimum Amount"}, 0);
        itemTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(itemTable);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        for (Grocery grocery : inventory.getGroceries()) {
            tableModel.addRow(new Object[]
                    {grocery.getGroceryName(), grocery.getQuantity(), grocery.getMinAmount()});
        }
        return scrollPane;
    }

    private void makeSelectionModelList() {
        ListSelectionModel selectionModel = itemTable.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    @Override
    protected void saveButton() {
        saveButton = new JButton("Save/Reload");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        add(saveButton, BorderLayout.SOUTH);  // causing a second panel on bottom half of screen
    }

    @Override
    protected void save() {
        List<Grocery> groceries = inventory.getGroceries();
        List<Grocery> newGroc = new ArrayList<>();

        for (int i : itemTable.getSelectedRows()) {
            Grocery grocToAdd = groceries.get(i);
            newGroc.add(grocToAdd);
        }

        for (Grocery g : newGroc) {
            inventory.removeGrocery(g);
        }
        super.save();
        setUpPanel();
    }
}
// drop down menu with names of all current groceries
// when user selects a grocery and hits "save", grocery item is
// removed from inventory and changes reflect on home page

//    private void setUpPopUp() {
//        JButton popupButton = new JButton("Show Popup");
//        popupButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showPopupImage();
//            }
//        });
//
//        centerPanel.add(popupButton);
//    }
//
//    private void showPopupImage() {
//        JDialog dialog = new JDialog();
////        dialog.setTitle("Popup Image");
//        dialog.setModal(true);
//        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//
//        try {
//            BufferedImage image = ImageIO.read(getClass().getResource(IMG_PATH));
//            ImageIcon imageIcon = new ImageIcon(image);
//
//            JLabel label = new JLabel(imageIcon);
//            dialog.add(label);
//
//            JButton closeButton = new JButton("Close");
//            closeButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    dialog.dispose(); // Close the dialog when the "Close" button is clicked
//                }
//            });
//
//            dialog.add(closeButton, BorderLayout.EAST);
//
//            dialog.pack();
//            dialog.setLocationRelativeTo(null); // Center the dialog on screen
//            dialog.setVisible(true);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

