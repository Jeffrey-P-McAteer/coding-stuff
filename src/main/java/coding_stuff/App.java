package coding_stuff;

// Without this line, every time we wanted to
// use the JFrame class we'd have to type
// the full name: javax.swing.JFrame
import javax.swing.JFrame;

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
        main_window.setVisible(true);
        
        
    }
}
