package wifi;
import java.util.*;

public class Sender implements Runnable{
    //TODO List<Packet>
    public Sender()
    
    //List<Packet> queue = new ArrayList<Packet>();
    public void run()
    {
        while(queue.size() > 0){
            System.out.println("Current Packcet: " + queue.get(0));
            try {
                Integer consumedElement = queue.take();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            try 
            {
                Thread.sleep(3000);
            } 
            catch(InterruptedException e)
            {
                // this part is executed when an exception (in this example InterruptedException) occurs
            }
            queue.remove(0);
        }
    }
}