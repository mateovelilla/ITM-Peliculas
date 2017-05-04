package peliculas.vistas;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;
import peliculas.negocio.pelicula;
public class repartos extends javax.swing.JFrame {
    JSONArray _actoresCombo = null;
    int _pelicula = 0;
    
    public repartos() {
        initComponents();
        this.setActores();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public void setRepartos(JSONArray repartos,int pelicula)
    {
        this._pelicula = pelicula;
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Actor");
        modelo.addColumn("Reparto");
        modelo.addColumn("Eliminar");
                try{
            for (int i = 0; i < repartos.length(); i++) {
                if(repartos.getJSONObject(i)!= null){
                    Object [] fila = new Object[4];
                    fila[0] = repartos.getJSONObject(i).get("id");
                    fila[1] = repartos.getJSONObject(i).get("actor");
                    fila[2] = repartos.getJSONObject(i).get("reparto");
                    fila[3] = "Eliminar";
                    modelo.addRow(fila);
                }
                
            }
            JTableRepartos.setModel(modelo);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void setActores()
    {
        pelicula pelicula = new pelicula();
        try{
            this._actoresCombo= pelicula.traerActores();
            for (int i = 0; i < this._actoresCombo.length(); i++) {
                if(this._actoresCombo.getJSONObject(i)!= null){
                    
                    JComboActores.addItem(this._actoresCombo.getJSONObject(i).getString("nombre"));
                }
            }
        }catch(JSONException e){
            System.err.println(e);
        }
    }
    
    private int getItem(int id)
    {
        int respuesta = 0;
        try{
            for (int i = 0; i < this._actoresCombo.length(); i++) {
                if(i == id)
                {
                    respuesta = this._actoresCombo.getJSONObject(i).getInt("id");
                }
        }
        }catch(JSONException e){
            System.err.println(e);
        }
  
        return respuesta;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JComboActores = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        JTextReparto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableRepartos = new javax.swing.JTable();
        Guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("REPARTOS: ");

        jLabel2.setText("Actor:");

        jLabel3.setText("Reparto:");

        JTableRepartos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTableRepartos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableRepartosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableRepartos);

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(JComboActores, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JTextReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JComboActores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextReparto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Guardar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTableRepartosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableRepartosMouseClicked
        JTable target = (JTable)evt.getSource();
        int row = target.getSelectedRow();
        String idReparto = target.getModel().getValueAt(row, 0).toString();
        if(!idReparto.trim().isEmpty())
        {
            if(target.getSelectedColumn() == 3)
            {
                int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea eliminar el reparto?","Atención",JOptionPane.YES_NO_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION)
                {
                    pelicula pelicula = new pelicula();
                    if(pelicula.eliminarReparto(Integer.parseInt(idReparto)))
                    {
                        JOptionPane.showMessageDialog(null, "registro eliminado con exito", "Atención", JOptionPane.INFORMATION_MESSAGE);
                        DefaultTableModel modelo = (DefaultTableModel)target.getModel(); 
                        modelo.removeRow(row); 
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error eliminando el reparto:\n" + pelicula.getResponse(), "Atención", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }else
        {
            JOptionPane.showMessageDialog(null,"El identificador no se encontro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JTableRepartosMouseClicked

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        String reparto = JTextReparto.getText();
        int actor = this.getItem(JComboActores.getSelectedIndex());
        int peliculaId = this._pelicula;
        pelicula pelicula = new pelicula();
        boolean respuesta = pelicula.guardarReparto(reparto,actor,peliculaId);
        if(respuesta)
        {
            JOptionPane.showMessageDialog(null,"Se guador con exito", "Alerta",JOptionPane.INFORMATION_MESSAGE);
            JTextReparto.setText("");
            DefaultTableModel model = (DefaultTableModel) JTableRepartos.getModel();
            model.addRow(new Object[]{3, actor, reparto,"Eliminar"});
            JTableRepartos.setModel(model);
        }else
        {
            JOptionPane.showMessageDialog(null,"Error al guardar el reparto!"+pelicula.getResponse(), "Alerta",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_GuardarActionPerformed

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
            java.util.logging.Logger.getLogger(repartos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(repartos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(repartos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(repartos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new repartos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar;
    private javax.swing.JComboBox<String> JComboActores;
    private javax.swing.JTable JTableRepartos;
    private javax.swing.JTextField JTextReparto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
