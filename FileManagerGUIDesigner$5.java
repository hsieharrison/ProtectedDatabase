/*     */ import java.awt.Desktop;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.io.File;
/*     */ import javax.swing.JList;
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
/*     */   extends MouseAdapter
/*     */ {
/*     */   public void mouseClicked(MouseEvent evt) {
/* 139 */     JList list = (JList)evt.getSource();
/* 140 */     if (evt.getClickCount() == 2) {
/*     */ 
/*     */       
/* 143 */       int index = list.locationToIndex(evt.getPoint());
/* 144 */       File temp = new File(FileManagerGUIDesigner.access$1(FileManagerGUIDesigner.this));
/* 145 */       String[] contents = temp.list();
/* 146 */       String fileToOpen = String.valueOf(FileManagerGUIDesigner.access$1(FileManagerGUIDesigner.this)) + "\\" + contents[index];
/* 147 */       JOptionPane.showMessageDialog(null, fileToOpen);
/*     */       try {
/* 149 */         Desktop.getDesktop().open(new File(fileToOpen));
/* 150 */       } catch (Exception e) {
/* 151 */         JOptionPane.showMessageDialog(null, "Not a valid address.");
/*     */       }
/*     */     
/* 154 */     } else if (evt.getClickCount() == 3) {
/*     */ 
/*     */       
/* 157 */       int i = list.locationToIndex(evt.getPoint());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Josh\Desktop\Protected Database.jar!\FileManagerGUIDesigner$5.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */