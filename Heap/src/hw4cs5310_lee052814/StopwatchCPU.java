package hw4cs5310_lee052814;

import java.lang.management.ThreadMXBean;
import java.lang.management.ManagementFactory;

public class StopwatchCPU {
    private final ThreadMXBean threadTimer;
    private final long start;
    private static final double NANOSECONDS_PER_SECOND = 1000000000;
            
    /**
     * Initialize a stopwatch object.
     */
    public StopwatchCPU() {  
        threadTimer = ManagementFactory.getThreadMXBean();
        start = threadTimer.getCurrentThreadCpuTime();
    }   
        
    /**
     * Returns the elapsed CPU time (in seconds) since the object was created.
     */
    public double elapsedTime() {
        long now = threadTimer.getCurrentThreadCpuTime();
        return (now - start) / NANOSECONDS_PER_SECOND;
    }   
}
