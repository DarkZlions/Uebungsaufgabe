package gui.layouts;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.Window;
import gui.WindowHandler;

public class HomeWindowLayout extends BaseLayout {
	private String title;
	private JLabel titleLabel;
	private JButton editButton, exitButton;
	private JPanel homePanel;
	
	@Override
	public void init(Window window) {
		/*
		 * Initialize all variables
		 */
		title = "Just Muesli";
		titleLabel = new JLabel(title);
		editButton = new JButton("Edit Customer Details");
		exitButton = new JButton("Exit");	
		homePanel = new JPanel();
		
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		editButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				window.setVisible(false);
				WindowHandler.EDIT_CUSTOMER_DETAILS_WINDOW.setVisible(true);
			}
		});
		
		exitButton.setBounds((window.getWidth() - 70) / 2, 600, 80, 40);
		editButton.setBounds((window.getWidth() - 160) / 2, 400, 160, 50);
		titleLabel.setFont(new Font(Font.SANS_SERIF, 1, 40));
		titleLabel.setBounds(
				(window.getWidth() - 250) / 2, 50,
					250, 400
				);
		
		homePanel.setLayout(null);
		
		//Add the components to the panel
		homePanel.add(titleLabel);
		homePanel.add(editButton);
		homePanel.add(exitButton);
		
		window.add(homePanel);
		
		this.componentList.add(editButton);
		this.componentList.add(exitButton);
		this.componentList.add(titleLabel);
		this.panels.add(homePanel);
	}
}
