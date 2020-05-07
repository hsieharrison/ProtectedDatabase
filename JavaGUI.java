/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.ItemEvent;
/*     */ import java.awt.event.ItemListener;
/*     */ import javax.swing.BoxLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JavaGUI
/*     */   extends JFrame
/*     */ {
/*     */   JPanel panel;
/*     */   JLabel label;
/*     */   JTextField txt;
/*     */   JButton button;
/*     */   JCheckBox boldCheckBox;
/*     */   JCheckBox italicCheckBox;
/*     */   JList list;
/*     */   
/*     */   public JavaGUI() {
/*  31 */     super("JavaGUI");
/*  32 */     String[] names = { "Dr.Lin", "Xavier", "Chris", "Justin", "My Uncle", 
/*  33 */         "Las Vegas", "Money", "Hello" };
/*  34 */     this.panel = new JPanel();
/*  35 */     this.label = new JLabel("Label Goes Here!");
/*  36 */     this.txt = new JTextField(30);
/*  37 */     this.button = new JButton("CLICK!");
/*  38 */     this.boldCheckBox = new JCheckBox();
/*  39 */     this.italicCheckBox = new JCheckBox();
/*  40 */     this.list = new JList<>(names);
/*  41 */     this.panel.setLayout(new BoxLayout(this.panel, 1));
/*  42 */     setLocation(500, 280);
/*     */     
/*  44 */     this.list.setVisibleRowCount(3);
/*  45 */     this.list.setFixedCellWidth(100);
/*  46 */     this.list.setFixedCellHeight(15);
/*  47 */     this.list.setSelectionMode(
/*  48 */         1);
/*  49 */     this.txt.setMaximumSize(this.txt.getPreferredSize());
/*  50 */     this.txt.setBounds(70, 30, 100, 20);
/*  51 */     this.button.setBounds(70, 40, 100, 20);
/*  52 */     this.list.setBounds(70, 30, 100, 20);
/*  53 */     this.boldCheckBox.setBounds(70, 30, 100, 20);
/*  54 */     this.italicCheckBox.setBounds(70, 30, 100, 20);
/*     */     
/*  56 */     this.panel.add(this.label);
/*  57 */     this.panel.add(this.txt);
/*  58 */     this.panel.add(this.button);
/*  59 */     this.panel.add(this.boldCheckBox);
/*  60 */     this.panel.add(this.italicCheckBox);
/*  61 */     this.panel.add(this.list);
/*     */     
/*  63 */     getContentPane().add(this.panel);
/*  64 */     setDefaultCloseOperation(3);
/*  65 */     setVisible(true);
/*     */ 
/*     */     
/*  68 */     CheckBoxHandler handler = new CheckBoxHandler(null);
/*  69 */     this.boldCheckBox.addItemListener(handler);
/*  70 */     this.italicCheckBox.addItemListener(handler);
/*     */     
/*  72 */     this.button.addActionListener(
/*     */         
/*  74 */         new ActionListener()
/*     */         {
/*     */           
/*     */           public void actionPerformed(ActionEvent event)
/*     */           {
/*  79 */             int x = JavaGUI.this.list.getSelectedIndex() + 1;
/*  80 */             JavaGUI.this.txt.setText("You selected number " + x + " from the list");
/*  81 */             JavaGUI.this.label.setText("You clicked the button!");
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private class CheckBoxHandler
/*     */     implements ItemListener {
/*     */     private CheckBoxHandler() {
/*  89 */       this.valBold = 0;
/*  90 */       this.valItalic = 0;
/*     */     }
/*     */     private int valBold;
/*     */     private int valItalic;
/*     */     
/*     */     public void itemStateChanged(ItemEvent event) {
/*  96 */       if (event.getSource() == JavaGUI.this.boldCheckBox) {
/*  97 */         this.valBold = 
/*  98 */           JavaGUI.this.boldCheckBox.isSelected() ? 1 : 0;
/*     */       }
/*     */       
/* 101 */       if (event.getSource() == JavaGUI.this.italicCheckBox) {
/* 102 */         this.valItalic = 
/* 103 */           JavaGUI.this.italicCheckBox.isSelected() ? 2 : 0;
/*     */       }
/*     */       
/* 106 */       JavaGUI.this.txt.setFont(
/* 107 */           new Font("Serif", this.valBold + this.valItalic, 14));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Josh\Desktop\Protected Database.jar!\JavaGUI.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */