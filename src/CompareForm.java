import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class CompareForm extends JFrame{
    private JPanel pnMain;
    private JLabel lbTitle;
    private JPanel pnImitiate;
    private JPanel pnTool;
    private JPanel pnArray;
    private JPanel pnCreateArray;
    private JSpinner spNum;
    private JButton btnCreateArray, btnDeleteArray, btnSetZero;
//    private JPanel pnSetValueArray;
    private JButton btnRandom;
//    private JPanel pnCode;
//    private JSlider slSize;
//    private JScrollPane pnScroll;
    private DefaultListModel<String> model;
    private ActionListener eInterchangeSort, eSelectionSort, eBubbleSort, eInsertionSort, eShellSort, eHeapSort, eQuickSort, eMergeSort;
    private ChangeListener eSize;
//    private JList<String> lsCode;
    private JPanel pnAlgorithm;
    private JRadioButton rdInterchangeSort, rdSelectionSort, rdBubbleSort, rdInsertionSort, rdShellSort, rdHeapSort, rdQuickSort, rdMergeSort;
    private ButtonGroup grSort, grSort2;

    private ButtonGroup grDirect;
    private JPanel pnControl;
    private JRadioButton rdIncrease, rdDecrease;
    private ActionListener eIncrease, eDecrease;
    private boolean isIncrease = true;
    private JButton btnSort;
//    private JSlider slSpeed;
    private ChangeListener eSpeed;
    public int num;

    public int num2;
    private JLabel[] lbArrays;

    private JLabel[] lbArrays2;
    private int[] array;
    private int[] array2;
    private Thread[] threads = new Thread[1000000];


    private Thread[] threads2 = new Thread[1000000];
    private int curT = -1;
    private int curT2 = -1;
    private int time = 50;
    private int step = 0;
    private int[] lbI = new int[50];
    private int[] lbJ = new int[50];
    private int[] oriLocat = new int[15];
    private int[] lbL = new int[50];
    private int[] lbR = new int[50];
    private File file = new File ("src/array.txt");
    private float speed;
//    private JButton btnNewButton;
    private JPanel pnImitiate2;
    private JPanel pnAlgorithm2;
    private JLabel lbNum;
    private JLabel lbMaxNum;
    private JRadioButton rdInterchangeSort2;
    private JRadioButton rdSelectionSort2;
    private JRadioButton rdQuickSort2;
    private JRadioButton rdMergeSort2;
    private JRadioButton rdHeapSort2;
    private JRadioButton rdShellSort2;
    private JRadioButton rdInsertionSort2;
    private JRadioButton rdBubbleSort2;
    private JButton btnBack;
    private JLabel lbTime1;
    private JLabel lbTime2;
    private boolean isStep = false;
    private JLabel lbPoint1 = new JLabel();
    private JLabel lbPoint2 = new JLabel();
    private JLabel lbPointM = new JLabel();

    private JLabel lbPoint12 = new JLabel();
    private JLabel lbPoint22 = new JLabel();
    private JLabel lbPointM2 = new JLabel();
    private Color processingColor = new Color(255, 153, 153);
    private Color selectedGreen = new Color(153, 255, 153);
    private Color selectedYellow = new Color(255, 255, 153);

    private long time1 = 0, time2 = 0;


    public CompareForm(){
        setTitle("Mo Phong Thuat Toan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1372, 742);
        setContentPane(pnMain);
        setLocationRelativeTo(null);
        setVisible(true);


        grDirect = new ButtonGroup();
        grDirect.add(rdDecrease);grDirect.add(rdIncrease);
        rdIncrease.setSelected(true);

        grSort = new ButtonGroup();
        grSort.add(rdInterchangeSort);
        grSort.add(rdSelectionSort);
        grSort.add(rdBubbleSort);
        grSort.add(rdInsertionSort);
        grSort.add(rdShellSort);
        grSort.add(rdHeapSort);
        grSort.add(rdQuickSort);
        grSort.add(rdMergeSort);

        grSort2 = new ButtonGroup();
        grSort2.add(rdInterchangeSort2);
        grSort2.add(rdSelectionSort2);
        grSort2.add(rdBubbleSort2);
        grSort2.add(rdInsertionSort2);
        grSort2.add(rdShellSort2);
        grSort2.add(rdHeapSort2);
        grSort2.add(rdQuickSort2);
        grSort2.add(rdMergeSort2);

        rdInterchangeSort.setSelected(true);

        rdInterchangeSort2.setSelected(true);


//        slSpeed.setOrientation(SwingConstants.VERTICAL);


        pnImitiate.setBorder(new TitledBorder(null, "Khung ch\u1EA1y m\u00F4 ph\u1ECFng 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnImitiate.setLayout(null);

        pnImitiate2.setBorder(new TitledBorder(null, "Khung ch\u1EA1y m\u00F4 ph\u1ECFng 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnImitiate2.setLayout(null);


//        pnSetValueArray.setBorder(new TitledBorder(null, "Tạo mảng dữ liệu", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        pnCreateArray.setBorder(new TitledBorder(null, "Kh\u1EDFi t\u1EA1o m\u1EA3ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        GroupLayout gl_pnArray = new GroupLayout(pnArray);
        gl_pnArray.setHorizontalGroup(
                gl_pnArray.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(pnCreateArray, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
        );
        gl_pnArray.setVerticalGroup(
                gl_pnArray.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.LEADING, gl_pnArray.createSequentialGroup()
                                .addComponent(pnCreateArray, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
        );

        model = new DefaultListModel<>();
//        lsCode = new JList<String>(model);
//        lsCode.setBorder(new LineBorder(new Color(0, 0, 0)));
//        lsCode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        lsCode.setFont(new Font("Monospaced",Font.BOLD,14));
//        pnScroll.setViewportView(lsCode);

        SpinnerModel sm = new SpinnerNumberModel(2, 2, 15, 1);
        spNum.setModel(sm);
        JFormattedTextField txt = ((JSpinner.NumberEditor) spNum.getEditor()).getTextField();
        ((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainForm mainForm = new MainForm();
                mainForm.setVisible(true);
            }
        });

//        btnReadFile.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                deleteArrays();
//                try {
//                    Scanner in = new Scanner(file);
//                    num = Integer.parseInt(in.nextLine());
//                    array = new int[num];
//                    array2 = new int[num];
//                    int pos = 0;
//                    while (in.hasNextLine()) {
//                        array[pos] = Integer.parseInt(in.nextLine());
//                        array2[pos] = Integer.parseInt(in.nextLine());
//                        pos++;
//                    }
//                    in.close();
//                    lbArrays = new JLabel[num];
//
//                    lbArrays2 = new JLabel[num];
//
//                    for (int i = 0; i < num; i++) {
//                        //create label, set text "0"
//
//                        lbArrays[i] = new JLabel(String.valueOf(array[i]));
//                        lbArrays2[i] = new JLabel(String.valueOf(array2[i]));
//
//                        pnImitiate.add(lbArrays[i]);
//                        pnImitiate2.add(lbArrays2[i]);
//
//                        //set size label
//                        lbArrays[i].setSize(50,50);
//                        lbArrays[i].setOpaque(true);
//                        lbArrays[i].setForeground(Color.BLUE);
//
//                        lbArrays2[i].setSize(50,50);
//                        lbArrays2[i].setOpaque(true);
//                        lbArrays2[i].setForeground(Color.BLUE);
//
//                        //set location label
//                        if (i == 0) {
//                            lbArrays[i].setLocation(((int) (((18 - num) * 0.5) * 70) + 100), 150);
//                            lbArrays2[i].setLocation(((int) (((18 - num) * 0.5) * 70) + 100), 150);
//                        }
//                        else {
//                            lbArrays[i].setLocation((lbArrays[i - 1].getX() + 70), 150);
//                            lbArrays2[i].setLocation((lbArrays[i - 1].getX() + 70), 150);
//                        }
//
//                        //set fonts
//                        lbArrays[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
//
//                        //set background color
//                        lbArrays[i].setBackground(SystemColor.inactiveCaption);
//
//                        //set text alignment center
//                        lbArrays[i].setHorizontalAlignment(SwingConstants.CENTER);
//                        lbArrays[i].setVerticalAlignment(SwingConstants.CENTER);
//
//                        //set fonts
//                        lbArrays2[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
//
//                        //set background color
//                        lbArrays2[i].setBackground(SystemColor.inactiveCaption);
//
//                        //set text alignment center
//                        lbArrays2[i].setHorizontalAlignment(SwingConstants.CENTER);
//                        lbArrays2[i].setVerticalAlignment(SwingConstants.CENTER);
//                    }
//                    pnImitiate.setVisible(true);
//                    pnImitiate.validate();
//                    pnImitiate.repaint();
//
//                    pnImitiate2.setVisible(true);
//                    pnImitiate2.validate();
//                    pnImitiate2.repaint();
//
//                    setState(2);
//                } catch (FileNotFoundException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        });

//        btnOpenFile.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    Desktop desktop = null;
//                    if (Desktop.isDesktopSupported()) {
//                        desktop = Desktop.getDesktop();
//                    }
//                    desktop.open(file);
//                } catch (IOException ioe) {
//                    //file isn't existed
//                    ioe.printStackTrace();
//                }
//            }
//        });

        btnSort.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                Thread leftSort = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (!isSorted() && !isSorted2()) {
                            setState(3);
                            for (int i = 0; i < num; i++) {
                                lbArrays[i].setForeground(Color.BLUE);
                                lbArrays2[i].setForeground(Color.BLUE);
                            }

                            if (rdInterchangeSort.isSelected())
                                InterchangeSort();
                            if (rdSelectionSort.isSelected())
                                SelectionSort();
                            if (rdBubbleSort.isSelected())
                                BubbleSort();
                            if (rdInsertionSort.isSelected())
                                InsertionSort();
                            if (rdShellSort.isSelected())
                                ShellSort();
                            if (rdHeapSort.isSelected()) {
                                HeapSort();
                                threadReLocate();
                            }

                            if (rdQuickSort.isSelected())
                                QuickSort();
                            if (rdMergeSort.isSelected())
                                MergeSort();

                            waitEnd();
                        }
                    }
                });

                Thread rightSort = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (!isSorted() && !isSorted2()) {
                            setState(3);
                            for (int i = 0; i < num; i++) {
                                lbArrays[i].setForeground(Color.BLUE);
                                lbArrays2[i].setForeground(Color.BLUE);
                            }
                            if (rdInterchangeSort2.isSelected())
                                InterchangeSort2();
                            if (rdSelectionSort2.isSelected())
                                SelectionSort2();
                            if (rdBubbleSort2.isSelected())
                                BubbleSort2();
                            if (rdInsertionSort2.isSelected())
                                InsertionSort2();
                            if (rdShellSort2.isSelected())
                                ShellSort2();

//22222222222222222222222222222



//                    if (rdHeapSort.isSelected()) {
//                        HeapSort();
//                        threadReLocate();
//                    }
//
//                    if (rdQuickSort.isSelected())
//                        QuickSort();
//                    if (rdMergeSort.isSelected())
//                        MergeSort();
                            waitEnd2();
                        }
                    }
                });

                leftSort.start();
                rightSort.start();


                lbTime1.setText("Thời giaṇ chạy: "+time1 +" ms");
                lbTime2.setText("Thời giaṇ chạy: "+time2 +" ms");
            }
        });

        btnCreateArray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                createArrays();
            }
        });

        btnDeleteArray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                deleteArrays();
                setState(0);
            }
        });

        btnSetZero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setZero();
            }
        });

        btnRandom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createRandom();
            }
        });

        eSize = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
