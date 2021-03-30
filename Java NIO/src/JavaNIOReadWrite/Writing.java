package JavaNIOReadWrite;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Writing {
    public static void main(String[] args) {
        try (FileOutputStream file = new FileOutputStream("data.dat");
             FileChannel bin = file.getChannel()) {

            byte[] output = "Hello World!".getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(output);
            int numBytes = bin.write(buffer);
            System.out.println(numBytes + " was written");

            ByteBuffer buffer1 = ByteBuffer.allocate(Integer.BYTES * 2);
            buffer1.putInt(123);
            buffer1.putInt(456);
            buffer1.flip();
            numBytes = bin.write(buffer1);
            System.out.println(numBytes + " was written");
/*

            buffer1.flip();
            buffer1.flip();
            numBytes = bin.write(buffer1);
            System.out.println(numBytes + " was written");
*/





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
