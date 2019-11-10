package wifi;
import java.util.*;
import java.util.concurrent.*;
import rf.RF;

public class Sender implements Runnable{
    BlockingQueue<Packet> queue;
    RF ourRF;
    //TODO List<Packet>
    public Sender(BlockingQueue<Packet> theQueue, RF theRF){
        this.queue = theQueue;
    }
    
    public void setRF(RF newRF){
        this.ourRF = newRF;
    }
    //List<Packet> queue = new ArrayList<Packet>();
    public void run()
    {   
        while(true){
            try {
                Packet newPacket = queue.take();
                if(newPacket != null){
                    System.out.println("thinks that new packet is not null");
                    ourRF.transmit(newPacket.getData());
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            try 
            {
                Thread.sleep(1000);
            } 
            catch(InterruptedException e)
            {
                // this part is executed when an exception (in this example InterruptedException) occurs
            }
        }
    }
}