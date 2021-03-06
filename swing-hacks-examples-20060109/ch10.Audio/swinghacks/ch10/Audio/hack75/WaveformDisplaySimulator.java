package swinghacks.ch10.Audio.hack75;

import java.awt.BorderLayout;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.JFrame;

public class WaveformDisplaySimulator {

	public static void main(String[] args) {
		try {

			JFrame frame = new JFrame("Waveform Display Simulator");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(200, 200, 500, 350);

			File file = new File(args[0]);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));

			WaveformPanelContainer container = new WaveformPanelContainer();
			container.setAudioToDisplay(audioInputStream);

			frame.getContentPane().setLayout(new BorderLayout());
			frame.getContentPane().add(container, BorderLayout.CENTER);


			frame.setVisible(true);
			frame.validate();
			frame.repaint();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
