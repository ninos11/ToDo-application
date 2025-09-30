import javax.swing.*;
import java.awt.*;

    public class  Todo_application extends JFrame{
      
      private final JTextField input = new JTextField();
      private final JButton addButton = new JButton("Lägg till");


    public Todo_application () {
        setTitle("ToDo Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(12, 12));
        ((JComponent)getContentPane()).setBorder(BorderFactory.createEmptyBorder(12,12,12,12));
        
        
        // Top Part: textbox and add button
        JPanel topPart = new JPanel(new BorderLayout(8,8));
        input.setPreferredSize(new Dimension(10, 30));
        topPart.add(input, BorderLayout.CENTER);
        topPart.add(addButton, BorderLayout.EAST);
        add(topPart, BorderLayout.NORTH);
        
        setVisible(true);
        setMinimumSize(new Dimension(720, 480));
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) throws Exception {
        new Todo_application();

    }
}
