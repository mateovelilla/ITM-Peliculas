/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peliculas.vistas;

import javax.swing.JOptionPane;
import peliculas.negocio.director;
import org.json.JSONArray;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author wong
 */
public class consultarDirector extends javax.swing.JFrame {

    /**
     * Creates new form consultarDirector
     */
    public consultarDirector() {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTextId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JTextNombre = new javax.swing.JTextField();
        JTextNacion = new javax.swing.JTextField();
        JTextNac = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblDirectores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CONSULTAR DIRECTOR");

        jLabel2.setText("Id:");

        JTextId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextIdActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre:");

        jLabel4.setText("Nacion:");

        jLabel5.setText("Fecha de nacimiento:");

        JTextNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextNombreActionPerformed(evt);
            }
        });

        JTextNacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextNacionActionPerformed(evt);
            }
        });

        JTextNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextNacActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Consultar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        TblDirectores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TblDirectores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblDirectoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblDirectores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JTextNacion, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel4))
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JTextNac, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(JTextId, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextNacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jToggleButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTextIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextIdActionPerformed

    private void JTextNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextNombreActionPerformed

    private void JTextNacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextNacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextNacionActionPerformed

    private void JTextNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextNacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextNacActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        int  id = JTextId.getText().length() == 0 ? 0 : Integer.parseInt(JTextId.getText());
        String nombre = JTextNombre.getText();
        String nacion = JTextNacion.getText();
        String fechaNacimiento = JTextNac.getText();
        director Direct =  new director();
        JSONArray datos = Direct.consutar(id, nombre, nacion, fechaNacimiento);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nacion");
        modelo.addColumn("Fecha nacimiento");
        modelo.addColumn("Eliminar");
        
        try{
            for (int i = 0; i < datos.length(); i++) {
                if(datos.getJSONObject(i)!= null){
                    Object [] fila = new Object[5];
                    fila[0] = datos.getJSONObject(i).get("id");
                    fila[1] = datos.getJSONObject(i).get("nombre");
                    fila[2] = datos.getJSONObject(i).get("nacion");
                    fila[3] = datos.getJSONObject(i).get("fechaNacimiento");
                    fila[4] = "Eliminar";
                    modelo.addRow(fila);
                }
                
            }
            TblDirectores.setModel(modelo);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void TblDirectoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDirectoresMouseClicked
        JTable target = (JTable)evt.getSource();
        int row = target.getSelectedRow();
        String idDirector = target.getModel().getValueAt(row, 0).toString();
        if(!idDirector.trim().isEmpty())
        {
            if(target.getSelectedColumn() == 4)
            {
                int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea eliminar el director?","Atención",JOptionPane.YES_NO_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION)
                {
                    director dtor = new director();
                    if(dtor.eliminar(Integer.parseInt(idDirector)))
                    {
                        JOptionPane.showMessageDialog(null, "registro eliminado con exito", "Atención", JOptionPane.INFORMATION_MESSAGE);
                        DefaultTableModel modelo = (DefaultTableModel)target.getModel(); 
                        modelo.removeRow(row); 
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error eliminando el director:\n" + dtor.getResponse(), "Atención", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }else
            {
                director dtor = new director();
                dtor.verEditarDirector(Integer.parseInt(idDirector));
            }
        }else
        {
            JOptionPane.showMessageDialog(null,"El identificador no se encontro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_TblDirectoresMouseClicked

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
            java.util.logging.Logger.getLogger(consultarDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consultarDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consultarDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consultarDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consultarDirector().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextId;
    private javax.swing.JTextField JTextNac;
    private javax.swing.JTextField JTextNacion;
    private javax.swing.JTextField JTextNombre;
    private javax.swing.JTable TblDirectores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
