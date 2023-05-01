import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;

public class roundHandle implements ActionListener{

  Timer timer;
  Game game = new Game();
  GameFrame frame;

  public roundHandle() {

    timer = new Timer(100, this);
    timer.start();
    frame = new GameFrame(game);
  }



@Override
  public void actionPerformed(ActionEvent e) {
    if(game.lose) {
      frame.dispose();
      new RoundOver(game.body.size());
      timer.stop();
    }
  }

}
