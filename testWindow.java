package testing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class testWindow {
	


	public testWindow(String currPrice) {
		JFrame frame = new JFrame();
		
		JButton button = new JButton("Current Price");
		
		JTextArea textArea = new JTextArea("Some text\nSome other text");
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(100, 300, 100, 300));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(button);
		
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("web scraper");
		frame.pack();
		frame.setVisible(true);
		
		
		
		panel.add(textArea);
	    textArea.setBounds(50, 50, 150, 150);
	}


	
		
	}

		

