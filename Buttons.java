package bull;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Buttons {
	private JButton addButton = new JButton("Add a bull");
	private JButton postureButton = new JButton("Change posture");
	private JButton colourButton = new JButton("Change eye colour");

	public void addActionListener(ActionListener listener) {
		addButton.addActionListener(listener);
		postureButton.addActionListener(listener);
		colourButton.addActionListener(listener);
	}
	public void addButtonsToAPanel(JFrame frame) {
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(18, 1, 15, 20));

		menu.add(addButton);
		menu.add(postureButton);
		menu.add(colourButton);

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
}
