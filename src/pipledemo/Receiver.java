package pipledemo;

import java.io.PipedInputStream;

public class Receiver extends Thread{
    PipedInputStream pipe = new PipedInputStream();
    public PipedInputStream getPipe(){
        return  pipe;
    }
    @Override
    public void run() {
       receiveMessage();
    }
    public void receiveMessage(){
        try{
            byte[] b = new byte[5];
            int len = pipe.read(b);
            System.out.println(new String(b,0,len));
            pipe.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
