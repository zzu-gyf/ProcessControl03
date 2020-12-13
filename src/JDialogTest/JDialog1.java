/*
 * Created by JFormDesigner on Sun Dec 13 13:53:11 CST 2020
 */

package JDialogTest;

import Control.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author gyf
 */
public class JDialog1 extends JDialog {
    public JDialog1(Window owner) {
        super(owner);
        initComponents();
    }
    public static boolean isNumber(String str) {
        if (str != null && !str.equals("")) {
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {//用java自带的函数
                    return false;
                }
            }
            return true;
        } else
            return false;

    }

    public void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String mem = textField1.getText();
        String times = textField2.getText();
        String pro = textField3.getText();

        if (isNumber(mem)&&isNumber(times)&&isNumber(pro)){
            Control.RequestPCB1(textField4.getText(),Integer.parseInt(mem),Integer.parseInt(times),Integer.parseInt(pro));
        }

        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
//        setVisible(false);



    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textField1 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label3 = new JLabel();
        textField3 = new JTextField();
        textField4 = new JTextField();
        label4 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(textField1);
        textField1.setBounds(185, 105, 110, 30);

        //---- label1 ----
        label1.setText("\u7533\u8bf7\u5185\u5b58\u5927\u5c0f\uff1a");
        contentPane.add(label1);
        label1.setBounds(75, 105, 105, 30);

        //---- label2 ----
        label2.setText("\u8fd0\u884c\u65f6\u95f4\uff1a");
        contentPane.add(label2);
        label2.setBounds(75, 145, 90, 30);
        contentPane.add(textField2);
        textField2.setBounds(185, 145, 110, 30);

        //---- button1 ----
        button1.setText("\u63d0\u4ea4");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(160, 235, 78, 30);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setText("\u8bf7\u8f93\u5165\u5408\u6cd5\u6570\u636e\uff0c\u5982\u679c\u6570\u636e\u4e0d\u5408\u6cd5\uff0c\u5219\u4f7f\u7528\u9ed8\u8ba4\u6570\u503c");
            textArea1.setLineWrap(true);
            textArea1.setEditable(false);
            textArea1.setEnabled(false);
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(85, 10, 225, 40);

        //---- label3 ----
        label3.setText("\u4f18\u5148\u7ea7\uff1a");
        contentPane.add(label3);
        label3.setBounds(75, 190, 75, 30);
        contentPane.add(textField3);
        textField3.setBounds(185, 190, 110, 30);
        contentPane.add(textField4);
        textField4.setBounds(185, 65, 110, 30);

        //---- label4 ----
        label4.setText("\u8fdb\u7a0b\u540d\uff1a");
        contentPane.add(label4);
        label4.setBounds(75, 65, 105, 30);

        contentPane.setPreferredSize(new Dimension(385, 330));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField textField1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField2;
    public JButton button1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label3;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
