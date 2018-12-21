/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepfilefind;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author owner
 */
public class DeepFileFind extends javax.swing.JFrame {
    DFF dff;
    Map<String, JTextComponent> fields = new HashMap<>();
    
    boolean maxSizeCheckBoxAutoEnabled = false;
    /**
     * Creates new form DeepFileFind
     */
    public DeepFileFind() {
        
        //Add listener to components that can bring up popup menus.
        //MouseListener popupListener = new PopupListener();
        //this.resultsTable.addMouseListener(popupListener);
        //output.addMouseListener(popupListener);
        //menuBar.addMouseListener(popupListener);   
        
        
        initComponents();
        this.setTitle("DeepFileFind");
        dff = new DFF();
        for (String line : dff.locations) {
            this.locationComboBox.addItem(line);
        }
        if (dff.profilePath!=null) {
            DefaultComboBoxModel model = (DefaultComboBoxModel)this.locationComboBox.getModel();
            if (model.getIndexOf(dff.profilePath) < 0)
                this.locationComboBox.addItem(dff.profilePath);
        }
        // select most recent:
        this.locationComboBox.setSelectedIndex(this.locationComboBox.getItemCount()-1);
        DFFShutdownHook dffsh = new DFFShutdownHook();
        dffsh.app = this;
        Runtime.getRuntime().addShutdownHook(dffsh);
        fields.put("max_size", this.maxSizeTextField);
        fields.put("min_size", this.minSizeTextField);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        nameTextField = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        foldersCheckBox = new javax.swing.JCheckBox();
        recursiveCheckBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        contentTextField = new javax.swing.JTextField();
        locationComboBox = new javax.swing.JComboBox<>();
        contentCheckBox = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        minSizeCheckBox = new javax.swing.JCheckBox();
        minSizeTextField = new javax.swing.JTextField();
        maxSizeTextField = new javax.swing.JTextField();
        maxSizeCheckBox = new javax.swing.JCheckBox();
        statusTextField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(350);

        resultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Path", "Ext", "Modified", "Created", "Name"
            }
        ));
        resultsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                resultsTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(resultsTable);
        if (resultsTable.getColumnModel().getColumnCount() > 0) {
            resultsTable.getColumnModel().getColumn(0).setPreferredWidth(400);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel1);

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        findButton.setText("Find");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        foldersCheckBox.setText("Include folders as results");

        recursiveCheckBox.setSelected(true);
        recursiveCheckBox.setText("Search Subfolders");

        jLabel1.setText("Location(s):");

        contentTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentTextFieldActionPerformed(evt);
            }
        });
        contentTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contentTextFieldKeyTyped(evt);
            }
        });

        locationComboBox.setEditable(true);

        contentCheckBox.setText("Contains:");
        contentCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentCheckBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Size:");

        minSizeCheckBox.setText("Min");

        minSizeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minSizeTextFieldActionPerformed(evt);
            }
        });
        minSizeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                minSizeTextFieldKeyTyped(evt);
            }
        });

        maxSizeTextField.setText("2048000");
        maxSizeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxSizeTextFieldActionPerformed(evt);
            }
        });
        maxSizeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                maxSizeTextFieldKeyTyped(evt);
            }
        });

        maxSizeCheckBox.setText("Max");
        maxSizeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxSizeCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(contentCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(locationComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(contentTextField)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(59, 59, 59)
                        .addComponent(minSizeCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maxSizeCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maxSizeTextField))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameTextField)
                            .addComponent(foldersCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recursiveCheckBox)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(findButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findButton)
                    .addComponent(cancelButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(foldersCheckBox)
                    .addComponent(recursiveCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(locationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contentCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(minSizeCheckBox)
                    .addComponent(minSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxSizeCheckBox)
                    .addComponent(maxSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 302, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel2);

        statusTextField.setMaximumSize(new java.awt.Dimension(20, 2147483647));
        statusTextField.setMinimumSize(new java.awt.Dimension(4, 20));
        statusTextField.setName(""); // NOI18N

        jMenu1.setText("File");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Save List");
        jMenu1.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setForeground(new java.awt.Color(153, 0, 0));
        jMenuItem1.setText("Delete Actual Files Listed");
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Exit");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem5.setText("Find");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");

        jMenuItem4.setText("About");
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(statusTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        this.executeSearch();
    }//GEN-LAST:event_findButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        //if (dff.searchThread!=null) {
            //dff.searchThread.in
        //}
        if (dff!=null) dff.enable = false;
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void contentCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentCheckBoxActionPerformed
        if (this.contentCheckBox.isSelected()) {
            if (!this.maxSizeCheckBox.isSelected()) maxSizeCheckBoxAutoEnabled = true;
            //else maxSizeCheckBoxAutoEnabled = false;
            this.maxSizeCheckBox.setSelected(true);
        }
        else {
            if (maxSizeCheckBoxAutoEnabled) {
                this.maxSizeCheckBox.setSelected(false);
                maxSizeCheckBoxAutoEnabled = false;
            }
        }
    }//GEN-LAST:event_contentCheckBoxActionPerformed

    private void contentTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentTextFieldActionPerformed
        this.executeSearch();
    }//GEN-LAST:event_contentTextFieldActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        this.executeSearch();
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void contentTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contentTextFieldKeyTyped
        if (this.contentTextField.getText().trim().length()==0) {
            this.contentCheckBox.setSelected(false);
            if (maxSizeCheckBoxAutoEnabled) {
                this.maxSizeCheckBox.setSelected(false);
                maxSizeCheckBoxAutoEnabled = false;
            }
        }
        else {
            this.contentCheckBox.setSelected(true);
            if (!this.maxSizeCheckBox.isSelected()) maxSizeCheckBoxAutoEnabled = true;
            //else maxSizeCheckBoxAutoEnabled = false;
            this.maxSizeCheckBox.setSelected(true);
        }
    }//GEN-LAST:event_contentTextFieldKeyTyped

    private void maxSizeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxSizeCheckBoxActionPerformed
        
    }//GEN-LAST:event_maxSizeCheckBoxActionPerformed

    private void maxSizeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxSizeTextFieldActionPerformed
        
    }//GEN-LAST:event_maxSizeTextFieldActionPerformed

    private void minSizeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minSizeTextFieldActionPerformed
        this.minSizeCheckBox.setSelected(true);
    }//GEN-LAST:event_minSizeTextFieldActionPerformed

    private void minSizeTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_minSizeTextFieldKeyTyped
        if (this.minSizeTextField.getText().trim().length()==0) {
            this.minSizeCheckBox.setSelected(false);
        }
        else {
            this.minSizeCheckBox.setSelected(true);
        }
    }//GEN-LAST:event_minSizeTextFieldKeyTyped

    private void maxSizeTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maxSizeTextFieldKeyTyped
        if (this.maxSizeTextField.getText().trim().length()==0) {
            this.maxSizeCheckBox.setSelected(false);
        }
        else {
            this.maxSizeCheckBox.setSelected(true);
        }
    }//GEN-LAST:event_maxSizeTextFieldKeyTyped

    private void resultsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultsTableMousePressed
        JTable source = (JTable)evt.getSource();
        int row = source.rowAtPoint( evt.getPoint() );
        int col = source.columnAtPoint( evt.getPoint() );

        if (! source.isRowSelected(row))
            source.changeSelection(row, col, false, false);
        JTable t = (JTable)evt.getSource();
        JMenuItem menuItem;
        if ((evt.getClickCount() == 2) && (evt.getButton() == MouseEvent.BUTTON1)) {
            String sub_path = (String)this.resultsTable.getValueAt(row, col);
            //System.out.println("double-clicked item " + sub_path);
            File sub = new File(sub_path);
            //if (sub.exists()) {
            try {
                Desktop.getDesktop().open(sub);
            } catch (IOException ex) {
                Logger.getLogger(DeepFileFind.class.getName()).log(Level.SEVERE, null, ex);
            }
            //}
            //else {
            //    this.statusTextField.setText("ERROR: Could not find file " + sub.getAbsolutePath());
            //}

        }
        else if (evt.getButton() == MouseEvent.BUTTON3) {
            JPopupMenu popup = new JPopupMenu();
            menuItem = new JMenuItem("Open Containing Directory");
            menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    clickOpenContainingActionPerformed(evt);
                }
            });
            popup.add(menuItem);
            MouseListener popupListener = new PopupListener();
            popup.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_resultsTableMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeepFileFind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeepFileFind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeepFileFind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeepFileFind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeepFileFind().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox contentCheckBox;
    private javax.swing.JTextField contentTextField;
    private javax.swing.JButton findButton;
    private javax.swing.JCheckBox foldersCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JComboBox<String> locationComboBox;
    private javax.swing.JCheckBox maxSizeCheckBox;
    private javax.swing.JTextField maxSizeTextField;
    private javax.swing.JCheckBox minSizeCheckBox;
    private javax.swing.JTextField minSizeTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JCheckBox recursiveCheckBox;
    private javax.swing.JTable resultsTable;
    private javax.swing.JTextField statusTextField;
    // End of variables declaration//GEN-END:variables

    void saveState() {
        if (dff != null) {
            //DefaultComboBoxModel model = (DefaultComboBoxModel)this.locationComboBox.getModel();
            ComboBoxModel<String> model = this.locationComboBox.getModel();
            for(int i=0; i<model.getSize(); i++) {
                String element = model.getElementAt(i);
                //System.out.println("adding '" + element + "'");
                if (dff.locations.indexOf(element) < 0)
                    dff.locations.add(element);
            }
            String element = (String)locationComboBox.getEditor().getItem();
            if (element != null) {
                //if not an item but was typed manually
                if (dff.locations.indexOf(element) < 0)
                    dff.locations.add(element);
                //System.out.println("manually adding '" + element + "'");
            }
            dff.saveState();
        }
    }
    
    public void markEntry (String fieldName, boolean good) {
        Color color = Color.white;
        if (!good) color = Color.yellow;
        JTextComponent component = this.fields.get(fieldName);
        if (component!=null) component.setBackground(color);
        //if (fieldName == "max_size") this.maxSizeTextField.setBackground(color);
    }
    public void markAllEntries(boolean good) {
        Color color = Color.white;
        if (!good) color = Color.yellow;
        for (String key : this.fields.keySet()) {
            JTextComponent component = this.fields.get(key);
            if (component!=null) component.setBackground(color);
        }
    }
    void executeSearch() {
        //markEntry("max_size", true);
        this.markAllEntries(true);
        //this.resultsTable.removeAll(); //doesn't work
        DefaultTableModel model = (DefaultTableModel)resultsTable.getModel();
        model.setRowCount(0);        
        dff.options.put("name_string", this.nameTextField.getText());
        dff.options.put("location_paths", "");
        //if (this.locationComboBox.getSelectedItem()!=null)
            //dff.options.put("location_paths", this.locationComboBox.getSelectedItem().toString());
        //NOTE: getSelectedItem does NOT work for item currently being edited, so:
        dff.options.put("location_paths", (String)locationComboBox.getEditor().getItem());
        //getSelectedItem: You can get the selected or typed value from a JComboBox by calling method getSelectedItem . If it is not an existing item, then you'll get a String object. Otherwise you'll get whatever object you populated the combo box with.
        dff.options.put("content_string", this.contentTextField.getText());
        dff.options.put("content_enable", this.contentCheckBox.isSelected()?"true":"false");
        dff.options.put("include_folders_as_results_enable", this.foldersCheckBox.isSelected() ? "true" : "false");
        dff.options.put("recursive_enable", this.recursiveCheckBox.isSelected() ? "true" : "false");
        dff.options.put("min_size_enable", this.minSizeCheckBox.isSelected() ? "true" : "false");
        dff.options.put("min_size", this.minSizeTextField.getText());
        dff.options.put("max_size_enable", this.maxSizeCheckBox.isSelected() ? "true" : "false");
        dff.options.put("max_size", this.maxSizeTextField.getText());
        
        DFFMatchEventListener mListener = new DFFMatchEventListener();
        mListener.table = this.resultsTable;
        mListener.app = this;
        mListener.statusTextField = this.statusTextField;
        dff.registerOnGeekEventListener(mListener); 
        dff.executeSearch(); 
    }
    
    private void clickOpenContainingActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // JMenuItem me = evt.getSource();
        int row = this.resultsTable.getSelectedRow();
        int col = this.resultsTable.getSelectedColumn();
        String sub_path = (String)this.resultsTable.getValueAt(row, col);
        //System.out.println("clicked popup item " + sub_path);
        File sub = new File(sub_path);
        File parent = sub.getParentFile();
        //if (parent.exists()) {
        try {
            Desktop.getDesktop().open(parent);
        } catch (IOException ex) {
            Logger.getLogger(DeepFileFind.class.getName()).log(Level.SEVERE, null, ex);
        }
        //}
        //else {
        //    this.statusTextField.setText("ERROR: Could not find path containing " + sub.getAbsolutePath());
        //}
    }

    //private static class PopupListener implements MouseListener { //suggested by NetBeans
    private class PopupListener extends MouseAdapter {
        // see also <https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html#popup>
        //JPopupMenu popup;

            /*
        private PopupListener() { //JPopupMenu popup
            //Create the popup menu.
            popup = new JPopupMenu();
            JMenuItem menuItem;
            menuItem = new JMenuItem("A popup menu item");
            menuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    clickOpenContainingActionPerformed(evt);
                }
            });
            popup.add(menuItem);
            menuItem = new JMenuItem("Another popup menu item");
            menuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    clickOpenContainingActionPerformed(evt);
                }
            });
            popup.add(menuItem);
        }
*/
        
        
        /*
        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                popup.show(e.getComponent(),
                           e.getX(), e.getY());
            }
        }
        */
    }
}
