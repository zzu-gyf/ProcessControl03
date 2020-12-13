/*
 * Created by JFormDesigner on Sun Dec 13 12:01:56 CST 2020
 */

package JDialogTest;

import Bean.OSResource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author gyf
 */
public class JDialogTest extends JDialog {
    public JDialogTest(Window owner) {
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
        String a = textField1.getText();
        String b = textField2.getText();
        String c = textField3.getText();

        OSResource.OSInit();

        if (isNumber(a)&&isNumber(b)){
            int men = Integer.parseInt(a);
            int cpu = Integer.parseInt(b);
            OSResource.setOSMemory(men);
            OSResource.setMaxOsMemory(men);
            OSResource.setCpuState(cpu);
        }else if (isNumber(a)){
            int men = Integer.parseInt(a);
            OSResource.setOSMemory(men);
            OSResource.setMaxOsMemory(men);
        }else if (isNumber(b)){
            int cpu = Integer.parseInt(b);
            OSResource.setCpuState(cpu);
        }

        if (isNumber(c)){
            int run = Integer.parseInt(c);
            OSResource.setRun(run);
        }

        setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label3 = new JLabel();
        textField3 = new JTextField();

        //======== this ========
        setTitle("\u7cfb\u7edf\u8d44\u6e90\u5206\u914d");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7cfb\u7edf\u6700\u5927\u5185\u5b58\uff1a");
        contentPane.add(label1);
        label1.setBounds(15, 95, 190, 30);
        contentPane.add(textField1);
        textField1.setBounds(175, 95, 110, 30);

        //---- label2 ----
        label2.setText("\u7cfb\u7edfcpu\u6700\u5927\u7ebf\u7a0b\uff1a");
        contentPane.add(label2);
        label2.setBounds(15, 135, 200, 30);
        contentPane.add(textField2);
        textField2.setBounds(175, 135, 110, 30);

        //---- button1 ----
        button1.setText("\u63d0\u4ea4");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(130, 235), button1.getPreferredSize()));

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
        scrollPane1.setBounds(35, 10, 225, 40);

        //---- label3 ----
        label3.setText("\u8fdb\u7a0b\u4e00\u6b21\u8fd0\u884c\u65f6\u95f4\u7247\u6570\uff1a");
        contentPane.add(label3);
        label3.setBounds(15, 180, 190, 30);
        contentPane.add(textField3);
        textField3.setBounds(175, 180, 110, 30);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(350, 315);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    public JButton button1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label3;
    private JTextField textField3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
