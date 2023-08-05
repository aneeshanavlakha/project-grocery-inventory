package ui.pages;

import model.Inventory;

import javax.swing.*;
import java.awt.*;

public class ChangeValueTab extends Tab {
    private JTextField valueEntry;
    private static String IMG_PATH = "data/projectimage.jpg";

    public ChangeValueTab(Inventory inventory) {
        super(inventory);
        setUpPanel();
    }

    public void setUpPanel() {
        centerPanel.removeAll();
        displayValue(inventory);
        displayValueEntryObjects();
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    // EFFECTS: test box that allows user to input new value
    private void displayValueEntryObjects() {
        JLabel label = new JLabel("Set new value: ");
        label.setBounds(10, 60, 200, 25);
        valueEntry = new JTextField();
        valueEntry.setBounds(200, 60, 50, 25);
        centerPanel.add(label);
        centerPanel.add(valueEntry);
    }

    private void displayValue(Inventory inventory) {
        int val = inventory.getValue();
        JLabel heading = new JLabel("Amount Spent So Far: $" + val);
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(heading, BorderLayout.NORTH);
    }

    @Override
    protected void save() {
        inventory.setValue(Integer.parseInt(valueEntry.getText()));
        super.save();
        setUpPanel();
        displayImage();
    }

    public void displayImage() {
        ImageIcon icon = new ImageIcon(IMG_PATH);
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(100, 200, 5, 5);
        centerPanel.add(imageLabel);
    }
}


// current value displayed on top of page
// text box that allows user to input new value
// when user enters new number and hits "save", new value is updated in inventory and changes reflect
// on home page


//    @Override
//    protected void saveButton() {
//        saveButton = new JButton("Save");
//        imageButton = new JButton("Fun Image");
//
//        saveButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                save();
//            }
//        });
//
//        imageButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                displayImage();
//            }
//        });
//
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.add(saveButton);
//        buttonPanel.add(imageButton);
//
//        centerPanel.add(buttonPanel, BorderLayout.SOUTH);
//    }
//
//    @Override
//    protected void save() {
//        inventory.setValue(Integer.parseInt(valueEntry.getText()));
//        super.save();
//    }
//
//    public void displayImage() {
//        imageButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    // Load the image from the specified path
//                    Image image = ImageIO.read(getClass().getResource(IMG_PATH));
//                    // Create a label to display the image
//                    JLabel imageLabel = new JLabel(new ImageIcon(image));
//                    // Clear previous content and add the image label to the panel
//                    centerPanel.removeAll();
//                    centerPanel.add(imageLabel);
//                    // Repaint the panel to update the UI
//                    centerPanel.revalidate();
//                    centerPanel.repaint();
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
//    }


//OR

//
//    @Override
//    protected void save() {
//        inventory.setValue(Integer.parseInt(valueEntry.getText()));
//        super.save();
//        displayImage();
//    }
//
//    public void displayImage() {
//        saveButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    // Load the image from the specified path
//                    Image image = ImageIO.read(getClass().getResource(IMG_PATH));
//                    // Create a label to display the image
//                    JLabel imageLabel = new JLabel(new ImageIcon(image));
//                    // Clear previous content and add the image label to the panel
//                    centerPanel.removeAll();
//                    centerPanel.add(imageLabel);
//                    // Repaint the panel to update the UI
//                    centerPanel.revalidate();
//                    centerPanel.repaint();
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
//    }

