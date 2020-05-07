/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.Scanner;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements ActionListener
/*     */ {
/*     */   public void actionPerformed(ActionEvent e) {
/*     */     try {
/*  85 */       File file = new File("userPass.txt");
/*  86 */       Scanner scan = new Scanner(file);
/*  87 */       String line = null;
/*  88 */       FileWriter filewrite = new FileWriter(file, true);
/*     */       
/*  90 */       String usertxt = " ";
/*  91 */       String passtxt = " ";
/*  92 */       String user = Login.this.userText.getText();
/*  93 */       String pass = Login.this.passText.getText();
/*  94 */       String hash = null;
/*  95 */       boolean loginValid = false;
/*  96 */       boolean loginEmpty = false;
/*  97 */       User temp = new User();
/*  98 */       while (scan.hasNext()) {
/*  99 */         hash = scan.nextLine();
/* 100 */         temp.ModifyUserPW(user, pass);
/* 101 */         if (temp.equals(hash)) {
/*     */           
/* 103 */           loginValid = true;
/*     */           continue;
/*     */         } 
/* 106 */         if (user.equals("") && pass.equals(""))
/*     */         {
/* 108 */           loginEmpty = true;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 118 */       if (loginEmpty) {
/* 119 */         JOptionPane.showMessageDialog(null, "Please insert Username and Password");
/*     */       }
/* 121 */       else if (loginValid) {
/* 122 */         JOptionPane.showMessageDialog(null, String.valueOf(user) + " is logged in.");
/*     */         
/* 124 */         File folder = new File(String.valueOf(System.getProperty("user.dir")) + "\\" + user);
/* 125 */         folder.mkdir();
/* 126 */         File firstFile = new File(String.valueOf(folder.getAbsolutePath()) + "\\firstTxt.txt");
/* 127 */         firstFile.createNewFile();
/* 128 */         Login.this.openFileManager(folder.getAbsolutePath());
/*     */       } else {
/*     */         
/* 131 */         JOptionPane.showMessageDialog(null, "Wrong Username / Password");
/* 132 */         Login.this.userText.setText("");
/* 133 */         Login.this.passText.setText("");
/* 134 */         Login.this.userText.requestFocus();
/*     */       }
/*     */     
/*     */     }
/* 138 */     catch (IOException d) {
/* 139 */       d.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Josh\Desktop\Protected Database.jar!\Login$1.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */