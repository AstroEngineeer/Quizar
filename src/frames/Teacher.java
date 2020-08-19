/*
 * Created by JFormDesigner on Sun Aug 09 11:35:57 IST 2020
 */

package frames;

import models.Q_and_A;
import AdvanceCSVSplitting.CSVUtils;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.security.SecureRandom;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 * @author Vignesh
 */
public class Teacher extends JFrame {

    Student studentWindow = new Student();
    ButtonGroup bg = new ButtonGroup();
    int category = 5;
    ArrayList<ArrayList<Q_and_A>> qa_list = new ArrayList<ArrayList<Q_and_A>>();
    ArrayList<ArrayList<Q_and_A>> qa_list_temp = new ArrayList<ArrayList<Q_and_A>>();
    List<String> result = new ArrayList<>();


    public Teacher() {
        initComponents();

        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);
        bg.add(radioButton4);
        qa_list.add(new ArrayList<Q_and_A>()); qa_list.add(new ArrayList<Q_and_A>());
        qa_list.add(new ArrayList<Q_and_A>()); qa_list.add(new ArrayList<Q_and_A>());
        qa_list.add(new ArrayList<Q_and_A>()); qa_list.add(new ArrayList<Q_and_A>());
        qa_list.add(new ArrayList<Q_and_A>()); qa_list.add(new ArrayList<Q_and_A>());
    }

    void newFile(){
        //radioButton1.setSelected(true);

        button1.setVisible(true);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);

        textArea1.setText("Question will be displayed here.");
        textArea2.setText("Answer will be displayed here.");
        studentWindow.textArea1.setText("Question will be displayed here.");

        qa_list.clear();
        qa_list.add(new ArrayList<Q_and_A>()); qa_list.add(new ArrayList<Q_and_A>());
        qa_list.add(new ArrayList<Q_and_A>()); qa_list.add(new ArrayList<Q_and_A>());
        qa_list.add(new ArrayList<Q_and_A>()); qa_list.add(new ArrayList<Q_and_A>());
        qa_list.add(new ArrayList<Q_and_A>()); qa_list.add(new ArrayList<Q_and_A>());
    }

    private void copyArrayList(ArrayList<ArrayList<Q_and_A>> d, ArrayList<ArrayList<Q_and_A>> s){
        qa_list_temp.clear();

        d.add(new ArrayList<Q_and_A>()); d.add(new ArrayList<Q_and_A>());
        d.add(new ArrayList<Q_and_A>()); d.add(new ArrayList<Q_and_A>());
        d.add(new ArrayList<Q_and_A>()); d.add(new ArrayList<Q_and_A>());
        d.add(new ArrayList<Q_and_A>()); d.add(new ArrayList<Q_and_A>());

        for(int i = 0 ; i < 8 ; i++ ){
            for (int j = 0 ; j < s.get(i).size() ; j++ ){
                d.get(i).add(s.get(i).get(j));
            }
        }
    }

    void checkEmptyCategory(){
        if(qa_list.get(0).isEmpty() && qa_list.get(1).isEmpty()){
            radioButton1.setEnabled(false);
            radioButton1.setSelected(false);
        }
        else
        {
            radioButton1.setEnabled(true);
        }
        if(qa_list.get(2).isEmpty() && qa_list.get(3).isEmpty()){
            radioButton2.setEnabled(false);
        }
        else
        {
            radioButton2.setEnabled(true);
        }
        if(qa_list.get(4).isEmpty() && qa_list.get(5).isEmpty()){
            radioButton3.setEnabled(false);
        }
        else
        {
            radioButton3.setEnabled(true);
        }
        if(qa_list.get(6).isEmpty() && qa_list.get(7).isEmpty()){
            radioButton4.setEnabled(false);
        }
        else
        {
            radioButton4.setEnabled(true);
        }
    }

    private void thisWindowClosing(WindowEvent e) {
        studentWindow.dispose();
        this.dispose();
    }

    int rand_gen(int a) {
        int ran = 0;
        try {
            SecureRandom rand = SecureRandom.getInstance("Windows-PRNG");
            //rand.setSeed(System.currentTimeMillis() % 1000);
            ran = rand.nextInt(a);
        }catch (Exception exc)
        {
            JOptionPane.showMessageDialog(this,exc);
        }

        return  ran;
    }

    private void menuItem1ActionPerformed(ActionEvent e) {
        newFile();
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV", "csv", "questions");
        j.setFileFilter(filter);
        int r = j.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            String path = j.getSelectedFile().getAbsolutePath();
            String line = "";
            String splitBy = ",";
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    if (!line.equals(",,,")) {
                        //System.out.println(line);
                        //String[] qa = line.split(splitBy);
                        result = CSVUtils.parseLine(line);
//                      //result.get(1), result.get(3)
                        //System.out.println(result.get(0)+"| "+result.get(1)+"| question = "+result.get(2)+"| Answer ="+result.get(3));
                        //System.out.println(qa[0]+" "+qa[1]+" "+qa[2]+" "+qa[3]+" ");
                        if(result.size()==4) {
                            switch (result.get(0)) {
                                case "1":
                                    if (result.get(1).equalsIgnoreCase("E"))
                                        qa_list.get(0).add(new Q_and_A(result.get(2), result.get(3)));
                                    else if (result.get(1).equalsIgnoreCase("H"))
                                        qa_list.get(1).add(new Q_and_A(result.get(2), result.get(3)));
                                    break;
                                case "2":
                                    if (result.get(1).equalsIgnoreCase("E"))
                                        qa_list.get(2).add(new Q_and_A(result.get(2), result.get(3)));
                                    else if (result.get(1).equalsIgnoreCase("H"))
                                        qa_list.get(3).add(new Q_and_A(result.get(2), result.get(3)));
                                    break;
                                case "3":
                                    if (result.get(1).equalsIgnoreCase("E"))
                                        qa_list.get(4).add(new Q_and_A(result.get(2), result.get(3)));
                                    else if (result.get(1).equalsIgnoreCase("H"))
                                        qa_list.get(5).add(new Q_and_A(result.get(2), result.get(3)));
                                    break;
                                case "4":
                                    if (result.get(1).equalsIgnoreCase("E"))
                                        qa_list.get(6).add(new Q_and_A(result.get(2), result.get(3)));
                                    else if (result.get(1).equalsIgnoreCase("H"))
                                        qa_list.get(7).add(new Q_and_A(result.get(2), result.get(3)));
                                    break;
                                default:
                                    //System.out.println(qa[0]);
                            }
                        }
                    }
                }
                } catch(IOException exc){
                    exc.printStackTrace();
                    JOptionPane.showMessageDialog(this,exc + " file selector");
                }

            copyArrayList(qa_list_temp, qa_list);
            checkEmptyCategory();
            studentWindow.setVisible(true);
        }
    }

    private void button1MouseClicked(MouseEvent e) {
        if (qa_list.get(0).isEmpty()
                &&qa_list.get(1).isEmpty()
                &&qa_list.get(2).isEmpty()
                &&qa_list.get(3).isEmpty()
                &&qa_list.get(4).isEmpty()
                &&qa_list.get(5).isEmpty()
                &&qa_list.get(6).isEmpty()
                &&qa_list.get(7).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Open CSV file first!");
        } else {
            try {
                if(!(category ==5)) {
                    int rand = rand_gen(qa_list_temp.get(category).size());
                    Q_and_A a = qa_list_temp.get(category).get(rand);
                    textArea1.setText(a.question);
                    textArea2.setText(a.answer);
                    studentWindow.textArea1.setText(a.question);
                    qa_list_temp.get(category).remove(rand);
                    button1.setVisible(false);
                    button2.setVisible(true);
                    button3.setVisible(true);
                    button4.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"select category");
                }
            } catch (Exception exc) {
                exc.printStackTrace();
                JOptionPane.showMessageDialog(this,exc + " start button");
            }
        }
    }

    private void button2MouseClicked(MouseEvent e) {
        copyArrayList(qa_list_temp, qa_list);

       // radioButton1.setSelected(true);
        bg.clearSelection();
        radioButton1ActionPerformed(null);

        button1.setVisible(true);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);

        textArea1.setText("Question will be displayed here.");
        textArea2.setText("Answer will be displayed here.");
        studentWindow.textArea1.setText("Question will be displayed here.");
    }

    private void button3MouseClicked(MouseEvent e) {
        if(!(category ==5)) {
            if (qa_list_temp.get(category).isEmpty()) {
                JOptionPane.showMessageDialog(this, "No more question!");
            } else {
                try {
                    int rand = rand_gen(qa_list_temp.get(category).size());
                    Q_and_A a = qa_list_temp.get(category).get(rand);
                    textArea1.setText(a.question);
                    textArea2.setText(a.answer);
                    studentWindow.textArea1.setText(a.question);
                    qa_list_temp.get(category).remove(rand);
                } catch (Exception exc) {
                    exc.printStackTrace();
                    JOptionPane.showMessageDialog(this,exc + "next easy button" );
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this,"select category");
        }
    }

    private void button4ActionPerformed(ActionEvent e) {
        if(!(category==5))
        {
        if (qa_list_temp.get(category + 1).isEmpty()) {
            JOptionPane.showMessageDialog(this, "No more question!");
        } else {
            try {
                int rand = rand_gen(qa_list_temp.get(category + 1).size());
                Q_and_A a = qa_list_temp.get(category + 1).get(rand);
                textArea1.setText(a.question);
                textArea2.setText(a.answer);
                studentWindow.textArea1.setText(a.question);
                qa_list_temp.get(category + 1).remove(rand);
            } catch (Exception exc) {
                exc.printStackTrace();
                JOptionPane.showMessageDialog(this,exc + " next hard button");
            }
        }
        }else
        {
            JOptionPane.showMessageDialog(this,"select category");
        }
    }

    private void radioButton1ActionPerformed(ActionEvent e) {
        category = 0;
    }

    private void radioButton2ActionPerformed(ActionEvent e) {
        category = 2;
    }

    private void radioButton3ActionPerformed(ActionEvent e) {
        category = 4;
    }

    private void radioButton4ActionPerformed(ActionEvent e) { category = 6; }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Sam
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();

        //======== this ========
        setTitle("Teacher");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("File");

                //---- menuItem1 ----
                menuItem1.setText("Open");
                menuItem1.addActionListener(e -> menuItem1ActionPerformed(e));
                menu1.add(menuItem1);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //---- button1 ----
        button1.setText("Start Test");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- button2 ----
        button2.setText("Reset");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });

        //---- button3 ----
        button3.setText(">>Next Easy>>");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });

        //---- button4 ----
        button4.setText(">>Next Hard>>");
        button4.addActionListener(e -> button4ActionPerformed(e));

        //---- radioButton1 ----
        radioButton1.setText("Category 1");
        radioButton1.addActionListener(e -> radioButton1ActionPerformed(e));

        //---- radioButton2 ----
        radioButton2.setText("Category 2");
        radioButton2.addActionListener(e -> radioButton2ActionPerformed(e));

        //---- radioButton3 ----
        radioButton3.setText("Category 3");
        radioButton3.addActionListener(e -> radioButton3ActionPerformed(e));

        //---- radioButton4 ----
        radioButton4.setText("Category 4");
        radioButton4.addActionListener(e -> radioButton4ActionPerformed(e));

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setLineWrap(true);
            textArea1.setEditable(false);
            textArea1.setFont(textArea1.getFont().deriveFont(textArea1.getFont().getSize() + 6f));
            textArea1.setText("Question Will be Displayed here!");
            textArea1.setOpaque(false);
            scrollPane1.setViewportView(textArea1);
        }

        //======== scrollPane2 ========
        {

            //---- textArea2 ----
            textArea2.setEditable(false);
            textArea2.setFont(textArea2.getFont().deriveFont(textArea2.getFont().getSize() + 3f));
            textArea2.setLineWrap(true);
            textArea2.setText("Answer will be displayed here.");
            scrollPane2.setViewportView(textArea2);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 374, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button4)
                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
                            .addGap(112, 112, 112))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 722, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)))
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(radioButton3)
                        .addComponent(radioButton2)
                        .addComponent(radioButton1)
                        .addComponent(radioButton4))
                    .addContainerGap(94, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 722, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(210, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(radioButton1)
                    .addGap(18, 18, 18)
                    .addComponent(radioButton2)
                    .addGap(31, 31, 31)
                    .addComponent(radioButton3)
                    .addGap(18, 18, 18)
                    .addComponent(radioButton4)
                    .addContainerGap(208, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button3)
                        .addComponent(button1))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button2)
                        .addComponent(button4))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        new Teacher().setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Sam
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JScrollPane scrollPane2;
    private JTextArea textArea2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
