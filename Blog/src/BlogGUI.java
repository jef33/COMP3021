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


public class BlogGUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnPost;
	private JButton btnRefresh;
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
		splitPaneRight.setResizeWeight(0.2);
		splitPaneRight.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPaneRight);
		
		JSplitPane splitPanePost = new JSplitPane();
		splitPanePost.setResizeWeight(0.9);
		splitPanePost.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPaneRight.setLeftComponent(splitPanePost);
		
		textAreaPost = new JTextArea();
		splitPanePost.setLeftComponent(textAreaPost);
		
		JPanel panel = new JPanel();
		splitPanePost.setRightComponent(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		btnRefresh = new JButton("Refresh");
		panel.add(btnRefresh);
		
		btnPost = new JButton("Post");
		btnPost.addActionListener(this);
		panel.add(btnPost);
		
		textPaneDisplay = new JTextPane();
		textPaneDisplay.setEnabled(true);
		textPaneDisplay.setEditable(false);
		textPaneDisplay.setText("This is a sample.");
		splitPaneRight.setRightComponent(textPaneDisplay);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnPost){
			Date d = new Date();
			blog.post(new Post(d, textAreaPost.getText()));
			textPaneDisplay.setText(blog.list());
		}
	}

}
