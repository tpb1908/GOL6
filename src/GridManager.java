import org.omg.PortableServer.ServantActivatorPOA;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by theo on 20/07/16.
 */
public class GridManager {

    private WindowManager parent;
    private Cell[][] cells;
    private int generation;
    private Random rnd = new Random();
    private final int cores;

    private ExecutorService exec;
    private ArrayList<Future> runningTasks;

    public GridManager(WindowManager parent) {
        this.parent = parent;
        cores = Runtime.getRuntime().availableProcessors();
        runningTasks = new ArrayList<>(cores);
    }

    public void start() {
        generation = 0;
    }

    public void step() {
        final int block = cells.length/cores;
        final int rem = cells.length%cores;
        int sPos = 0;
        int ePos = block + rem;
        for(int i = 0; i < cores; i++) {
            final int s = sPos;
            final int e = ePos;

            runningTasks.add(exec.submit(new Runnable() {
                @Override
                public void run() {
                    for(int i = s; i < e; i++) {
                        for(int j = 0; j < cells[i].length; j++) {
                            //Do update on cell
                        }
                    }
                }
            }));
            sPos = ePos + 1;
            ePos += block;
        }


        generation++;
    }

    public boolean isReady() {
        for(Future f : runningTasks) {
            if(!f.isDone()) return false;
        }
        runningTasks.clear();
        return true;
    }

}
