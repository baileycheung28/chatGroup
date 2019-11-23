package chatty;
import java.awt.*; 
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;

public class ChatScreen extends JFrame implements ActionListener{
	private String userName; 
	private int w = 400;
	private int h = 400; 

	private JFrame frame; 
	private JPanel chatPanel; 
	
	private JLabel userLabel;
	private Border border;

	private JPanel displayPanel; 
	private JTextArea displayText;
	
	private JPanel sendMessagePanel;
	private JButton sendButton;
	private JTextArea textArea;	
		
	public ChatScreen(String un) {
		userName = un; 
	}
	
	public String getUserName() {
		return userName; 
	}
	
	public void setUpGUI() {	
		userLabel = new JLabel();
		userLabel.setText("Username: " + userName); 
		userLabel.setBackground(Color.lightGray);
		border = BorderFactory.createLineBorder(Color.BLACK);
		userLabel.setBorder(border);
		userLabel.setPreferredSize(new Dimension(w, 20));		
				
		displayPanel = new JPanel();
		displayPanel.setSize(new Dimension(w,300));
		
		displayText = new JTextArea(); 
		displayPanel.setLayout(new BorderLayout()); 
		displayText.setBackground(Color.PINK); 
		displayText.setEditable(false);
		displayPanel.add(new JScrollPane(displayText), BorderLayout.CENTER); 
		
		textArea = new JTextArea(); 
		textArea.setBackground(Color.WHITE);
		textArea.setLineWrap(true);
				
		sendButton = new JButton("Send Message");
		sendButton.setBackground(Color.BLUE); 
		sendButton.addActionListener(this);
		
		sendMessagePanel = new JPanel();
		sendMessagePanel.add(textArea);
		sendMessagePanel.add(sendButton); 

		chatPanel = new JPanel(new BorderLayout()); 
		chatPanel.setSize(w, h);
		chatPanel.add(userLabel, BorderLayout.PAGE_START); 
		
		chatPanel.add(displayPanel, BorderLayout.CENTER);
		chatPanel.add(sendMessagePanel, BorderLayout.PAGE_END);
		frame = new JFrame("Group Chat App"); 	
		frame.setSize(new Dimension(w, h));
		frame.add(chatPanel); 
		frame.setVisible(true);
	}
	
	//cannot figure out how to add action listener to button to update for other user 
	public void anotherUser(ChatScreen anotherUser) {
		sendButton.addActionListener(anotherUser);
	}
	
	public void actionPerformed(ActionEvent e) {
		displayMessage(sendButtonPressed(), this.userName); 
	}
		
	public String sendButtonPressed() {
		String currentMessage = this.textArea.getText().trim();
		return currentMessage; 
	}

	public void displayMessage(String message, String user) {
		displayText.append(user + ": "); 
		displayText.append(message + "\n"); 
		textArea.setText("");
		sendMessagePanel.add(textArea);
		
		chatPanel.add(displayPanel, BorderLayout.CENTER);
		chatPanel.add(sendMessagePanel, BorderLayout.PAGE_END);
		frame.setContentPane(chatPanel);
	}
}
