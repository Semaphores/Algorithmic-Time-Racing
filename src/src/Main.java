package src;

import sort.Sort;

/*
 * The Program provides the user the sorting-times for several 
 * sorting algorithms.
 * A startTime variable begins when the instance of the 
 * class is created.
 * The sorting algorithms are all in threads which start as soon
 * as the instance is created.
 * When the sorting algorithm is done is prints it's time to the console.
 * The first one to finish wins... 
 */
 public class Main{
    RaceEnvironment track;
    int[] ARRAY;
    int ARRAYSIZE;
	
	public Main(int size){
		ARRAY = new int[size];
        ARRAYSIZE = ARRAY.length;
		createArray();
        track = new RaceEnvironment();
	}
	
	private void createArray(){
        // create array of integers with values between 1 and 100
        for (int i : ARRAY){ i = (int) (Math.random() * 100) + 1; }
	}

    /**
     * Used for demonstration purposes
     */
    private void build(){
        track.add(new Racer(() -> { Sort.bubbleSort(ARRAY); }));
        track.add(new Racer(() -> { Sort.insertionSort(ARRAY); }));
        track.add(new Racer(() -> { Sort.selectionSort(ARRAY); }));
        track.add(new Racer(() -> { Sort.quickSort(ARRAY, 0, ARRAYSIZE - 1); }));
    }

	public void printResults(){
		build();
        track.go();
        for (Racer r : track.getCompetitors()){
            System.out.println(r.getName() + " " + r.getRunningTime());
        }
	}

    public static void main(String[] args){
		/* Instance when array is of size: 10,000
		 * When running the instance the the sorting
		 * algorithms from fastest to slowest were
		 * Insertion, Quick, Selection, and Bubble
		 * with Quick sometimes beating Insertion
		 */
        Main smallArray = new Main(10000);
        smallArray.printResults();

		/* Instance when array is of size: 1,000,000
		 * When running the instance the the sorting
		 * algorithms from fastest to slowest were
		 * Quick, Insertion, Selection, and Bubble
		 */
        Main bigArray = new Main(1000000);
        //bigArray.printResults();
    }
}
