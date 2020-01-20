package ClassSub;

public class Class11
{
    public long lastMs;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class11() {
        this.lastMs = 0L;
    }
    
    public boolean isDelayComplete(final long n) {
        return System.currentTimeMillis() - this.lastMs > n;
    }
    
    public long getCurrentMS() {
        return System.nanoTime() / 1000000L;
    }
    
    public void reset() {
        this.lastMs = System.currentTimeMillis();
    }
    
    public long getLastMs() {
        return this.lastMs;
    }
    
    public void setLastMs(final int n) {
        this.lastMs = System.currentTimeMillis() + n;
    }
    
    public boolean hasReached(final long n) {
        return this.getCurrentMS() - this.lastMs >= n;
    }
    
    public boolean isDelayComplete(final float n) {
        return System.currentTimeMillis() - this.lastMs > n;
    }
    
    public boolean isDelayComplete(final Double n) {
        return System.currentTimeMillis() - this.lastMs > n;
    }
}