//                lsCode.setFont(new Font("Monospaced",Font.BOLD,slSize.getValue()));
//                lsCode.repaint();
            }
        };

//        slSize.addChangeListener(eSize);

        eSpeed = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
//                time = 100 - slSpeed.getValue() * 10;
                time = 100;
            }
        };

//        slSpeed.addChangeListener(eSpeed);

        /*
         * event Action Listener all sorts
         */
        eInterchangeSort = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                model.removeAllElements();
                addInterchangeSort();
//                lsCode.setSelectedIndex(0);
            }
        };

        eSelectionSort = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                model.removeAllElements();
                addSelectionSort();
//                lsCode.setSelectedIndex(0);
            }
        };

        eBubbleSort = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                model.removeAllElements();
                addBubbleSort();
//                lsCode.setSelectedIndex(0);
            }
        };

        eInsertionSort = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                model.removeAllElements();
                addInsertionSort();
//                lsCode.setSelectedIndex(0);
            }
        };

        eShellSort = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                model.removeAllElements();
                addShellSort();
//                lsCode.setSelectedIndex(0);
            }
        };

        eHeapSort = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                model.removeAllElements();
                addHeapSort();
//                lsCode.setSelectedIndex(0);
            }
        };

        eQuickSort = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                model.removeAllElements();
                addQuickSort();
//                lsCode.setSelectedIndex(0);
            }
        };

        eMergeSort = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                model.removeAllElements();
                addMergeSort();
//                lsCode.setSelectedIndex(0);
            }
        };

        //add ActionListener to radio buttons
        rdInterchangeSort.addActionListener(eInterchangeSort);
        rdSelectionSort.addActionListener(eSelectionSort);
        rdBubbleSort.addActionListener(eBubbleSort);
        rdInsertionSort.addActionListener(eInsertionSort);
        rdShellSort.addActionListener(eShellSort);
        rdHeapSort.addActionListener(eHeapSort);
        rdQuickSort.addActionListener(eQuickSort);
        rdMergeSort.addActionListener(eMergeSort);

        model.removeAllElements();
        addInterchangeSort();
//        lsCode.setSelectedIndex(0);

        eIncrease = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                //set Increase or Decrease
                isIncrease = true;

                //update element sort
                if (rdInterchangeSort.isSelected())
                    model.set(4, "                    if(a[j] < a[i])");
                if (rdSelectionSort.isSelected())
                    model.set(5, "               if (a[j] < a[pos])");
                if (rdBubbleSort.isSelected())
                    model.set(4,"               if(a[j] < a[j-1])");
                if (rdInsertionSort.isSelected())
                    model.set(6,"          while ((pos >= 0) && (a[pos] > x)) {");
            }
        };

        eDecrease = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                isIncrease = false;

                if (rdInterchangeSort.isSelected())
                    model.set(4, "                    if(a[j] > a[i])");
                if (rdSelectionSort.isSelected())
                    model.set(5, "               if (a[j] > a[pos])");
                if (rdBubbleSort.isSelected())
                    model.set(4,"               if(a[j] > a[j-1])");
                if (rdInsertionSort.isSelected())
                    model.set(6,"          while ((pos >= 0) && (a[pos] < x)) {");
            }
        };

        rdIncrease.addActionListener(eIncrease);
        rdDecrease.addActionListener(eDecrease);
        setState(0);

        lbPoint1.setSize(50, 25);
        lbPoint1.setOpaque(true);
        lbPoint1.setLocation(50, 50);
        lbPoint1.setFont(new Font("Helvetica", Font.BOLD, 17));
        lbPoint1.setBackground(SystemColor.white);
//        lbPoint1.setHorizontalAlignment(SwingConstants.CENTER);
        lbPoint1.setVerticalAlignment(SwingConstants.CENTER);
//////////////////////////++++++++++++++
        lbPoint12.setSize(50, 25);
        lbPoint12.setOpaque(true);
        lbPoint12.setLocation(50, 50);
        lbPoint12.setFont(new Font("Helvetica", Font.BOLD, 17));
        lbPoint12.setBackground(SystemColor.white);
//        lbPoint1.setHorizontalAlignment(SwingConstants.CENTER);
        lbPoint12.setVerticalAlignment(SwingConstants.CENTER);

        pnImitiate.add(lbPoint1);
        pnImitiate.add(lbPoint2);

        pnImitiate2.add(lbPoint12);
        pnImitiate2.add(lbPoint22);

        lbPoint2.setSize(50, 25);
        lbPoint2.setOpaque(true);
        lbPoint2.setLocation(50, 50);
        lbPoint2.setFont(new Font("Helvetica", Font.BOLD, 17));
        lbPoint2.setBackground(SystemColor.white);
//        lbPoint2.setHorizontalAlignment(SwingConstants.CENTER);
        lbPoint2.setVerticalAlignment(SwingConstants.CENTER);

//        +++++++++++++++++++++
        lbPoint22.setSize(50, 25);
        lbPoint22.setOpaque(true);
        lbPoint22.setLocation(50, 50);
        lbPoint22.setFont(new Font("Helvetica", Font.BOLD, 17));
        lbPoint22.setBackground(SystemColor.white);
//        lbPoint2.setHorizontalAlignment(SwingConstants.CENTER);
        lbPoint22.setVerticalAlignment(SwingConstants.CENTER);


        pnImitiate.add(lbPointM);

        pnImitiate2.add(lbPointM2);

        lbPointM.setSize(50, 25);
        lbPointM.setOpaque(true);
        lbPointM.setLocation(50, 50);
        lbPointM.setFont(new Font("Helvetica", Font.BOLD, 17));
        lbPointM.setBackground(SystemColor.white);
//        lbPointM.setHorizontalAlignment(SwingConstants.CENTER);
        lbPointM.setVerticalAlignment(SwingConstants.CENTER);
//+++++++++++++++++++++++++++++++++++++++++
        lbPointM2.setSize(50, 25);
        lbPointM2.setOpaque(true);
        lbPointM2.setLocation(50, 50);
        lbPointM2.setFont(new Font("Helvetica", Font.BOLD, 17));
        lbPointM2.setBackground(SystemColor.white);
