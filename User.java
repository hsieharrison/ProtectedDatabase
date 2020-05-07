/*    */ 
/*    */ 
/*    */ 
/*    */ public class User
/*    */ {
/*    */   private String username;
/*    */   private String pw;
/*    */   private String hash;
/*    */   
/*    */   public User() {
/* 11 */     this.username = null;
/* 12 */     this.pw = null;
/*    */   }
/*    */   
/*    */   public User(String username, String pw) {
/* 16 */     this.username = username;
/* 17 */     this.pw = pw;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 21 */     int prime = 31;
/* 22 */     int result = 1;
/* 23 */     result = 31 * result + ((this.pw == null) ? 0 : this.pw.hashCode());
/* 24 */     result = 31 * result + ((this.username == null) ? 0 : this.username.hashCode());
/* 25 */     this.hash = Integer.toString(result);
/* 26 */     return result;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(String hash) {
/* 31 */     return hash.matches(this.hash);
/*    */   }
/*    */   public void ModifyUserPW(String user, String pass) {
/* 34 */     this.username = user;
/* 35 */     this.pw = pass;
/* 36 */     hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Users\Josh\Desktop\Protected Database.jar!\User.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */