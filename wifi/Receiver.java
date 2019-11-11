package wifi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import rf.RF;

public class Receiver implements Runnable{
  public void run(){
    CircularByteBuffer bytes = new CircularByteBuffer(-1);
    BufferedReader buffer = new BufferedReader(new InputStreamReader(bytes.getInputStream()));
    RF rf = new RF(new PrintWriter(bytes.getOutputStream(), true), null);
    System.out.println(rf.toString());
    while (true) {
      try {
        Thread.sleep(5000);
      } 
      catch (InterruptedException interruptedException) {}
      try {
        if (reader.ready()) {
          System.out.println(String.valueOf(buffer.readLine()) + "\n");
        }
      } 
      catch (IOException e) {
        {
            System.out.println(e);
        }
      }
    }
  }
}
