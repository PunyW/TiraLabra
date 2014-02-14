package tiralabra.gui.listeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import tiralabra.Benchmark;

/**
 *
 * @author Joel
 */
public class HeapListener implements ItemListener {

    private Benchmark bm;

    public HeapListener(Benchmark bm) {
        this.bm = bm;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == 1) {
            bm.setHeap(true);
        } else {
            bm.setHeap(false);
        }
    }

}
