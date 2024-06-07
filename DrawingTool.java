/**
 * Provides a test application window with a panel "DrawingArea" and some "Buttons".
 * 
 * @author Björn Gottfried
 * @version 2.0
 */

package bull;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class DrawingTool extends JFrame implements ActionListener {
	private DrawingArea drawing;
	private Buttons buttons = new Buttons();
	private Dimension screenSize;

	public DrawingTool(String title) {
		super(title);
		
		setLayout(new BorderLayout());

		constructButtonMenu();
		constructDrawingArea();

		screenSize = getToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);

		setVisible(true);
	}
	
	private void constructButtonMenu() {
		buttons.addButtonsToAPanel(this);
		buttons.addActionListener(this);
	}

	private void constructDrawingArea() {
		drawing = new DrawingArea();
		add(drawing, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttons.getAddButton()) {
			tidyUpDrawingArea();
			drawing.getScene().addBull(Color.BLACK, RandomNumber.between(10, 500), RandomNumber.between(10, 500), RandomNumber.between(100,screenSize.width), RandomNumber.between(100,screenSize.height));
		} else if (e.getSource() == buttons.getPostureButton()) {
			tidyUpDrawingArea();
			drawing.getScene().postureButton();
		} else if (e.getSource() == buttons.getColourButton()) {
			tidyUpDrawingArea();
			drawing.getScene().eyeColorButton();
		}
	}

	private void tidyUpDrawingArea() {
		drawing.removeAll();
		drawing.revalidate();
		drawing.repaint();		
	}
	
	public static void main(String[] args) {
		new DrawingTool("Draw a bull");
	}
}
