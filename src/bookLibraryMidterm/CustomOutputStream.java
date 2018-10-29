package bookLibraryMidterm;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

public class CustomOutputStream extends OutputStream {
	private JTextArea consoleOut;

	public CustomOutputStream(JTextArea window) {
		this.consoleOut = window;
	}

	@Override
	public void write(int b) throws IOException {
		// redirects data to the text area
        consoleOut.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        consoleOut.setCaretPosition(consoleOut.getDocument().getLength());
	}
}