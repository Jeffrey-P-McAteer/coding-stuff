package coding_stuff;

// Without this line, every time we wanted to
// use the JFrame class we'd have to type
// the full name: javax.swing.JFrame
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

/**
 * This is the first class loaded when we run `gradle run`
 * because build.gradle specifies mainClassName = 'coding_stuff.App'.
 * If we wanted to start running code from another class
 * we'd change it to mainClassName = 'coding_stuff.SomeOtherClassName'
 */
public class App {
    /**
     * This is where code begins executing. If you run
     * from a terminal `args` will be populated with the words
     * typed at the end of the command.
     */
    public static void main(String[] args) {
        JFrame main_window = new JFrame();
        main_window.setSize(800, 600);
        main_window.setTitle("Some window title");
        // This is a magic constant that tells the rest of the
        // program to exit when the window is closed.
        // Some programs can be built to continue running after
        // their window is closed, but we aren't doing that for now.
        main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_window.setLayout(new BorderLayout());
        
        JLabel input_label = new JLabel("Write Stuff:");
        JTextField input = new JTextField(25);
        input_label.setLabelFor(input);
        
        JLabel output_label = new JLabel("Hi There!");
        
        // This bit of magic lets us run code whenever
        // the text input changes. We create an "anonymous class"
        // which is a fancy way to say we _should_ create a new
        // SomeListenerName.java and call `new SomeListenerName()`
        // but that takes planning and effort.
        input.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
              do_stuff();
            }
            public void removeUpdate(DocumentEvent e) {
              do_stuff();
            }
            public void insertUpdate(DocumentEvent e) {
              do_stuff();
            }
            // ^^^ We _could_ do something different on each
            //     different type of change, but I didn't have anything in mind.

            public void do_stuff() {
               String user_typed = input.getText();
               // Computers care about details; we do not.
               // It is simpler to test for "hi" (lowercase) than all
               // combinations of "Hi" "hI" "HI" and "hi".
               user_typed = user_typed.toLowerCase();
               
               // Here we can do some logic based on what the user typed.
               if (user_typed.contains("hi") || user_typed.contains("hello")) {
                  output_label.setText("Hello! I am a computer!");
               }
               else if (user_typed.contains("what") && user_typed.contains("name")) {
                  // Rather than put all the logic to get our name here directly
                  // we wrote an entire function our_name() to do it for us.
                  output_label.setText("My name is "+our_name()+".");
               }
               else {
                  output_label.setText("I'm not sure what you mean.");
               }
               
            }
        });
        // This is the end of input.getDocument().addDocumentListener
        // No code within has been executed yet, we just gave it
        // to someone else who will run it when text changes.
        
        // Now we add the child elements to the main window, 
        // specifying their locations as the second argument.
        main_window.add(input_label, BorderLayout.WEST);
        main_window.add(input, BorderLayout.CENTER);
        main_window.add(output_label, BorderLayout.SOUTH);
        
        // "packing" in java Swing refers to running
        // the calculations to figure out where text goes.
        main_window.pack();
        main_window.setVisible(true);
        
    }
    
    /**
     * This piece of magic attempts to determine our computer's name
     * using network information.
     */
    private static String our_name() {
        try {
            return java.net.InetAddress.getLocalHost().getHostName();
        }
        catch (Exception e) {
            // Something blew up; print an error message
            e.printStackTrace();
            // and return something
            return "Cody the buggy macbook";
        }
    }
}
