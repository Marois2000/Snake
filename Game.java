import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class Game extends JPanel implements ActionListener{

  final int PANEL_WIDTH = 500;
  final int PANEL_HEIGHT = 500;
  Image backgroundImage;
  Image head;
  Image food;
  Image bodyimage;
  Timer timer;
  int xVelocity = 25;
  int yVelocity = 25;
  int foodx = PANEL_WIDTH / 2;
  int foody = 100;
  int x = PANEL_WIDTH / 2;
  int y = PANEL_HEIGHT / 2;
  int direction = 0;
  ArrayList<int[]> body = new ArrayList<int[]>();
  boolean lose = false ;

  public Game() {

    this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    head = new ImageIcon("head.jpg").getImage();
    food = new ImageIcon("food.jpg").getImage();
    bodyimage = new ImageIcon("body.jpg").getImage();
    backgroundImage = new ImageIcon("background.jpg").getImage();
    timer = new Timer(100, this);
    timer.start();
    int headlocation[] = {x, y};
    body.add(headlocation);
  }

  public void paint(Graphics g) {
    super.paint(g);

    Graphics2D g2d = (Graphics2D)g;
    g2d.drawImage(backgroundImage, 0, 0, null);
    g2d.drawImage(head, x, y, null);
    g2d.drawImage(food, foodx, foody, null);

    int count = 0;
    for(int[] i: body) {
      if (count != 0) {
        g2d.drawImage(bodyimage, i[0], i[1], null);
      }
      count++;
    }

    if(lose) {

    }
  }

  public void foodLocation(){
    int randx = 25 * (int)(Math.floor(Math.random() * (PANEL_WIDTH / 25)));
    int randy = 25 * (int)(Math.floor(Math.random() * (PANEL_HEIGHT / 25)));
    int location[] = {randx, randy};
    for(int i[]: body) {
      if(i[0] == location[0] && i[1] == location[1]) {
        if((body.size() - 1) != ((PANEL_WIDTH/25) * (PANEL_HEIGHT/25))) {
          foodLocation();
        }
      }
    }
    foodx = location[0];
    foody = location[1];
  }


  public void addBody() {
    int last[] = body.get(body.size() - 1);
    int addedlast[] = {last[0] - 25, last[1] - 25};
    body.add(addedlast);

  }

  public void updateBody(int headspot[]) {
    int prevspot[] = headspot;
    int currspot[];

    for(int i = 1; i < body.size(); i++) {
      currspot = body.get(i);
      body.set(i, prevspot);
      prevspot = currspot;
    }
  }

  public void detectHit() {
    int count = 0;
    for(int i[]: body) {
      if(count != 0) {
        if (i[0] == x && i[1] == y) {
          System.out.println("HIT!!!!!!!!");
          timer.stop();
          lose = true;
        }
      }
      count++;
    }

    if(x == PANEL_WIDTH || x < 0 || y == PANEL_HEIGHT || y < 0) {
      timer.stop();
      lose = true;
    }
  }

@Override
  public void actionPerformed(ActionEvent e) {
    switch(direction) {
      case 0:
        x = x + xVelocity;
      break;

      case 2:
        x = x - xVelocity;
      break;

      case 1:
        y = y + yVelocity;
      break;

      case 3:
        y = y - yVelocity;
      break;
    }

    int headspot[] = body.get(0);
    int headupdate[] = {x, y};
    body.set(0, headupdate);
    detectHit();
    updateBody(headspot);


    if(x == foodx && y == foody) {
      foodLocation();
      addBody();
    }


    repaint();
  }


}
