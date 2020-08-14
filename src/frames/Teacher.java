/*
 * Created by JFormDesigner on Sun Aug 09 11:35:57 IST 2020
 */

package frames;

import models.Q_and_A;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.filechooser.FileSystemView;

/**
 * @author Vignesh
 */
public class Teacher extends JFrame {

    Student studentWindow = new Student();
    ButtonGroup bg = new ButtonGroup();
    int category = 0;

    ArrayList<ArrayList<Q_and_A>> qa_list = new ArrayList<ArrayList<Q_and_A>>();
    ArrayList<ArrayList<Q_and_A>> qa_list_temp = new ArrayList<ArrayList<Q_and_A>>();

    public Teacher() {
        initComponents();

        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);
    }

    void newFile(){
        radioButton1.setSelected(true);

        button1.setVisible(true);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);

        label1.setText("Question will be displayed here.");
        label2.setText("Answer will be displayed here.");
        studentWindow.label1.setText("Question will be displayed here.");

        qa_list.clear();
        qa_list.add(new ArrayList<Q_and_A>()); qa_list.add(new ArrayList<Q_and_A>());
        qa_list.add(new ArrayList<Q_and_A>()); qa_list.add(new ArrayList<Q_and_A>());
        qa_list.add(new ArrayList<Q_and_A>()); qa_list.add(new ArrayList<Q_and_A>());
    }

    void copyArrayList(ArrayList<ArrayList<Q_and_A>> d, ArrayList<ArrayList<Q_and_A>> s){
        qa_list_temp.clear();

        d.add(new ArrayList<Q_and_A>()); d.add(new ArrayList<Q_and_A>());
        d.add(new ArrayList<Q_and_A>()); d.add(new ArrayList<Q_and_A>());
        d.add(new ArrayList<Q_and_A>()); d.add(new ArrayList<Q_and_A>());

        for(int i = 0 ; i < 6 ; i++ ){
            for (int j = 0 ; j < s.get(i).size() ; j++ ){
                d.get(i).add(s.get(i).get(j));
            }
        }
    }

    void checkEmptyCategory(){
        if(qa_list.get(0).isEmpty() && qa_list.get(1).isEmpty()){
            radioButton1.setEnabled(false);
        }
        if(qa_list.get(2).isEmpty() && qa_list.get(3).isEmpty()){
            radioButton2.setEnabled(false);
        }
        if(qa_list.get(4).isEmpty() && qa_list.get(5).isEmpty()){
            radioButton3.setEnabled(false);
        }
    }

    private void thisWindowClosing(WindowEvent e) {
        studentWindow.dispose();
        this.dispose();
    }

    int rand_gen(int a) {
        Random rand = new Random();
        return rand.nextInt(a);
    }

    private void menuItem1ActionPerformed(ActionEvent e) {
        newFile();
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int r = j.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            String path = j.getSelectedFile().getAbsolutePath();
            String line = "";
            String splitBy = ",";
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    if (!line.equals(",,,")) {
                        String[] qa = line.split(splitBy);
                        switch (qa[0]) {
                            case "1":
                                if (qa[1].equalsIgnoreCase("E"))
                                    qa_list.get(0).add(new Q_and_A(qa[2], qa[3]));
                                else if (qa[1].equalsIgnoreCase("H"))
                                    qa_list.get(1).add(new Q_and_A(qa[2], qa[3]));
                                break;
                            case "2":
                                if (qa[1].equalsIgnoreCase("E"))
                                    qa_list.get(2).add(new Q_and_A(qa[2], qa[3]));
                                else if (qa[1].equalsIgnoreCase("H"))
                                    qa_list.get(3).add(new Q_and_A(qa[2], qa[3]));
                                break;
                            case "3":
                                if (qa[1].equalsIgnoreCase("E"))
                                    qa_list.get(4).add(new Q_and_A(qa[2], qa[3]));
                                else if (qa[1].equalsIgnoreCase("H"))
                                    qa_list.get(5).add(new Q_and_A(qa[2], qa[3]));
                                break;
                            default:
                                //System.out.println(qa[0]);
                        }
                    }
                }
                } catch(IOException exc){
                    exc.printStackTrace();
                }

            copyArrayList(qa_list_temp, qa_list);
            checkEmptyCategory();
            studentWindow.setVisible(true);
        }
    }

    private void button1MouseClicked(MouseEvent e) {
        if (qa_list.get(0).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Open CSV file first!");
        } else {
            try {
                int rand = rand_gen(qa_list_temp.get(category).size());
                Q_and_A a = qa_list_temp.get(category).get(rand);
                label1.setText(a.question);
                label2.setText(a.answer);
                studentWindow.label1.setText(a.question);
                qa_list_temp.get(category).remove(rand);
                button1.setVisible(false);
                button2.setVisible(true);
                button3.setVisible(true);
                button4.setVisible(true);
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
    }

    private void button2MouseClicked(MouseEvent e) {
        copyArrayList(qa_list_temp, qa_list);

        radioButton1.setSelected(true);
        radioButton1ActionPerformed(null);

        button1.setVisible(true);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);

        label1.setText("Question will be displayed here.");
        label2.setText("Answer will be displayed here.");
        studentWindow.label1.setText("Question will be displayed here.");
    }

    private void button3MouseClicked(MouseEvent e) {
        if (qa_list_temp.get(category).isEmpty()) {
            JOptionPane.showMessageDialog(this, "No more question!");
        } else {
            try {
                int rand = rand_gen(qa_list_temp.get(category).size());
                Q_and_A a = qa_list_temp.get(category).get(rand);
                label1.setText(a.question);
                label2.setText(a.answer);
                studentWindow.label1.setText(a.question);
                qa_list_temp.get(category).remove(rand);
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
    }

    private void button4ActionPerformed(ActionEvent e) {
        if (qa_list_temp.get(category + 1).isEmpty()) {
            JOptionPane.showMessageDialog(this, "No more question!");
        } else {
            try {
                int rand = rand_gen(qa_list_temp.get(category + 1).size());
                Q_and_A a = qa_list_temp.get(category + 1).get(rand);
                label1.setText(a.question);
                label2.setText(a.answer);
                studentWindow.label1.setText(a.question);
                qa_list_temp.get(category + 1).remove(rand);
            } catch (Exception exc) {
                exc.printStackTrace();
            }
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

    private void radioButton4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Vignesh
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        label1 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();

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

        //---- label1 ----
        label1.setText("Question will be displayed here.");

        //---- label2 ----
        label2.setText("Answer will be displayed here.");

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

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(label1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                            .addComponent(label2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(231, 231, 231)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button4))))
                    .addGap(29, 29, 29)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(radioButton3)
                                .addComponent(radioButton2)
                                .addComponent(radioButton1))
                            .addGap(0, 70, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(radioButton4)
                            .addContainerGap(70, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(radioButton1)))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addComponent(button1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                    .addComponent(button3)
                                    .addGap(18, 18, 18)))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button2)
                                .addComponent(button4))
                            .addGap(34, 34, 34))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(radioButton2)
                            .addGap(18, 18, 18)
                            .addComponent(radioButton3)
                            .addGap(18, 18, 18)
                            .addComponent(radioButton4)
                            .addContainerGap(108, Short.MAX_VALUE))))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        new Teacher().setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Vignesh
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
