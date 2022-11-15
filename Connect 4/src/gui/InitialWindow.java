package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InitialWindow implements ActionListener {
	private JFrame frame;
	private JButton okButton;
	private JLabel label;
	private JTextField depth;
	private JRadioButton noPruning;
	private JRadioButton pruning;
	private Controller controller;

	public InitialWindow(Controller controller) {
		this.controller = controller;

		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(400, 250);
		frame.getContentPane().setLayout(null);

		ButtonGroup group = new ButtonGroup();
		noPruning = new JRadioButton("MinMax without pruning");
		noPruning.setHorizontalAlignment(SwingConstants.CENTER);
		noPruning.setSelected(true);
		noPruning.setBounds(20, 100, 160, 25);

		pruning = new JRadioButton("MinMax with pruning");
		pruning.setHorizontalAlignment(SwingConstants.CENTER);
		pruning.setBounds(213, 100, 150, 25);
		group.add(noPruning);
		group.add(pruning);
		frame.getContentPane().add(noPruning);
		frame.getContentPane().add(pruning);

		depth = new JTextField();
		depth.setHorizontalAlignment(SwingConstants.CENTER);
		depth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		depth.setBounds(140, 30, 120, 40);
		frame.getContentPane().add(depth);

		okButton = new JButton("Play");
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		okButton.setBounds(125, 150, 150, 55);
		okButton.addActionListener(this);
		frame.getContentPane().add(okButton);

		label = new JLabel("Depth");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(40, 30, 90, 40);
		frame.getContentPane().add(label);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			if (pruning.isSelected())
				controller.pruning();
			else
				controller.noPruning();
			try {
				controller.setDepth(Integer.parseInt(depth.getText()));
			} catch (Exception exception) {}
			frame.dispose();
		}
	}
}
