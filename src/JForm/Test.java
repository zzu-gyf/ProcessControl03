/*
 * Created by JFormDesigner on Thu Dec 10 23:31:22 CST 2020
 */

package JForm;

import Bean.OSResource;
import Bean.PCB;
import Control.Control;
import JDialogTest.JDialog1;
import JDialogTest.JDialogTest;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
 * @author GYF
 */
public class Test extends JFrame {
    public Test() {
        initComponents();
    }

    private void button9ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (Control.c_List.size() <= 0) {
            textArea2.setText("");
        } else {
            for (int i = 0; i < Control.c_List.size(); i++) {
                PCB pcb = Control.c_List.get(i);
                if (i == 0) {
                    textArea2.setText("id:" + pcb.getId() + "  进程名:" + pcb.getName());
                } else {
                    textArea2.setText(textArea2.getText() + "\n" + "id:" + pcb.getId() + "  进程名:" + pcb.getName());
                }
            }
        }

    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String pcbName = textArea8.getText();
        Control.OutPut="";
        if (pcbName.equals("") || pcbName == "" || pcbName == null) {
            //什么都不做
        } else {
            Control.RequestPCB(pcbName);
        }
        textArea8.setText("");
        show1();
        textArea1.setText(textArea1.getText()+"\n"+Control.OutPut);
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        Control.init();
        show1();
        textArea1.setText(textArea1.getText()+"\n"+Control.OutPut);
    }

    private void button10ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //  活动就绪进程表
        if (Control.r_List.size() <= 0) {
            textArea3.setText("");
        } else {
            for (int i = 0; i < Control.r_List.size(); i++) {
                PCB pcb = Control.r_List.get(i);
                if (i == 0) {
                    textArea3.setText("id:" + pcb.getId() + "  进程名:" + pcb.getName() + "  优先级:" + pcb.getPriority());
                } else {
                    textArea3.setText(textArea3.getText() + "\n" + "id:" + pcb.getId() + "  进程名:" + pcb.getName() + "  优先级:" + pcb.getPriority());
                }
            }
        }

    }

    private void button11ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //  活动阻塞进程表
        if (Control.b_List.size() <= 0) {
            textArea4.setText("");
        } else {
            for (int i = 0; i < Control.b_List.size(); i++) {
                PCB pcb = Control.b_List.get(i);
                if (i == 0) {
                    textArea4.setText("id:" + pcb.getId() + "  进程名:" + pcb.getName());
                } else {
                    textArea4.setText(textArea4.getText() + "\n" + "id:" + pcb.getId() + "  进程名:" + pcb.getName());
                }
            }
        }
    }

    private void button12ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //  执行进程表
        if (Control.p_List.size() <= 0) {
            textArea5.setText("");
        } else {
            for (int i = 0; i < Control.p_List.size(); i++) {
                PCB pcb = Control.p_List.get(i);
                if (i == 0) {
                    textArea5.setText("id:" + pcb.getId() + "  进程名:" + pcb.getName());
                } else {
                    textArea5.setText(textArea5.getText() + "\n" + "id:" + pcb.getId() + "  进程名:" + pcb.getName());
                }
            }
        }

    }

    private void button13ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //  终止进程表
        if (Control.e_List.size() <= 0) {
            textArea6.setText("");
        } else {
            for (int i = 0; i < Control.e_List.size(); i++) {
                PCB pcb = Control.e_List.get(i);
                if (i == 0) {
                    textArea6.setText("id:" + pcb.getId() + "  进程名:" + pcb.getName());
                } else {
                    textArea6.setText(textArea6.getText() + "\n" + "id:" + pcb.getId() + "  进程名:" + pcb.getName());
                }
            }
        }
    }

    private void button14ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //  静止就绪进程表
        if (Control.s_r_List.size() <= 0) {
            textArea7.setText("");
        } else {
            for (int i = 0; i < Control.s_r_List.size(); i++) {
                PCB pcb = Control.s_r_List.get(i);
                if (i == 0) {
                    textArea7.setText("id:" + pcb.getId() + "  进程名:" + pcb.getName());
                } else {
                    textArea7.setText(textArea7.getText() + "\n" + "id:" + pcb.getId() + "  进程名:" + pcb.getName());
                }
            }
        }
    }

    private void button15ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //  静止阻塞进程表
        if (Control.s_b_List.size() <= 0) {
            textArea12.setText("");
        } else {
            for (int i = 0; i < Control.s_b_List.size(); i++) {
                PCB pcb = Control.s_b_List.get(i);
                if (i == 0) {
                    textArea12.setText("id:" + pcb.getId() + "  进程名:" + pcb.getName());
                } else {
                    textArea12.setText(textArea12.getText() + "\n" + "id:" + pcb.getId() + "  进程名:" + pcb.getName());
                }
            }
        }
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        // 系统资源初始化

        JDialogTest jDialogTest = new JDialogTest(this);
        jDialogTest.setVisible(true);

        jDialogTest.button1.addActionListener(e1 -> {
            jDialogTest.button1ActionPerformed(e1);
            this.show(e1);
        });
    }

    public void show1(){
        textArea1.setText("当前系统内存为：" + OSResource.getOSMemory() + "，cpu线程数为：" + OSResource.getCpuState() + "，进程每次运行" + OSResource.getRun() + "个时间片");

    }

    private void show(ActionEvent e) {
        // TODO add your code here
        // 显示系统信息

        textArea1.setText("当前系统内存为：" + OSResource.getOSMemory() + "，cpu线程数为：" + OSResource.getCpuState() + "，进程每次运行" + OSResource.getRun() + "个时间片");
    }

    private void button5ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //分配cpu
        Control.OutPut="";
        Control.aaa();
        show1();
        textArea1.setText(textArea1.getText()+"\n"+Control.OutPut);
    }

    private void button4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //运行一次时间片
        Control.OutPut="";
        if (Control.p_List.isEmpty()) {
            //弹出窗体，执行队列为空
            a();
            jl.setText("执行队列为空");
            frame.setVisible(true);
        } else {
            Control.bbb();
        }
        show1();
        textArea1.setText(textArea1.getText()+"\n"+Control.OutPut);


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

    JDialog frame = new JDialog();
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    JLabel jl = new JLabel();

    public void a() {
        frame.setBounds(
                new Rectangle(
                        (d.width - 100) / 2, (d.height - 100) / 2, 100, 100
                )
        );
        frame.getContentPane().add(jl);
        jl.setText("请输入合法的id号");
        jl.setVerticalAlignment(JLabel.CENTER);
        jl.setHorizontalAlignment(JLabel.CENTER);
        frame.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
    }


    private void button7ActionPerformed(ActionEvent e) {
        // TODO add your code here
        a();
        Control.OutPut="";

        String a = textArea10.getText();
        if (isNumber(a)) {

            int b = Integer.parseInt(a);
            Control.ccc(b);
            if (Control.win_true) {
                frame.setVisible(true);
            }
        } else {
            frame.setVisible(true);
        }
        textArea10.setText("");
        show1();
        textArea1.setText(textArea1.getText()+"\n"+Control.OutPut);
    }

    private void button6ActionPerformed(ActionEvent e) {
        // TODO add your code here
        a();
        Control.OutPut="";
        String a = textArea9.getText();
        if (isNumber(a)) {

            int b = Integer.parseInt(a);
            Control.ddd(b);
            if (Control.win_true) {
                frame.setVisible(true);
            }
        } else {
            frame.setVisible(true);
        }
        textArea9.setText("");
        show1();
        textArea1.setText(textArea1.getText()+"\n"+Control.OutPut);
    }

    private void button8ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //  请求io
        Control.OutPut="";
        a();
        String a = textArea11.getText();
        if (isNumber(a)) {

            int b = Integer.parseInt(a);
            Control.eee(b);
            if (Control.win_true) {
                frame.setVisible(true);
            }
        } else {
            frame.setVisible(true);
        }
        textArea11.setText("");
        show1();
        textArea1.setText(textArea1.getText()+"\n"+Control.OutPut);
    }

    private void button16ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //  io完成
        Control.OutPut="";
        a();
        String a = textArea13.getText();
        if (isNumber(a)) {

            int b = Integer.parseInt(a);
            Control.fff(b);
            if (Control.win_true) {
                frame.setVisible(true);
            }
        } else {
            frame.setVisible(true);
        }
        textArea13.setText("");
        show1();
        textArea1.setText(textArea1.getText()+"\n"+Control.OutPut);
    }

    private void button17ActionPerformed(ActionEvent e) {
        // TODO add your code here
        Control.OutPut="";
        a();
        String a = textArea14.getText();
        if (isNumber(a)) {

            int b = Integer.parseInt(a);
            Control.ggg(b);
            if (Control.win_true) {
                frame.setVisible(true);
            }
        } else {
            frame.setVisible(true);
        }
        textArea14.setText("");
        show1();
        textArea1.setText(textArea1.getText()+"\n"+Control.OutPut);
    }

    private void button18ActionPerformed(ActionEvent e) {
        // TODO add your code here
        Control.OutPut="";
        JDialog1 jDialog1 = new JDialog1(this);
        jDialog1.setVisible(true);
//        jDialog1.button1.addActionListener(e1 -> this.button9ActionPerformed(e1));
        jDialog1.button1.addActionListener(e1 -> {
            jDialog1.button1ActionPerformed(e1);
            this.button9ActionPerformed(e1);
//            this.show(e1);
            this.show2(e1);

        });
        show1();
//        textArea1.setText(textArea1.getText()+"\n"+Control.OutPut);
    }

    public void show2(ActionEvent e){
        show1();
        textArea1.setText(textArea1.getText()+"\n"+Control.OutPut);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        panel1 = new JPanel();
        button3 = new JButton();
        scrollPane8 = new JScrollPane();
        textArea8 = new JTextArea();
        button1 = new JButton();
        button18 = new JButton();
        button2 = new JButton();
        button5 = new JButton();
        button4 = new JButton();
        panel2 = new JPanel();
        scrollPane2 = new JScrollPane();
        panel16 = new JPanel();
        textArea2 = new JTextArea();
        button9 = new JButton();
        scrollPane3 = new JScrollPane();
        panel10 = new JPanel();
        textArea3 = new JTextArea();
        button10 = new JButton();
        scrollPane4 = new JScrollPane();
        panel11 = new JPanel();
        textArea4 = new JTextArea();
        button11 = new JButton();
        scrollPane5 = new JScrollPane();
        panel12 = new JPanel();
        textArea5 = new JTextArea();
        button12 = new JButton();
        scrollPane6 = new JScrollPane();
        panel13 = new JPanel();
        textArea6 = new JTextArea();
        button13 = new JButton();
        scrollPane7 = new JScrollPane();
        panel14 = new JPanel();
        textArea7 = new JTextArea();
        button14 = new JButton();
        scrollPane12 = new JScrollPane();
        panel15 = new JPanel();
        textArea12 = new JTextArea();
        button15 = new JButton();
        panel3 = new JPanel();
        panel5 = new JPanel();
        panel7 = new JPanel();
        scrollPane10 = new JScrollPane();
        textArea10 = new JTextArea();
        button7 = new JButton();
        panel6 = new JPanel();
        scrollPane9 = new JScrollPane();
        textArea9 = new JTextArea();
        button6 = new JButton();
        panel8 = new JPanel();
        scrollPane11 = new JScrollPane();
        textArea11 = new JTextArea();
        button8 = new JButton();
        panel9 = new JPanel();
        scrollPane13 = new JScrollPane();
        textArea13 = new JTextArea();
        button16 = new JButton();
        panel17 = new JPanel();
        scrollPane14 = new JScrollPane();
        textArea14 = new JTextArea();
        button17 = new JButton();
        panel4 = new JPanel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setTitle("\u8fdb\u7a0b\u7ba1\u7406");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== panel1 ========
            {
                panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));

                //---- button3 ----
                button3.setText("\u7cfb\u7edf\u8d44\u6e90\u521d\u59cb\u5316");
                button3.addActionListener(e -> button3ActionPerformed(e));
                panel1.add(button3);

                //======== scrollPane8 ========
                {
                    scrollPane8.setViewportView(textArea8);
                }
                panel1.add(scrollPane8);

                //---- button1 ----
                button1.setText("       \u7533\u8bf7pcb       ");
                button1.addActionListener(e -> {
                    button1ActionPerformed(e);
                    button9ActionPerformed(e);
                    button10ActionPerformed(e);
                    button11ActionPerformed(e);
                    button12ActionPerformed(e);
                    button13ActionPerformed(e);
                    button14ActionPerformed(e);
                    button15ActionPerformed(e);
                });
                panel1.add(button1);

                //---- button18 ----
                button18.setText("\u7533\u8bf7pcb\uff08\u9ad8\u7ea7\uff09");
                button18.addActionListener(e -> {
                    button9ActionPerformed(e);
                    button10ActionPerformed(e);
                    button11ActionPerformed(e);
                    button12ActionPerformed(e);
                    button13ActionPerformed(e);
                    button14ActionPerformed(e);
                    button15ActionPerformed(e);
                    button18ActionPerformed(e);
                });
                panel1.add(button18);

                //---- button2 ----
                button2.setText("     \u5206\u914d\u5185\u5b58     ");
                button2.addActionListener(e -> {
                    button2ActionPerformed(e);
                    button9ActionPerformed(e);
                    button10ActionPerformed(e);
                    button11ActionPerformed(e);
                    button12ActionPerformed(e);
                    button13ActionPerformed(e);
                    button14ActionPerformed(e);
                    button15ActionPerformed(e);
                });
                panel1.add(button2);

                //---- button5 ----
                button5.setText("     \u5206\u914dcpu     ");
                button5.addActionListener(e -> {
                    button5ActionPerformed(e);
                    button9ActionPerformed(e);
                    button10ActionPerformed(e);
                    button11ActionPerformed(e);
                    button12ActionPerformed(e);
                    button13ActionPerformed(e);
                    button14ActionPerformed(e);
                    button15ActionPerformed(e);
                });
                panel1.add(button5);

                //---- button4 ----
                button4.setText("   \u8fd0\u884c  ");
                button4.addActionListener(e -> {
                    button4ActionPerformed(e);
                    button9ActionPerformed(e);
                    button10ActionPerformed(e);
                    button11ActionPerformed(e);
                    button12ActionPerformed(e);
                    button13ActionPerformed(e);
                    button14ActionPerformed(e);
                    button15ActionPerformed(e);
                });
                panel1.add(button4);
            }
            dialogPane.add(panel1, BorderLayout.NORTH);

            //======== panel2 ========
            {
                panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));

                //======== scrollPane2 ========
                {

                    //======== panel16 ========
                    {
                        panel16.setLayout(new BorderLayout());

                        //---- textArea2 ----
                        textArea2.setLineWrap(true);
                        panel16.add(textArea2, BorderLayout.CENTER);

                        //---- button9 ----
                        button9.setText("\u521b\u5efa\u8fdb\u7a0b\u8868");
                        button9.addActionListener(e -> button9ActionPerformed(e));
                        panel16.add(button9, BorderLayout.NORTH);
                    }
                    scrollPane2.setViewportView(panel16);
                }
                panel2.add(scrollPane2);

                //======== scrollPane3 ========
                {

                    //======== panel10 ========
                    {
                        panel10.setLayout(new BorderLayout());

                        //---- textArea3 ----
                        textArea3.setLineWrap(true);
                        panel10.add(textArea3, BorderLayout.CENTER);

                        //---- button10 ----
                        button10.setText("\u6d3b\u52a8\u5c31\u7eea\u8fdb\u7a0b\u8868");
                        button10.addActionListener(e -> button10ActionPerformed(e));
                        panel10.add(button10, BorderLayout.NORTH);
                    }
                    scrollPane3.setViewportView(panel10);
                }
                panel2.add(scrollPane3);

                //======== scrollPane4 ========
                {

                    //======== panel11 ========
                    {
                        panel11.setLayout(new BorderLayout());

                        //---- textArea4 ----
                        textArea4.setLineWrap(true);
                        panel11.add(textArea4, BorderLayout.CENTER);

                        //---- button11 ----
                        button11.setText("\u6d3b\u52a8\u963b\u585e\u8fdb\u7a0b\u8868");
                        button11.addActionListener(e -> button11ActionPerformed(e));
                        panel11.add(button11, BorderLayout.NORTH);
                    }
                    scrollPane4.setViewportView(panel11);
                }
                panel2.add(scrollPane4);

                //======== scrollPane5 ========
                {

                    //======== panel12 ========
                    {
                        panel12.setLayout(new BorderLayout());

                        //---- textArea5 ----
                        textArea5.setLineWrap(true);
                        panel12.add(textArea5, BorderLayout.CENTER);

                        //---- button12 ----
                        button12.setText("\u6267\u884c\u8fdb\u7a0b\u8868");
                        button12.addActionListener(e -> button12ActionPerformed(e));
                        panel12.add(button12, BorderLayout.NORTH);
                    }
                    scrollPane5.setViewportView(panel12);
                }
                panel2.add(scrollPane5);

                //======== scrollPane6 ========
                {

                    //======== panel13 ========
                    {
                        panel13.setLayout(new BorderLayout());

                        //---- textArea6 ----
                        textArea6.setLineWrap(true);
                        panel13.add(textArea6, BorderLayout.CENTER);

                        //---- button13 ----
                        button13.setText("\u7ec8\u6b62\u8fdb\u7a0b\u8868");
                        button13.addActionListener(e -> button13ActionPerformed(e));
                        panel13.add(button13, BorderLayout.NORTH);
                    }
                    scrollPane6.setViewportView(panel13);
                }
                panel2.add(scrollPane6);

                //======== scrollPane7 ========
                {

                    //======== panel14 ========
                    {
                        panel14.setLayout(new BorderLayout());

                        //---- textArea7 ----
                        textArea7.setLineWrap(true);
                        panel14.add(textArea7, BorderLayout.CENTER);

                        //---- button14 ----
                        button14.setText("\u9759\u6b62\u5c31\u7eea\u8fdb\u7a0b\u8868");
                        button14.addActionListener(e -> button14ActionPerformed(e));
                        panel14.add(button14, BorderLayout.NORTH);
                    }
                    scrollPane7.setViewportView(panel14);
                }
                panel2.add(scrollPane7);

                //======== scrollPane12 ========
                {

                    //======== panel15 ========
                    {
                        panel15.setLayout(new BorderLayout());

                        //---- textArea12 ----
                        textArea12.setLineWrap(true);
                        panel15.add(textArea12, BorderLayout.CENTER);

                        //---- button15 ----
                        button15.setText("\u9759\u6b62\u963b\u585e\u8fdb\u7a0b\u8868");
                        button15.addActionListener(e -> button15ActionPerformed(e));
                        panel15.add(button15, BorderLayout.NORTH);
                    }
                    scrollPane12.setViewportView(panel15);
                }
                panel2.add(scrollPane12);
            }
            dialogPane.add(panel2, BorderLayout.CENTER);

            //======== panel3 ========
            {
                panel3.setLayout(new GridLayout());

                //======== panel5 ========
                {
                    panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));

                    //======== panel7 ========
                    {
                        panel7.setLayout(new BoxLayout(panel7, BoxLayout.X_AXIS));

                        //======== scrollPane10 ========
                        {
                            scrollPane10.setViewportView(textArea10);
                        }
                        panel7.add(scrollPane10);

                        //---- button7 ----
                        button7.setText("\u6302    \u8d77");
                        button7.addActionListener(e -> {
                            button7ActionPerformed(e);
                            button9ActionPerformed(e);
                            button10ActionPerformed(e);
                            button11ActionPerformed(e);
                            button12ActionPerformed(e);
                            button13ActionPerformed(e);
                            button14ActionPerformed(e);
                            button15ActionPerformed(e);
                        });
                        panel7.add(button7);
                    }
                    panel5.add(panel7);

                    //======== panel6 ========
                    {
                        panel6.setLayout(new BoxLayout(panel6, BoxLayout.X_AXIS));

                        //======== scrollPane9 ========
                        {
                            scrollPane9.setViewportView(textArea9);
                        }
                        panel6.add(scrollPane9);

                        //---- button6 ----
                        button6.setText("\u6fc0    \u6d3b");
                        button6.addActionListener(e -> {
                            button6ActionPerformed(e);
                            button9ActionPerformed(e);
                            button10ActionPerformed(e);
                            button11ActionPerformed(e);
                            button12ActionPerformed(e);
                            button13ActionPerformed(e);
                            button14ActionPerformed(e);
                            button15ActionPerformed(e);
                        });
                        panel6.add(button6);
                    }
                    panel5.add(panel6);

                    //======== panel8 ========
                    {
                        panel8.setLayout(new BoxLayout(panel8, BoxLayout.X_AXIS));

                        //======== scrollPane11 ========
                        {
                            scrollPane11.setViewportView(textArea11);
                        }
                        panel8.add(scrollPane11);

                        //---- button8 ----
                        button8.setText("\u8bf7\u6c42IO");
                        button8.addActionListener(e -> {
                            button8ActionPerformed(e);
                            button9ActionPerformed(e);
                            button10ActionPerformed(e);
                            button11ActionPerformed(e);
                            button12ActionPerformed(e);
                            button13ActionPerformed(e);
                            button14ActionPerformed(e);
                            button15ActionPerformed(e);
                        });
                        panel8.add(button8);
                    }
                    panel5.add(panel8);

                    //======== panel9 ========
                    {
                        panel9.setLayout(new BoxLayout(panel9, BoxLayout.X_AXIS));

                        //======== scrollPane13 ========
                        {
                            scrollPane13.setViewportView(textArea13);
                        }
                        panel9.add(scrollPane13);

                        //---- button16 ----
                        button16.setText("IO\u5b8c\u6210");
                        button16.addActionListener(e -> {
                            button16ActionPerformed(e);
                            button9ActionPerformed(e);
                            button10ActionPerformed(e);
                            button11ActionPerformed(e);
                            button12ActionPerformed(e);
                            button13ActionPerformed(e);
                            button14ActionPerformed(e);
                            button15ActionPerformed(e);
                        });
                        panel9.add(button16);
                    }
                    panel5.add(panel9);

                    //======== panel17 ========
                    {
                        panel17.setLayout(new BoxLayout(panel17, BoxLayout.X_AXIS));

                        //======== scrollPane14 ========
                        {
                            scrollPane14.setViewportView(textArea14);
                        }
                        panel17.add(scrollPane14);

                        //---- button17 ----
                        button17.setText("\u91ca    \u653e");
                        button17.addActionListener(e -> {
                            button17ActionPerformed(e);
                            button9ActionPerformed(e);
                            button10ActionPerformed(e);
                            button11ActionPerformed(e);
                            button12ActionPerformed(e);
                            button13ActionPerformed(e);
                            button14ActionPerformed(e);
                            button15ActionPerformed(e);
                        });
                        panel17.add(button17);
                    }
                    panel5.add(panel17);
                }
                panel3.add(panel5);

                //======== panel4 ========
                {
                    panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));

                    //======== scrollPane1 ========
                    {

                        //---- textArea1 ----
                        textArea1.setText("\u8f93\u51fa\u7a97\u4f53");
                        textArea1.setLineWrap(true);
                        scrollPane1.setViewportView(textArea1);
                    }
                    panel4.add(scrollPane1);
                }
                panel3.add(panel4);
            }
            dialogPane.add(panel3, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        new Test().setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel panel1;
    private JButton button3;
    private JScrollPane scrollPane8;
    private JTextArea textArea8;
    private JButton button1;
    private JButton button18;
    private JButton button2;
    private JButton button5;
    private JButton button4;
    private JPanel panel2;
    private JScrollPane scrollPane2;
    private JPanel panel16;
    private JTextArea textArea2;
    private JButton button9;
    private JScrollPane scrollPane3;
    private JPanel panel10;
    private JTextArea textArea3;
    private JButton button10;
    private JScrollPane scrollPane4;
    private JPanel panel11;
    private JTextArea textArea4;
    private JButton button11;
    private JScrollPane scrollPane5;
    private JPanel panel12;
    private JTextArea textArea5;
    private JButton button12;
    private JScrollPane scrollPane6;
    private JPanel panel13;
    private JTextArea textArea6;
    private JButton button13;
    private JScrollPane scrollPane7;
    private JPanel panel14;
    private JTextArea textArea7;
    private JButton button14;
    private JScrollPane scrollPane12;
    private JPanel panel15;
    private JTextArea textArea12;
    private JButton button15;
    private JPanel panel3;
    private JPanel panel5;
    private JPanel panel7;
    private JScrollPane scrollPane10;
    private JTextArea textArea10;
    private JButton button7;
    private JPanel panel6;
    private JScrollPane scrollPane9;
    private JTextArea textArea9;
    private JButton button6;
    private JPanel panel8;
    private JScrollPane scrollPane11;
    private JTextArea textArea11;
    private JButton button8;
    private JPanel panel9;
    private JScrollPane scrollPane13;
    private JTextArea textArea13;
    private JButton button16;
    private JPanel panel17;
    private JScrollPane scrollPane14;
    private JTextArea textArea14;
    private JButton button17;
    private JPanel panel4;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
