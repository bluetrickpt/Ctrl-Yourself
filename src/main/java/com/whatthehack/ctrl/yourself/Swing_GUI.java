/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whatthehack.ctrl.yourself;

import com.whatthehack.ctrl.yourself.comms.Client;
import com.whatthehack.ctrl.yourself.comms.Server;
import com.whatthehack.ctrl.yourself.game.GameManager;
import com.whatthehack.ctrl.yourself.helpers.CommsHelper;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Filipe
 */
public class Swing_GUI extends javax.swing.JFrame {

    /**
     * Creates new form Swing_GUI
     */
    private Boolean portValidated;
    private Boolean nickValidated;
    private Boolean ipValidated;

    private GameManager gameManager;

    public Swing_GUI(GameManager gameManager) {

        portValidated = false;
        nickValidated = false;
        ipValidated = false;

        this.gameManager = gameManager;

        initComponents();

        java.awt.event.WindowAdapter close_handler = new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                Server server = gameManager.getServer();
                if (server != null) {
                    //server.sendShutdownMessage(); //TODO
                    dispose();
                    System.exit(0);
                }
            }
        };

        this.addWindowListener(close_handler);
        d_Login.addWindowListener(close_handler);
        d_Login.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        d_Login = new javax.swing.JDialog();
        p_buttons = new javax.swing.JPanel();
        b_create = new javax.swing.JButton();
        b_join = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tf_Nickname = new javax.swing.JTextField();
        t_Nickname = new javax.swing.JLabel();
        t_Port = new javax.swing.JLabel();
        tf_Port = new javax.swing.JTextField();
        d_HostIP = new javax.swing.JDialog();
        p_HostIP = new javax.swing.JPanel();
        b_Connnect = new javax.swing.JButton();
        t_HostIP = new javax.swing.JLabel();
        p_IP = new javax.swing.JPanel();
        tf_IP1 = new javax.swing.JTextField();
        tf_IP2 = new javax.swing.JTextField();
        tf_IP3 = new javax.swing.JTextField();
        tf_IP4 = new javax.swing.JTextField();
        t_point1 = new javax.swing.JLabel();
        t_point2 = new javax.swing.JLabel();
        t_point3 = new javax.swing.JLabel();
        d_Rules = new javax.swing.JDialog();
        sp_Rules = new javax.swing.JScrollPane();
        ta_Rules = new javax.swing.JTextArea();
        p_submitMessage = new javax.swing.JPanel();
        tf_message = new javax.swing.JTextField();
        b_sendNudes = new javax.swing.JButton();
        p_chat = new javax.swing.JPanel();
        chatUsersOnline = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        l_users = new javax.swing.JList<>();
        p_messages = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        l_messages = new javax.swing.JList<>();
        mb_Menu = new javax.swing.JMenuBar();
        m_file = new javax.swing.JMenu();
        mi_quit = new javax.swing.JMenuItem();
        m_help = new javax.swing.JMenu();
        mi_rules = new javax.swing.JMenuItem();

        d_Login.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        d_Login.setTitle("Ctrl-Yourself");
        d_Login.setAlwaysOnTop(true);
        d_Login.setMinimumSize(new java.awt.Dimension(777, 508));
        d_Login.setResizable(false);

        p_buttons.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        b_create.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b_create.setText("Create");
        b_create.setEnabled(false);
        b_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_createActionPerformed(evt);
            }
        });

        b_join.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b_join.setText("Join");
        b_join.setEnabled(false);
        b_join.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_joinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_buttonsLayout = new javax.swing.GroupLayout(p_buttons);
        p_buttons.setLayout(p_buttonsLayout);
        p_buttonsLayout.setHorizontalGroup(
            p_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_buttonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b_create, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(79, 79, 79)
                .addComponent(b_join, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        p_buttonsLayout.setVerticalGroup(
            p_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_buttonsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(p_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_join, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(b_create, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tf_Nickname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_Nickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_NicknameActionPerformed(evt);
            }
        });
        tf_Nickname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_NicknameKeyTyped(evt);
            }
        });

        t_Nickname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t_Nickname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t_Nickname.setText("Nickname:");

        t_Port.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t_Port.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        t_Port.setText("Port:");
        t_Port.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        tf_Port.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_Port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_PortActionPerformed(evt);
            }
        });
        tf_Port.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_PortKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(t_Port, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tf_Port, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(t_Nickname)
                        .addGap(17, 17, 17)
                        .addComponent(tf_Nickname, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Nickname, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_Nickname, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_Port, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(t_Port, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout d_LoginLayout = new javax.swing.GroupLayout(d_Login.getContentPane());
        d_Login.getContentPane().setLayout(d_LoginLayout);
        d_LoginLayout.setHorizontalGroup(
            d_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_LoginLayout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addGroup(d_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_buttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        d_LoginLayout.setVerticalGroup(
            d_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_LoginLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(p_buttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        d_HostIP.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        d_HostIP.setMinimumSize(new java.awt.Dimension(460, 232));
        d_HostIP.setResizable(false);

        b_Connnect.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        b_Connnect.setText("Connect");
        b_Connnect.setEnabled(false);
        b_Connnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ConnnectActionPerformed(evt);
            }
        });

        t_HostIP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t_HostIP.setText("Host IP:");

        tf_IP1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_IP1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_IP1.setPreferredSize(new java.awt.Dimension(36, 28));
        tf_IP1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_IP1KeyTyped(evt);
            }
        });

        tf_IP2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_IP2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_IP2.setPreferredSize(new java.awt.Dimension(36, 28));
        tf_IP2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_IP2KeyTyped(evt);
            }
        });

        tf_IP3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_IP3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_IP3.setPreferredSize(new java.awt.Dimension(36, 28));
        tf_IP3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_IP3KeyTyped(evt);
            }
        });

        tf_IP4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_IP4.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_IP4.setPreferredSize(new java.awt.Dimension(36, 28));
        tf_IP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_IP4ActionPerformed(evt);
            }
        });
        tf_IP4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_IP4KeyTyped(evt);
            }
        });

        t_point1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t_point1.setText(".");

        t_point2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t_point2.setText(".");

        t_point3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t_point3.setText(".");

        javax.swing.GroupLayout p_IPLayout = new javax.swing.GroupLayout(p_IP);
        p_IP.setLayout(p_IPLayout);
        p_IPLayout.setHorizontalGroup(
            p_IPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_IPLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tf_IP1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(t_point1)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tf_IP2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(t_point2)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tf_IP3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(t_point3)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tf_IP4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        p_IPLayout.setVerticalGroup(
            p_IPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_IPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(p_IPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_IP1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_IP2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_IP4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_IP3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_point1)
                    .addComponent(t_point2)
                    .addComponent(t_point3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout p_HostIPLayout = new javax.swing.GroupLayout(p_HostIP);
        p_HostIP.setLayout(p_HostIPLayout);
        p_HostIPLayout.setHorizontalGroup(
            p_HostIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_HostIPLayout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(p_HostIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b_Connnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(p_HostIPLayout.createSequentialGroup()
                        .addComponent(t_HostIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(p_IP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        p_HostIPLayout.setVerticalGroup(
            p_HostIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_HostIPLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(p_HostIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(p_IP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_HostIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(b_Connnect, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout d_HostIPLayout = new javax.swing.GroupLayout(d_HostIP.getContentPane());
        d_HostIP.getContentPane().setLayout(d_HostIPLayout);
        d_HostIPLayout.setHorizontalGroup(
            d_HostIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_HostIPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_HostIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        d_HostIPLayout.setVerticalGroup(
            d_HostIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d_HostIPLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(p_HostIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        d_Rules.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        d_Rules.setTitle("Rules");
        d_Rules.setFocusable(false);
        d_Rules.setSize(new java.awt.Dimension(500, 400));

        ta_Rules.setColumns(20);
        ta_Rules.setRows(5);
        ta_Rules.setFocusable(false);
        sp_Rules.setViewportView(ta_Rules);

        javax.swing.GroupLayout d_RulesLayout = new javax.swing.GroupLayout(d_Rules.getContentPane());
        d_Rules.getContentPane().setLayout(d_RulesLayout);
        d_RulesLayout.setHorizontalGroup(
            d_RulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp_Rules, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        d_RulesLayout.setVerticalGroup(
            d_RulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp_Rules, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ctrl-Yourself");

        tf_message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_messageActionPerformed(evt);
            }
        });
        tf_message.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_messageKeyPressed(evt);
            }
        });

        b_sendNudes.setText("Send");
        b_sendNudes.setFocusPainted(false);
        b_sendNudes.setFocusable(false);
        b_sendNudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_sendNudesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_submitMessageLayout = new javax.swing.GroupLayout(p_submitMessage);
        p_submitMessage.setLayout(p_submitMessageLayout);
        p_submitMessageLayout.setHorizontalGroup(
            p_submitMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_submitMessageLayout.createSequentialGroup()
                .addComponent(tf_message, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_sendNudes, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
        );
        p_submitMessageLayout.setVerticalGroup(
            p_submitMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_submitMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(b_sendNudes, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addComponent(tf_message, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
        );

        l_users.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        l_users.setFocusable(false);
        jScrollPane1.setViewportView(l_users);

        javax.swing.GroupLayout chatUsersOnlineLayout = new javax.swing.GroupLayout(chatUsersOnline);
        chatUsersOnline.setLayout(chatUsersOnlineLayout);
        chatUsersOnlineLayout.setHorizontalGroup(
            chatUsersOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        chatUsersOnlineLayout.setVerticalGroup(
            chatUsersOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(l_messages);

        javax.swing.GroupLayout p_messagesLayout = new javax.swing.GroupLayout(p_messages);
        p_messages.setLayout(p_messagesLayout);
        p_messagesLayout.setHorizontalGroup(
            p_messagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        p_messagesLayout.setVerticalGroup(
            p_messagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        javax.swing.GroupLayout p_chatLayout = new javax.swing.GroupLayout(p_chat);
        p_chat.setLayout(p_chatLayout);
        p_chatLayout.setHorizontalGroup(
            p_chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_chatLayout.createSequentialGroup()
                .addComponent(p_messages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chatUsersOnline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        p_chatLayout.setVerticalGroup(
            p_chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatUsersOnline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p_messages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        m_file.setText("File");

        mi_quit.setText("Quit");
        mi_quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_quitActionPerformed(evt);
            }
        });
        m_file.add(mi_quit);

        mb_Menu.add(m_file);

        m_help.setText("Help");

        mi_rules.setText("Rules");
        mi_rules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_rulesActionPerformed(evt);
            }
        });
        m_help.add(mi_rules);

        mb_Menu.add(m_help);

        setJMenuBar(mb_Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_chat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p_submitMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(p_chat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(p_submitMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_NicknameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_NicknameKeyTyped
        // TODO add your handling code here:
        if (tf_Nickname.getText().length() >= 15) {
            evt.consume();
        }

        if (tf_Nickname.getText().length() >= 0) {
            nickValidated = true;
            t_Nickname.setForeground(Color.blue);
            if (portValidated) {
                b_create.setEnabled(true);
                b_join.setEnabled(true);
            }
        }
        if (tf_Nickname.getText().length() == 0) {
            nickValidated = false;
            t_Nickname.setForeground(Color.black);
            b_create.setEnabled(false);
            b_join.setEnabled(false);
        }
    }//GEN-LAST:event_tf_NicknameKeyTyped

    private void tf_PortKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_PortKeyTyped
        // TODO add your handling code here:
        if (tf_Port.getText().length() < 4) {
            portValidated = false;
            t_Port.setForeground(Color.black);
            b_create.setEnabled(false);
            b_join.setEnabled(false);
        }
        if (tf_Port.getText().length() == 3 && Character.isDigit(evt.getKeyChar())) {
            portValidated = true;
            t_Port.setForeground(Color.blue);
            if (nickValidated) {
                b_create.setEnabled(true);
                b_join.setEnabled(true);
            }
        }

        if (!Character.isDigit(evt.getKeyChar()) || tf_Port.getText().length() == 4) {
            portValidated = true;
            evt.consume();
        }

    }//GEN-LAST:event_tf_PortKeyTyped

    private void b_joinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_joinActionPerformed
        // TODO add your handling code here:
        d_Login.setVisible(false);
        d_HostIP.setVisible(true);
    }//GEN-LAST:event_b_joinActionPerformed

    private void b_sendNudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_sendNudesActionPerformed
        // TODO add your handling code here:
        String toSendMessage = tf_message.getText();
        if (!toSendMessage.isEmpty()) {
            gameManager.getClient().sendMessage(toSendMessage);
            tf_message.setText("");
        }
        tf_message.requestFocusInWindow();
    }//GEN-LAST:event_b_sendNudesActionPerformed

    private void b_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_createActionPerformed
        try {
            //isServer = true;
            d_Login.setVisible(false);

            gameManager.setNickname(tf_Nickname.getText());
            CommsHelper.setPort((short) Integer.parseInt(tf_Port.getText()));
            gameManager.setServer(new Server(gameManager, CommsHelper.getPort()));
            gameManager.setClient(new Client(
                    InetAddress.getLocalHost().getHostAddress(),
                    CommsHelper.getPort(), gameManager.getNickname(),
                    gameManager)
            );
            //gameManager.setTa_users(ta_users);
            gameManager.setL_users(l_users);
            gameManager.setChatWindow(l_messages);

            setVisible(true);
            tf_message.requestFocusInWindow();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Swing_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b_createActionPerformed

    private void tf_PortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_PortActionPerformed
        // TODO add your handling code here:
        if (tf_Port.getText().length() == 4) {
            portValidated = true;

            t_Port.setForeground(Color.blue);
            if (nickValidated) {
                b_create.setEnabled(true);
                b_join.setEnabled(true);
            }
        } else {
            portValidated = false;
            b_create.setEnabled(false);
            b_join.setEnabled(false);
        }
    }//GEN-LAST:event_tf_PortActionPerformed

    private void tf_IP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_IP4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_IP4ActionPerformed

    private void tf_IP1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_IP1KeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar()) || tf_IP1.getText().length() == 3) {
            evt.consume();
        }
        if (tf_IP1.getText().length() == 2 && Character.isDigit(evt.getKeyChar())) {
            tf_IP2.requestFocusInWindow();
        }
    }//GEN-LAST:event_tf_IP1KeyTyped

    private void tf_IP2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_IP2KeyTyped
        // TODO add your handling code here:

        if (!Character.isDigit(evt.getKeyChar()) || tf_IP2.getText().length() == 3) {
            evt.consume();
        }
        if (tf_IP2.getText().length() == 2 && Character.isDigit(evt.getKeyChar())) {
            tf_IP3.requestFocusInWindow();
        }
    }//GEN-LAST:event_tf_IP2KeyTyped

    private void tf_IP3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_IP3KeyTyped
        // TODO add your handling code here:

        if (!Character.isDigit(evt.getKeyChar()) || tf_IP3.getText().length() == 3) {
            evt.consume();
        }
        if (tf_IP3.getText().length() == 2 && Character.isDigit(evt.getKeyChar())) {
            tf_IP4.requestFocusInWindow();
        }
    }//GEN-LAST:event_tf_IP3KeyTyped

    private void tf_IP4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_IP4KeyTyped
        // TODO add your handling code here:

        if (!Character.isDigit(evt.getKeyChar()) || tf_IP4.getText().length() == 3) {
            evt.consume();
        }
        if (tf_IP4.getText().length() == 2 && Character.isDigit(evt.getKeyChar())) {
            b_Connnect.setEnabled(true);
        }
    }//GEN-LAST:event_tf_IP4KeyTyped

    private void b_ConnnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ConnnectActionPerformed
        // TODO add your handling code here:
        d_HostIP.setVisible(false);
        setVisible(true);
        tf_message.requestFocusInWindow();
    }//GEN-LAST:event_b_ConnnectActionPerformed

    private void mi_rulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_rulesActionPerformed
        // TODO add your handling code here:
        d_Rules.setVisible(true);
    }//GEN-LAST:event_mi_rulesActionPerformed

    private void mi_quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_quitActionPerformed
        // TODO add your handling code here:
        dispose();
        System.exit(0);
    }//GEN-LAST:event_mi_quitActionPerformed

    private void tf_NicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_NicknameActionPerformed
        // TODO add your handling code here:
        if (tf_Nickname.getText().length() <= 1) {
            nickValidated = false;
            t_Nickname.setForeground(Color.black);
        }
    }//GEN-LAST:event_tf_NicknameActionPerformed

    private void tf_messageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_messageKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String toSendMessage = tf_message.getText();
            if (!toSendMessage.isEmpty()) {
                gameManager.getClient().sendMessage(toSendMessage);
                tf_message.setText("");
            }
            tf_message.requestFocusInWindow();
        }
    }//GEN-LAST:event_tf_messageKeyPressed

    private void tf_messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_messageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_messageActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_Connnect;
    private javax.swing.JButton b_create;
    private javax.swing.JButton b_join;
    private javax.swing.JButton b_sendNudes;
    private javax.swing.JPanel chatUsersOnline;
    private javax.swing.JDialog d_HostIP;
    private javax.swing.JDialog d_Login;
    private javax.swing.JDialog d_Rules;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> l_messages;
    private javax.swing.JList<String> l_users;
    private javax.swing.JMenu m_file;
    private javax.swing.JMenu m_help;
    private javax.swing.JMenuBar mb_Menu;
    private javax.swing.JMenuItem mi_quit;
    private javax.swing.JMenuItem mi_rules;
    private javax.swing.JPanel p_HostIP;
    private javax.swing.JPanel p_IP;
    private javax.swing.JPanel p_buttons;
    private javax.swing.JPanel p_chat;
    private javax.swing.JPanel p_messages;
    private javax.swing.JPanel p_submitMessage;
    private javax.swing.JScrollPane sp_Rules;
    private javax.swing.JLabel t_HostIP;
    private javax.swing.JLabel t_Nickname;
    private javax.swing.JLabel t_Port;
    private javax.swing.JLabel t_point1;
    private javax.swing.JLabel t_point2;
    private javax.swing.JLabel t_point3;
    private javax.swing.JTextArea ta_Rules;
    private javax.swing.JTextField tf_IP1;
    private javax.swing.JTextField tf_IP2;
    private javax.swing.JTextField tf_IP3;
    private javax.swing.JTextField tf_IP4;
    private javax.swing.JTextField tf_Nickname;
    private javax.swing.JTextField tf_Port;
    private javax.swing.JTextField tf_message;
    // End of variables declaration//GEN-END:variables
}
