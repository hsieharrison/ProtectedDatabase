/*     */ import java.awt.Color;
/*     */ import java.awt.Desktop;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.awt.event.WindowListener;
/*     */ import java.io.File;
/*     */ import javax.swing.AbstractAction;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.DefaultListModel;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPopupMenu;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSplitPane;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.JTree;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.event.TreeExpansionEvent;
/*     */ import javax.swing.event.TreeExpansionListener;
/*     */ import javax.swing.event.TreeSelectionEvent;
/*     */ import javax.swing.event.TreeSelectionListener;
/*     */ import javax.swing.tree.DefaultMutableTreeNode;
/*     */ import javax.swing.tree.DefaultTreeModel;
/*     */ import javax.swing.tree.TreeCellRenderer;
/*     */ import javax.swing.tree.TreePath;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileManagerGUIDesigner
/*     */   extends JFrame
/*     */ {
/*     */   class DirExpansionListener
/*     */     implements TreeExpansionListener
/*     */   {
/*     */     public void treeCollapsed(TreeExpansionEvent event) {}
/*     */     
/*     */     public void treeExpanded(TreeExpansionEvent event) {
/* 239 */       final DefaultMutableTreeNode node = FileManagerGUIDesigner.this.getTreeNode(event.getPath());
/* 240 */       final FileNode fnode = FileManagerGUIDesigner.this.getFileNode(node);
/*     */       
/* 242 */       Thread runner = new Thread() {
/*     */           public void run() {
/* 244 */             if (fnode != null && fnode.expand(node)) {
/* 245 */               Runnable runnable = new Runnable() {
/*     */                   public void run() {
/* 247 */                     (FileManagerGUIDesigner.DirExpansionListener.access$0(FileManagerGUIDesigner.DirExpansionListener.null.access$0(FileManagerGUIDesigner.DirExpansionListener.null.this))).m_model.reload(node);
/*     */                   }
/*     */                 };
/* 250 */               SwingUtilities.invokeLater(runnable);
/*     */             } 
/*     */           }
/*     */         };
/* 254 */       runner.start();
/*     */     }
/*     */   } public static final ImageIcon ICON_COMPUTER = new ImageIcon("src/Resources/Icons/computer.png"); public static final ImageIcon ICON_DISK = new ImageIcon("src/Resources/Icons/disk.png"); public static final ImageIcon ICON_FOLDER = new ImageIcon("src/Resources/Icons/folder.png"); public static final ImageIcon ICON_EXPANDEDFOLDER = new ImageIcon("src/Resources/Icons/folder_open.png"); protected JTree m_tree; protected DefaultTreeModel m_model; protected JTextField m_display; protected JPopupMenu m_popup; protected Action m_action; protected TreePath m_clickedPath; private JSplitPane splitPane; private String currentAddress = ""; private JList list_1; private DefaultListModel list_model; private JPopupMenu list_popup; public void goToAddress(String address) { try { File path = new File(address); if (!path.exists()) { JOptionPane.showMessageDialog(null, "Not a valid address."); return; }  String[] list = path.list(); for (int i = 0; i < list.length; i++) JOptionPane.showMessageDialog(null, list[i]);  } catch (Exception e) { JOptionPane.showMessageDialog(null, "Not a valid address."); }  } public void populateList(String address) { try { this.list_model.removeAllElements(); File path = new File(address); if (!path.exists()) { JOptionPane.showMessageDialog(null, "Not a valid address."); return; }  String[] list = path.list(); for (int i = 0; i < list.length; i++) this.list_model.addElement(list[i]);  } catch (Exception e) { JOptionPane.showMessageDialog(null, "Not a valid address."); }  } public FileManagerGUIDesigner(String userPath) { super("Directories Tree [Popup Menus]"); setSize(641, 448); DefaultMutableTreeNode top = new DefaultMutableTreeNode(new IconData(ICON_COMPUTER, null, "Computer")); File[] roots = File.listRoots(); File userFolder = new File(userPath); DefaultMutableTreeNode node = new DefaultMutableTreeNode(new IconData(ICON_DISK, null, new FileNode(userFolder))); top.add(node); node.add(new DefaultMutableTreeNode(new Boolean(true))); this.m_model = new DefaultTreeModel(top); this.list_model = new DefaultListModel(); this.m_display = new JTextField(); this.m_display.addKeyListener(new KeyAdapter() { public void keyPressed(KeyEvent e) { FileManagerGUIDesigner.this.goToAddress(FileManagerGUIDesigner.this.m_display.getText()); } }
/*     */       ); this.m_display.setEditable(false); getContentPane().add(this.m_display, "North"); this.m_action = new AbstractAction() { public void actionPerformed(ActionEvent e) { if (FileManagerGUIDesigner.this.m_clickedPath == null) return;  if (FileManagerGUIDesigner.this.m_tree.isExpanded(FileManagerGUIDesigner.this.m_clickedPath)) { FileManagerGUIDesigner.this.m_tree.collapsePath(FileManagerGUIDesigner.this.m_clickedPath); } else { FileManagerGUIDesigner.this.m_tree.expandPath(FileManagerGUIDesigner.this.m_clickedPath); }  } }
/*     */       ; Action a1 = new AbstractAction("Delete") { public void actionPerformed(ActionEvent e) { FileManagerGUIDesigner.this.m_tree.repaint(); JOptionPane.showMessageDialog(FileManagerGUIDesigner.this, "Delete option is not implemented", "Info", 1); } }
/*     */       ; Action a2 = new AbstractAction("Rename") { public void actionPerformed(ActionEvent e) { FileManagerGUIDesigner.this.m_tree.repaint(); JOptionPane.showMessageDialog(FileManagerGUIDesigner.this, "Rename option is not implemented", "Info", 1); } }
/*     */       ; this.m_tree = new JTree(this.m_model); this.m_tree.setFont(new Font("Tahoma", 0, 15)); this.m_tree.setBackground(Color.GRAY); this.m_tree.putClientProperty("JTree.lineStyle", "Angled"); TreeCellRenderer renderer = new IconCellRenderer(); this.m_tree.setCellRenderer(renderer); this.m_tree.addTreeExpansionListener(new DirExpansionListener()); this.m_tree.addTreeSelectionListener(new DirSelectionListener()); this.m_tree.getSelectionModel().setSelectionMode(1); this.m_tree.setShowsRootHandles(true); this.m_tree.setEditable(false); this.list_1 = new JList(this.list_model); this.list_1.addMouseListener(new MouseAdapter() { public void mouseClicked(MouseEvent evt) { JList list = (JList)evt.getSource(); if (evt.getClickCount() == 2) { int index = list.locationToIndex(evt.getPoint()); File temp = new File(FileManagerGUIDesigner.this.currentAddress); String[] contents = temp.list(); String fileToOpen = String.valueOf(FileManagerGUIDesigner.this.currentAddress) + "\\" + contents[index]; JOptionPane.showMessageDialog(null, fileToOpen); try { Desktop.getDesktop().open(new File(fileToOpen)); } catch (Exception e) { JOptionPane.showMessageDialog(null, "Not a valid address."); }  } else if (evt.getClickCount() == 3) { int i = list.locationToIndex(evt.getPoint()); }  } }
/*     */       ); JScrollPane tree = new JScrollPane(); tree.setViewportView(this.m_tree); this.m_popup = new JPopupMenu(); this.m_popup.add(this.m_action); this.m_popup.addSeparator(); this.m_popup.add(a1); this.m_popup.add(a2); this.m_tree.add(this.m_popup); this.list_popup = new JPopupMenu(); this.list_popup.add(a1); this.list_popup.add(a2); this.list_1.add(this.list_popup); this.splitPane = new JSplitPane(); this.splitPane.setLeftComponent(tree); this.splitPane.setRightComponent(this.list_1); getContentPane().add(this.splitPane, "Center"); this.splitPane.setRightComponent(this.list_1); this.m_tree.addMouseListener(new PopupTrigger()); WindowListener wndCloser = new WindowAdapter() {
/*     */         public void windowClosing(WindowEvent e) { System.exit(0); }
/* 263 */       }; addWindowListener(wndCloser); setVisible(true); } DefaultMutableTreeNode getTreeNode(TreePath path) { return (DefaultMutableTreeNode)path.getLastPathComponent(); } FileNode getFileNode(DefaultMutableTreeNode node) { if (node == null) return null;  Object obj = node.getUserObject(); if (obj instanceof IconData) obj = ((IconData)obj).getObject();  if (obj instanceof FileNode) return (FileNode)obj;  return null; } class PopupTrigger extends MouseAdapter { public void mouseReleased(MouseEvent e) { if (e.isPopupTrigger()) { int x = e.getX(); int y = e.getY(); TreePath path = FileManagerGUIDesigner.this.m_tree.getPathForLocation(x, y); if (path != null) { if (FileManagerGUIDesigner.this.m_tree.isExpanded(path)) { FileManagerGUIDesigner.this.m_action.putValue("Name", "Collapse"); } else { FileManagerGUIDesigner.this.m_action.putValue("Name", "Expand"); }  FileManagerGUIDesigner.this.m_popup.show(FileManagerGUIDesigner.this.m_tree, x, y); FileManagerGUIDesigner.this.m_clickedPath = path; }  }  } } class DirSelectionListener implements TreeSelectionListener { public void valueChanged(TreeSelectionEvent event) { DefaultMutableTreeNode node = FileManagerGUIDesigner.this.getTreeNode(event.getPath());
/* 264 */       FileNode fnode = FileManagerGUIDesigner.this.getFileNode(node);
/* 265 */       if (fnode != null) {
/* 266 */         FileManagerGUIDesigner.this.m_display.setText(fnode.getFile().getAbsolutePath());
/* 267 */         FileManagerGUIDesigner.this.currentAddress = FileManagerGUIDesigner.this.m_display.getText();
/* 268 */         FileManagerGUIDesigner.this.populateList(FileManagerGUIDesigner.this.currentAddress);
/*     */       } else {
/* 270 */         FileManagerGUIDesigner.this.m_display.setText("");
/* 271 */         FileManagerGUIDesigner.this.currentAddress = "";
/*     */       }  }
/*     */      }
/*     */ 
/*     */ }


/* Location:              C:\Users\Josh\Desktop\Protected Database.jar!\FileManagerGUIDesigner.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */