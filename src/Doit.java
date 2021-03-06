import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Doit extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	static JTextField txtboc;
	private static Frame bobJFrame;
	static JFrame frame;
  public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
	 String jaf ="";
String jaf2="";
String jaf1="";
	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		FileDialog fd = new FileDialog(bobJFrame, "Choose a .java", FileDialog.LOAD);
		fd.setDirectory("");
		fd.setFile("*.java");
		fd.setFilenameFilter((dir, name) -> name.endsWith(".java"));
		fd.setVisible(true);
	    jaf2 =fd.getDirectory();
		jaf1 = fd.getFile();	 
        if (jaf1 == null) {
        	System.exit(0);
        }
		Thread.sleep(2000);
		
		FileDialog fd2 = new FileDialog(bobJFrame, "Choose a .jar", FileDialog.LOAD);
		fd2.setDirectory("");
		fd2.setFile("*.jar");
		fd2.setFilenameFilter((dir, name) -> name.endsWith(".jar"));
		fd2.setVisible(true);
	    jaf =fd2.getDirectory();
	    if (jaf == null) {
        	System.exit(0);
        }
        File f1 = new File(jaf2+jaf1);
		File f2 = new File(jaf+"Execut.java");
		f1.renameTo(f2);
		
		frame = new JFrame("Customizer");

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
		Doit loen = new Doit(); 
		button.addActionListener(loen); 
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
  public void actionPerformed(ActionEvent e) { 	
	  String s = e.getActionCommand(); 
		if (s.equals("Okay") ) { 
			frame.setVisible(false);
			  Runtime r= Runtime.getRuntime();
				try {
					r.exec(txtboc.getText());
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					r.exec("jar uf AOW.jar Execut.class");
					System.out.println("Done");
					ChickenIsNotFood();
					r.exec("java -jar AOW.jar");
					System.exit(0);
				} catch (IOException ez) {
					ez.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
  }
  public int ChickenIsNotFood() throws Exception {
		return JOptionPane.showConfirmDialog((Component) null, "Done",
				"Done", JOptionPane.CLOSED_OPTION);
  }
}