//        lbPointM.setHorizontalAlignment(SwingConstants.CENTER);
        lbPointM2.setVerticalAlignment(SwingConstants.CENTER);
    }

    public static void main(String[] args){
        new CompareForm();
    }


    /**
     * Set Lock And Feel
     */
    public static void setLockAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {

        }
    }

    /**
     * Set state and manage GUI
     */
    public void setState(int state) {
        switch (state) {
            case 0: //first state, haven't created arrays.
                btnCreateArray.setEnabled(true);
                btnDeleteArray.setEnabled(false);
                btnSetZero.setEnabled(false);

                btnRandom.setEnabled(false);
//                btnByHand.setEnabled(true);
//                btnOpenFile.setEnabled(true);
//                btnReadFile.setEnabled(true);

                rdInterchangeSort.setEnabled(true);
                rdSelectionSort.setEnabled(true);
                rdBubbleSort.setEnabled(true);
                rdInsertionSort.setEnabled(true);
                rdShellSort.setEnabled(true);
                rdHeapSort.setEnabled(true);
                rdQuickSort.setEnabled(true);
                rdMergeSort.setEnabled(true);

                rdInterchangeSort2.setEnabled(true);
                rdSelectionSort2.setEnabled(true);
                rdBubbleSort2.setEnabled(true);
                rdInsertionSort2.setEnabled(true);
                rdShellSort2.setEnabled(true);
                rdHeapSort2.setEnabled(true);
                rdQuickSort2.setEnabled(true);
                rdMergeSort2.setEnabled(true);

                rdIncrease.setEnabled(true);
                rdDecrease.setEnabled(true);

                btnSort.setEnabled(false);
                //btnNext.setEnabled(false);
                //btnNext2.setEnabled(false);
//                btnStop.setEnabled(false);
                break;

            case 1: //created arrays, be waiting to set value arrays.
                btnDeleteArray.setEnabled(true);
                btnSetZero.setEnabled(true);

                btnRandom.setEnabled(true);
//                btnByHand.setEnabled(true);
//                btnOpenFile.setEnabled(true);
//                btnReadFile.setEnabled(true);

                rdInterchangeSort.setEnabled(true);
                rdSelectionSort.setEnabled(true);
                rdBubbleSort.setEnabled(true);
                rdInsertionSort.setEnabled(true);
                rdShellSort.setEnabled(true);
                rdHeapSort.setEnabled(true);
                rdQuickSort.setEnabled(true);
                rdMergeSort.setEnabled(true);

                rdInterchangeSort2.setEnabled(true);
                rdSelectionSort2.setEnabled(true);
                rdBubbleSort2.setEnabled(true);
                rdInsertionSort2.setEnabled(true);
                rdShellSort2.setEnabled(true);
                rdHeapSort2.setEnabled(true);
                rdQuickSort2.setEnabled(true);
                rdMergeSort2.setEnabled(true);

                rdIncrease.setEnabled(true);
                rdDecrease.setEnabled(true);
                break;

            case 2: //be set values, ready to sort
                btnDeleteArray.setEnabled(true);
                btnSetZero.setEnabled(true);

                btnRandom.setEnabled(true);

                rdInterchangeSort.setEnabled(true);
                rdSelectionSort.setEnabled(true);
                rdBubbleSort.setEnabled(true);
                rdInsertionSort.setEnabled(true);
                rdShellSort.setEnabled(true);
                rdHeapSort.setEnabled(true);
                rdQuickSort.setEnabled(true);
                rdMergeSort.setEnabled(true);

                rdInterchangeSort2.setEnabled(true);
                rdSelectionSort2.setEnabled(true);
                rdBubbleSort2.setEnabled(true);
                rdInsertionSort2.setEnabled(true);
                rdShellSort2.setEnabled(true);
                rdHeapSort2.setEnabled(true);
                rdQuickSort2.setEnabled(true);
                rdMergeSort2.setEnabled(true);

                rdIncrease.setEnabled(true);
                rdDecrease.setEnabled(true);

                btnSort.setEnabled(true);
                //btnNext.setEnabled(false);
                //btnNext2.setEnabled(false);
//                btnStop.setEnabled(false);
                break;

            case 3: //sorting
                btnCreateArray.setEnabled(true);
                btnDeleteArray.setEnabled(true);
                btnSetZero.setEnabled(false);

                btnRandom.setEnabled(false);
//                btnByHand.setEnabled(false);
//                btnOpenFile.setEnabled(false);
//                btnReadFile.setEnabled(false);

                rdIncrease.setEnabled(false);
                rdDecrease.setEnabled(false);

                rdInterchangeSort.setEnabled(false);
                rdSelectionSort.setEnabled(false);
                rdBubbleSort.setEnabled(false);
                rdInsertionSort.setEnabled(false);
                rdShellSort.setEnabled(false);
                rdHeapSort.setEnabled(false);
                rdQuickSort.setEnabled(false);
                rdMergeSort.setEnabled(false);

                rdInterchangeSort2.setEnabled(false);
                rdSelectionSort2.setEnabled(false);
                rdBubbleSort2.setEnabled(false);
                rdInsertionSort2.setEnabled(false);
                rdShellSort2.setEnabled(false);
                rdHeapSort2.setEnabled(false);
                rdQuickSort2.setEnabled(false);
                rdMergeSort2.setEnabled(false);

                btnSort.setEnabled(false);
                //btnNext.setEnabled(true);
                //btnNext2.setEnabled(true);
//                btnStop.setEnabled(true);
                break;

            case 4: //sort done
                btnCreateArray.setEnabled(true);
                btnDeleteArray.setEnabled(true);
                btnSetZero.setEnabled(true);

                btnRandom.setEnabled(true);
//                btnByHand.setEnabled(true);
//                btnOpenFile.setEnabled(true);
//                btnReadFile.setEnabled(true);

                rdInterchangeSort.setEnabled(true);
                rdSelectionSort.setEnabled(true);
                rdBubbleSort.setEnabled(true);
                rdInsertionSort.setEnabled(true);
                rdShellSort.setEnabled(true);
                rdHeapSort.setEnabled(true);
                rdQuickSort.setEnabled(true);
                rdMergeSort.setEnabled(true);

                rdInterchangeSort2.setEnabled(true);
                rdSelectionSort2.setEnabled(true);
                rdBubbleSort2.setEnabled(true);
                rdInsertionSort2.setEnabled(true);
                rdShellSort2.setEnabled(true);
                rdHeapSort2.setEnabled(true);
                rdQuickSort2.setEnabled(true);
                rdMergeSort2.setEnabled(true);

                rdIncrease.setEnabled(true);
                rdDecrease.setEnabled(true);

                btnSort.setEnabled(true);
                //btnNext.setEnabled(true);
                //btnNext2.setEnabled(true);
//                btnStop.setEnabled(true);
                break;
            default:
                btnCreateArray.setEnabled(true);
                btnDeleteArray.setEnabled(false);
                btnSetZero.setEnabled(false);

                btnRandom.setEnabled(false);
//                btnByHand.setEnabled(true);
//                btnOpenFile.setEnabled(true);
//                btnReadFile.setEnabled(true);

                rdInterchangeSort.setEnabled(true);
                rdSelectionSort.setEnabled(true);
                rdBubbleSort.setEnabled(true);
                rdInsertionSort.setEnabled(true);
                rdShellSort.setEnabled(true);
                rdHeapSort.setEnabled(true);
                rdQuickSort.setEnabled(true);
                rdMergeSort.setEnabled(true);

                rdInterchangeSort2.setEnabled(true);
                rdSelectionSort2.setEnabled(true);
                rdBubbleSort2.setEnabled(true);
                rdInsertionSort2.setEnabled(true);
                rdShellSort2.setEnabled(true);
                rdHeapSort2.setEnabled(true);
                rdQuickSort2.setEnabled(true);
                rdMergeSort2.setEnabled(true);

                rdIncrease.setEnabled(true);
                rdDecrease.setEnabled(true);

                btnSort.setEnabled(false);
                //btnNext.setEnabled(false);
                //btnNext2.setEnabled(false);
//                btnStop.setEnabled(false);
        }
    }

    /**
     * Doing with arrays
     */
    public void createArrays() {

        //delete previous arrays and set number elements of array
        deleteArrays();
        num = (Integer)spNum.getValue();

        lbArrays = new JLabel[num];
        lbArrays2 = new JLabel[num];
        array = new int[num];
        array2 = new int[num];

        for (int i = 0; i < num; i++) {

            //create label, set text "0"
            lbArrays[i] = new JLabel("0");
            lbArrays2[i] = new JLabel("0");
            array[i] = 0;
            array2[i] = 0;
            pnImitiate.add(lbArrays[i]);

            pnImitiate2.add(lbArrays2[i]);

            lbArrays[i].setText(String.valueOf(array[i]));

            //set size label
            lbArrays[i].setSize(30,30);
            lbArrays[i].setOpaque(true);
            lbArrays[i].setForeground(Color.blue);

            lbArrays2[i].setText(String.valueOf(array2[i]));

            //set size label
            lbArrays2[i].setSize(30,30);
            lbArrays2[i].setOpaque(true);
            lbArrays2[i].setForeground(Color.blue);


            //set location label
            if (i == 0) {
                lbArrays[i].setLocation(((int) ((((18 - num) * 0.5) * 70) + 100) / 2 - 20), 150);
                lbArrays2[i].setLocation(((int) ((((18 - num) * 0.5) * 70) + 100) / 2 - 20), 150);
            }
            else {
                lbArrays[i].setLocation(lbArrays[i - 1].getX() + 35, 150);
                lbArrays2[i].setLocation(lbArrays[i-1].getX() + 35, 150);
            }

            //set fonts
            lbArrays[i].setFont(new Font("Tahoma", Font.PLAIN, 16));

            //set background color
            lbArrays[i].setBackground(SystemColor.inactiveCaption);
            //set text alignment center
            lbArrays[i].setHorizontalAlignment(SwingConstants.CENTER);
            lbArrays[i].setVerticalAlignment(SwingConstants.CENTER);

            //set fonts
            lbArrays2[i].setFont(new Font("Tahoma", Font.PLAIN, 16));

            //set background color
            lbArrays2[i].setBackground(SystemColor.inactiveCaption);
            //set text alignment center
            lbArrays2[i].setHorizontalAlignment(SwingConstants.CENTER);
            lbArrays2[i].setVerticalAlignment(SwingConstants.CENTER);
        }

        pnImitiate.add(lbPoint1);
        pnImitiate.add(lbPoint2);
        pnImitiate.add(lbPointM);

        pnImitiate.setVisible(true);
        pnImitiate.validate();
        pnImitiate.repaint();

        pnImitiate2.add(lbPoint12);
        pnImitiate2.add(lbPoint22);
        pnImitiate2.add(lbPointM2);

        pnImitiate2.setVisible(true);
        pnImitiate2.validate();
        pnImitiate2.repaint();

        setState(1);
    }

    public void deleteArrays() {
        for (int i = 0; i < num; i++) {
            lbArrays[i].setText("0");
            lbArrays2[i].setText("0");
            array[i] = 0;
            array2[i] = 0;
            lbArrays[i].setVisible(false);
            lbArrays2[i].setVisible(false);
            pnImitiate.remove(lbArrays[i]);
            pnImitiate2.remove(lbArrays2[i]);
        }

        lbPoint1.setText("");
        lbPoint2.setText("");
        lbPointM.setText("");

        lbPoint12.setText("");
        lbPoint22.setText("");
        lbPointM2.setText("");

        pnImitiate.remove(lbPoint1);
        pnImitiate.remove(lbPoint2);
        pnImitiate.remove(lbPointM);

        pnImitiate2.remove(lbPoint12);
        pnImitiate2.remove(lbPoint22);
        pnImitiate2.remove(lbPointM2);

        for (int i = 0; i < curT; i++) {
            try {
                threads[i].interrupt();
                threads2[i].interrupt();
            }
            catch (Exception e) {

            }
        }
        curT = -1;

        pnImitiate.revalidate();
        pnImitiate.repaint();

        pnImitiate2.revalidate();
        pnImitiate2.repaint();

        setState(0);
    }

    public void setZero() {
        for (int i = 0; i < num; i++) {
            lbArrays[i].setText("0");
            lbArrays2[i].setText("0");
            array[i] = 0;
            array2[i] = 0;
        }
        createArrays();
        pnImitiate.revalidate();
        pnImitiate.repaint();

        pnImitiate2.revalidate();
        pnImitiate2.repaint();

        setState(1);
    }

    public void createRandom() {
        Random rand = new Random();
        for (int i = 0; i < num; i++) {
            int ranNum = rand.nextInt(101) + 0;
            lbArrays[i].setText(String.valueOf(ranNum));
            lbArrays[i].setForeground(Color.BLUE);

            lbArrays2[i].setText(String.valueOf(ranNum));
            lbArrays2[i].setForeground(Color.BLUE);
            array[i] = ranNum;
            array2[i] = ranNum;
        }
        pnImitiate.setVisible(true);
        pnImitiate.validate();
        pnImitiate.repaint();

        pnImitiate2.setVisible(true);
        pnImitiate2.validate();
        pnImitiate2.repaint();

        setState(2);
    }

    /**
     * Add Text Sort to JList
     */
    public void addInterchangeSort() {
        model.addElement("void InterchangeSort(int a[], int N) {");
        model.addElement("     int i, j;");
        model.addElement("          for (i = 0 ; i<N-1 ; i++)");
        model.addElement("               for (j =i+1; j < N ; j++)");
        model.addElement("                    if(a[j ]< a[i])");
        model.addElement("                         Swap(a[i], a[j])");
        model.addElement("}");
    }

    public void addSelectionSort() {
        model.addElement("void SelectionSort(int a[],int n ) {");
        model.addElement("     int pos,i,j;");
        model.addElement("     for (i=0; i<n-1 ; i++) {");
        model.addElement("          pos = i;");
        model.addElement("          for(j = i+1; j <N ; j++)");
        model.addElement("               if (a[j] < a[pos])");
        model.addElement("                    pos = j;");
        model.addElement("               Swap(a[pos],a[i]);");
        model.addElement("     }");
        model.addElement("}");
    }

    public void addBubbleSort() {
        model.addElement("void BubbleSort(int a[],int n) {");
        model.addElement("     int i, j;");
        model.addElement("     for (i = 0 ; i<n-1 ; i++)");
        model.addElement("          for (j =n-1; j >i ; j --)");
        model.addElement("               if(a[j] < a[j-1])");
        model.addElement("                    Swap(a[j], a[j-1]");
        model.addElement("}");
    }

    public void addInsertionSort() {
        model.addElement("void InsertionSort(int a[], int n ) {");
        model.addElement("     int pos, i;");
        model.addElement("     int x;");
        model.addElement("     for(i = 1; i < n; i++) {");
        model.addElement("          x = a[i];");
        model.addElement("          pos = i - 1;");
        model.addElement("          while ((pos >= 0) && (a[pos] > x)) {");
        model.addElement("               a[pos+1] = a[pos];");
        model.addElement("               pos--;");
        model.addElement("          }");
        model.addElement("     a[pos+1] = x];");
        model.addElement("     }");
        model.addElement("}");
    }

    public void addShellSort() {
        model.addElement("void ShellSort(int a[], int n) {");
        model.addElement("    int len, i, j, x;");
        model.addElement("    for (len = 11; len > 0; len /= 2) {");
        model.addElement("        for (i = len; i < n; i++) {");
        model.addElement("            x = a[i];");
        model.addElement("            j = i - len;");
        model.addElement("            while (j >= 0 && x < a[i]) {");
        model.addElement("                a[j + len] = a[j];");
        model.addElement("            }");
        model.addElement("            j -= len;");
        model.addElement("        }");
        model.addElement("        a[j + len] = x;");
        model.addElement("    }");
        model.addElement("}");
    }

    public void addHeapSort() {
        model.addElement("void HeapSort(int a[],int n) {");
        model.addElement("     int r;");
        model.addElement("     CreateHeap(a,n);");
        model.addElement("     r=n-1;");
        model.addElement("     while(r>0) {");
        model.addElement("          Swap(a[0],a[r]);");
        model.addElement("          r--;");
        model.addElement("          if(r>0)");
        model.addElement("               shift(a,0,r);");
        model.addElement("     }");
        model.addElement("}");
        model.addElement("");
        model.addElement("void CreateHeap(int a[],int n) {");
        model.addElement("     int l;");
        model.addElement("     l=n/2-1;");
        model.addElement("     while(l>=0) {");
        model.addElement("          shift(a,l,n-1);");
        model.addElement("          l=l-1;");
        model.addElement("     }");
        model.addElement("}");
        model.addElement("");
        model.addElement("void shift(int a[],int l,int r) {");
        model.addElement("     int x,i,j;");
        model.addElement("     i=l;");
        model.addElement("     j=2*i+1;");
        model.addElement("     x=a[i];");
        model.addElement("     while(j<=r) {");
        model.addElement("          if(j<r)");
        model.addElement("          if(a[j]<a[j+1])");
        model.addElement("          j++;");
        model.addElement("          if(a[j]<=x)");
        model.addElement("               return;");
        model.addElement("          else {");
        model.addElement("               a[i]=a[j]");
        model.addElement("               a[j]=x;");
        model.addElement("               i=j;");
        model.addElement("               j=2*i+1;");
        model.addElement("               x=a[i];");
        model.addElement("          }");
        model.addElement("     }");
        model.addElement("}");
    }

    public void addQuickSort() {
        model.addElement("void QuickSort(int a[], int left, int right) {");
        model.addElement("     int i, j, x;");
        model.addElement("     x = a[(left+right)/2];");
        model.addElement("     i = left; j = right;");
        model.addElement("     while(i < j) {");
        model.addElement("          while(a[i] < x) i++;");
        model.addElement("          while(a[j] > x) j--;");
        model.addElement("          if(i <= j) {");
        model.addElement("               Swap(a[i],a[j]);");
        model.addElement("               i++ ; j--;");
        model.addElement("          }");
        model.addElement("     }");
        model.addElement("     if(left<j)");
        model.addElement("          QuickSort(a, left, j)");
        model.addElement("     if(i<right)");
        model.addElement("          QuickSort(a, i, right);");
        model.addElement("}");
    }

    public void addMergeSort() {
        model.addElement("void MergeSort(int left, int right) {");
        model.addElement("    if (left < right) {");
        model.addElement("        int mid = (left + right) / 2;");
        model.addElement("        MergeSort(left, mid);");
        model.addElement("        MergeSort(mid + 1, right);");
        model.addElement("        Merge(left, mid, right);");
        model.addElement("    }");
        model.addElement("}");
        model.addElement("");
        model.addElement("public void Merge(int left, int mid, int right) {");
        model.addElement("    int n1 = mid - left + 1;");
        model.addElement("    int n2 = right - mid;");
        model.addElement("    int[] T = new int[n1 + n2];");
        model.addElement("    int[] L = new int[n1];");
        model.addElement("    int[] R = new int[n2];");
        model.addElement("    int i, j, k;");
        model.addElement("    for (i = 0; i < n1; i ++)");
        model.addElement("        L[i] = array[left + i];");
        model.addElement("    for (j = 0; j < n2; j ++)");
        model.addElement("        R[j] = array[mid + 1 + j];");
        model.addElement("    i = 0; j = 0;");
        model.addElement("    k = left;");
        model.addElement("    while (i < n1 && j < n2) {");
        model.addElement("        if (L[i] <= R[j]) {");
        model.addElement("            array[k] = L[i];");
        model.addElement("            i ++;");
        model.addElement("        } else {");
        model.addElement("            array[k] = R[j];");
        model.addElement("            j ++;");
        model.addElement("        }");
        model.addElement("        k ++;");
        model.addElement("    }");
        model.addElement("    while (i < n1) {");
        model.addElement("        array[k] = L[i];");
        model.addElement("        i ++;");
        model.addElement("        k ++;");
        model.addElement("    }");
        model.addElement("    while (j < n2) {");
        model.addElement("        array[k] = R[j];");
        model.addElement("        j ++;");
        model.addElement("        k ++;");
        model.addElement("    }");
        model.addElement("}");
    }

    /*
     * Sort and Swap
     */
    public void Swap(JLabel lb1, JLabel lb2) {
        int x1 = lb1.getX();
        int x2 = lb2.getX();
        curT ++;

        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur-1].join();
                    }

                    lb1.setBackground(processingColor);
                    lb2.setBackground(processingColor);
                    while (lb1.getY() > 100) {
                        lb1.setLocation(lb1.getX(), lb1.getY() - 10);
                        lb2.setLocation(lb2.getX(), lb2.getY() + 10);
                        lbPointM.setLocation(x2, lbPointM.getY() + 10);
                        Thread.sleep(time);
                    }
                    while (lb1.getX() < x2) {
                        lb1.setLocation(lb1.getX() + 10, lb1.getY());
                        lb2.setLocation(lb2.getX() - 10, lb2.getY());
                        lbPointM.setLocation(lb2.getX(), 250);
                        Thread.sleep(time);
                    }
                    while (lb1.getY() < 140) {
                        lb1.setLocation(lb1.getX(), lb1.getY() + 10);
                        lb2.setLocation(lb2.getX(), lb2.getY() - 10);
                        lbPointM.setLocation(x1, lbPointM.getY() - 10);
                        Thread.sleep(time);
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    lb1.setLocation(x1, 150);
                    lb2.setLocation(x2, 150);
                    lb1.setBackground(SystemColor.inactiveCaption);
                    lb2.setBackground(SystemColor.inactiveCaption);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }

    public void Swap2(JLabel lb1, JLabel lb2) {
        int x1 = lb1.getX();
        int x2 = lb2.getX();
        curT2 ++;

        int cur = curT2;
        threads2[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads2[cur-1].join();
                    }

                    lb1.setBackground(processingColor);
                    lb2.setBackground(processingColor);
                    while (lb1.getY() > 100) {
                        lb1.setLocation(lb1.getX(), lb1.getY() - 10);
                        lb2.setLocation(lb2.getX(), lb2.getY() + 10);
                        lbPointM2.setLocation(x2, lbPointM2.getY() + 10);
                        Thread.sleep(time);
                    }
                    while (lb1.getX() < x2) {
                        lb1.setLocation(lb1.getX() + 10, lb1.getY());
                        lb2.setLocation(lb2.getX() - 10, lb2.getY());
                        lbPointM2.setLocation(lb2.getX(), 250);
                        Thread.sleep(time);
                    }
                    while (lb1.getY() < 140) {
                        lb1.setLocation(lb1.getX(), lb1.getY() + 10);
                        lb2.setLocation(lb2.getX(), lb2.getY() - 10);
                        lbPointM2.setLocation(x1, lbPointM2.getY() - 10);
                        Thread.sleep(time);
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    lb1.setLocation(x1, 150);
                    lb2.setLocation(x2, 150);
                    lb1.setBackground(SystemColor.inactiveCaption);
                    lb2.setBackground(SystemColor.inactiveCaption);
                } catch (Exception e) {
                }
            }
        });
        threads2[cur].start();
    }

    public void setlbPoint(JLabel lbPoint, int i, String s) {
        curT ++;
//        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0)
                        threads[cur - 1].join();
                    if (i == -1) {
                        lbPoint.setText("");
                        return;
                    }
                    if (s.charAt(0) == 'm') {
                        lbPoint.setLocation(lbArrays[i].getX(), 200);
                        lbPoint.setLocation(lbArrays2[i].getX(), 200);
                        lbPoint.setText(s);
                    } else if (s.charAt(0) == 'k') {
                        lbPoint.setLocation(oriLocat[i], 200);
                        lbPoint.setText(s + i);
                    } else {
                        lbPoint.setLocation(lbArrays[i].getX(), 275);
                        lbPoint.setLocation(lbArrays2[i].getX(), 275);
                        lbPoint.setText(s + i);
                    }
                } catch (Exception e){}
            }
        });
        threads[cur].start();
    }

    public void setlbPoint2(JLabel lbPoint, int i, String s) {
        curT2 ++;
//        System.out.println(curT2);
        int cur = curT2;
        threads2[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0)
                        threads2[cur - 1].join();
                    if (i == -1) {
                        lbPoint.setText("");
                        return;
                    }
                    if (s.charAt(0) == 'm') {
                        lbPoint.setLocation(lbArrays[i].getX(), 200);
                        lbPoint.setLocation(lbArrays2[i].getX(), 200);
                        lbPoint.setText(s);
                    } else if (s.charAt(0) == 'k') {
                        lbPoint.setLocation(oriLocat[i], 200);
                        lbPoint.setText(s + i);
                    } else {
                        lbPoint.setLocation(lbArrays[i].getX(), 275);
                        lbPoint.setLocation(lbArrays2[i].getX(), 275);
                        lbPoint.setText(s + i);
                    }
                } catch (Exception e){}
            }
        });
        threads2[cur].start();
    }

    /**
     * Interchange Sort
     */
    public void InterchangeSort() {
        long startTime = System.currentTimeMillis();
        if (isIncrease) {
            highLight(1);
            int i, j;
            for (i = 0 ; i < num ; i++) {
                highLight(2);
                setlbPoint(lbPoint1, i, "i = ");
                for (j = i + 1; j < num ; j++) {
                    setlbPoint(lbPoint2, j, "j = ");
                    highLight(3);
                    highLight(4);
                    if(array[j] < array[i]) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        highLight(5);
                        Swap(lbArrays[i], lbArrays[j]);
//                        Swap(lbArrays2[i], lbArrays2[j]);
                    }
                }
            }
            highLight(0);
        } else {
            highLight(1);
            int i, j;
            for (i = 0 ; i < num ; i++) {
                highLight(2);
                setlbPoint(lbPoint1, i, "i = ");
                for (j = i + 1; j < num ; j++) {
                    setlbPoint(lbPoint2, j, "j = ");
                    highLight(3);
                    highLight(4);
                    if(array[j] > array[i]) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        highLight(5);
                        Swap(lbArrays[i], lbArrays[j]);
//                        Swap(lbArrays2[i], lbArrays2[j]);
                    }
                }
            }
            highLight(0);
        }

        long endTime = System.currentTimeMillis();
        time1 = endTime - startTime;
    }

    public void InterchangeSort2() {
        long startTime = System.currentTimeMillis();
        if (isIncrease) {
            highLight2(1);
            int i, j;
            for (i = 0 ; i < num ; i++) {
                highLight2(2);
                setlbPoint2(lbPoint12, i, "i = ");
                for (j = i + 1; j < num ; j++) {
                    setlbPoint2(lbPoint22, j, "j = ");
                    highLight2(3);
                    highLight2(4);
                    if(array2[j] < array2[i]) {
                        int temp = array2[i];
                        array2[i] = array2[j];
                        array2[j] = temp;
                        highLight2(5);
//                        Swap(lbArrays[i], lbArrays[j]);
                        Swap2(lbArrays2[i], lbArrays2[j]);
                    }
                }
            }
            highLight2(0);
        } else {
            highLight2(1);
            int i, j;
            for (i = 0 ; i < num ; i++) {
                highLight2(2);
                setlbPoint2(lbPoint12, i, "i = ");
                for (j = i + 1; j < num ; j++) {
                    setlbPoint2(lbPoint22, j, "j = ");
                    highLight2(3);
                    highLight2(4);
                    if(array2[j] > array2[i]) {
                        int temp = array2[i];
                        array2[i] = array2[j];
                        array2[j] = temp;
                        highLight2(5);
//                        Swap(lbArrays[i], lbArrays[j]);
                        Swap2(lbArrays2[i], lbArrays2[j]);
                    }
                }
            }
            highLight2(0);
        }
        long endTime = System.currentTimeMillis();
        time2 = endTime-startTime;
    }

    /**
     * Selection Sort
     */
    public void SelectionSort() {
        long startTime = System.currentTimeMillis();
        if (isIncrease) {
            highLight(1);
            int min,i,j;
            for (i = 0; i < num - 1; i++) {
                highLight(2);
                setlbPoint(lbPoint1, i, "i = ");
                min = i;
                setlbPoint(lbPointM, i, "min");
                highLight(3);
                for(j = i + 1; j < num; j++) {
                    highLight(4);
                    highLight(5);
                    setlbPoint(lbPoint2, j, "j = ");
                    if (array[j] < array[min]) {
                        highLight(6);
                        min = j;
                        setlbPoint(lbPointM, j, "min");
                    }
                }
                if (min > i) {
                    int temp = array[min];
                    array[min] = array[i];
                    array[i] = temp;
                    highLight(7);
                    Swap(lbArrays[i], lbArrays[min]);
//                    Swap(lbArrays2[i], lbArrays2[min]);
                }
            }
        } else {
            highLight(1);
            int min,i,j;
            for (i = 0; i < num - 1; i++) {
                highLight(2);
                setlbPoint(lbPoint1, i, "i = ");
                min = i;
                setlbPoint(lbPointM, i, "max");
                highLight(3);
                for(j = i + 1; j < num; j++) {
                    highLight(4);
                    highLight(5);
                    setlbPoint(lbPoint2, j, "j = ");
                    if (array[j] > array[min]) {
                        highLight(6);
                        min = j;
                        setlbPoint(lbPointM, j, "max");
                    }
                }
                if (min > i) {
                    int temp = array[min];
                    array[min] = array[i];
                    array[i] = temp;
                    highLight(7);
                    Swap(lbArrays[i], lbArrays[min]);
//                    Swap(lbArrays2[i], lbArrays2[min]);
                }
            }
        }
        highLight(0);
        long endTime = System.currentTimeMillis();
        time1 = endTime-startTime;
    }

    public void SelectionSort2() {
        long startTime = System.currentTimeMillis();
        if (isIncrease) {
            highLight2(1);
            int min,i,j;
            for (i = 0; i < num - 1; i++) {
                highLight2(2);
                setlbPoint2(lbPoint12, i, "i = ");
                min = i;
                setlbPoint2(lbPointM2, i, "min");
                highLight2(3);
                for(j = i + 1; j < num; j++) {
                    highLight2(4);
                    highLight2(5);
                    setlbPoint2(lbPoint22, j, "j = ");
                    if (array2[j] < array2[min]) {
                        highLight2(6);
                        min = j;
                        setlbPoint2(lbPointM2, j, "min");
                    }
                }
                if (min > i) {
                    int temp = array2[min];
                    array2[min] = array2[i];
                    array2[i] = temp;
                    highLight2(7);
//                    Swap(lbArrays[i], lbArrays[min]);
                    Swap2(lbArrays2[i], lbArrays2[min]);
                }
            }
        } else {
            highLight2(1);
            int min,i,j;
            for (i = 0; i < num - 1; i++) {
                highLight2(2);
                setlbPoint2(lbPoint12, i, "i = ");
                min = i;
                setlbPoint2(lbPointM2, i, "max");
                highLight2(3);
                for(j = i + 1; j < num; j++) {
                    highLight2(4);
                    highLight2(5);
                    setlbPoint2(lbPoint22, j, "j = ");
                    if (array2[j] > array2[min]) {
                        highLight2(6);
                        min = j;
                        setlbPoint2(lbPointM2, j, "max");
                    }
                }
                if (min > i) {
                    int temp = array2[min];
                    array2[min] = array2[i];
                    array2[i] = temp;
                    highLight2(7);
//                    Swap(lbArrays[i], lbArrays[min]);
                    Swap2(lbArrays2[i], lbArrays2[min]);
                }
            }
        }
        highLight2(0);
        long endTime = System.currentTimeMillis();
        time2 = endTime-startTime;
    }

    /*
     * Bubble Sort
     */
    public void BubbleSort() {
        long startTime = System.currentTimeMillis();
        if (isIncrease) {
            highLight(1);
            int i, j;
            for (i = 0; i< num; i++) {
                highLight(2);
                setlbPoint(lbPoint1, i, "i = ");
                for (j = num - 1; j > i; j--) {
                    highLight(3);
                    highLight(4);
                    setlbPoint(lbPoint2, j, "j = ");
                    if(array[j]< array[j-1]) {
                        int temp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = temp;
                        highLight(5);
                        Swap(lbArrays[j - 1], lbArrays[j]);
                        Swap(lbArrays2[j - 1], lbArrays2[j]);
                    }
                }
            }
            highLight(0);
        } else {
            highLight(1);
            int i, j;
            for (i = 0; i< num; i++) {
                highLight(2);
                setlbPoint(lbPoint1, i, "i = ");
                for (j = num - 1; j > i; j--) {
                    highLight(3);
                    highLight(4);
                    setlbPoint(lbPoint2, j, "j = ");
                    if(array[j] > array[j-1]) {
                        int temp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = temp;
                        highLight(5);
                        Swap(lbArrays[j - 1], lbArrays[j]);
                        Swap(lbArrays2[j - 1], lbArrays2[j]);
                    }
                }
            }
            highLight(0);
        }
        long endTime = System.currentTimeMillis();
        time1 = endTime-startTime;
    }

    public void BubbleSort2() {
        long startTime = System.currentTimeMillis();
        if (isIncrease) {
            highLight2(1);
            int i, j;
            for (i = 0; i< num; i++) {
                highLight2(2);
                setlbPoint2(lbPoint12, i, "i = ");
                for (j = num - 1; j > i; j--) {
                    highLight2(3);
                    highLight2(4);
                    setlbPoint2(lbPoint22, j, "j = ");
                    if(array2[j]< array2[j-1]) {
                        int temp = array2[j];
                        array2[j] = array2[j - 1];
                        array2[j - 1] = temp;
                        highLight2(5);
                        Swap2(lbArrays2[j - 1], lbArrays2[j]);
                    }
                }
            }
            highLight2(0);
        } else {
            highLight2(1);
            int i, j;
            for (i = 0; i< num; i++) {
                highLight2(2);
                setlbPoint2(lbPoint12, i, "i = ");
                for (j = num - 1; j > i; j--) {
                    highLight2(3);
                    highLight2(4);
                    setlbPoint2(lbPoint22, j, "j = ");
                    if(array2[j] > array2[j-1]) {
                        int temp = array2[j];
                        array2[j] = array2[j - 1];
                        array2[j - 1] = temp;
                        highLight2(5);
                        Swap2(lbArrays2[j - 1], lbArrays2[j]);
                    }
                }
            }
            highLight2(0);
        }
        long endTime = System.currentTimeMillis();
        time2 = endTime-startTime;
    }

    public void Move(JLabel lb1, JLabel lb2, int pos) {
        int x1 = lb1.getX();
        int x2 = lb2.getX();
        curT ++;

        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    lb1.setOpaque(true);
                    lb2.setOpaque(true);
                    lb1.setBackground(processingColor);
                    lb2.setBackground(processingColor);
                    while (lb1.getY() > 100) {
                        lb1.setLocation(lb1.getX(), lb1.getY() - 10);
                        Thread.sleep(time);
                    }
                    while (lb1.getX() > x2) {
                        lb2.setLocation(lb2.getX() + 10, lb2.getY());
                        lb1.setLocation(lb1.getX() - 10, lb1.getY());
                        Thread.sleep(time);
                    }
                    while (pos == 0 && lb1.getY() < 150) {
                        lb1.setLocation(lb1.getX(), lb1.getY() + 10);
                        Thread.sleep(time);
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    int y1 = lb1.getY();
                    lb1.setLocation(x1, lb2.getY());
                    lb2.setLocation(x2, y1);
                    lb1.setBackground(SystemColor.inactiveCaption);
                    if (pos == 0)
                        lb2.setBackground(SystemColor.inactiveCaption);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }

    public void Move2(JLabel lb1, JLabel lb2, int pos) {
        int x1 = lb1.getX();
        int x2 = lb2.getX();
        curT2++;

        int cur = curT2;
        threads2[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads2[cur - 1].join();
                    }
                    lb1.setOpaque(true);
                    lb2.setOpaque(true);
                    lb1.setBackground(processingColor);
                    lb2.setBackground(processingColor);
                    while (lb1.getY() > 100) {
                        lb1.setLocation(lb1.getX(), lb1.getY() - 10);
                        Thread.sleep(time);
                    }
                    while (lb1.getX() > x2) {
                        lb2.setLocation(lb2.getX() + 10, lb2.getY());
                        lb1.setLocation(lb1.getX() - 10, lb1.getY());
                        Thread.sleep(time);
                    }
                    while (pos == 0 && lb1.getY() < 150) {
                        lb1.setLocation(lb1.getX(), lb1.getY() + 10);
                        Thread.sleep(time);
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    int y1 = lb1.getY();
                    lb1.setLocation(x1, lb2.getY());
                    lb2.setLocation(x2, y1);
                    lb1.setBackground(SystemColor.inactiveCaption);
                    if (pos == 0)
                        lb2.setBackground(SystemColor.inactiveCaption);
                } catch (Exception e) {
                }
            }
        });
        threads2[cur].start();
    }

    /*
     * Insertion Sort
     */
    public void InsertionSort() {
        long startTime = System.currentTimeMillis();
        if (isIncrease) {
            int pos, i;
            highLight(1);
            int x;
            highLight(2);
            for (i = 1; i < num; i++) {
                highLight(3);
                setlbPoint(lbPoint1, i, "i = ");
                x = array[i];
                highLight(4);
                pos = i - 1;
                highLight(5);
                while ((pos >= 0) && (array[pos] > x)) {
                    highLight(6);
                    setlbPoint(lbPoint2, pos, "j = ");
                    array[pos + 1] = array[pos];
                    highLight(7);
                    if (pos > 0 && array[pos - 1] <= x) {
                        Move(lbArrays[pos + 1], lbArrays[pos], 0);
                    } else {
                        Move(lbArrays[pos + 1], lbArrays[pos], pos);
                    }
                    pos--;
                    highLight(8);
                }
                highLight(9);
                array[pos + 1] = x;
                setlbPoint(lbPoint2, -1, null);
            }
            highLight(0);
        }
        else {
            int pos, i;
            highLight(1);
            int x;
            highLight(2);
            for (i = 1; i < num; i++) {
                highLight(3);
                setlbPoint(lbPoint1, i, "i = ");
                x = array[i];
                highLight(4);
                pos = i - 1;
                highLight(5);
                while ((pos >= 0) && (array[pos] < x)) {
                    highLight(6);
                    setlbPoint(lbPoint2, pos, "j = ");
                    array[pos + 1] = array[pos];
                    highLight(7);
                    if (pos > 0 && array[pos - 1] >= x) {
                        Move(lbArrays[pos + 1], lbArrays[pos], 0);
                    } else {
                        Move(lbArrays[pos + 1], lbArrays[pos], pos);
                    }
                    pos--;
                    highLight(8);
                }
                array[pos + 1] = x;
                highLight(9);
                setlbPoint(lbPoint2, -1, null);
            }
            highLight(0);
        }
        long endTime = System.currentTimeMillis();
        time2 = endTime-startTime;
    }

    public void InsertionSort2() {
        long startTime = System.currentTimeMillis();
        if (isIncrease) {
            int pos, i;
            highLight2(1);
            int x;
            highLight2(2);
            for (i = 1; i < num; i++) {
                highLight2(3);
                setlbPoint2(lbPoint12, i, "i = ");
                x = array2[i];
                highLight2(4);
                pos = i - 1;
                highLight2(5);
                while ((pos >= 0) && (array2[pos] > x)) {
                    highLight2(6);
                    setlbPoint2(lbPoint22, pos, "j = ");
                    array2[pos + 1] = array2[pos];
                    highLight2(7);
                    if (pos > 0 && array2[pos - 1] <= x) {
                        Move2(lbArrays2[pos + 1], lbArrays2[pos], 0);
                    } else {
                        Move2(lbArrays2[pos + 1], lbArrays2[pos], pos);
                    }
                    pos--;
                    highLight2(8);
                }
                highLight2(9);
                array2[pos + 1] = x;
                setlbPoint2(lbPoint22, -1, null);
            }
            highLight2(0);
        }
        else {
            int pos, i;
            highLight2(1);
            int x;
            highLight2(2);
            for (i = 1; i < num; i++) {
                highLight2(3);
                setlbPoint2(lbPoint12, i, "i = ");
                x = array2[i];
                highLight2(4);
                pos = i - 1;
                highLight2(5);
                while ((pos >= 0) && (array2[pos] < x)) {
                    highLight2(6);
                    setlbPoint2(lbPoint22, pos, "j = ");
                    array2[pos + 1] = array2[pos];
                    highLight2(7);
                    if (pos > 0 && array2[pos - 1] >= x) {
                        Move2(lbArrays2[pos + 1], lbArrays2[pos], 0);
                    } else {
                        Move2(lbArrays2[pos + 1], lbArrays2[pos], pos);
                    }
                    pos--;
                    highLight2(8);
                }
                array2[pos + 1] = x;
                highLight2(9);
                setlbPoint2(lbPoint22, -1, null);
            }
            highLight2(0);
        }
        long endTime = System.currentTimeMillis();
        time2 = endTime-startTime;
    }

    /*
     * Shell Sort
     */

    public void MoveShell(JLabel lb1, JLabel lb2,  int next) {
        int x1 = lb1.getX();
        int x2 = lb2.getX();
        curT ++;

        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    setBackgroundMoving(lb1, lb2);
                    while (lb2.getY() < 200) {
                        if (lb1.getY() > 100)
                            lb1.setLocation(lb1.getX(), lb1.getY() - 10);
                        lb2.setLocation(lb2.getX(), lb2.getY() + 10);
                        Thread.sleep(time);
                    }
                    while (lb1.getX() > x2) {
                        lb2.setLocation(lb2.getX() + 10, lb2.getY());
                        lb1.setLocation(lb1.getX() - 10, lb1.getY());
                        Thread.sleep(time);
                    }
                    while (lb2.getY() > 150) {
                        if (next == 0) {
                            lb1.setLocation(lb1.getX(), lb1.getY() + 10);
                        }
                        lb2.setLocation(lb2.getX(), lb2.getY() - 10);
                        Thread.sleep(time);
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    int y1 = lb1.getY();
                    lb1.setLocation(x1, lb2.getY());
                    lb2.setLocation(x2, y1);
                    if (next == 0)
                        setBackgroundDone(lb1, lb2);
                    else
                        lb1.setBackground(SystemColor.inactiveCaption);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }

    public void MoveShell2(JLabel lb1, JLabel lb2,  int next) {
        int x1 = lb1.getX();
        int x2 = lb2.getX();
        curT2++;

        int cur = curT2;
        threads2[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads2[cur - 1].join();
                    }
                    setBackgroundMoving(lb1, lb2);
                    while (lb2.getY() < 200) {
                        if (lb1.getY() > 100)
                            lb1.setLocation(lb1.getX(), lb1.getY() - 10);
                        lb2.setLocation(lb2.getX(), lb2.getY() + 10);
                        Thread.sleep(time);
                    }
                    while (lb1.getX() > x2) {
                        lb2.setLocation(lb2.getX() + 10, lb2.getY());
                        lb1.setLocation(lb1.getX() - 10, lb1.getY());
                        Thread.sleep(time);
                    }
                    while (lb2.getY() > 150) {
                        if (next == 0) {
                            lb1.setLocation(lb1.getX(), lb1.getY() + 10);
                        }
                        lb2.setLocation(lb2.getX(), lb2.getY() - 10);
                        Thread.sleep(time);
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    int y1 = lb1.getY();
                    lb1.setLocation(x1, lb2.getY());
                    lb2.setLocation(x2, y1);
                    if (next == 0)
                        setBackgroundDone(lb1, lb2);
                    else
                        lb1.setBackground(SystemColor.inactiveCaption);
                } catch (Exception e) {
                }
            }
        });
        threads2[cur].start();
    }

    public void ShellSort() {
        long startTime = System.currentTimeMillis();
        if (isIncrease) {
            int len, i, j, x;
            highLight(1);
            for (len = 11; len > 0; len /= 2) {
                highLight(2);
                for (i = len; i < num; i ++) {
                    highLight(3);
                    setlbPoint(lbPoint1, i, "i = ");
                    x = array[i];
                    highLight(4);
                    j = i - len;
                    highLight(5);
                    while (j >= 0 && x < array[j]) {
                        highLight(6);
                        setlbPoint(lbPoint2, j, "j = ");
                        array[j + len] = array[j];
                        highLight(7);
                        if (len > 1) {
                            if (j < len) {
                                MoveShell(lbArrays[j + len], lbArrays[j], 0);
                            } else {
                                if (x >= array[j - len])
                                    MoveShell(lbArrays[j + len], lbArrays[j], 0);
                                else
                                    MoveShell(lbArrays[j + len], lbArrays[j], 1);
                            }
                        } else {
                            if (j < len) {
                                Move(lbArrays[j + len], lbArrays[j], 0);
                            } else {
                                if (x >= array[j - len])
                                    Move(lbArrays[j + len], lbArrays[j], 0);
                                else
                                    Move(lbArrays[j + len], lbArrays[j], 1);
                            }
                        }
                        j -= len;
                        highLight(8);
                    }
                    array[j + len] = x;
                    highLight(9);
                    setlbPoint(lbPoint2, -1, null);
                }
            }
            highLight(0);
        }
        else {
            int len, i, j, x;
            highLight(1);
            for (len = 11; len > 0; len /= 2) {
                highLight(2);
                for (i = len; i < num; i ++) {
                    highLight(3);
                    setlbPoint(lbPoint1, i, "i = ");
                    x = array[i];
                    highLight(4);
                    j = i - len;
                    highLight(5);
                    while (j >= 0 && x > array[j]) {
                        highLight(6);
                        setlbPoint(lbPoint2, j, "j = ");
                        array[j + len] = array[j];
                        highLight(7);
                        if (len > 1) {
                            if (j < len) {
                                MoveShell(lbArrays[j + len], lbArrays[j], 0);
                            } else {
                                if (x <= array[j - len])
                                    MoveShell(lbArrays[j + len], lbArrays[j], 0);
                                else
                                    MoveShell(lbArrays[j + len], lbArrays[j], 1);
                            }
                        } else {
                            if (j < len) {
                                Move(lbArrays[j + len], lbArrays[j], 0);
                            } else {
                                if (x <= array[j - len])
                                    Move(lbArrays[j + len], lbArrays[j], 0);
                                else
                                    Move(lbArrays[j + len], lbArrays[j], 1);
                            }
                        }
                        j -= len;
                        highLight(8);
                    }
                    array[j + len] = x;
                    highLight(9);
                    setlbPoint(lbPoint2, -1, null);
                }
            }
        }
        highLight(0);
        long endTime = System.currentTimeMillis();
        time1 = endTime-startTime;
    }

    public void ShellSort2() {
        long startTime = System.currentTimeMillis();
        if (isIncrease) {
            int len, i, j, x;
            highLight2(1);
            for (len = 11; len > 0; len /= 2) {
                highLight2(2);
                for (i = len; i < num; i ++) {
                    highLight2(3);
                    setlbPoint2(lbPoint12, i, "i = ");
                    x = array2[i];
                    highLight2(4);
                    j = i - len;
                    highLight2(5);
                    while (j >= 0 && x < array2[j]) {
                        highLight2(6);
                        setlbPoint2(lbPoint22, j, "j = ");
                        array2[j + len] = array2[j];
                        highLight2(7);
                        if (len > 1) {
                            if (j < len) {
                                MoveShell2(lbArrays2[j + len], lbArrays2[j], 0);
                            } else {
                                if (x >= array2[j - len])
                                    MoveShell2(lbArrays2[j + len], lbArrays2[j], 0);
                                else
                                    MoveShell2(lbArrays2[j + len], lbArrays2[j], 1);
                            }
                        } else {
                            if (j < len) {
                                Move2(lbArrays2[j + len], lbArrays2[j], 0);
                            } else {
                                if (x >= array2[j - len])
                                    Move2(lbArrays2[j + len], lbArrays2[j], 0);
                                else
                                    Move2(lbArrays2[j + len], lbArrays2[j], 1);
                            }
                        }
                        j -= len;
                        highLight2(8);
                    }
                    array2[j + len] = x;
                    highLight2(9);
                    setlbPoint2(lbPoint22, -1, null);
                }
            }
            highLight2(0);
        }
        else {
            int len, i, j, x;
            highLight2(1);
            for (len = 11; len > 0; len /= 2) {
                highLight2(2);
                for (i = len; i < num; i ++) {
                    highLight2(3);
                    setlbPoint2(lbPoint12, i, "i = ");
                    x = array2[i];
                    highLight2(4);
                    j = i - len;
                    highLight2(5);
                    while (j >= 0 && x > array2[j]) {
                        highLight2(6);
                        setlbPoint2(lbPoint22, j, "j = ");
                        array2[j + len] = array2[j];
                        highLight2(7);
                        if (len > 1) {
                            if (j < len) {
                                MoveShell2(lbArrays2[j + len], lbArrays2[j], 0);
                            } else {
                                if (x <= array[j - len])
                                    MoveShell2(lbArrays2[j + len], lbArrays2[j], 0);
                                else
                                    MoveShell2(lbArrays2[j + len], lbArrays2[j], 1);
                            }
                        } else {
                            if (j < len) {
                                Move2(lbArrays2[j + len], lbArrays2[j], 0);
                            } else {
                                if (x <= array2[j - len])
                                    Move2(lbArrays2[j + len], lbArrays2[j], 0);
                                else
                                    Move2(lbArrays2[j + len], lbArrays2[j], 1);
                            }
                        }
                        j -= len;
                        highLight2(8);
                    }
                    array2[j + len] = x;
                    highLight2(9);
                    setlbPoint2(lbPoint2, -1, null);
                }
            }
        }
        highLight2(0);
        long endTime = System.currentTimeMillis();
        time2 = endTime-startTime;
    }

    // <editor-fold defaultstate="collapsed" desc="HeapSort">
    public void MovetoLocation(JLabel lb1, int x, int y) {
        curT ++;

        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    lb1.setBackground(processingColor);
                    int x1 = lb1.getX();
                    int y1 = lb1.getY();
                    if (x1 < x && y1 < y) {
                        while (lb1.getX() < x) {
                            lb1.setLocation(lb1.getX() + 10, y1);
                            Thread.sleep(time);
                        }
                        while (lb1.getY() < y) {
                            lb1.setLocation(x, lb1.getY() + 10);
                            Thread.sleep(time);
                        }
                    } else if (x1 >= x && y1 < y) {
                        while (lb1.getX() > x) {
                            lb1.setLocation(lb1.getX() - 10, y1);
                            Thread.sleep(time);
                        }
                        while (lb1.getY() < y) {
                            lb1.setLocation(x, lb1.getY() + 10);
                            Thread.sleep(time);
                        }
                    } else if (x1 < x && y1 >= y) {
                        while (lb1.getY() > y) {
                            lb1.setLocation(x1, lb1.getY() - 10);
                            Thread.sleep(time);
                        }
                        while (lb1.getX() < x) {
                            lb1.setLocation(lb1.getX() + 10, y);
                            Thread.sleep(time);
                        }
                    } else if (x1 >= x && y1 >= y) {
                        while (lb1.getY() > y) {
                            lb1.setLocation(x1, lb1.getY() - 10);
                            Thread.sleep(time);
                        }
                        while (lb1.getX() > x) {
                            lb1.setLocation(lb1.getX() - 10, y);
                            Thread.sleep(time);
                        }
                    }
                    lb1.setBackground(SystemColor.inactiveCaption);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }

    public void HeapLocationInit() {
        int i, j = 0;
        int row = 1;
        int maxirow = 0;
        int[] xi = {600, 480, 720, 420, 540, 660, 780, 390, 450, 510, 570, 630, 690, 750, 810};
        int[] yi = {60, 110, 160, 210};
        MovetoLocation(lbArrays[0], xi[0], yi[0]);
        for (i = 0; i <= (num - 1) / 2; i ++) {
            if (i > maxirow) {
                row ++;
                maxirow = maxirow * 2 + 2;
            }
            j = i * 2 + 1;
            while (j <= i * 2 + 2 && j < num) {
                if (j == i * 2 + 1) {
                    MovetoLocation(lbArrays[j], xi[j], yi[row]);
                } else {
                    MovetoLocation(lbArrays[j], xi[j], yi[row]);
                }
                j ++;
            }
        }
    }

    public void SwapinHeap(JLabel lb1, JLabel lb2) {
        curT ++;
//        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur-1].join();
                    }
                    setBackgroundMoving(lb1, lb2);
                    int x1 = lb1.getX();
                    int x2 = lb2.getX();
                    int y1 = lb1.getY();
                    int y2 = lb2.getY();
                    while (lb2.getY() > y1) {
                        if (lb1.getY() > y1 - 50)
                            lb1.setLocation(lb1.getX(), lb1.getY() - 10);
                        lb2.setLocation(lb2.getX(), lb2.getY() - 10);
                        Thread.sleep(time);
                    }
                    if (x2 < x1) {
                        while (lb2.getX() < x1) {
                            lb1.setLocation(lb1.getX() - 10, lb1.getY());
                            lb2.setLocation(lb2.getX() + 10, lb2.getY());
                            Thread.sleep(time);
                        }
                    } else {
                        while (lb2.getX() > x1) {
                            lb1.setLocation(lb1.getX() + 10, lb1.getY());
                            lb2.setLocation(lb2.getX() - 10, lb2.getY());
                            Thread.sleep(time);
                        }
                    }
                    while (lb1.getY() < y2) {
                        lb1.setLocation(lb1.getX(), lb1.getY() + 10);
                        Thread.sleep(time);
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    lb1.setLocation(x1, y1);
                    lb2.setLocation(x2, y2);
                    setBackgroundDone(lb1, lb2);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }

    public void SwapHeapEnd(JLabel lb1, JLabel lb2, int xend) {
        MovetoLocation(lb1, xend, 260);
        MovetoLocation(lb2, 600, 60);
        SwapwithoutMoving(lb1, lb2);
    }

    public void SwapwithoutMoving(JLabel lb1, JLabel lb2) {
        curT ++;
//        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    int x = lb1.getX();
                    int y = lb1.getY();
                    lb1.setLocation(lb2.getX(), lb2.getY());
                    lb2.setLocation(x, y);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }

    public void Shift(int l, int r) {
        int x, i ,j;
        highLight(23);
        i = l;
        highLight(24);
        j = i * 2 + 1;
        highLight(25);
        x = array[i];
        if (isIncrease) {
            while (j <= r) {
                highLight(26);
                highLight(27);
                if (j < r) {
                    highLight(28);
                    if (array[j] < array[j + 1]) {
                        highLight(29);
                        j++;
                    }
                }
                highLight(30);
                if (array[j] <= x) {
                    highLight(31);
                    return;
                } else {
                    highLight(33);
                    array[i] = array[j];
                    highLight(34);
                    array[j] = x;
                    SwapinHeap(lbArrays[i], lbArrays[j]);
                    highLight(35);
                    i = j;
                    highLight(36);
                    j = i * 2 + 1;
                    highLight(37);
                    x = array[i];
                }
            }
        } else {
            while (j <= r) {
                highLight(26);
                highLight(27);
                if (j < r) {
                    highLight(28);
                    if (array[j] > array[j + 1]) {
                        highLight(29);
                        j ++;
                    }
                }
                highLight(30);
                if (array[j] >= x) {
                    highLight(31);
                    return;
                } else {
                    highLight(33);
                    array[i] = array[j];
                    highLight(34);
                    array[j] = x;
                    SwapinHeap(lbArrays[i], lbArrays[j]);
                    highLight(35);
                    i = j;
                    highLight(36);
                    j = i * 2 + 1;
                    highLight(37);
                    x = array[i];
                }
            }
        }
    }

    public void CreateHeap() {
        int l;
        highLight(14);
        l = num / 2 - 1;
        while (l >= 0) {
            highLight(15);
            highLight(16);
            Shift(l, num - 1);
            highLight(17);
            l --;
        }
    }

    public void HeapSort() {
        int r;
        int xend = ((int) ((18 - num) * 0.5) * 70) + 100 + (num - 1) * 70;
        HeapLocationInit();
        highLight(2);
        CreateHeap();
        highLight(3);
        r = num - 1;
        while (r > 0) {
            highLight(4);
            highLight(5);
            int x = array[0];
            array[0] = array[r];
            array[r] = x;
            SwapHeapEnd(lbArrays[0], lbArrays[r], xend);
            xend -= 70;
            highLight(6);
            r --;
            highLight(7);
            if (r > 0) {
                highLight(8);
                Shift(0, r);
            }
        }
        SwapHeapEnd(lbArrays[0], null, xend);
    }
    // </editor-fold>

    /*
     * HightLight lines
     */
    public void highLight(int line) {
        curT++;

        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur-1].join();
                    }
