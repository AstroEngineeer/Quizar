/*
 * Created by JFormDesigner on Sun Aug 09 12:20:51 IST 2020
 */

package frames;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Vignesh
 */
public class Student extends JFrame {
    public Student() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Sam
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setTitle("Student");
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setEditable(false);
            textArea1.setOpaque(false);
            textArea1.setLineWrap(true);
            textArea1.setFont(textArea1.getFont().deriveFont(textArea1.getFont().getStyle() | Font.BOLD, textArea1.getFont().getSize() + 6f));
            textArea1.setText("Question Will be Displayed here!");
            scrollPane1.setViewportView(textArea1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Sam
    private JScrollPane scrollPane1;
    public JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
