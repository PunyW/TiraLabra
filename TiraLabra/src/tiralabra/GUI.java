package tiralabra;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Joel
 */
public class GUI extends JFrame {

    /**
     * Fonts
     */
    private Font font;
    private Font boldedFont;

    /**
     * Panel
     */
    private JPanel optionsPanel;
    private JPanel sortingPanel;

    /**
     * Check boxes to enable or disable sorting algorithms
     */
    private JCheckBox bubbleSort;
    private JCheckBox mergeSort;
    private JCheckBox heapSort;
    private JCheckBox quickSort;
    private JCheckBox countingSort;
    private JCheckBox standardSort;
    private JCheckBox testSorted;

    /**
     * Different Labels for naming stuff and separator
     */
    private JSeparator separator;
    private JLabel enabled;
    private JLabel currentLoop;
    private JLabel lastSortTime;
    private JLabel averageSortTime;
    private JLabel sortedSortTime;

    /**
     * Sliders for array size selector and loop size selector
     */
    private JSlider arraySize;
    private JSlider loops;

    /**
     * Panel Layouts
     */
    private GroupLayout optionsLayout;
    private GroupLayout algoLayout;

    // Button to start the test
    private JButton startTest;

    public GUI() {
        initUI();
    }

    private void initUI() {
        initComponents();

        optionsPanel.setLayout(optionsLayout);

        sortingPanel.setBorder(BorderFactory.createTitledBorder(null,
                "Sorting Algorithms", TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, boldedFont));
        sortingPanel.setLayout(algoLayout);

        confLayouts();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(sortingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(sortingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();

        setTitle("Sorttaus algot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void confLayouts() {

        confAlgoLayout();

    }

    private void confAlgoLayout() {
        algoCreateHorizontalGroup();
        algoCreateVerticalGroup();
    }

    private void algoCreateVerticalGroup() {
        SequentialGroup seq = algoLayout.createSequentialGroup();

        ParallelGroup loopGroup = algoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE);
        loopGroup.addComponent(currentLoop);

        seq.addGroup(loopGroup).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);

        ParallelGroup titleGroup = algoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE);
        titleGroup.addComponent(enabled);
        titleGroup.addComponent(lastSortTime);
        titleGroup.addComponent(averageSortTime);
        titleGroup.addComponent(sortedSortTime);

        seq.addGroup(titleGroup).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        seq.addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        seq.addComponent(bubbleSort).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        seq.addComponent(mergeSort).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        seq.addComponent(heapSort).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        seq.addComponent(quickSort).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        seq.addComponent(countingSort).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        seq.addComponent(standardSort).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addContainerGap();

        algoLayout.setVerticalGroup(
                algoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, seq));
    }

    private void algoCreateHorizontalGroup() {
        SequentialGroup mainSeq = algoLayout.createSequentialGroup().addGap(35);

        SequentialGroup loop = algoLayout.createSequentialGroup();
        loop.addComponent(currentLoop);

        SequentialGroup titleGroup = algoLayout.createSequentialGroup();
        titleGroup.addComponent(enabled).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE);
        titleGroup.addComponent(lastSortTime).addGap(120, 120, 120);
        titleGroup.addComponent(averageSortTime).addGap(120, 120, 120);
        titleGroup.addComponent(sortedSortTime);

        ParallelGroup loopNTitle = algoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(loop).addGroup(titleGroup);
        
        mainSeq.addGroup(loopNTitle);
        
        SequentialGroup boxes = algoLayout.createSequentialGroup().addGap(35);
        ParallelGroup checkBoxes = algoLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        checkBoxes.addComponent(bubbleSort);
        checkBoxes.addComponent(mergeSort);
        checkBoxes.addComponent(heapSort);
        checkBoxes.addComponent(quickSort);
        checkBoxes.addComponent(countingSort);
        checkBoxes.addComponent(standardSort);
        boxes.addGroup(checkBoxes).addContainerGap();

        algoLayout.setHorizontalGroup(algoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(separator).addGroup(mainSeq).addGroup(boxes));

    }

    private void initComponents() {
        optionsPanel = new JPanel();
        sortingPanel = new JPanel();

        optionsLayout = new GroupLayout(optionsPanel);
        algoLayout = new GroupLayout(sortingPanel);

        bubbleSort = new JCheckBox();
        mergeSort = new JCheckBox();
        heapSort = new JCheckBox();
        quickSort = new JCheckBox();
        countingSort = new JCheckBox();
        standardSort = new JCheckBox();
        testSorted = new JCheckBox();

        setCheckBoxes();

        separator = new JSeparator();
        enabled = new JLabel();
        currentLoop = new JLabel();
        lastSortTime = new JLabel();
        averageSortTime = new JLabel();
        sortedSortTime = new JLabel();

        setLabels();

        arraySize = new JSlider();
        loops = new JSlider();

        startTest = new JButton();

        font = new Font("Dialog", 0, 12);
        boldedFont = new Font("Dialog", 1, 12);
    }

    private void setCheckBoxes() {
        bubbleSort.setFont(font);
        bubbleSort.setSelected(true);
        bubbleSort.setLabel("Bubble Sort");

        mergeSort.setFont(font);
        mergeSort.setSelected(true);
        mergeSort.setLabel("Merge Sort");

        heapSort.setFont(font);
        heapSort.setSelected(true);
        heapSort.setLabel("Heap Sort");

        quickSort.setFont(font);
        quickSort.setSelected(true);
        quickSort.setLabel("Quick Sort");

        countingSort.setFont(font);
        countingSort.setSelected(true);
        countingSort.setLabel("Counting Sort");

        standardSort.setFont(font);
        standardSort.setSelected(true);
        standardSort.setLabel("Arrays.sort()");

        testSorted.setFont(font);
        testSorted.setLabel("Test Algorithms against sorted array");
    }

    private void setLabels() {
        enabled.setFont(font);
        enabled.setText("Enabled");

        currentLoop.setFont(font);
        currentLoop.setText("Current Loop #: ");

        lastSortTime.setFont(font);
        lastSortTime.setText("Loop Sort Time");

        averageSortTime.setFont(font);
        averageSortTime.setText("Average Sort Time");

        sortedSortTime.setFont(font);
        sortedSortTime.setText("Time to Sort Sorted Array");
    }

}
