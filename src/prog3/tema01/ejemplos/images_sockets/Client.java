package prog3.tema01.ejemplos.images_sockets;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

public class Client {

    public static void main(String [] args)
    {
        try
        {
            Socket socket = new Socket("localhost", 4000);
            BufferedImage image = ImageIO.read(new File("bin/prog3/tema01/ejemplos/images_sockets/coche.png"));
            ImageIO.write(image,"JPG",socket.getOutputStream());
            socket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}