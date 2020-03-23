package pipledemo;

import java.io.IOException;
import java.io.PipedOutputStream;

public class Sender extends  Thread{
    PipedOutputStream pipedOutputStream = new PipedOutputStream();
    public PipedOutputStream getPipedOutputStream(){
        return  pipedOutputStream;
    }

    @Override
    public void run() {
        sendMessage();
    }
    public void sendMessage(){
        String str = "hello world";
        try {
            pipedOutputStream.write(str.getBytes());
            //记得关闭流
            pipedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
