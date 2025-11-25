import javax.swing.*;
import java.awt.*;

public class SortedListGUI extends JFrame {

    private SortedList sortedList = new SortedList();
    private JTextArea displayArea;
    private JTextField inputField, searchField;

    public SortedListGUI() {
        setTitle("Sorted Array List (Binary Search)");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        inputField = new JTextField(12);
        JButton addBtn = new JButton("Add");
        topPanel.add(new JLabel("Add:"));
        topPanel.add(inputField);
        topPanel.add(addBtn);

        JPanel bottomPanel = new JPanel();
        searchField = new JTextField(12);
        JButton searchBtn = new JButton("Search");
        bottomPanel.add(new JLabel("Search:"));
        bottomPanel.add(searchField);
        bottomPanel.add(searchBtn);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> addItem());
        searchBtn.addActionListener(e -> searchItem());
    }

    private void addItem() {
        String text = inputField.getText().trim();
        if (text.isEmpty()) return;

        sortedList.add(text);
        inputField.setText("");

        displayArea.append("Added: " + text + "\n");
        displayArea.append(sortedList + "\n\n");
    }

    private void searchItem() {
        String text = searchField.getText().trim();
        if (text.isEmpty()) return;

        int result = sortedList.search(text);

        if (result >= 0) {
            displayArea.append("FOUND: \"" + text + "\" at position " + result + "\n");
        } else {
            int insertPos = -result - 1;
            displayArea.append("NOT FOUND: \"" + text + "\" would be inserted at position " + insertPos + "\n");
        }
        displayArea.append(sortedList + "\n\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SortedListGUI().setVisible(true));
    }
}
