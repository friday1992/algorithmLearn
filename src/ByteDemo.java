import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteDemo {
    byte[] bytes = {1,2,3,4,5};

    @Test
    public void test(){
        int b;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        while ((b = byteArrayInputStream.read())!=-1){
            System.out.print(b);
        }
        System.out.println();
        System.out.println("******************");
        ByteArrayInputStream byteArrayInputStream1 = new ByteArrayInputStream(bytes,1,bytes.length);
        while ((b = byteArrayInputStream1.read())!=-1){
            System.out.print(b);
        }
    }
    @Test
    public void test2(){
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int b;
        byteArrayInputStream.skip(2);
        while ((b=byteArrayInputStream.read())!=-1){
            System.out.print(b);
        }

    }
    @Test
    public void test3(){
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int b;
        //返回可以读的个数
        System.out.print(byteArrayInputStream.available());
        while ((b=byteArrayInputStream.read())!=-1){
            System.out.print(byteArrayInputStream.available());
        }
    }
    @Test
    public void test4() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int b;
        //mark 是否可以标记
        System.out.println(byteArrayInputStream.markSupported());
        System.out.println(byteArrayInputStream.read());
        //mark的参数是无效的，标记位置为pos
        byteArrayInputStream.mark(2);

        //reset() 还原标记为
        byteArrayInputStream.reset();
        while ((b=byteArrayInputStream.read())!=-1){
            System.out.print(b);
        }
        //不要关闭流没有意义，因为数组是存在内存，会自动回收
        byteArrayInputStream.close();
    }

}
