package tiralabra;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author Joel
 */
public class GUI extends JFrame {

    /**
     * Check boxes to enable or disable sorting algorithms
     */
    private JCheckBox bubbleSort;
    private JCheckBox mergeSort;
    private JCheckBox heapSort;
    private JCheckBox quickSort;
    private JCheckBox countingSort;
    private JCheckBox standardSort;
    
    /**
     * Different Labels to label 
     */
    
    
    /**
     * Sliders for array size selector and loop size selector
     */
    private JSlider arraySize;
    private JSlider loops;
    
    public GUI() {
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();

        
        
        add(panel);
        pack();
        
        setTitle("Sorttaus algot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
}
