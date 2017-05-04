/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peliculas.vistas;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import peliculas.negocio.pelicula;

/**
 *
 * @author wong
 */
public class modificarPelicula extends javax.swing.JFrame {
    JSONObject _resultado = null;
    JSONArray _directores = null;
    /**
     * Creates new form modificarPelicula
     */
    public modificarPelicula() {
        
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                pelicula pelicula = new pelicula();
        try{
            this._directores = pelicula.traerDirectores();
            for (int i = 0; i < this._directores.length(); i++) {
                if(this._directores.getJSONObject(i)!= null){
                    
                    JComboDirectores.addItem(this._directores.getJSONObject(i).getString("nombre"));
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
            for (int i = 0; i < this. _directores.length(); i++) {
                if(i == id)
                {
                    respuesta = this._directores.getJSONObject(i).getInt("id");
                }
        }
        }catch(JSONException e){
            System.err.println(e);
        }
  
        return respuesta;
    }
    public void setResultado(JSONObject resultado)
    {
        try{
            this._resultado = resultado;
            JTextTitulo.setText(this._resultado.getString("titulo"));
            JTextNacion.setText(this._resultado.getString("nacion"));
            JTextColor.setText(this._resultado.getString("color"));
            JTextIdioma.setText(this._resultado.getString("idioma"));
            int ano = this._resultado.getInt("ano");
            JTextAno.setText(Integer.toString(ano));
            JTextResumen.setText(this._resultado.getString("resumen"));
            JTextObservaciones.setText(this._resultado.getString("observaciones"));
        }catch(Exception e){
            System.err.println("Error manipular el resultado");
            System.err.println(e);
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JTextTitulo = new javax.swing.JTextField();
        JTextNacion = new javax.swing.JTextField();
        JTextIdioma = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JTextColor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTextAno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTextResumen = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTextObservaciones = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        JButtonModificar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        JComboDirectores = new javax.swing.JComboBox<>();
        JBActores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setText("Observaciones:");

        jLabel8.setText("Año:");

        jLabel1.setText("MODIFICAR PELICULA:");

        jLabel2.setText("Titulo:");

        JTextAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTextAnoKeyTyped(evt);
            }
        });

        jLabel3.setText("Color:");

        JTextResumen.setColumns(20);
        JTextResumen.setRows(5);
        jScrollPane1.setViewportView(JTextResumen);

        jLabel4.setText("Nación:");

        jLabel5.setText("Resumen:");

        JTextObservaciones.setColumns(20);
        JTextObservaciones.setRows(5);
        jScrollPane2.setViewportView(JTextObservaciones);

        jLabel6.setText("Idioma:");

        JButtonModificar.setText("Modificar");
        JButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonModificarActionPerformed(evt);
            }
        });

        jLabel9.setText("Director:");

        JBActores.setText("Actores");
        JBActores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBActoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(JComboDirectores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JTextAno)
                            .addComponent(JTextIdioma)
                            .addComponent(JTextColor)
                            .addComponent(JTextNacion)
                            .addComponent(JTextTitulo))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBActores)
                .addGap(56, 56, 56)
                .addComponent(JButtonModificar)
                .addGap(107, 107, 107))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(255, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(JTextTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(JTextNacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(JTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(JTextIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(JTextAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(JComboDirectores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonModificar)
                    .addComponent(JBActores))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addContainerGap(640, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonModificarActionPerformed
        String titulo = JTextTitulo.getText();
        String nacion = JTextNacion.getText();
        String color = JTextColor.getText();
        String idioma = JTextIdioma.getText();
        int ano = Integer.parseInt(JTextAno.getText());
        int director = this.getItem(JComboDirectores.getSelectedIndex());
        String resumen = JTextResumen.getText();
        String observacion = JTextObservaciones.getText();
        pelicula pelicula = new pelicula();
        try{
            Boolean respuesta = pelicula.Modificar(this._resultado.getInt("id"), director,titulo, nacion, idioma, color, ano, resumen, observacion);
            if(respuesta)
            {
                JOptionPane.showMessageDialog(null, "Modificacion realizada con exito", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }else
            {
                JOptionPane.showMessageDialog(null, "Error al modificar la pelicula!\n"+pelicula.getResponse(), "Alerta",JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_JButtonModificarActionPerformed

    private void JBActoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBActoresActionPerformed
        pelicula pelicula = new pelicula();
        try{
            pelicula.buscarRepartos(this._resultado.getInt("id"));
        }catch(Exception e)
        {
            System.err.println("Error al ejecutar la busqueda de los repartos");
            System.err.println(e);
        }
    }//GEN-LAST:event_JBActoresActionPerformed

    private void JTextAnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextAnoKeyTyped
        char caracter = evt.getKeyChar(); 
        if(((caracter < '0') || (caracter > '9')) && (caracter != '\b'))
        {
            evt.consume();
        } 
    }//GEN-LAST:event_JTextAnoKeyTyped

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
            java.util.logging.Logger.getLogger(modificarPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificarPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificarPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificarPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificarPelicula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBActores;
    private javax.swing.JButton JButtonModificar;
    private javax.swing.JComboBox<String> JComboDirectores;
    private javax.swing.JTextField JTextAno;
    private javax.swing.JTextField JTextColor;
    private javax.swing.JTextField JTextIdioma;
    private javax.swing.JTextField JTextNacion;
    private javax.swing.JTextArea JTextObservaciones;
    private javax.swing.JTextArea JTextResumen;
    private javax.swing.JTextField JTextTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
