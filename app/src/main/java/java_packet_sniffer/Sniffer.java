package java_packet_sniffer;

public class Sniffer {
    static {System.loadLibrary("packetsniffer");}
    public static native void packetSniffer(int argc, char[][] argv);
}
