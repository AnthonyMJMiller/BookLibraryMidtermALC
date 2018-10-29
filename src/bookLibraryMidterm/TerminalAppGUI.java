package bookLibraryMidterm;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TerminalAppGUI extends JFrame {
	private static  JTextArea consoleOut;
	private JTextField textField;
	private PrintWriter pWriter;
	private static String input;

	public TerminalAppGUI() {
		//Output Window Creation
		super("Art Garfunkel's Library Terminal");
		setConsoleOut(new JTextArea(50, 50));
		getConsoleOut().setEditable(false);
		setLayout(new GridBagLayout());
		GridBagConstraints window = new GridBagConstraints();
		window.gridx = 1;
		window.gridy = 1;
		window.gridwidth = 1;
		window.fill = GridBagConstraints.BOTH;
		window.weightx = 11.0;
		window.weighty = 1.0;

		GridBagConstraints textBox = new GridBagConstraints();
	    textBox.gridwidth = GridBagConstraints.REMAINDER;
	    textBox.fill = GridBagConstraints.HORIZONTAL;
	    textBox.fill = GridBagConstraints.BOTH;
	    
		//Output change from Console to Window
		PrintStream consoleStream = new PrintStream(new CustomOutputStream(getConsoleOut()));
		System.setOut(consoleStream);
		System.setErr(consoleStream);
		JScrollPane scrollPane = new JScrollPane(getConsoleOut());
		add(new JScrollPane(getConsoleOut()), window);
		
		//add elements to window
		add(scrollPane, textBox);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 500);
		setLocationRelativeTo(null);	
	}

	public static JTextArea getConsoleOut() {
		return consoleOut;
	}

	public void setConsoleOut(JTextArea consoleOut) {
		this.consoleOut = consoleOut;
	}
}