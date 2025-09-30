import javax.swing.*;
import java.awt.*;

public class Todo_application extends JFrame {

    private final JTextField input = new JTextField();
    private final JButton addButton = new JButton("Lägg till");
    private final JList<String> todoList = new JList<>();
    private final JList<String> doneList = new JList<>();

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
        c.gridx = 1;
        c.gridy = 0;
        center.add(ToDoPanel, c);

        // Done panel
        JPanel DonePanel = new JPanel(new BorderLayout(6, 6));
        DonePanel.add(new JLabel("Done"), BorderLayout.NORTH);
        doneList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        DonePanel.add(new JScrollPane(doneList), BorderLayout.CENTER);

        c.gridx = 3;
        c.gridy = 0;
        center.add(DonePanel, c);

        setVisible(true);
        setMinimumSize(new Dimension(720, 480));
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) throws Exception {
        new Todo_application();

    }
}
