/*package com.advanced.development;
import java.awt.*;
import java.awt.event.*;
public class jarDemo {

    public static void main(String[] args) {
       
        Frame frame = new Frame("JAR Demo");
      
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Fixed: Let the full loop execute to print all messages
                for (int i = 1; i < 10; i++) {
                    System.out.println("Closing window " + i);
                }
                
                // Exit the application after the loop finishes
                System.exit(0);
            }
        });

        frame.add(new Label("I can Create Executable Jar File", Label.CENTER));
        frame.setSize(400, 300);
        frame.setVisible(true);

    }   
    
}
*/