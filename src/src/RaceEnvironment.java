package src;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Phillip on 8/29/2014.
 */
public class RaceEnvironment {
    /**
     * All Algorithms will be added to Environment for future calculation
     */
    private long startTime;
    private LinkedList<Racer> competitors;

    RaceEnvironment(){
        competitors = new LinkedList<Racer>();
    }

    /**
     * add racer to racing environment
     * @param racer participating in race
     */
    public void add(Racer racer){
        competitors.add(racer);
    }

    /**
     *
     * @param i
     */
    public void remove(int i){
        competitors.remove(i);
    }

    public void go(){
        startTime = System.nanoTime();
        for (Racer competitor : competitors) {
            competitor.start(startTime);
        }
    }

}
