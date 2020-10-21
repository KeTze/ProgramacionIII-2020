package prog3.tema01.ejemplos.images_sockets;

import java.awt.image.BufferedImage;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4000);
        Socket socket = serverSocket.accept();

        BufferedImage image = ImageIO.read(ImageIO.createImageInputStream(socket.getInputStream()));

        JFrame frame = new JFrame();
        frame.getContentPane().add(new JLabel(new ImageIcon(image)));
        frame.pack();
        frame.setVisible(true);    
        
        socket.close();
        serverSocket.close();
    }

}