import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;

public class Doit {
	static JTextField txtboc;
  public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
	 String jaf ="";
	 String jaf5="";
	  try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
			| UnsupportedLookAndFeelException e1) {
		e1.printStackTrace();
	}
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Select a .java file"); 
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			jaf = selectedFile.getAbsolutePath().toString();
		}
		
		Thread.sleep(2000);

		JFileChooser jfc2 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc2.setDialogTitle("Select your AOW.jar file"); 
		int returnValue2 = jfc2.showOpenDialog(null);
		if (returnValue2 == JFileChooser.APPROVE_OPTION) {
			File selectedPath = jfc2.getSelectedFile();
			jaf5 = selectedPath.getAbsolutePath().toString();
		}
   
   
		StringBuilder jaf2 = new StringBuilder(jaf5) ;
		String jaf3 = jaf2.reverse().toString();
		jaf3 = jaf3.substring(jaf3.indexOf("/"));
		StringBuilder jaf4 = new StringBuilder(jaf3);
		jaf4 = jaf4.reverse();
		jaf3 = jaf4.toString();
        File f1 = new File(jaf);
		File f2 = new File(jaf3+"Execut.java");
		f1.renameTo(f2);
		
		JFrame frame = new JFrame("Customizer");

		txtboc = new JTextField("javac Execut.java");  
		JLabel lblLabel = new JLabel("Enter your command to compile (if you don't know, leave it as it is)");
		JLabel lblLabel2 = new JLabel("Several .java files (soundfx,...) ie javac Execut.java Soundfx.java");

		final URI uri = new URI("https://github.com/frychicken/AvoidingObstacles/tree/master/src");
		JButton button2 = new JButton();
		button2.setText("important dependencies: Soundfx, Frychicken");
		button2.setHorizontalAlignment(SwingConstants.LEFT);
		button2.setBorderPainted(false);
		button2.setOpaque(false);
		button2.setForeground(Color.CYAN);
		button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button2.setToolTipText("Go to website");
		HashMap<TextAttribute, Object> textAttrMap = new HashMap<TextAttribute, Object>();
		textAttrMap.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		button2.setFont(button2.getFont().deriveFont(Font.BOLD | Font.ITALIC));
		button2.setFont(button2.getFont().deriveFont(textAttrMap));
		button2.setBackground(Color.lightGray);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					try {
						desktop.browse(uri);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		
		final URI uri2 = new URI("https://github.com/frychicken/art-IF-icial-Intelligence/blob/master/README.md");
		JButton button3 = new JButton();
		button3.setText("help");
		button3.setHorizontalAlignment(SwingConstants.LEFT);
		button3.setBorderPainted(false);
		button3.setOpaque(false);
		button3.setForeground(Color.BLUE);
		button3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button3.setToolTipText("? - Display help");
		HashMap<TextAttribute, Object> textAttrMap2 = new HashMap<TextAttribute, Object>();
		textAttrMap2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		button3.setFont(button3.getFont().deriveFont(Font.BOLD | Font.ITALIC));
		button3.setFont(button3.getFont().deriveFont(textAttrMap2));
		button3.setBackground(Color.lightGray);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					try {
						desktop.browse(uri2);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		
		JButton  button = new JButton("Okay"); 
		JPanel panel = new JPanel(); 
		panel.add(lblLabel);
		panel.add(txtboc);
		panel.add(lblLabel2);
		panel.add(button2);
		panel.add(button3);
		panel.add(button);
		frame.add(panel);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300); 
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);       

		
  }
  public void actionPerformed(ActionEvent e) throws InterruptedException { 	
	  String s = e.getActionCommand(); 
		if (s.equals("Okay") ) { 
			  Runtime r= Runtime.getRuntime();
				try {
					r.exec(txtboc.getText());
					Thread.sleep(3000);
					r.exec("jar uf AOW.jar Execut.class");
					System.out.println("Done");
				} catch (IOException ez) {
					ez.printStackTrace();
				}
		}
  }
}
