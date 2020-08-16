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
        textArea1 = new JTextArea();

        //======== this ========
        setTitle("Student");
        var contentPane = getContentPane();

        //---- textArea1 ----
        textArea1.setEditable(false);
        textArea1.setOpaque(false);
        textArea1.setLineWrap(true);
        textArea1.setFont(textArea1.getFont().deriveFont(textArea1.getFont().getStyle() | Font.BOLD, textArea1.getFont().getSize() + 12f));
        textArea1.setText("Question Will be Displayed here!");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(textArea1, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(12, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(textArea1, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Sam
    public JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
