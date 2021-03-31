package observer.v8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends Frame{
    public void launch(){
        Button b = new Button("press me");
        b.addActionListener(new MyActionListener());
        b.addActionListener(new MyActionListener2());
        b.addActionListener(e -> {
            System.out.println("button pressed 3!");
        });
        this.add(b);
        this.pack();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setLocation(400,400);
        this.setVisible(true);
    }
    private class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button pressed!");
        }
    }

    private class MyActionListener2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button pressed 2!");
        }
    }

    public static void main(String[] args) {
        new Main().launch();
    }

}
