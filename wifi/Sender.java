package wifi;
import java.util.*;

public class Sender implements Runnable{
    //TODO List<Packet>
    List<Integer> queue = new ArrayList<Integer>();
    public void run()
    {
        while(queue.size() > 0){
            System.out.println("Current Int: " + queue.get(0));
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
    
    //use this to add to the outgoing packet queue which lives in the sender
    public void addToQueue(Integer newInt){
        queue.add(newInt);
    }
}