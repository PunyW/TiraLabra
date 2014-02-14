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
    private HeapListener hl;
    private QuickListener ql;
    private CountingListener cl;
    private StandardListener sl;
    private TestSortedListener tsl;

    public CheckBoxListeners(Benchmark bm) {
        this.bm = bm;
        initListeners();
    }

    private void initListeners() {
        bl = new BubbleListener(bm);
        ml = new MergeListener(bm);
        hl = new HeapListener(bm);
        ql = new QuickListener(bm);
        cl = new CountingListener(bm);
        sl = new StandardListener(bm);
        tsl = new TestSortedListener(bm);
    }

    public BubbleListener getBl() {
        return bl;
    }

    public MergeListener getMl() {
        return ml;
    }

    public HeapListener getHl() {
        return hl;
    }

    public CountingListener getCl() {
        return cl;
    }

    public StandardListener getSl() {
        return sl;
    }

    public TestSortedListener getTsl() {
        return tsl;
    }

    public QuickListener getQl() {
        return ql;
    }
}
