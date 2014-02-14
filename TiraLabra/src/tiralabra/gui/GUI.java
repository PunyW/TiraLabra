package tiralabra.gui;

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
import tiralabra.Interface;

/**
 *
 * @author Joel
 */
public class GUI extends JFrame {

    private Interface ui;
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
     * Title labels
     */
    private JLabel enabled;
    private JLabel currentLoop;
    private JLabel lastSortTime;
    private JLabel averageSortTime;
    private JLabel sortedSortTime;

    /**
     * Labels for time taking / benchmarking
     */
    private JLabel bubbleTime;
    private JLabel bubbleAverage;
    private JLabel bubbleSorted;
    private JLabel mergeTime;
    private JLabel mergeAverage;
    private JLabel mergeSorted;
    private JLabel heapTime;
    private JLabel heapAverage;
    private JLabel heapSorted;
    private JLabel quickTime;
    private JLabel quickAverage;
    private JLabel quickSorted;
    private JLabel countingTime;
    private JLabel countingAverage;
    private JLabel countingSorted;
    private JLabel standardTime;
    private JLabel standardAverage;
    private JLabel standardSorted;

    /**
     * Sliders for array size selector and loop size selector and separator
     */
    private JSlider arraySize;
    private JSlider loops;
    private JSeparator separator;

    /**
     * Panel Layouts
     */
    private GroupLayout optionsLayout;
    private GroupLayout algoLayout;

    // Button to start the test
    private JButton startTest;

    public GUI(Interface ui) {
        this.ui = ui;
        initUI();
    }

    private void initUI() {
        initComponents();

        optionsPanel.setBorder(BorderFactory.createTitledBorder(null, "Sorting Options",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, boldedFont));
        optionsPanel.setLayout(optionsLayout);

        sortingPanel.setBorder(BorderFactory.createTitledBorder(null,
                "Sorting Algorithms - (I advice to disable bubble sort with arrays larger than 20k)", TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, boldedFont));
        sortingPanel.setLayout(algoLayout);

        confLayouts();

        GroupLayout layout = new GroupLayout(getContentPane());
        confGroupLayout(layout);

        pack();

        setTitle("Sorttaus algot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void confGroupLayout(GroupLayout layout) {
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(optionsPanel, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sortingPanel, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(optionsPanel, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sortingPanel, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
    }

    private void confLayouts() {
        confOptionsLayout();
        confAlgoLayout();

    }

    private void confOptionsLayout() {
        optionsSetHorizontalGroup();
        optionsSetVerticalGroup();
    }

    private void optionsSetHorizontalGroup() {

        ParallelGroup components = optionsLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        SequentialGroup checkBox = optionsLayout.createSequentialGroup();
        checkBox.addComponent(testSorted).addGap(0, 0, Short.MAX_VALUE);

        SequentialGroup sliders = optionsLayout.createSequentialGroup();
        sliders.addComponent(arraySize, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE);
        sliders.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        sliders.addComponent(loops, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);

        SequentialGroup testButton = optionsLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE);
        testButton.addComponent(startTest);

        components.addGroup(checkBox).addGroup(sliders).addGroup(testButton);

        optionsLayout.setHorizontalGroup(optionsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(components));

    }

    private void optionsSetVerticalGroup() {
        ParallelGroup main = optionsLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        SequentialGroup components = optionsLayout.createSequentialGroup();

        ParallelGroup sliders = optionsLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        sliders.addComponent(arraySize, GroupLayout.PREFERRED_SIZE,
                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
        sliders.addComponent(loops, GroupLayout.PREFERRED_SIZE,
                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);

        components.addGroup(sliders);
        components.addGap(20, 20, 20);
        components.addComponent(testSorted)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE);
        components.addComponent(startTest).addContainerGap();

        optionsLayout.setVerticalGroup(main.addGroup(components));
    }

    private void confAlgoLayout() {
        algoSetHorizontalGroup();
        algoSetVerticalGroup();
    }

    private void algoSetVerticalGroup() {
        algoLayout.setVerticalGroup(
                algoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, algoLayout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addGroup(algoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(enabled)
                                .addComponent(lastSortTime)
                                .addComponent(averageSortTime)
                                .addComponent(sortedSortTime))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(algoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bubbleSort)
                                .addComponent(bubbleTime)
                                .addComponent(bubbleAverage)
                                .addComponent(bubbleSorted))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(algoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(mergeSort)
                                .addComponent(mergeTime)
                                .addComponent(mergeAverage)
                                .addComponent(mergeSorted))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(algoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(heapSort)
                                .addComponent(heapTime)
                                .addComponent(heapAverage)
                                .addComponent(heapSorted))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(algoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(quickSort)
                                .addComponent(quickTime)
                                .addComponent(quickAverage)
                                .addComponent(quickSorted))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(algoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(countingSort)
                                .addComponent(countingTime)
                                .addComponent(countingAverage)
                                .addComponent(countingSorted))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(algoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(standardSort)
                                .addComponent(standardTime)
                                .addComponent(standardAverage)
                                .addComponent(standardSorted))
                        .addContainerGap())
        );
    }

    private void algoSetHorizontalGroup() {
        algoLayout.setHorizontalGroup(
                algoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(separator)
                .addGroup(algoLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(enabled)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addComponent(lastSortTime)
                        .addGap(132, 132, 132)
                        .addComponent(averageSortTime)
                        .addGap(130, 130, 130)
                        .addComponent(sortedSortTime)
                        .addGap(69, 69, 69))
                .addGroup(algoLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(algoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bubbleSort)
                                .addComponent(mergeSort)
                                .addComponent(heapSort)
                                .addComponent(quickSort)
                                .addComponent(countingSort)
                                .addComponent(standardSort))
                        .addGap(70, 70, 70)
                        .addGroup(algoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bubbleTime)
                                .addComponent(mergeTime)
                                .addComponent(heapTime)
                                .addComponent(quickTime)
                                .addComponent(countingTime)
                                .addComponent(standardTime))
                        .addGap(280, 280, 280)
                        .addGroup(algoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bubbleAverage)
                                .addComponent(standardAverage)
                                .addComponent(countingAverage)
                                .addComponent(quickAverage)
                                .addComponent(heapAverage)
                                .addComponent(mergeAverage))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(algoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bubbleSorted)
                                .addComponent(mergeSorted)
                                .addComponent(heapSorted)
                                .addComponent(quickSorted)
                                .addComponent(countingSorted)
                                .addComponent(standardSorted))
                        .addGap(100, 100, 100))
        );
    }

    private void initComponents() {
        optionsPanel = new JPanel();
        sortingPanel = new JPanel();

        optionsLayout = new GroupLayout(optionsPanel);
        algoLayout = new GroupLayout(sortingPanel);

        /**
         * Check Boxes
         */
        bubbleSort = new JCheckBox();
        mergeSort = new JCheckBox();
        heapSort = new JCheckBox();
        quickSort = new JCheckBox();
        countingSort = new JCheckBox();
        standardSort = new JCheckBox();
        testSorted = new JCheckBox();
        confCheckBoxes();

        /**
         * Labels
         */
        separator = new JSeparator();
        enabled = new JLabel();
        currentLoop = new JLabel();
        lastSortTime = new JLabel();
        averageSortTime = new JLabel();
        sortedSortTime = new JLabel();

        /**
         * Timing Labels
         */
        bubbleTime = new JLabel();
        bubbleAverage = new JLabel();
        bubbleSorted = new JLabel();
        mergeTime = new JLabel();
        mergeAverage = new JLabel();
        mergeSorted = new JLabel();
        heapTime = new JLabel();
        heapAverage = new JLabel();
        heapSorted = new JLabel();
        quickTime = new JLabel();
        quickAverage = new JLabel();
        quickSorted = new JLabel();
        countingTime = new JLabel();
        countingAverage = new JLabel();
        countingSorted = new JLabel();
        standardTime = new JLabel();
        standardAverage = new JLabel();
        standardSorted = new JLabel();
        confLabels();

        /**
         * Sliders
         */
        arraySize = new JSlider();
        loops = new JSlider();
        confSliders();

        /**
         * Buttons
         */
        startTest = new JButton();
        startTest.setFont(font);
        startTest.setText("Start Test");
        startTest.addActionListener(ui.getStartTest());

        /**
         * Fonts
         */
        font = new Font("Dialog", 0, 12);
        boldedFont = new Font("Dialog", 1, 12);
    }

    private void confSliders() {
        arraySize.setMajorTickSpacing(200000);
        arraySize.setMaximum(1000000);
        arraySize.setMinorTickSpacing(100000);
        arraySize.setPaintLabels(true);
        arraySize.setPaintTicks(true);
        arraySize.setValue(100000);
        arraySize.setBorder(BorderFactory.createTitledBorder("Size of the Array"));
        arraySize.addChangeListener(ui.getSliderListener());
        arraySize.setName("size");

        loops.setMajorTickSpacing(1);
        loops.setMaximum(10);
        loops.setMinimum(1);
        loops.setMinorTickSpacing(1);
        loops.setPaintLabels(true);
        loops.setPaintTicks(true);
        loops.setBorder(BorderFactory.createTitledBorder("Number of Loops"));
        loops.setName("loops");
        loops.addChangeListener(ui.getSliderListener());
    }

    private void confCheckBoxes() {
        bubbleSort.setFont(font);
        bubbleSort.setSelected(false);
        bubbleSort.setLabel("Bubble Sort");
        bubbleSort.addItemListener(ui.getCheckBoxListener().getBl());

        mergeSort.setFont(font);
        mergeSort.setSelected(true);
        mergeSort.setLabel("Merge Sort");
        mergeSort.addItemListener(ui.getCheckBoxListener().getMl());

        heapSort.setFont(font);
        heapSort.setSelected(true);
        heapSort.setLabel("Heap Sort");
        heapSort.addItemListener(ui.getCheckBoxListener().getHl());

        quickSort.setFont(font);
        quickSort.setSelected(true);
        quickSort.setLabel("Quick Sort");
        quickSort.addItemListener(ui.getCheckBoxListener().getQl());

        countingSort.setFont(font);
        countingSort.setSelected(true);
        countingSort.setLabel("Counting Sort");
        countingSort.addItemListener(ui.getCheckBoxListener().getCl());

        standardSort.setFont(font);
        standardSort.setSelected(true);
        standardSort.setLabel("Arrays.sort()");
        standardSort.addItemListener(ui.getCheckBoxListener().getSl());

        testSorted.setFont(font);
        testSorted.setLabel("Test Algorithms against sorted array");
        testSorted.addItemListener(ui.getCheckBoxListener().getTsl());
    }

    private void confLabels() {
        enabled.setFont(font);
        enabled.setText("Enabled");

        lastSortTime.setFont(font);
        lastSortTime.setText("Last Loops sort time in ms");

        averageSortTime.setFont(font);
        averageSortTime.setText("Average Sort Time in ms");

        sortedSortTime.setFont(font);
        sortedSortTime.setText("Time to Sort Sorted Array in ms");

        confChangingLabels();
    }

    private void confChangingLabels() {
        bubbleTime.setFont(font);
        bubbleTime.setText("-");

        bubbleAverage.setFont(font);
        bubbleAverage.setText("-");

        bubbleSorted.setFont(font);
        bubbleSorted.setText("-");

        mergeTime.setFont(font);
        mergeTime.setText("-");

        mergeAverage.setFont(font);
        mergeAverage.setText("-");

        mergeSorted.setFont(font);
        mergeSorted.setText("-");

        heapTime.setFont(font);
        heapTime.setText("-");

        heapAverage.setFont(font);
        heapAverage.setText("-");

        heapSorted.setFont(font);
        heapSorted.setText("-");

        quickTime.setFont(font);
        quickTime.setText("-");

        quickAverage.setFont(font);
        quickAverage.setText("-");

        quickSorted.setFont(font);
        quickSorted.setText("-");

        countingTime.setFont(font);
        countingTime.setText("-");

        countingAverage.setFont(font);
        countingAverage.setText("-");

        countingSorted.setFont(font);
        countingSorted.setText("-");

        standardTime.setFont(font);
        standardTime.setText("-");

        standardAverage.setFont(font);
        standardAverage.setText("-");

        standardSorted.setFont(font);
        standardSorted.setText("-");
    }

    public void setLabelTexts() {
        bubbleAverage.setText(ui.getBm().getBubbleAvg());
        mergeAverage.setText(ui.getBm().getMergeAvg());
        heapAverage.setText(ui.getBm().getHeapAvg());
        quickAverage.setText(ui.getBm().getQuickAvg());
        countingAverage.setText(ui.getBm().getCountingAvg());
        standardAverage.setText(ui.getBm().getStandardAvg());
    }

    public void setSortedTexts() {
    }

    public void setBubbleText(String text) {
        bubbleTime.setText(text);
        this.validate();
    }

    public void setMergeText(String text) {
        mergeTime.setText(text);
    }

    public void setHeapText(String text) {
        heapTime.setText(text);
    }

    public void setQuickText(String text) {
        quickTime.setText(text);
    }

    public void setCountingText(String text) {
        countingTime.setText(text);
    }

    public void setStandardText(String text) {
        standardTime.setText(text);
        standardTime.validate();
        standardTime.repaint();
    }
}
