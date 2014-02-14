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
                "Sorting Algorithms", TitledBorder.DEFAULT_JUSTIFICATION,
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

    private void algoSetHorizontalGroup() {
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
        confCheckBoxes();

        separator = new JSeparator();
        enabled = new JLabel();
        currentLoop = new JLabel();
        lastSortTime = new JLabel();
        averageSortTime = new JLabel();
        sortedSortTime = new JLabel();
        confLabels();

        arraySize = new JSlider();
        loops = new JSlider();
        confSliders();

        startTest = new JButton();
        startTest.setFont(font);
        startTest.setText("Start Test");
        startTest.addActionListener(ui.getStartTest());

        font = new Font("Dialog", 0, 12);
        boldedFont = new Font("Dialog", 1, 12);
    }

    private void confSliders() {
        arraySize.setMajorTickSpacing(250000);
        arraySize.setMaximum(1000000);
        arraySize.setMinorTickSpacing(1000);
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
        bubbleSort.setSelected(true);
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

        currentLoop.setFont(font);
        currentLoop.setText("Current Loop #: ");

        lastSortTime.setFont(font);
        lastSortTime.setText("Loop Sort Time");

        averageSortTime.setFont(font);
        averageSortTime.setText("Average Sort Time");

        sortedSortTime.setFont(font);
        sortedSortTime.setText("Time to Sort Sorted Array");
    }
    
    public void setLabelTexts() {
        
        repaint();
    }

}
