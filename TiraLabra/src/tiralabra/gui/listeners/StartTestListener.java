package tiralabra.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tiralabra.Benchmark;

/**
 *
 * @author Joel
 */
public class StartTestListener implements ActionListener {

    private Benchmark bm;

    public StartTestListener(Benchmark bm) {
        this.bm = bm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bm.startTest();
    }

}
