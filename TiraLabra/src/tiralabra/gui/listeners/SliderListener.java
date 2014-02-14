package tiralabra.gui.listeners;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import tiralabra.Benchmark;

/**
 *
 * @author Joel
 */
public class SliderListener implements ChangeListener {

    private Benchmark bm;

    public SliderListener(Benchmark bm) {
        this.bm = bm;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting() && source.getName().equals("size")) {
            bm.setSize(source.getValue());
        }
        
        if(!source.getValueIsAdjusting() && source.getName().equals("loops")) {
            bm.setLoops(source.getValue());
        }
    }

}
