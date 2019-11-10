package wifi;
import java.io.PrintWriter;
import java.util.*;
import rf.RF;
import java.util.concurrent.*;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args)
    {
        // Create an instance of the RF layer. See documentation for
        // info on parameters, but they're null here since we don't need
        // to override any of its default settings.
        byte[] arr = new byte[2048];
        Arrays.fill(arr, (byte) 1);
        
        RF theRF = new RF(null,null);
        LinkLayer currentLayer;
        try {
            currentLayer = new LinkLayer((short) 123456, new PrintWriter(new File("C:/Users/jrile/Desktop/Software Engineering/325WifiProject/80211_project/wifi/output.txt")));
            currentLayer.setRF(theRF);
            
            BlockingQueue<Packet> packetQueue = new SynchronousQueue<Packet>();
            currentLayer.setPacketQueue(packetQueue);
            
            Sender transmitter = new Sender(packetQueue, currentLayer.getRF());
            Receiver listener = new Receiver();
            System.out.println("finished initializing");
            
            (new Thread(listener)).start();
            (new Thread(transmitter)).start();
            while(true){
               currentLayer.send((short)  123456, arr, 2048);
               try 
               {
                   Thread.sleep(1000);
               } 
               catch(InterruptedException e)
               {
                   // this part is executed when an exception (in this example InterruptedException) occurs
               }
            }
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        //System.exit(0);  // Make sure all threads die
    }
}
