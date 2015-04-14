import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class BlogGUI extends JFrame implements ActionListener{

	private JLabel labelWordCount;
	private JPanel contentPane;
	private JButton btnPost;
	private JTextArea textAreaPost;
	private JTextPane textPaneDisplay;
	
	private Blog blog = new Blog(new User(1, "self", "a@a.com"));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlogGUI frame = new BlogGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BlogGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 2, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.2);
		contentPane.add(splitPane);
		
		JTree tree = new JTree();
		splitPane.setLeftComponent(tree);
		
		JSplitPane splitPaneRight = new JSplitPane();
		splitPaneRight.setResizeWeight(0.4);
		splitPaneRight.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPaneRight);
		
		JSplitPane splitPanePost = new JSplitPane();
		splitPanePost.setResizeWeight(0.9);
		splitPanePost.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPaneRight.setLeftComponent(splitPanePost);
		
		textAreaPost = new JTextArea();
		textAreaPost.setLineWrap(true);
		textAreaPost.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				int len = textAreaPost.getText().length();
				if(len <= 140){
					labelWordCount.setText("You can still input " + (140 - len) + " words.");
					btnPost.setEnabled(true);
				}
				else{
					labelWordCount.setText("Your post length has exceeded 140 wrods limit.");
					btnPost.setEnabled(false);
				}
			}
		});
		splitPanePost.setLeftComponent(textAreaPost);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.8);
		splitPanePost.setRightComponent(splitPane_1);
		
		btnPost = new JButton("Post");
		btnPost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				blog.post(new Post(new Date(), textAreaPost.getText()));
				textPaneDisplay.setText(blog.list());
			}
		});
		splitPane_1.setRightComponent(btnPost);
		
		labelWordCount = new JLabel("You can still input 140 words.");
		splitPane_1.setLeftComponent(labelWordCount);
		
		textPaneDisplay = new JTextPane();
		textPaneDisplay.setEnabled(true);
		textPaneDisplay.setEditable(false);
		textPaneDisplay.setText("This is a sample.");
		splitPaneRight.setRightComponent(textPaneDisplay);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
