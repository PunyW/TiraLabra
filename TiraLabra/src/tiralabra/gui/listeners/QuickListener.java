package tiralabra.gui.listeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import tiralabra.Benchmark;

/**
 *
 * @author Joel
 */
public class QuickListener implements ItemListener {

    private Benchmark bm;

    public QuickListener(Benchmark bm) {
        this.bm = bm;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == 1) {
            bm.setQuick(true);
        } else {
            bm.setQuick(false);
        }
    }
}
