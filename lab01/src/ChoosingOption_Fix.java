package src;
import javax.swing.*;

public class ChoosingOption_Fix {
    public static void main(String[] args) {
        String[] options = {"Yes", "No", "I do", "I don't"};
        int option = JOptionPane.showOptionDialog(null, "Enter your choice:", "User's choice",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (option >= 0) {
            JOptionPane.showMessageDialog(null, "You've chosen: " + options[option]);
        } else {
            JOptionPane.showMessageDialog(null, "You've closed the dialog .");
        }
        System.exit(0);
    }
}
