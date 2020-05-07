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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements ActionListener
/*     */ {
/*     */   public void actionPerformed(ActionEvent e) {
/*     */     try {
/*  89 */       File file = new File("userPass.txt");
/*  90 */       Scanner scan = new Scanner(file);
/*     */       
/*  92 */       FileWriter filewrite = new FileWriter(file, true);
/*     */       
/*  94 */       String usertxter = " ";
/*  95 */       String passtxter = " ";
/*  96 */       String user = Registration.this.userText.getText();
/*  97 */       String pass = Registration.this.passText.getText();
/*  98 */       String repass = Registration.this.repassText.getText();
/*  99 */       while (scan.hasNext()) {
/* 100 */         usertxter = scan.nextLine();
/*     */       }
/*     */ 
/*     */       
/* 104 */       if (user.equals(usertxter) && pass.equals(passtxter)) {
/* 105 */         JOptionPane.showMessageDialog(null, "Username is already in use");
/* 106 */         Registration.this.userText.setText("");
/* 107 */         Registration.this.passText.setText("");
/* 108 */         Registration.this.userText.requestFocus();
/*     */       
/*     */       }
/* 111 */       else if (user.length() < 3 || user.length() > 10) {
/* 112 */         JOptionPane.showMessageDialog(null, "Please make the User Name between 3 and 10 characters");
/* 113 */         Registration.this.userText.requestFocus();
/*     */       
/*     */       }
/* 116 */       else if (user.equals("") && pass.equals("")) {
/* 117 */         JOptionPane.showMessageDialog(null, "Please insert Username and Password");
/*     */       }
/* 119 */       else if (!pass.equals(repass)) {
/* 120 */         JOptionPane.showMessageDialog(null, "Please input the same password into 'Retype Password'");
/* 121 */         Registration.this.passText.requestFocus();
/*     */       }
/* 123 */       else if (pass.length() < 4 || pass.length() > 10) {
/* 124 */         JOptionPane.showMessageDialog(null, "Please make the password between 4 and 10 characters");
/* 125 */         Registration.this.passText.requestFocus();
/*     */       } else {
/*     */         
/* 128 */         User test = new User(user, pass);
/* 129 */         filewrite.write(String.valueOf(Integer.toString(test.hashCode())) + "\r\n");
/* 130 */         filewrite.close();
/* 131 */         JOptionPane.showMessageDialog(null, "Account has been created.");
/* 132 */         Registration.this.dispose();
/* 133 */         Registration.openLogin();
/*     */       } 
/* 135 */     } catch (IOException d) {
/* 136 */       d.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Josh\Desktop\Protected Database.jar!\Registration$1.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */