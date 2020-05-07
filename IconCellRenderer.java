/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Graphics;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTree;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.tree.DefaultMutableTreeNode;
/*     */ import javax.swing.tree.TreeCellRenderer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class IconCellRenderer
/*     */   extends JLabel
/*     */   implements TreeCellRenderer
/*     */ {
/*     */   protected Color m_textSelectionColor;
/*     */   protected Color m_textNonSelectionColor;
/*     */   protected Color m_bkSelectionColor;
/*     */   protected Color m_bkNonSelectionColor;
/*     */   protected Color m_borderSelectionColor;
/*     */   protected boolean m_selected;
/*     */   
/*     */   public IconCellRenderer() {
/* 290 */     this.m_textSelectionColor = UIManager.getColor("Tree.selectionForeground");
/*     */     
/* 292 */     this.m_textNonSelectionColor = Color.WHITE;
/* 293 */     this.m_bkSelectionColor = UIManager.getColor("Tree.selectionBackground");
/*     */     
/* 295 */     this.m_bkNonSelectionColor = null;
/* 296 */     this.m_borderSelectionColor = UIManager.getColor("Tree.selectionBorderColor");
/* 297 */     setOpaque(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
/* 304 */     DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
/* 305 */     Object obj = node.getUserObject();
/* 306 */     setText(obj.toString());
/*     */     
/* 308 */     if (obj instanceof Boolean) {
/* 309 */       setText("Retrieving data...");
/*     */     }
/* 311 */     if (obj instanceof IconData)
/* 312 */     { IconData idata = (IconData)obj;
/* 313 */       if (expanded) {
/* 314 */         setIcon(idata.getExpandedIcon());
/*     */       } else {
/* 316 */         setIcon(idata.getIcon());
/*     */       }  }
/* 318 */     else { setIcon((Icon)null); }
/*     */     
/* 320 */     setFont(tree.getFont());
/* 321 */     setForeground(sel ? this.m_textSelectionColor : this.m_textNonSelectionColor);
/* 322 */     setBackground(sel ? this.m_bkSelectionColor : this.m_bkNonSelectionColor);
/* 323 */     this.m_selected = sel;
/* 324 */     return this;
/*     */   }
/*     */   
/*     */   public void paintComponent(Graphics g) {
/* 328 */     Color bColor = getBackground();
/* 329 */     Icon icon = getIcon();
/*     */     
/* 331 */     g.setColor(bColor);
/* 332 */     int offset = 0;
/* 333 */     if (icon != null && getText() != null)
/* 334 */       offset = icon.getIconWidth() + getIconTextGap(); 
/* 335 */     g.fillRect(offset, 0, getWidth() - 1 - offset, getHeight() - 1);
/*     */     
/* 337 */     if (this.m_selected) {
/* 338 */       g.setColor(this.m_borderSelectionColor);
/* 339 */       g.drawRect(offset, 0, getWidth() - 1 - offset, getHeight() - 1);
/*     */     } 
/*     */     
/* 342 */     super.paintComponent(g);
/*     */   }
/*     */ }


/* Location:              C:\Users\Josh\Desktop\Protected Database.jar!\IconCellRenderer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */