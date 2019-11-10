package wifi;
import java.lang.reflect.*;
import java.io.PrintWriter;
import java.util.*;
import rf.RF;
import java.util.concurrent.*;
import java.util.Arrays;

public class Packet{
    /*
        Packet Class 
        
        Fields
            Control field : 2 bytes
                Frame type: 3 bits
                Retry: 1 bit
                Sequence Num: 12 bits
            Destination address : 2 bytes
            Source Address : 2 bytes
            Data : 2038 bytes lmao
            CRC : 4 bytes
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
    private final int controlFieldIndex = 2;
    private final int frameTypeIndex = 3;       //bit indexes
    private final int retryIndex = 4;
    private final int sequenceNumIndex = 16;    //end bit indexes
    private final int destinationAddressIndex = 4;
    private final int sourceAddress = 6;
    private final int dataIndex = 2044;
    private final int crcIndex = 2048;

    public Packet(Transmittion transmittion){
        //set myBytes equal to transmittion.getBuf()
        //check dest and src address, change if not matching?
        this.myBytes = transmittion.getBuf();
    }

    public Packet(byte[] byteArray){
        this.myBytes = byteArray;
    }

}
    