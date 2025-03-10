package Baitap1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoadDrawTask implements Runnable{
    public Account acc;
    public int amount;

    public LoadDrawTask(Account acc, int amount) {
        this.acc = acc;
        this.amount = amount;
    }



    @Override
    public void run() {
        try {
            this.acc.loadDraw(amount);
        } catch (InterruptedException ex) {
            Logger.getLogger(WithDrawTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