//                    lsCode.setSelectedIndex(line);
//                    lsCode.ensureIndexIsVisible(line); // Tu cuon den dong dang highlight
                    Thread.sleep(time);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        threads[cur].start();
    }

    public void highLight2(int line) {
        curT2++;

        int cur = curT2;
        threads2[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads2[cur-1].join();
                    }
//                    lsCode.setSelectedIndex(line);
//                    lsCode.ensureIndexIsVisible(line); // Tu cuon den dong dang highlight
                    Thread.sleep(time);
                } catch (Exception e) {

                }
            }
        });
        threads2[cur].start();
    }

    /*
     * Stop all Threads[]
     */

    public void stopAllThreads() {
        for (int i = 0; i < curT; i++) {
            try {
                threads[i].interrupt();
            } catch (Exception e) {

            }
        }
        curT = -1;
    }

    /*
     * Waiting to end sorting
     */
    public void waitEnd() {
        curT++;

        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur-1].join();
                    }
                    setState(4);
                    for (int i = 0; i < num; i++) {
                        lbArrays[i].setForeground(Color.darkGray);
//                        lbArrays2[i].setForeground(Color.darkGray);
                    }
                    lbPoint1.setText("");
                    lbPoint2.setText("");
                    lbPointM.setText("");

//                    lbPoint12.setText("");
//                    lbPoint22.setText("");
//                    lbPointM2.setText("");

