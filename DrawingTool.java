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
			if (!buttons.getXt().isBlank() && !buttons.getYt().isBlank()) {
				try {
					int x = Integer.parseInt(buttons.getXt());
					int y = Integer.parseInt(buttons.getYt());
					if (x <= screenSize.width && y <= screenSize.height) {
						tidyUpDrawingArea();
						if (!drawing.getScene().addBull(Color.BLACK, RandomNumber.between(50, 200), RandomNumber.between(50, 200), x, y)) {
							buttons.getMsg().setText("Bull overlap");
						} else {
							buttons.getMsg().setText("Success");
						}
					} else {
						buttons.getMsg().setText("Offscreen");
					}
				} catch (NumberFormatException nfe) {
					buttons.getMsg().setText("Invalid");
				}
			} else {
				buttons.getMsg().setText("Empty field");
			}
		} else if (e.getSource() == buttons.getPostureButton()) {
			tidyUpDrawingArea();
			drawing.getScene().postureButton();
		} else if (e.getSource() == buttons.getColourButton()) {
			tidyUpDrawingArea();
			drawing.getScene().eyeColorButton();
		} else if (e.getSource() == buttons.getDrawFull()) {
			tidyUpDrawingArea();
			drawing.getScene().fullState();
		} else if (e.getSource() == buttons.getDrawHead()) {
			tidyUpDrawingArea();
			drawing.getScene().headState();
		} else if (e.getSource() == buttons.getGreenBg()) {
			tidyUpDrawingArea();
			drawing.getScene().greenState();
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
