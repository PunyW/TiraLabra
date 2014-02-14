package tiralabra;

import tiralabra.gui.listeners.SliderListener;
import tiralabra.gui.GUI;
import tiralabra.gui.listeners.CheckBoxListeners;

/**
 *
 * @author Joel
 */
public class Interface implements Runnable {

    private final Benchmark bm = new Benchmark();
    private SliderListener sl;
    private CheckBoxListeners cbl;

    public Interface() {
        init();

    }

    private void init() {
        sl = new SliderListener(bm);
        cbl = new CheckBoxListeners(bm);
    }

    public Benchmark getBm() {
        return bm;
    }

    public CheckBoxListeners getCheckBoxListener() {
        return cbl;
    }

    public SliderListener getSliderListener() {
        return sl;
    }

    @Override
    public void run() {
        GUI gui = new GUI(this);
        gui.setVisible(true);
    }

}
