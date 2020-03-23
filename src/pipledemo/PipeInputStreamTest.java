package pipledemo;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeInputStreamTest {
    @Test
    public void test() throws IOException {
        Receiver receiver = new Receiver();
        Sender sender = new Sender();
        PipedInputStream in=receiver.getPipe();
        PipedOutputStream out = sender.getPipedOutputStream();
        in.connect(out);
        receiver.start();
        sender.start();


    }
}
