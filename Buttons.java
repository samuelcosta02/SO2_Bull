package bull;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Buttons {
	private JButton addButton = new JButton("Add a bull");
	private JButton postureButton = new JButton("Change posture");
	private JButton colourButton = new JButton("Change eye colour");
	private JButton drawFull = new JButton("Draw full bull");
	private JButton drawHead = new JButton("Draw head only");
	private JTextField xCood = new JTextField(5);
	private JTextField yCood = new JTextField(5);
	private JLabel msg = new JLabel("");

	public void addActionListener(ActionListener listener) {
		
		addButton.addActionListener(listener);
		postureButton.addActionListener(listener);
		colourButton.addActionListener(listener);
		drawFull.addActionListener(listener);
		drawHead.addActionListener(listener);

	}
	
	public void addButtonsToAPanel(JFrame frame) {
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(20, 1, 15, 20));
		
		JPanel coodPanel = new JPanel(new FlowLayout());
		coodPanel.add(new JLabel("X: "));
		coodPanel.add(xCood);
		coodPanel.add(new JLabel("Y: "));
		coodPanel.add(yCood);
		
		menu.add(coodPanel);
		menu.add(msg);
		menu.add(addButton);
		menu.add(postureButton);
		menu.add(colourButton);
		menu.add(drawFull);
		menu.add(drawHead);

		menu.setBorder(BorderFactory.createRaisedBevelBorder());
		frame.add(menu, BorderLayout.WEST);
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JButton getPostureButton() {
		return postureButton;
	}

	public JButton getColourButton() {
		return colourButton;
	}

	public JButton getDrawFull() {
		return drawFull;
	}

	public JButton getDrawHead() {
		return drawHead;
	}
	
	public String getXt() {
		return xCood.getText();
	}
	
	public String getYt() {
		return yCood.getText();
	}
	
	public JLabel getMsg() {
		return msg;
	}
}
