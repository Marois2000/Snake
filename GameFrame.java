import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;

public class GameFrame extends JFrame implements KeyListener{

  Game game;

  public GameFrame(Game gamed){
    game = gamed;

    this.addKeyListener(this);
    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(game);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  @Override
    public void keyTyped(KeyEvent e) {
      switch(e.getKeyChar()) {
        case 'w':
          game.direction = 3;
        break;

        case 'd':
          game.direction = 0;
        break;

        case 's':
          game.direction = 1;
        break;

        case 'a':
          game.direction = 2;
        break;
      }


    }

  @Override
    public void keyPressed(KeyEvent e) {

    }

  @Override
      public void keyReleased(KeyEvent e) {
      }

  public static void main(String[] args) {
    new roundHandle();
  }

}
