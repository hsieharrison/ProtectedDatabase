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
/*     */ public class Login
/*     */   extends JFrame
/*     */ {
/*     */   JPanel loginPanel;
/*     */   JButton buttLogin;
/*     */   JTextField userText;
/*     */   JTextField passText;
/*     */   JLabel userLabel;
/*     */   JLabel passLabel;
/*     */   
/*     */   public Login() {
/*  31 */     super("Login");
/*     */     
/*  33 */     this.loginPanel = new JPanel();
/*  34 */     this.buttLogin = new JButton("Login");
/*  35 */     this.userText = new JTextField(30);
/*  36 */     this.passText = new JPasswordField(30);
/*  37 */     this.userLabel = new JLabel("User Name");
/*  38 */     this.passLabel = new JLabel("Password");
/*     */     
/*  40 */     this.loginPanel.setBackground(Color.DARK_GRAY);
/*  41 */     this.loginPanel.setLayout(new BoxLayout(this.loginPanel, 1));
/*     */     
/*  43 */     setLocation(500, 280);
/*     */ 
/*     */     
/*  46 */     this.userText.setMaximumSize(this.userText.getPreferredSize());
/*  47 */     this.passText.setMaximumSize(this.passText.getPreferredSize());
/*  48 */     this.userLabel.setForeground(Color.WHITE);
/*  49 */     this.passLabel.setForeground(Color.WHITE);
/*     */     
/*  51 */     this.userText.setBounds(70, 30, 100, 20);
/*  52 */     this.passText.setBounds(70, 65, 100, 20);
/*  53 */     this.buttLogin.setBounds(70, 70, 150, 20);
/*  54 */     this.buttLogin.setBackground(Color.LIGHT_GRAY);
/*     */     
/*  56 */     this.loginPanel.add(this.userLabel);
/*  57 */     this.loginPanel.add(this.userText);
/*  58 */     this.loginPanel.add(this.passLabel);
/*  59 */     this.loginPanel.add(this.passText);
/*  60 */     this.loginPanel.add(this.buttLogin);
/*     */     
/*  62 */     getContentPane().add(this.loginPanel);
/*  63 */     setDefaultCloseOperation(3);
/*  64 */     setVisible(true);
/*     */     
/*  66 */     Writer writer = null;
/*  67 */     File check = new File("userPass.txt");
/*  68 */     if (!check.exists()) {
/*     */       
/*     */       try {
/*     */ 
/*     */         
/*  73 */         File texting = new File("userPass.txt");
/*  74 */         writer = new BufferedWriter(new FileWriter(texting));
/*  75 */         writer.write("message");
/*  76 */       } catch (IOException e) {
/*  77 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  82 */     this.buttLogin.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*     */             try {
/*  85 */               File file = new File("userPass.txt");
/*  86 */               Scanner scan = new Scanner(file);
/*  87 */               String line = null;
/*  88 */               FileWriter filewrite = new FileWriter(file, true);
/*     */               
/*  90 */               String usertxt = " ";
/*  91 */               String passtxt = " ";
/*  92 */               String user = Login.this.userText.getText();
/*  93 */               String pass = Login.this.passText.getText();
/*  94 */               String hash = null;
/*  95 */               boolean loginValid = false;
/*  96 */               boolean loginEmpty = false;
/*  97 */               User temp = new User();
/*  98 */               while (scan.hasNext()) {
/*  99 */                 hash = scan.nextLine();
/* 100 */                 temp.ModifyUserPW(user, pass);
/* 101 */                 if (temp.equals(hash)) {
/*     */                   
/* 103 */                   loginValid = true;
/*     */                   continue;
/*     */                 } 
/* 106 */                 if (user.equals("") && pass.equals(""))
/*     */                 {
/* 108 */                   loginEmpty = true;
/*     */                 }
/*     */               } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 118 */               if (loginEmpty) {
/* 119 */                 JOptionPane.showMessageDialog(null, "Please insert Username and Password");
/*     */               }
/* 121 */               else if (loginValid) {
/* 122 */                 JOptionPane.showMessageDialog(null, String.valueOf(user) + " is logged in.");
/*     */                 
/* 124 */                 File folder = new File(String.valueOf(System.getProperty("user.dir")) + "\\" + user);
/* 125 */                 folder.mkdir();
/* 126 */                 File firstFile = new File(String.valueOf(folder.getAbsolutePath()) + "\\firstTxt.txt");
/* 127 */                 firstFile.createNewFile();
/* 128 */                 Login.this.openFileManager(folder.getAbsolutePath());
/*     */               } else {
/*     */                 
/* 131 */                 JOptionPane.showMessageDialog(null, "Wrong Username / Password");
/* 132 */                 Login.this.userText.setText("");
/* 133 */                 Login.this.passText.setText("");
/* 134 */                 Login.this.userText.requestFocus();
/*     */               }
/*     */             
/*     */             }
/* 138 */             catch (IOException d) {
/* 139 */               d.printStackTrace();
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void openFileManager(String userPath) {
/* 146 */     FileManagerGUIDesigner fileManager = new FileManagerGUIDesigner(userPath);
/* 147 */     fileManager.setDefaultCloseOperation(3);
/* 148 */     fileManager.setSize(400, 400);
/* 149 */     fileManager.setVisible(true); } public void listFilesForFolder(File folder, JPanel folderPanel) { byte b;
/*     */     int i;
/*     */     File[] arrayOfFile;
/* 152 */     for (i = (arrayOfFile = folder.listFiles()).length, b = 0; b < i; ) { File fileEntry = arrayOfFile[b];
/* 153 */       JLabel newLabel = null;
/* 154 */       if (fileEntry.isDirectory()) {
/* 155 */         listFilesForFolder(fileEntry, folderPanel);
/*     */       } else {
/*     */         
/* 158 */         newLabel = new JLabel(fileEntry.getName());
/* 159 */       }  System.out.println(newLabel.getText());
/* 160 */       folderPanel.add(newLabel);
/*     */       b++; }
/*     */      }
/*     */ 
/*     */ }


/* Location:              C:\Users\Josh\Desktop\Protected Database.jar!\Login.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */