package tiralabra.gui.listeners;

import tiralabra.Benchmark;

/**
 *
 * @author Joel
 */
public class CheckBoxListeners {

    private Benchmark bm;
    private BubbleListener bl;
    private MergeListener ml;

    public CheckBoxListeners(Benchmark bm) {
        this.bm = bm;
        initListeners();
    }

    private void initListeners() {
        bl = new BubbleListener(bm);
        ml = new MergeListener(bm);
    }

    public BubbleListener getBl() {
        return bl;
    }

    public MergeListener getMl() {
        return ml;
    }

}
