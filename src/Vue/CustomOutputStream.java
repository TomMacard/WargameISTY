package Vue;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomOutputStream extends OutputStream {
    private JTextArea textArea;
    private StringBuilder sb = new StringBuilder();
    private LinkedBlockingQueue<String> queue;

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
    public void flushQueue() {
        StringBuilder fullMessage = new StringBuilder();
        queue.drainTo(Collections.singleton(fullMessage));
        textArea.setText(fullMessage.toString());
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
