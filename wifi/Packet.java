package wifi;
import java.lang.reflect.*;

public class Packet{
    /*
        Packet Class 
        
        Fields
            Control field : 2 bits
                Frame type: 3 bytes
                Retry: 1 byte
                Sequence Num: 12 bits
            Destination address : 2 bits
            Source Address : 2 bits
            Data : 2038 bits lmao
            CRC : 4 bits
            ByteArray : 2048 array of all bytes

        Constructor
            Packet(Byte[] control, Byte[] dest, Byte[] )
                Parses 2048 bit array into object fields
            
        Methods
            toString()
                returns ByteArray to send on rf layer
            setters and getters for all fields
            
    */
    private byte[] myBytes;
    public Packet(byte[] byteArr){
        this.myBytes = byteArr;
    }
}
    