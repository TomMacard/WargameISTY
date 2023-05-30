package Vue;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    private JTextArea textArea;
    private StringBuilder sb = new StringBuilder();

    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public synchronized void write(int b) throws IOException {
        if (b == '\n') {
            textArea.setText(sb.toString());
            sb.setLength(0);
        } else {
            sb.append((char)b);
        }
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
