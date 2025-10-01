import javax.swing.*;
import java.awt.*;

public class Todo_application extends JFrame {

    private final JTextField input = new JTextField();
    private final JButton addButton = new JButton("Lägg till");
    private final DefaultListModel<String> todoModel = new DefaultListModel<>();
    private final DefaultListModel<String> doneModel = new DefaultListModel<>();
    private final JList<String> todoList = new JList<>(todoModel);
    private final JList<String> doneList = new JList<>(doneModel);
    private final JButton toDoneBtn = new JButton("→");
    private final JButton toTodoBtn = new JButton("←");
    private final JButton clearTodoBtn = new JButton("Rensa");
    private final JButton clearDoneBtn = new JButton("Rensa");
    private final JButton clearAll = new JButton("Rensa allt");

    public Todo_application() {
        setTitle("ToDo Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(12, 12));
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        // Top Part: textbox and add button
        JPanel topPart = new JPanel(new BorderLayout(8, 8));
        input.setPreferredSize(new Dimension(10, 30));
        topPart.add(input, BorderLayout.CENTER);
        topPart.add(addButton, BorderLayout.EAST);
        add(topPart, BorderLayout.NORTH);

        // Mitten: ToDo-panel | pilar-panel | Done-panel
        JPanel center = new JPanel(new GridBagLayout());
        add(center, BorderLayout.CENTER);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1;
        c.weightx = 1;

        // ToDo panel
        JPanel ToDoPanel = new JPanel(new BorderLayout(6, 6));
        ToDoPanel.add(new JLabel("To-Do"), BorderLayout.NORTH);
        todoList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ToDoPanel.add(new JScrollPane(todoList), BorderLayout.CENTER);
        ToDoPanel.add(clearTodoBtn, BorderLayout.SOUTH);
        c.gridx = 1;
        c.gridy = 0;
        center.add(ToDoPanel, c);

        // Done panel
        JPanel DonePanel = new JPanel(new BorderLayout(6, 6));
        DonePanel.add(new JLabel("Done"), BorderLayout.NORTH);
        doneList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        DonePanel.add(new JScrollPane(doneList), BorderLayout.CENTER);
        DonePanel.add(clearDoneBtn, BorderLayout.SOUTH);
        c.gridx = 3;
        c.gridy = 0;
        center.add(DonePanel, c);

        // Pilar i mitten
        JPanel arrows = new JPanel(new GridLayout(3, 1, 6, 6));
        arrows.add(toDoneBtn);
        arrows.add(toTodoBtn);
        arrows.add(clearAll);
        c.gridx = 2;
        c.gridy = 0;
        c.fill = GridBagConstraints.NONE;
        center.add(arrows, c);
        c.fill = GridBagConstraints.BOTH;

        addButton.addActionListener(e -> addTask());
        input.addActionListener(e -> addTask());
        toDoneBtn.addActionListener(e -> moveToDone());
        toTodoBtn.addActionListener(e -> moveToTodo());

        setVisible(true);
        setMinimumSize(new Dimension(720, 480));
        setLocationRelativeTo(null);

    }

    // Lägg till uppgift i ToDo
    private void addTask() {
        String text = input.getText().trim();
        if (!text.isEmpty()) {
            todoModel.addElement(text);
            input.setText("");
            input.requestFocusInWindow();
        }
    }

    // Flytta markerade tasks från ToDo till Done
    private void moveToDone() {
        int[] idx = todoList.getSelectedIndices();
        if (idx.length == 0)
            return;

        // Lägg till i Done
        for (int i : idx) {
            doneModel.addElement(todoModel.get(i));
        }
    }
    // Flytta markerade tasks från Done till Todo
    private void moveToTodo() {
        int[] index = doneList.getSelectedIndices();
        if (index.length == 0)
            return;

        // Lägg till i ToDo
        for (int i : index) {
            todoModel.addElement(doneModel.get(i));
        }
    }

    public static void main(String[] args) throws Exception {
        new Todo_application();

    }

}
