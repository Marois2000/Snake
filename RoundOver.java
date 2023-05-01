import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RoundOver implements ActionListener {


  JFrame menu = new JFrame("You Lost");
  JPanel panel = new JPanel();
  JButton play = new JButton("Play");
  JButton  mainMenu = new JButton("Menu");
  JLabel head = new JLabel("You Lost", SwingConstants.CENTER);
  JLabel score = new JLabel(" ", SwingConstants.CENTER);

  public RoundOver(Integer length) {
    mainMenu.setBounds(450, 475, 300, 150);
    mainMenu.addActionListener(this);
    mainMenu.setForeground(Color.black);
    mainMenu.setBackground(Color.lightGray);
    mainMenu.setFocusPainted(false);
    mainMenu.setFont(new Font("impact", Font.PLAIN, 24));

    play.setBounds(450, 300, 300, 150);
    play.addActionListener(this);
    play.setForeground(Color.black);
    play.setBackground(Color.lightGray);
    play.setFocusPainted(false);
    play.setFont(new Font("impact", Font.PLAIN, 24));

    head.setBounds(275, 50, 650, 125);
    head.setBackground(Color.pink);
    head.setFont(new Font("impact", Font.PLAIN, 60));
    head.setForeground(Color.black);
    head.setOpaque(true);

    score.setBounds(275, 175, 650, 100);
    score.setBackground(Color.pink);
    score.setFont(new Font("impact", Font.PLAIN, 60));
    score.setForeground(Color.black);
    score.setOpaque(true);
    StringBuilder full = new StringBuilder();
    full.append("Score: ");
    full.append(length);
    score.setText(full.toString());

    panel.add(play);
    panel.add(mainMenu);
    panel.add(head);
    panel.add(score);
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

  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == play) {
      new roundHandle();
      menu.dispose();
    } else if(e.getSource() == mainMenu){
      new Menu();
      menu.dispose();
    }
  }

}
