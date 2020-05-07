/*     */ import java.awt.Font;
/*     */ import java.awt.event.ItemEvent;
/*     */ import java.awt.event.ItemListener;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CheckBoxHandler
/*     */   implements ItemListener
/*     */ {
/*  89 */   private int valBold = 0;
/*  90 */   private int valItalic = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void itemStateChanged(ItemEvent event) {
/*  96 */     if (event.getSource() == JavaGUI.this.boldCheckBox) {
/*  97 */       this.valBold = 
/*  98 */         JavaGUI.this.boldCheckBox.isSelected() ? 1 : 0;
/*     */     }
/*     */     
/* 101 */     if (event.getSource() == JavaGUI.this.italicCheckBox) {
/* 102 */       this.valItalic = 
/* 103 */         JavaGUI.this.italicCheckBox.isSelected() ? 2 : 0;
/*     */     }
/*     */     
/* 106 */     JavaGUI.this.txt.setFont(
/* 107 */         new Font("Serif", this.valBold + this.valItalic, 14));
/*     */   }
/*     */   
/*     */   private CheckBoxHandler() {}
/*     */ }


/* Location:              C:\Users\Josh\Desktop\Protected Database.jar!\JavaGUI$CheckBoxHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */