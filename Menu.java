import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Menu implements ActionListener {

  public JFrame menu = new JFrame("Snake!");
  public JPanel panel = new JPanel();
  public JButton play = new JButton("Play!");
  public JButton quit = new JButton("Quit");
  public JLabel title = new JLabel("Snake!");


  public Menu() {

    title.setBounds(420, 50, 520, 200);
    title.setFont(new Font("impact", Font.PLAIN, 120));
    title.setForeground(Color.black);

    play.setBounds(450, 300, 300, 150);
    play.addActionListener(this);
    play.setForeground(Color.black);
    play.setBackground(Color.lightGray);
    play.setFocusPainted(false);
    play.setFont(new Font("impact", Font.PLAIN, 24));

    quit.setBounds(450, 475, 300, 150);
    quit.addActionListener(this);
    quit.setForeground(Color.black);
    quit.setBackground(Color.lightGray);
    quit.setFocusPainted(false);
    quit.setFont(new Font("impact", Font.PLAIN, 24));

    panel.add(title);
    panel.add(play);
    panel.add(quit);
    panel.setBackground(Color.cyan);
    panel.setLayout(null);

    menu.add(panel);
    menu.pack();
    menu.setLayout(new GridLayout());
    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menu.setSize(1200, 700);
    menu.setVisible(true);
    menu.setResizable(false);
  }



  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == play) {
      new roundHandle();
      menu.dispose();
    } else if (e.getSource() == quit) {
      menu.dispose();
    }
  }


  public static void main(String[] args){
    new Menu();
  }
}
