/*     */ import java.io.File;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.tree.DefaultMutableTreeNode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FileNode
/*     */ {
/*     */   protected File m_file;
/*     */   
/*     */   public FileNode(File file) {
/* 384 */     this.m_file = file;
/*     */   }
/*     */   
/*     */   public File getFile() {
/* 388 */     return this.m_file;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 392 */     return (this.m_file.getName().length() > 0) ? this.m_file.getName() : this.m_file.getPath();
/*     */   }
/*     */   
/*     */   public boolean expand(DefaultMutableTreeNode parent) {
/* 396 */     DefaultMutableTreeNode flag = (DefaultMutableTreeNode)parent.getFirstChild();
/* 397 */     if (flag == null)
/* 398 */       return false; 
/* 399 */     Object obj = flag.getUserObject();
/* 400 */     if (!(obj instanceof Boolean)) {
/* 401 */       return false;
/*     */     }
/* 403 */     parent.removeAllChildren();
/*     */     
/* 405 */     File[] files = listFiles();
/* 406 */     if (files == null) {
/* 407 */       return true;
/*     */     }
/* 409 */     Vector<FileNode> v = new Vector();
/*     */     
/* 411 */     for (int k = 0; k < files.length; k++) {
/* 412 */       File f = files[k];
/* 413 */       if (f.isDirectory()) {
/*     */ 
/*     */         
/* 416 */         FileNode newNode = new FileNode(f);
/*     */         
/* 418 */         boolean isAdded = false;
/* 419 */         for (int j = 0; j < v.size(); j++) {
/* 420 */           FileNode nd = v.elementAt(j);
/* 421 */           if (newNode.compareTo(nd) < 0) {
/* 422 */             v.insertElementAt(newNode, j);
/* 423 */             isAdded = true;
/*     */             break;
/*     */           } 
/*     */         } 
/* 427 */         if (!isAdded)
/* 428 */           v.addElement(newNode); 
/*     */       } 
/*     */     } 
/* 431 */     for (int i = 0; i < v.size(); i++) {
/* 432 */       FileNode nd = v.elementAt(i);
/* 433 */       IconData idata = new IconData(FileManagerGUIDesigner.ICON_FOLDER, 
/* 434 */           FileManagerGUIDesigner.ICON_EXPANDEDFOLDER, nd);
/* 435 */       DefaultMutableTreeNode node = new DefaultMutableTreeNode(idata);
/* 436 */       parent.add(node);
/*     */       
/* 438 */       if (nd.hasSubDirs()) {
/* 439 */         node.add(new DefaultMutableTreeNode(new Boolean(true)));
/*     */       }
/*     */     } 
/* 442 */     return true;
/*     */   }
/*     */   
/*     */   public boolean hasSubDirs() {
/* 446 */     File[] files = listFiles();
/* 447 */     if (files == null)
/* 448 */       return false; 
/* 449 */     for (int k = 0; k < files.length; k++) {
/* 450 */       if (files[k].isDirectory())
/* 451 */         return true; 
/*     */     } 
/* 453 */     return false;
/*     */   }
/*     */   
/*     */   public int compareTo(FileNode toCompare) {
/* 457 */     return this.m_file.getName().compareToIgnoreCase(toCompare.m_file.getName());
/*     */   }
/*     */   
/*     */   protected File[] listFiles() {
/* 461 */     if (!this.m_file.isDirectory())
/* 462 */       return null; 
/*     */     try {
/* 464 */       return this.m_file.listFiles();
/* 465 */     } catch (Exception ex) {
/* 466 */       JOptionPane.showMessageDialog(null, "Error reading directory " + this.m_file.getAbsolutePath(), "Warning", 
/* 467 */           2);
/* 468 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Josh\Desktop\Protected Database.jar!\FileNode.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */