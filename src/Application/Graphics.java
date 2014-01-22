package Application;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Graphics {
	
	JFrame jframe;
	JButton save;
	JButton load;
	JLabel content;
	
	public Graphics() {
		generateGUI();
	}

	private void generateGUI() {
		jframe = new JFrame();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(800, 600);
		jframe.setTitle("Finance Manager");
		
		content = new JLabel();
		content.setLayout(new BorderLayout());
		
		save = new JButton("Save");
		load = new JButton("Load");
		
		content.add(load, BorderLayout.PAGE_START);
		content.add(save, BorderLayout.AFTER_LAST_LINE);
	
		jframe.setContentPane(content);
		jframe.setVisible(true);
		
	}
}
