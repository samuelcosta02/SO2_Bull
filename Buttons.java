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
	private JButton positionButton = new JButton("Change position");

	public void addActionListener(ActionListener listener) {
		addButton.addActionListener(listener);
		postureButton.addActionListener(listener);
		positionButton.addActionListener(listener);
	}
	public void addButtonsToAPanel(JFrame frame) {
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(18, 1, 15, 20));

		menu.add(addButton);
		menu.add(postureButton);
		menu.add(positionButton);

		menu.setBorder(BorderFactory.createRaisedBevelBorder());
		frame.add(menu, BorderLayout.WEST);
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JButton getPostureButton() {
		return postureButton;
	}

	public JButton getPositionButton() {
		return positionButton;
	}
}
