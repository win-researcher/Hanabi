package ClassSub;

public class Class306 extends Class249
{
    public static final String PACKET_ID = "CRASH";
    public final String targetClient;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class306(final String s) {
        super("CRASH::" + (s.startsWith("CRASH::") ? s.split("::")[1] : s), Class298.SEND);
        this.targetClient = (s.startsWith("CRASH::") ? s.split("::")[1] : s);
    }
}
