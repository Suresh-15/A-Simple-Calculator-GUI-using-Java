package Calculator_App;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class RoundButton extends JButton{
	
	public RoundButton() {
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width,size.height);
		setPreferredSize(size);	setContentAreaFilled(false);
		setFocusPainted(false);	setFocusable(false);
	}
	
	public RoundButton(String label) {
		super(label);
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width,size.height);
		setPreferredSize(size);	setContentAreaFilled(false);
		setFocusPainted(false);	setFocusable(false);
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		g2D.setColor(getBackground());
		if(getModel().isArmed()){
			g2D.setColor(Color.white);
		}
		g2D.fillOval(0, 0, getSize().width-1, getSize().height-1);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		g2D.setColor(getForeground());
		g2D.drawOval(0, 0, getSize().width-2, getSize().height-2);
	}

	Shape shape;
	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		return shape.contains(x, y);
	}
	
	public static void main(String[] args){
		
		JButton button = new RoundButton("<html> <font color=#000000>Hi</font> </html>");
		button.setPreferredSize(new Dimension(60,60));
		button.setBackground(new Color(243,141,51));
		button.setForeground(new Color(255,163,81));
		button.setFocusable(false);
		
		JFrame frame = new JFrame("Round Button");
		frame.setLayout(new FlowLayout());
		frame.setSize(200,200);	frame.add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}