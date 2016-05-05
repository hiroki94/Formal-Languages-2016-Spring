/* 
 * Project Milestone 2 (Final)
 * 
 * Author: Hiroki Hayashi
 * 
 * Created: 05/04/16
 * 
 * Class: CMPT 440 - Formal Languages
 * Professor: Pablo Rivas-Perea
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;

public class ProjectFrame2 extends JFrame {
	
	//First we declare all the variables in the text editor window
	private JPanel contentPane;
	private final JTextArea textArea = new JTextArea();
	private final JScrollPane scrollPane = new JScrollPane();
	private final DFA myDFA = new DFA(); //creates a new DFA
	private final JLabel lblStatus = new JLabel("Line: 1 Column: 0");
	private final JButton btnClear = new JButton("Clear");
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenu mnEdit = new JMenu("Edit");
	private final JMenu mnHelp = new JMenu("Help");
	private final JMenuItem mntmNew = new JMenuItem("New");
	private final JMenuItem mntmSave = new JMenuItem("Save");
	private final JMenuItem mntmSaveAs = new JMenuItem("Save As...");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JMenuItem mntmOpenFile = new JMenuItem("Open File...");
	private final JMenuItem mntmHelp = new JMenuItem("Help...");
	private String filename = null;  // set by "Open" or "Save As"
	private int count;
	private final JMenuItem mntmBackgroundColor = new JMenuItem("Change colors");

	/*
	 * The main method launches the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectFrame2 frame = new ProjectFrame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * In the constructor, we have jbInit, which creates the frame
	 */
	public ProjectFrame2() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Hiroki's Text Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 365);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnFile);
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmNew_actionPerformed(arg0);
			}
		});
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		
		mnFile.add(mntmNew);
		mntmOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmOpenFile_actionPerformed(arg0);
			}
		});
		
		mnFile.add(mntmOpenFile);
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmSave_actionPerformed(arg0);
			}
		});
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		
		mnFile.add(mntmSave);
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmSaveAs_actionPerformed(arg0);
			}
		});
		
		mnFile.add(mntmSaveAs);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmExit_actionPerformed(arg0);
			}
		});
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
		
		mnFile.add(mntmExit);
		
		menuBar.add(mnEdit);
		mntmBackgroundColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmBackgroundColor_actionPerformed(arg0);
			}
		});
		
		mnEdit.add(mntmBackgroundColor);
		
		menuBar.add(mnHelp);
		
		mnHelp.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		scrollPane.setBounds(10, 11, 414, 239);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		contentPane.setLayout(null);
		
		contentPane.add(scrollPane);
		textArea.setBackground(Color.WHITE);
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				do_textArea_keyReleased(arg0);
			}
		});
		scrollPane.setViewportView(textArea);

		// CaretListener() is crucial to this project as it keeps track of the cursor.
		textArea.addCaretListener(new CaretListener() {
			//caretUpdate() function allows users to know
            public void caretUpdate(CaretEvent e) {
                JTextArea editArea = (JTextArea)e.getSource();
                int linenum = 1;
                int columnnum = 0;

                try {
                    int caretpos = editArea.getCaretPosition(); //finds caret position
                    
                    //getLineOfOffset did not work in textPane, forcing me to use textArea
                    linenum = editArea.getLineOfOffset(caretpos); 
                    // Subtracting the offset of where the line starts from the overall caret position gives us the column number
                    columnnum = caretpos - editArea.getLineStartOffset(linenum);

                    linenum += 1; // Line numbers start at 1, so we have to add 1
                }
                catch(Exception ex) { } // catch not implemented due to JOptionPane errors (ironic?) and... time constraints
                
                updateStatus(linenum, columnnum); // calls updateStatus function to update label
            }
        });
		lblStatus.setBounds(10, 288, 135, 14);
		
		
		contentPane.add(lblStatus);
		btnClear.setBounds(167, 268, 89, 23);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClear_actionPerformed(arg0);
			}
		});
		
		contentPane.add(btnClear);
	}
	
	// Updates status label (bottom left corner of window) to show correct line & column number
	private void updateStatus(int linenumber, int columnnumber) {
        lblStatus.setText("Line: " + linenumber + " Column: " + columnnumber);
        count = linenumber;
    }
	
	// Loads file (provided user saved a file)
	private void loadFile() {
	    JFileChooser jFC = new JFileChooser();
	    String name = null;
	    if (jFC.showOpenDialog(null) != JFileChooser.CANCEL_OPTION)
	    	name = jFC.getSelectedFile().getAbsolutePath(); // Takes in the name of the file into variable "name"
	    else
	    	return;  // User pressed Cancel
	    try {
	    	Scanner in = new Scanner(new File(name)); 
	    	filename = name;
	    	textArea.setText("");
	    	while (in.hasNext())
	    		textArea.append(in.nextLine() + "\n"); // Prints out all the contents of the file into our text editor
	    	in.close();
	    }
	    catch (FileNotFoundException e) {
	    	JOptionPane.showMessageDialog(null, "File not found: " + name, "Error", JOptionPane.ERROR_MESSAGE);
	    } // Error message when the file specified was not found.
	}
	
	// Saves the file locally (woot!)
	private void saveFile(String name) {
	    if (name == null) {  // get filename from user
	      JFileChooser fc = new JFileChooser();
	      if (fc.showSaveDialog(null) != JFileChooser.CANCEL_OPTION)
	        name = fc.getSelectedFile().getAbsolutePath();
	    }
	    
	    if (name != null) {  // else user cancelled
	      try {
	        Formatter out = new Formatter(new File(name));  // might fail
	        filename = name;
	        out.format("%s", textArea.getText());
	        out.close();
	        JOptionPane.showMessageDialog(null, "Saved to " + filename, "Save File", JOptionPane.PLAIN_MESSAGE);
	      }
	      catch (FileNotFoundException e) {
	        JOptionPane.showMessageDialog(null, "Cannot write to file: " + name, "Error", JOptionPane.ERROR_MESSAGE);
	      }
	    }
	}
	
	// Every time a key is released, this function runs
	protected void do_textArea_keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode(); // e is the event of the key being released.
		String[] lines = textArea.getText().split("\n");
		
		// Although inefficient, this prints out every key that was pressed on console.
		switch (keyCode) {
			case KeyEvent.VK_A:	System.out.println("Key Pressed: a");
								break;
			case KeyEvent.VK_B: System.out.println("Key Pressed: b");
								break;
			case KeyEvent.VK_C: System.out.println("Key Pressed: c");
								break;
			case KeyEvent.VK_D: System.out.println("Key Pressed: d");
								break;
			case KeyEvent.VK_E: System.out.println("Key Pressed: e");
								break;
			case KeyEvent.VK_F: System.out.println("Key Pressed: f");
								break;
			case KeyEvent.VK_G: System.out.println("Key Pressed: g");
								break;
			case KeyEvent.VK_H: System.out.println("Key Pressed: h");
								break;
			case KeyEvent.VK_I: System.out.println("Key Pressed: i");
								break;
			case KeyEvent.VK_J: System.out.println("Key Pressed: j");
								break;
			case KeyEvent.VK_K: System.out.println("Key Pressed: k");
								break;
			case KeyEvent.VK_L: System.out.println("Key Pressed: l");
								break;
			case KeyEvent.VK_M: System.out.println("Key Pressed: m");
								break;
			case KeyEvent.VK_N: System.out.println("Key Pressed: n");
								break;
			case KeyEvent.VK_O: System.out.println("Key Pressed: o");
								break;
			case KeyEvent.VK_P: System.out.println("Key Pressed: p");
								break;
			case KeyEvent.VK_Q: System.out.println("Key Pressed: q");
								break;
			case KeyEvent.VK_R: System.out.println("Key Pressed: r");
								break;
			case KeyEvent.VK_S: System.out.println("Key Pressed: s");
								break;
			case KeyEvent.VK_T: System.out.println("Key Pressed: t");
								break;
			case KeyEvent.VK_U: System.out.println("Key Pressed: u");
								break;
			case KeyEvent.VK_V: System.out.println("Key Pressed: v");
								break;
			case KeyEvent.VK_W: System.out.println("Key Pressed: w");
								break;
			case KeyEvent.VK_X: System.out.println("Key Pressed: x");
								break;
			case KeyEvent.VK_Y: System.out.println("Key Pressed: y");
								break;
			case KeyEvent.VK_Z: System.out.println("Key Pressed: z");
								break;
			case KeyEvent.VK_0: System.out.println("Key Pressed: 0");
								break;
			case KeyEvent.VK_1: System.out.println("Key Pressed: 1");
								break;
			case KeyEvent.VK_2: System.out.println("Key Pressed: 2");
								break;
			case KeyEvent.VK_3: System.out.println("Key Pressed: 3");
								break;
			case KeyEvent.VK_4: System.out.println("Key Pressed: 4");
								break;
			case KeyEvent.VK_5: System.out.println("Key Pressed: 5");
								break;
			case KeyEvent.VK_6: System.out.println("Key Pressed: 6");
								break;
			case KeyEvent.VK_7: System.out.println("Key Pressed: 7");
								break;
			case KeyEvent.VK_8: System.out.println("Key Pressed: 8");
								break;
			case KeyEvent.VK_9: System.out.println("Key Pressed: 9");
								break;
			case KeyEvent.VK_LEFT_PARENTHESIS: 	System.out.println("Key Pressed: Left Parenthesis");
								break;
			case KeyEvent.VK_RIGHT_PARENTHESIS: System.out.println("Key Pressed: Right Parenthesis");
								break;
			case KeyEvent.VK_QUOTEDBL: System.out.println("Key Pressed: Double Quote");
								break;
			case KeyEvent.VK_QUOTE: System.out.println("Key Pressed: Quote");
								break;
			case KeyEvent.VK_PLUS: 	System.out.println("Key Pressed: Plus");
								break;
			case KeyEvent.VK_MINUS: System.out.println("Key Pressed: Minus");
								break;
			case KeyEvent.VK_SPACE: System.out.println("Key Pressed: Space");
								break;
			case KeyEvent.VK_EQUALS: 	System.out.println("Key Pressed: Equals");
								break;
			case KeyEvent.VK_ASTERISK: 	System.out.println("Key Pressed: Asterisk");
								break;
			case KeyEvent.VK_ENTER: System.out.println("Key Pressed: Enter");
								break;
			case KeyEvent.VK_BACK_SPACE: System.out.println("Key Pressed: Backspace");
								break;
			case KeyEvent.VK_SHIFT:
								break;
			case KeyEvent.VK_TAB: System.out.println("Key Pressed: Tab");
								break;
			default: System.out.println("Error: Unknown Key Pressed");
								break;
		}
	    
		
		/* 
		 * The nested if statements below are what runs the whole program. This means that each
		 * time the user presses a key, this whole function from the DFA class runs (Big-O of ouch).
		 * 
		 * Outside if:
		 * We want different font colors when our background is different colored
		 * i.e Lighter colors with black background and darker colors with white background
		 * 
		 * Middle if:
		 * If the text editor has nothing typed in it, or if the user had just pressed tab or enter,
		 * we set the current state to 0, and print it out on the console.
		 * If the user pressed shift, we don't want anything to happen so we just print nothing on the console.
		 * Otherwise, go to Inner if.
		 * 
		 * Inner if:
		 * This is where the checker() function from the DFA class goes through the states and processes the string.
		 * Since checker() returns a different color depending on the state we're in, we can set the foreground
		 * color accordingly (yay!).
		 * 
		 * At the end of this process, the current state is printed out to the console.
		 */
		
		// Outside if
		if (textArea.getBackground() == Color.WHITE){
			// Middle if
			if (textArea.getText().isEmpty() == true || keyCode == KeyEvent.VK_TAB || keyCode == KeyEvent.VK_ENTER){
				myDFA.setCurrentState(0);
				System.out.println("Current State: q" + myDFA.getCurrentState());
			} else if (keyCode == KeyEvent.VK_SHIFT){
				System.out.print("");
			} else {
				// Inner if
				if (myDFA.checker(lines[count-1]) == "green"){
					textArea.setForeground(Color.GREEN);
				} else if (myDFA.checker(lines[count-1]) == "orange"){
					textArea.setForeground(Color.ORANGE);
				} else if (myDFA.checker(lines[count-1]) == "red"){
					textArea.setForeground(Color.RED);
				} else if (myDFA.checker(lines[count-1]) == "blue"){
					textArea.setForeground(Color.BLUE);
				} else {
					textArea.setForeground(Color.BLACK);
				}
				
				System.out.println("Current State: q" + myDFA.getCurrentState());
			}
		} else {
			// Middle if
			if (textArea.getText().isEmpty() == true || keyCode == KeyEvent.VK_TAB){
				myDFA.setCurrentState(0);
				System.out.println("Current State: q" + myDFA.getCurrentState());
			} else if (keyCode == KeyEvent.VK_ENTER) {
				myDFA.setCurrentState(0);
				System.out.println("Current State: q" + myDFA.getCurrentState());
			} else if (keyCode == KeyEvent.VK_BACK_SPACE) {
				
			} else if (keyCode == KeyEvent.VK_SHIFT){
				System.out.print("");
			} else {
				// Inner if
				if (myDFA.checker(lines[count-1]) == "green"){
					textArea.setForeground(Color.GREEN);
				} else if (myDFA.checker(lines[count-1]) == "orange"){
					textArea.setForeground(Color.ORANGE);
				} else if (myDFA.checker(lines[count-1]) == "red"){
					textArea.setForeground(Color.RED);
				} else if (myDFA.checker(lines[count-1]) == "blue"){
					textArea.setForeground(Color.BLUE);
				} else {
					textArea.setForeground(Color.WHITE);
				}
				
				System.out.println("Current State: q" + myDFA.getCurrentState());
			}
		}
	}
	
	protected void do_btnClear_actionPerformed(ActionEvent arg0) {
		textArea.setText("");
	}
	protected void do_mntmExit_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
	protected void do_mntmNew_actionPerformed(ActionEvent arg0) {
		textArea.setText("");
	}
	protected void do_mntmOpenFile_actionPerformed(ActionEvent arg0) {
		loadFile();
	}
	protected void do_mntmSave_actionPerformed(ActionEvent arg0) {
		saveFile(filename);
	}
	protected void do_mntmSaveAs_actionPerformed(ActionEvent arg0) {
		saveFile(null);
	}
	protected void do_mntmBackgroundColor_actionPerformed(ActionEvent arg0) {
		if(textArea.getBackground() == Color.BLACK){
			textArea.setBackground(Color.WHITE);
			textArea.setForeground(Color.BLACK);
		} else {
			textArea.setBackground(Color.BLACK);
			textArea.setForeground(Color.WHITE);
		}
	}
}
