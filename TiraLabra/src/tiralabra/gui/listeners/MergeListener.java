/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.gui.listeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import tiralabra.Benchmark;

/**
 *
 * @author Joel
 */
public class MergeListener implements ItemListener {

    private Benchmark bm;

    public MergeListener(Benchmark bm) {
        this.bm = bm;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == 1) {
            bm.setMerge(true);
        } else {
            bm.setMerge(false);
        }
    }
}
