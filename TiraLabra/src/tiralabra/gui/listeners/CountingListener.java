package tiralabra.gui.listeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import tiralabra.Benchmark;

/**
 *
 * @author Joel
 */
public class CountingListener implements ItemListener {

    private Benchmark bm;

    public CountingListener(Benchmark bm) {
        this.bm = bm;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == 1) {
            bm.setCounting(true);
        } else {
            bm.setCounting(false);
        }
    }
}
