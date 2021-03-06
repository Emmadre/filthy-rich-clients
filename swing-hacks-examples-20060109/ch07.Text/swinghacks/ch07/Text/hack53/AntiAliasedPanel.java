package swinghacks.ch07.Text.hack53;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

import swinghacks.ch01.JComponents.hack11.FullRepaintManager;

public class AntiAliasedPanel extends JPanel {

	public void paintChildren(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paintChildren(g2);
	}

	public static void main(String[] args) {
		RepaintManager.setCurrentManager(new FullRepaintManager());
		JPanel panel = new AntiAliasedPanel();
		JFrame frame = new JFrame("Hack 100: Anti-Aliased text");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);

		JLabel label = new JLabel("This is anti-aliased text");
		label.setFont(label.getFont().deriveFont(40f));
		panel.add(label);

		frame.pack();
		frame.setVisible(true);
	}
}
