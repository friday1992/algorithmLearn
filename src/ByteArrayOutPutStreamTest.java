import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutPutStreamTest {
    @Test
    public void test(){
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        int a = 0;
        int b = 1;
        int c = 2;
        ba.write(a);
        ba.write(b);
        ba.write(c);
        byte[] bs = ba.toByteArray();
        for(byte s:bs){
            System.out.println(s);
        }

    }
    @Test
    public void test2() throws IOException {
        byte[] bytes = new byte[33];
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        ba.write(bytes);
        byte[] bs = ba.toByteArray();
        System.out.println(bs.length);
        for(byte s:bs){
            System.out.println(s);
        }
        ByteArrayOutputStream ba2 = new ByteArrayOutputStream();
        ba.writeTo(ba2);
        byte[] bs2 = ba2.toByteArray();
        for(byte s:bs2){
            System.out.print(s);
        }
        //清空byte数组
        ba.reset();
        System.out.println("******");
        System.out.println(ba.toByteArray().length);
        ba.write(bytes);
        System.out.println("******");
        System.out.println(ba.toByteArray().length);
    }
}