//                    FormCompleteSorted form = new FormCompleteSorted();
//                    form.setVisible(true);
                } catch (Exception e) {

                }
            }
        });
        threads[cur].start();
    }

    public void waitEnd2() {
        curT2++;

        int cur = curT2;
        threads2[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads2[cur-1].join();
                    }
                    setState(4);
                    for (int i = 0; i < num; i++) {
//                        lbArrays[i].setForeground(Color.darkGray);
                        lbArrays2[i].setForeground(Color.darkGray);
                    }
//                    lbPoint1.setText("");
//                    lbPoint2.setText("");
//                    lbPointM.setText("");

                    lbPoint12.setText("");
                    lbPoint22.setText("");
                    lbPointM2.setText("");

//                    FormCompleteSorted form = new FormCompleteSorted();
//                    form.setVisible(true);
                } catch (Exception e) {

                }
            }
        });
        threads2[cur].start();
    }

    // <editor-fold defaultstate="collapsed" desc="QuickSort">
    public void QuickSort() {
        QuickSortAl(0, num - 1);
        QuickSortAnimation();
        step = 0;
    }

    public void Coloring(JLabel lb1, Color c) {
        curT ++;
//        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0)
                        threads[cur - 1].join();
                    lb1.setBackground(c);
                    Thread.sleep(time);
                } catch (Exception e) {}
            }
        });
        threads[cur].start();
    }

    public void Coloring(int left, int right, Color c) {
        curT ++;
//        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0)
                        threads[cur - 1].join();
                    int i = left;
                    while (i <= right) {
                        if (i != (left + right) / 2)
                            lbArrays[i].setBackground(c);
                        i ++;
                    }
                    Thread.sleep(time);
                } catch (Exception e) {}
            }
        });
        threads[cur].start();
    }

    public void QuickSortAnimation() {
        int s, i, j;
        for (s = 0; s < step; s ++) {
            i = lbI[s];
            j = lbJ[s];
            setlbPoint(lbPoint1, i, "i = ");
            setlbPoint(lbPoint2, j, "j = ");
            if (i != j) {
                Coloring(lbArrays[(lbL[s] + lbR[s]) / 2], selectedGreen);
                Coloring(lbL[s], lbR[s], selectedYellow);
                Swap(lbArrays[i], lbArrays[j]);
            }
            if (lbL[s + 1] + lbR[s + 1] != lbL[s] + lbR[s]) {
                Coloring(lbArrays[(lbL[s] + lbR[s]) / 2], SystemColor.inactiveCaption);
                Coloring(lbL[s], lbR[s], SystemColor.inactiveCaption);
            }
        }
    }

    public void QuickSortAl(int left, int right) {
        if (isIncrease) {
            int i, j, x;
            x = array[(left + right) / 2];
            i = left; j = right;
            while (i < j) {
                while (array[i] < x) {
                    i ++;
                }
                while (array[j] > x) {
                    j --;
                }
                if (i <= j) {
                    if (array[i] != array[j]) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        if (i != j) {
                            lbL[step] = left; lbR[step] = right;
                            lbI[step] = i; lbJ[step] = j;
                            step ++;
                        }
                    }
                    i ++; j --;
                }
            }
            if (left < j)
                QuickSortAl(left, j);
            if (i < right)
                QuickSortAl(i, right);
        }
        else {
            int i, j, x;
            x = array[(left + right) / 2];
            i = left; j = right;
            while (i < j) {
                while (array[i] > x) {
                    i ++;
                }
                while (array[j] < x) {
                    j --;
                }
                if (i <= j) {
                    if (array[i] != array[j]) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        if (i != j) {
                            lbL[step] = left; lbR[step] = right;
                            lbI[step] = i; lbJ[step] = j;
                            step ++;
                        }
                    }
                    i ++; j --;
                }
            }
            if (left < j)
                QuickSortAl(left, j);
            if (i < right)
                QuickSortAl(i, right);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="MergeSort">
    public void PutUp(int left, int right) {
        curT ++;
//        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0)
                        threads[cur - 1].join();
                    int mid = (left + right) / 2;
                    for (int i = left; i <= right; i ++) {
                        if (i < mid + 1) {
                            lbArrays[i].setBackground(selectedGreen);
                            lbArrays2[i].setBackground(selectedGreen);
                        }
                        else{
                            lbArrays[i].setBackground(selectedYellow);
                            lbArrays2[i].setBackground(selectedYellow);
                        }
                    }
                    while (lbArrays[right].getY() > 50) {
                        for (int i = left; i <= right; i ++) {
                            if (lbArrays[i].getY() > 50){
                                lbArrays[i].setLocation(lbArrays[i].getX(), lbArrays[i].getY() - 10);
                                lbArrays2[i].setLocation(lbArrays[i].getX(), lbArrays[i].getY() - 10);
                            }

                        }
                        Thread.sleep(time);
                    }
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }

    public void PutDown(JLabel lb1, int x, int y) {
        curT ++;
//        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    int x1 = lb1.getX();
                    lb1.setBackground(processingColor);
                    while (lb1.getY() < 100) {
                        lb1.setLocation(x1, lb1.getY() + 10);
                        Thread.sleep(time);
                    }
                    int y1 = lb1.getY();
                    if (x1 < x) {
                        while (lb1.getX() < x) {
                            lb1.setLocation(lb1.getX() + 10, y1);
                            Thread.sleep(time);
                        }
                        while (lb1.getY() < y) {
                            lb1.setLocation(x, lb1.getY() + 10);
                            Thread.sleep(time);
                        }
                    } else {
                        while (lb1.getX() > x) {
                            lb1.setLocation(lb1.getX() - 10, y1);
                            Thread.sleep(time);
                        }
                        while (lb1.getY() < y) {
                            lb1.setLocation(x, lb1.getY() + 10);
                            Thread.sleep(time);
                        }
                    }
                    lb1.setBackground(SystemColor.inactiveCaption);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }

    public void Relocat(int left, int right, int[] T) {
        curT ++;
//        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0)
                        threads[cur - 1].join();
                    for (int i = left; i <= right; i ++) {
                        if (lbArrays[i].getX() != oriLocat[i]) {
                            lbArrays[i].setLocation(oriLocat[i], 150);
                            lbArrays[i].setText(T[i - left] + "");
                            lbArrays2[i].setLocation(oriLocat[i], 150);
                            lbArrays2[i].setText(T[i - left] + "");
                        }
                    }
                    Thread.sleep(time);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }

    public void Merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] T = new int[n1 + n2];
        int[] L = new int[n1];
        int[] R = new int[n2];
        int i, j, k;
        highLight(16);
        for (i = 0; i < n1; i ++)
            L[i] = array[left + i];
        highLight(18);
        for (j = 0; j < n2; j ++)
            R[j] = array[mid + 1 + j];
        setlbPoint(lbPoint1, left, "i = ");
        setlbPoint(lbPoint2, mid + 1, "j = ");
        PutUp(left, right);
        if (isIncrease) {
            i = 0; j = 0;
            k = left;
            while (i < n1 && j < n2) {
                highLight(22);
                setlbPoint(lbPointM, k, "k = ");
                highLight(23);
                if (L[i] <= R[j]) {
                    setlbPoint(lbPoint1, left + i, "i = ");
                    highLight(24);
                    array[k] = L[i];
                    PutDown(lbArrays[left + i], oriLocat[k], 150);
                    highLight(25);
                    i ++;
                } else {
                    setlbPoint(lbPoint2, mid + 1 + j, "j = ");
                    highLight(27);
                    array[k] = R[j];
                    PutDown(lbArrays[mid + 1 + j], oriLocat[k], 150);
                    highLight(28);
                    j ++;
                }
                highLight(30);
                k ++;
            }
            while (i < n1) {
                highLight(32);
                setlbPoint(lbPointM, k, "k = ");
                setlbPoint(lbPoint1, left + i, "i = ");
                highLight(33);
                array[k] = L[i];
                PutDown(lbArrays[left + i], oriLocat[k], 150);
                i ++;
                k ++;
            }
            while (j < n2) {
                highLight(37);
                setlbPoint(lbPointM, k, "k = ");
                setlbPoint(lbPoint2, mid + 1 + j, "j = ");
                highLight(38);
                array[k] = R[j];
                PutDown(lbArrays[mid + 1 + j], oriLocat[k], 150);
                j ++;
                k ++;
            }
        } else {
            i = 0; j = 0;
            k = left;
            while (i < n1 && j < n2) {
                highLight(22);
                setlbPoint(lbPointM, k, "k = ");
                highLight(23);
                if (L[i] >= R[j]) {
                    setlbPoint(lbPoint1, left + i, "i = ");
                    highLight(24);
                    array[k] = L[i];
                    PutDown(lbArrays[left + i], oriLocat[k], 150);
                    highLight(25);
                    i ++;
                } else {
                    setlbPoint(lbPoint2, mid + 1 + j, "j = ");
                    highLight(27);
                    array[k] = R[j];
                    PutDown(lbArrays[mid + 1 + j], oriLocat[k], 150);
                    highLight(28);
                    j ++;
                }
                highLight(30);
                k ++;
            }
            while (i < n1) {
                highLight(32);
                setlbPoint(lbPointM, k, "k = ");
                setlbPoint(lbPoint1, left + i, "i = ");
                highLight(33);
                array[k] = L[i];
                PutDown(lbArrays[left + i], oriLocat[k], 150);
                i ++;
                k ++;
            }
            while (j < n2) {
                highLight(37);
                setlbPoint(lbPointM, k, "k = ");
                setlbPoint(lbPoint2, mid + 1 + j, "j = ");
                highLight(38);
                array[k] = R[j];
                PutDown(lbArrays[mid + 1 + j], oriLocat[k], 150);
                j ++;
                k ++;
            }
        }
        for (i = 0; i < n1 + n2; i ++)
            T[i] = array[left + i];
        Relocat(left, right, T);
    }

    public void MergeSortAl(int left, int right) {
        highLight(1);
        if (left < right) {
            highLight(2);
            int mid = (left + right) / 2;
            MergeSortAl(left, mid);
            MergeSortAl(mid + 1, right);
            Merge(left, mid, right);
        }
    }

    public void MergeSort() {
        for (int i = 0; i < num; i ++)
            oriLocat[i] = lbArrays[i].getX();
        MergeSortAl(0, num - 1);
    }
    // </editor-fold>

    public void setBackgroundMoving(JLabel lb1, JLabel lb2) {
        lb1.setOpaque(true);
        lb2.setOpaque(true);

        lb1.setBackground(processingColor);
        lb2.setBackground(processingColor);
    }

    public void setBackgroundDone(JLabel lb1, JLabel lb2) {
        lb1.setOpaque(true);
        lb2.setOpaque(true);

        lb1.setBackground(SystemColor.inactiveCaption);
        lb2.setBackground(SystemColor.inactiveCaption);
    }

    public boolean isSorted() {
        if (isIncrease) {
            for (int i = 0; i < array.length - 1; i++)
                if (array[i] > array[i+1])
                    return false;
        }
        else {
            for (int i = 0; i < array.length - 1; i++)
                if (array[i] < array[i+1])
                    return false;
        }
        return true;
    }

    public boolean isSorted2() {
        if (isIncrease) {
            for (int i = 0; i < array2.length - 1; i++)
                if (array2[i] > array2[i+1])
                    return false;
        }
        else {
            for (int i = 0; i < array2.length - 1; i++)
                if (array2[i] < array2[i+1])
                    return false;
        }
        return true;
    }

    public void threadReLocate() {
        curT++;

        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur-1].join();
                    }
                    reLocate();
                } catch (Exception e) {

                }
            }
        });
        threads[cur].start();
    }

    public void reLocate() {
        for (int i = 0; i < num; i++) {
            //set location label
            if (i == 0) {
                lbArrays[i].setLocation(((int) ((18 - num) * 0.5) * 70) + 100, 150);
                lbArrays2[i].setLocation(((int) ((18 - num) * 0.5) * 70) + 100, 150);
            }
            else {
                lbArrays[i].setLocation(lbArrays[i - 1].getX() + 70, 150);
                lbArrays2[i].setLocation(lbArrays[i-1].getX() + 70, 150);
            }
        }
    }
}
