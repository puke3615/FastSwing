package com.puke.getter.test;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MyFrame extends javax.swing.JFrame {
    public static void main(String[] args) {
        MyFrame f = new MyFrame();
    }

    JLabel label;
    JLabel username;
    JLabel password;
    JTextField username_ip;
    JPasswordField password_ip;
    JRadioButton remeber;
    JRadioButton autoLogin;

    JButton login;
    JButton bt2;

    public MyFrame() {
        this.setVisible(true);
        this.setSize(250, 220);
        this.setVisible(true);
        this.setLocation(400, 200);

        label = new JLabel("华软BBS快捷登陆");
        username = new JLabel("账号：");
        password = new JLabel("密码：");
        username_ip = new JTextField();
        password_ip = new JPasswordField();
        remeber = new JRadioButton("记住密码");
        autoLogin = new JRadioButton("自动登陆");
        login = new JButton("登陆");
        // 为指定的 Container 创建 GroupLayout
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);

        //创建GroupLayout的水平连续组，，越先加入的ParallelGroup，优先级级别越高。
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGap(5)//添加间隔
                .addGroup(
                        layout.createParallelGroup()
                                .addComponent(username)
                                .addComponent(password)
                )
                .addGap(5)
                .addGroup(
                        layout.createParallelGroup()
                                .addComponent(label)
                                .addComponent(password_ip)
                                .addComponent(remeber)
                                .addComponent(autoLogin)
                                .addComponent(username_ip)
                                .addComponent(login)
                )
                .addGap(5));

        //创建GroupLayout的垂直连续组，，越先加入的ParallelGroup，优先级级别越高。
        //设置垂直组
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(10)
                .addGroup(
                        layout.createParallelGroup()
                                .addComponent(label)
                )
                .addGap(10)
                .addGroup(
                        layout.createParallelGroup()
                                .addComponent(username)
                                .addComponent(username_ip)
                )
                .addGap(5)
                .addGroup(
                        layout.createParallelGroup()
                                .addComponent(password)
                                .addComponent(password_ip)
                )
                .addGroup(
                        layout.createParallelGroup()
                                .addComponent(remeber)
                )

                .addGroup(
                        layout.createParallelGroup()
                                .addComponent(autoLogin)
                )
                .addGroup(
                        layout.createParallelGroup(Alignment.TRAILING)
                                .addComponent(login)
                )
                .addGap(10));
    }
}
