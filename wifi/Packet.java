package wifi;
import java.lang.reflect.*;

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
    public boolean isRetry;
    public String controlField;

    public Packet(Transmittion transmittion){
        //set myBytes equal to transmittion.getBuf()
        //check dest and src address, change if not matching?
        this.myBytes = transmittion.getBuf();
    }

    public Packet(byte[] byteArray){
        this.myBytes = byteArray;
    }

    public byte[] getData(){
        return this.myBytes;
    }

    public byte[] getControlField(){
        byte[] controlField = new byte[controlFieldIndex];
        for(int i = 0; i < controlFieldIndex; i++){
            controlField[i] = myBytes[i];
        }
        return controlField;
    }

    public String getFrameType(){
        byte[] frameType = {getControlField()[0]};
        String frameString = byteToString(frameType).substring(0,frameTypeIndex);
        return frameString;
    }

    public 
=
    public String byteToString(byte[] bytes) {
        char[] bits = new char[8 * bytes.length];
        for(int i = 0; i < bytes.length; i++){
            byte byteval = b[i];
            int bytei = i << 3;
            int mask = 0x1;
            for(int j = 7; j >= 0; j--){
                int bitval = byteval & mask;
                if(bitval == 0) {
                    bits[bytei + j] = '0';
                } else {
                    bits[bytei + j] = '1';
                }
                mask <<= 1;
            }
        }
        return String.valueOf(bits);
    }
}
    