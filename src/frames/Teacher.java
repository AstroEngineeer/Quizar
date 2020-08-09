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
import java.util.List;
import java.util.Random;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.filechooser.FileSystemView;

/**
 * @author Vignesh
 */
public class Teacher extends JFrame {
    public Teacher() {
        initComponents();
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
    }

    private void thisWindowClosing(WindowEvent e) {
        studentWindow.dispose();
        this.dispose();
    }

    List<Q_and_A> qa_list = new ArrayList<Q_and_A>();
    List<Q_and_A> qa_list_temp = new ArrayList<Q_and_A>();
    Student studentWindow = new Student();

    int rand_gen(int a) {
        Random rand = new Random();
        return rand.nextInt(a);
    }

    private void menuItem1ActionPerformed(ActionEvent e) {
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int r = j.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            String path = j.getSelectedFile().getAbsolutePath();
            String line = "";
            String splitBy = ",";
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] qa = line.split(splitBy);
                    qa_list.add(new Q_and_A(qa[0], qa[1]));
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            }
            qa_list_temp.addAll(qa_list);
            studentWindow.setVisible(true);
        }
    }

    private void button1MouseClicked(MouseEvent e) {
        if (qa_list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Open CSV file first!");
        } else {
            try {
                int rand = rand_gen(qa_list_temp.size());
                Q_and_A a = qa_list_temp.get(rand);
                label1.setText(a.question);
                label2.setText(a.answer);
                studentWindow.label1.setText(a.question);
                qa_list_temp.remove(rand);
                button1.setVisible(false);
                button2.setVisible(true);
                button3.setVisible(true);
                button4.setVisible(true);
            } catch (Exception exc) {
                exc.printStackTrace();
            }
            ;
        }
    }

    private void button2MouseClicked(MouseEvent e) {
        qa_list_temp = new ArrayList<Q_and_A>();
        qa_list_temp.addAll(qa_list);
        button1.setVisible(true);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
        label1.setText("Question will be displayed here.");
        label2.setText("Answer will be displayed here.");
        studentWindow.label1.setText("Question will be displayed here.");
    }

    private void button3MouseClicked(MouseEvent e) {
        if (qa_list_temp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No more question!");
        } else {
            try {
                int rand = rand_gen(qa_list_temp.size());
                Q_and_A a = qa_list_temp.get(rand);
                label1.setText(a.question);
                label2.setText(a.answer);
                studentWindow.label1.setText(a.question);
                qa_list_temp.remove(rand);
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
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

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(231, 231, 231)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button4)))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(label1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                            .addComponent(label2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)))
                    .addContainerGap(23, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(button1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                            .addComponent(button3)
                            .addGap(18, 18, 18)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button2)
                        .addComponent(button4))
                    .addGap(33, 33, 33))
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
