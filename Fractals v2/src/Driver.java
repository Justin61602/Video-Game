import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener {

	/* Attributes a.k.a. Instance Variables */
	int w = 800, h = 800;

	public void paint(Graphics g) {
		super.paintComponent(g);
		 rings(g, 200, 0, 0);
		//clover(g, 200, 0, 0);
		//square(g, 200, 300, 300);
		
		//g.setColor(Color.BLUE);
		//g.translate(400, 400);
		//snowFlake(g, 266, 0, 0);
	}// end of paint method - put code above for anything dealing with drawing -

	public void clover(Graphics g, int radius, int x, int y) {

		// each method is in charge of drawing 4 circles!
		g.drawOval(x, y, radius, radius);

		// draw the oval to the right of the first one
		g.drawOval(x + radius, y, radius, radius);

		// draw the oval underneath the first one
		g.drawOval(x, y + radius, radius, radius);

		// draw the oval diagonal to the first one
		g.drawOval(x + radius, y + radius, radius, radius);

		// it will then invoke a new method to keep drawing!
		if (radius > 10) {
			clover(g, radius - 10, x + 10, y + 10);
		}

	}

	public void rings(Graphics g, int radius, int x, int y) {
		// each method call draws one part of the fractal
		g.drawOval(x, y, radius, radius);

		if (radius > 2) {
			rings(g, radius - 10, x + 10, y + 10);
		}

	}

	public void square(Graphics g, int len, int x, int y) {
		// each method draws one square using fillRect
		// ONLY DRAW if len is big enough
		// each method then invokes EIGHT copies of itself
		// to draw the smaller squares surrounding itself

		if (len > 2) {
			g.fillRect(x, y, len, len);

		}
		if (len > 2) {
			
			g.setColor(Color.BLUE);
			square(g, len / 3, x - len, y - len);
			g.setColor(Color.LIGHT_GRAY);
			square(g, len / 3, x + len * 2 - len / 3, y + len * 2 - len / 3);

			
			g.setColor(Color.GREEN);
			square(g, len / 3, x + len / 2 - len / 6, y - len);
			g.setColor(Color.MAGENTA);
			square(g, len / 3, x - len, y + len / 2 - len / 6);

			
			g.setColor(Color.RED);
			square(g, len / 3, x + len * 2 - len / 3, y - len);
			g.setColor(Color.PINK);
			square(g, len / 3, x - len, y + len * 2 - len / 3);

			
			g.setColor(Color.YELLOW);
			square(g, len / 3, x + len * 2 - len / 3, y + len / 2 - len / 6);
			g.setColor(Color.ORANGE);
			square(g, len / 3, x + len / 2 - len / 6, y + len * 2 - len / 3);

		}
	}

	private void snowFlake(Graphics g, int length, int x, int y){
		// TODO Auto-generated method stub
		if(length > 2){
			
			g.drawLine(x, y, x+length, y);
			g.drawLine(x, y, x-length, y);
			
			g.drawLine(x, y, x+length/2, y+length);
			g.drawLine(x, y, x-length/2, y+length);
		
			g.drawLine(x, y, x+length/2, y-length);
			g.drawLine(x, y, x-length/2, y-length);
			
		}
		if(length > 2){
			
		}
	}	
	/**
	 * Update the positions of the ball and paddle. Update the scores, counter
	 * and time
	 */
	public void update() {

	}// end of update method - put code above for any updates on variable

	// ==================code above ===========================

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	/* Instantiate any attributes here (instance variables */
	public Driver() {

		JFrame f = new JFrame();
		f.setTitle("Pong");
		f.setSize(w, h);
		f.setBackground(Color.BLACK);
		f.setResizable(false);

		f.add(this);
		t = new Timer(17, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	Timer t;

}
