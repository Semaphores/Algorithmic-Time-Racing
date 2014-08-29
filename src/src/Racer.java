package src;

/**
 * Created by Phillip on 8/29/2014.
 */
public class Racer {
    private Algorithmic algo;
    private String name;
    private long runningTime;
    private static int i = 0;
    Racer(Algorithmic algo){
        signup(algo, "Racer-"+i++);
    }

    private String currentRacer() { return name; }

    /**
     *
     * @param algo
     * @param name is assigned by default
     */
    private void signup(Algorithmic algo, String name){
        this.algo = algo;
        this.name = name;
    }

    /**
     *
     * @return name of racer
     */
    public String getName(){ return name; }

    /**
     *
     * @return running time of algorithm
     */
    public long getRunningTime(){ return runningTime; }

    /**
     * utility class for calculations
     * @param startTime
     * @return running time of algorithm
     */
    private Thread calculate(long startTime){
        return new Thread(() -> {
            algo.algorithim();
            long elapsedTime = (long) ((System.nanoTime() - startTime));
            long runTime = elapsedTime/1000;
            runningTime = runTime;
        });
    }

    /**
     * algorithm begins
     * @param startTime parameter variable which will pass on to inner function
     */
    public void start(long startTime){
        Thread t = calculate(startTime);
        t.start();
    }


}
