/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmuseumtable;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DemoBackgroundSwing extends JPanel {

  private Image img;

  public DemoBackgroundSwing() throws MalformedURLException {
    img = Toolkit.getDefaultToolkit().createImage(new URL("http://52.17.122.110/ingegneria.jpg"));
    loadImage(img);
  }

  private void loadImage(Image img) {
    try {
      MediaTracker track = new MediaTracker(this);
      track.addImage(img, 0);
      track.waitForID(0);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  protected void paintComponent(Graphics g) {
    setOpaque(false);
    g.drawImage(img, 10, 10, null);
    super.paintComponent(g);
  }


 
}