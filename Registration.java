/*     */ import java.awt.Color;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.util.Scanner;
/*     */ import javax.swing.BoxLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JPasswordField;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Registration
/*     */   extends JFrame
/*     */ {
/*     */   JPanel registerPane;
/*     */   JButton register;
/*     */   JTextField userText;
/*     */   JPasswordField passText;
/*     */   JPasswordField repassText;
/*     */   
/*     */   public Registration() {
/*  31 */     super("Registration");
/*  32 */     this.register = new JButton("Register");
/*  33 */     this.registerPane = new JPanel();
/*  34 */     this.userText = new JTextField(30);
/*  35 */     this.passText = new JPasswordField(30);
/*  36 */     this.repassText = new JPasswordField(30);
/*  37 */     this.register.setBackground(Color.LIGHT_GRAY);
/*  38 */     JLabel userLabel = new JLabel("User Name");
/*  39 */     userLabel.setForeground(Color.WHITE);
/*  40 */     JLabel passLabel = new JLabel("Password");
/*  41 */     passLabel.setForeground(Color.WHITE);
/*  42 */     JLabel repassLabel = new JLabel("Retype Password");
/*  43 */     repassLabel.setForeground(Color.WHITE);
/*  44 */     this.registerPane.setBackground(Color.DARK_GRAY);
/*  45 */     this.registerPane.setLayout(new BoxLayout(this.registerPane, 1));
/*     */     
/*  47 */     setLocation(450, 280);
/*     */ 
/*     */     
/*  50 */     this.userText.setMaximumSize(this.userText.getPreferredSize());
/*  51 */     this.passText.setMaximumSize(this.passText.getPreferredSize());
/*  52 */     this.repassText.setMaximumSize(this.repassText.getPreferredSize());
/*     */     
/*  54 */     this.userText.setBounds(70, 30, 100, 20);
/*  55 */     this.passText.setBounds(70, 65, 100, 20);
/*  56 */     this.repassText.setBounds(70, 65, 100, 20);
/*  57 */     this.register.setBounds(70, 70, 150, 20);
/*     */     
/*  59 */     this.registerPane.add(userLabel);
/*  60 */     this.registerPane.add(this.userText);
/*  61 */     this.registerPane.add(passLabel);
/*  62 */     this.registerPane.add(this.passText);
/*  63 */     this.registerPane.add(repassLabel);
/*  64 */     this.registerPane.add(this.repassText);
/*  65 */     this.registerPane.add(this.register);
/*     */     
/*  67 */     getContentPane().add(this.registerPane);
/*  68 */     setDefaultCloseOperation(3);
/*  69 */     setVisible(true);
/*     */     
/*  71 */     Writer writer = null;
/*  72 */     File check = new File("userPass.txt");
/*  73 */     if (!check.exists()) {
/*     */       
/*     */       try {
/*     */ 
/*     */         
/*  78 */         File texting = new File("userPass.txt");
/*  79 */         writer = new BufferedWriter(new FileWriter(texting));
/*  80 */         writer.write("message");
/*  81 */       } catch (IOException e) {
/*  82 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/*  86 */     this.register.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*     */             try {
/*  89 */               File file = new File("userPass.txt");
/*  90 */               Scanner scan = new Scanner(file);
/*     */               
/*  92 */               FileWriter filewrite = new FileWriter(file, true);
/*     */               
/*  94 */               String usertxter = " ";
/*  95 */               String passtxter = " ";
/*  96 */               String user = Registration.this.userText.getText();
/*  97 */               String pass = Registration.this.passText.getText();
/*  98 */               String repass = Registration.this.repassText.getText();
/*  99 */               while (scan.hasNext()) {
/* 100 */                 usertxter = scan.nextLine();
/*     */               }
/*     */ 
/*     */               
/* 104 */               if (user.equals(usertxter) && pass.equals(passtxter)) {
/* 105 */                 JOptionPane.showMessageDialog(null, "Username is already in use");
/* 106 */                 Registration.this.userText.setText("");
/* 107 */                 Registration.this.passText.setText("");
/* 108 */                 Registration.this.userText.requestFocus();
/*     */               
/*     */               }
/* 111 */               else if (user.length() < 3 || user.length() > 10) {
/* 112 */                 JOptionPane.showMessageDialog(null, "Please make the User Name between 3 and 10 characters");
/* 113 */                 Registration.this.userText.requestFocus();
/*     */               
/*     */               }
/* 116 */               else if (user.equals("") && pass.equals("")) {
/* 117 */                 JOptionPane.showMessageDialog(null, "Please insert Username and Password");
/*     */               }
/* 119 */               else if (!pass.equals(repass)) {
/* 120 */                 JOptionPane.showMessageDialog(null, "Please input the same password into 'Retype Password'");
/* 121 */                 Registration.this.passText.requestFocus();
/*     */               }
/* 123 */               else if (pass.length() < 4 || pass.length() > 10) {
/* 124 */                 JOptionPane.showMessageDialog(null, "Please make the password between 4 and 10 characters");
/* 125 */                 Registration.this.passText.requestFocus();
/*     */               } else {
/*     */                 
/* 128 */                 User test = new User(user, pass);
/* 129 */                 filewrite.write(String.valueOf(Integer.toString(test.hashCode())) + "\r\n");
/* 130 */                 filewrite.close();
/* 131 */                 JOptionPane.showMessageDialog(null, "Account has been created.");
/* 132 */                 Registration.this.dispose();
/* 133 */                 Registration.openLogin();
/*     */               } 
/* 135 */             } catch (IOException d) {
/* 136 */               d.printStackTrace();
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 144 */     JFrame startFrame = new JFrame("Protected Database");
/* 145 */     JPanel startPanel = new JPanel();
/* 146 */     JButton loginButton = new JButton("Login");
/* 147 */     loginButton.setBackground(Color.WHITE);
/* 148 */     JButton registerButton = new JButton("Register");
/* 149 */     registerButton.setBackground(Color.WHITE);
/* 150 */     JLabel welcomeLabel = new JLabel("Welcome! ");
/* 151 */     welcomeLabel.setForeground(Color.WHITE);
/* 152 */     JLabel selectLabel = new JLabel("Please make a selection:");
/* 153 */     selectLabel.setForeground(Color.WHITE);
/* 154 */     startPanel.setBackground(Color.darkGray);
/* 155 */     startPanel.setLayout(new BoxLayout(startPanel, 1));
/* 156 */     startPanel.add(welcomeLabel);
/* 157 */     startPanel.add(selectLabel);
/* 158 */     startPanel.add(loginButton);
/* 159 */     startPanel.add(registerButton);
/* 160 */     startFrame.getContentPane().add(startPanel);
/* 161 */     startFrame.setDefaultCloseOperation(3);
/* 162 */     startFrame.setSize(500, 300);
/* 163 */     startFrame.setVisible(true);
/* 164 */     loginButton.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent arg0)
/*     */           {
/* 168 */             Registration.openLogin();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 173 */     registerButton.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent arg0)
/*     */           {
/* 177 */             Registration registration = new Registration();
/* 178 */             registration.setDefaultCloseOperation(2);
/* 179 */             registration.setSize(400, 400);
/* 180 */             registration.setVisible(true);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public static void openLogin() {
/* 187 */     Login login = new Login();
/* 188 */     login.setDefaultCloseOperation(2);
/* 189 */     login.setSize(400, 400);
/* 190 */     login.setVisible(true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Josh\Desktop\Protected Database.jar!\Registration.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */