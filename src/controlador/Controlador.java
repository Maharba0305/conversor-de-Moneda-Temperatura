package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Modelo;
import vista.ventanMoneda;
import vista.ventanTemperatura;
import vista.ventanaPrincipal;

public class Controlador implements ActionListener {

    ventanaPrincipal vistaPrincipal;
    ventanMoneda vistaMoneda;
    ventanTemperatura vistaTemperatura;
    Modelo modelo;

    public Controlador(ventanaPrincipal vistaPrincipal, ventanMoneda vistaMoneda, ventanTemperatura vistaTemperatura, Modelo modelo) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaMoneda = vistaMoneda;
        this.vistaTemperatura = vistaTemperatura;
        this.modelo = modelo;
    }

    public void iniciar() {
        vistaPrincipal.setTitle("alura Challenge");
        vistaPrincipal.opMoneda.addActionListener(this);
        vistaPrincipal.opTemperatura.addActionListener(this);
        vistaPrincipal.opSalir.addActionListener(this);
        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.setVisible(true);

        vistaMoneda.cajaValor.addActionListener(this);
        vistaMoneda.comboMonedas.addActionListener(this);
        vistaMoneda.cajaResultado.addActionListener(this);
        vistaMoneda.botonSalir.addActionListener(this);
        
        vistaTemperatura.cajaValorTemperatura.addActionListener(this);
        vistaTemperatura.comboTemperatura.addActionListener(this);
        vistaTemperatura.cajaResultadoTemp.addActionListener(this);
        vistaTemperatura.botonSalirTemp.addActionListener(this);
    }

    public void num(JTextField a){
        a.addKeyListener(new KeyAdapter(){
        public void  keyTyped(KeyEvent e){
            char c = e.getKeyChar();
            if(!Character.isDigit(c) && c != '.'){
             JOptionPane.showMessageDialog(null, "ingrese solo numeros");
                e.consume();
            }
            if(c == '.' && vistaMoneda.cajaValor.getText().contains(".")){
                e.consume();
        }
        }
    });
    }
                
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
         num(vistaMoneda.cajaValor);
        //--------------VENTANA MONEDA-------------- 
        if (e.getSource().equals(vistaPrincipal.opMoneda)) {
            vistaPrincipal.escritorio.add(vistaMoneda);
            //Component add = vistaPrincipal.escritorio.add(vistaMoneda);
            vistaMoneda.setVisible(true);
        }
        //-------VENTANA TEMPERATURA
        if (e.getSource().equals(vistaPrincipal.opTemperatura)) {
            vistaPrincipal.escritorio.add(vistaTemperatura);
            vistaTemperatura.setVisible(true);
        }
        if (e.getSource().equals(vistaPrincipal.opSalir)) {
            int resp = JOptionPane.showConfirmDialog(vistaPrincipal,
                    "Desea Terminar el Programa..",
                    "salir",
                    JOptionPane.YES_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_NO_OPTION) {
                vistaPrincipal.dispose();
            }
        }
        
        
         
       

        //--------------moneda---------------------------------------------
        if (e.getSource().equals(vistaMoneda.comboMonedas)) {
            modelo.setValor_Moneda(Double.valueOf(vistaMoneda.cajaValor.getText()));
             
            
            
            
            if (vistaMoneda.comboMonedas.getSelectedItem().equals("Peso a Dolar")) {
                modelo.pesosDolar();
                vistaMoneda.cajaResultado.setText(String.valueOf(modelo.getResultado_Moneda()));

            } else if (vistaMoneda.comboMonedas.getSelectedItem().equals("Peso a Euro")) {
                modelo.PesosEuro();
                vistaMoneda.cajaResultado.setText(String.valueOf(modelo.getResultado_Moneda()));

            } else if (vistaMoneda.comboMonedas.getSelectedItem().equals("Peso a Yen")) {
                modelo.pesoYen();
                vistaMoneda.cajaResultado.setText(String.valueOf(modelo.getResultado_Moneda()));

            } else if (vistaMoneda.comboMonedas.getSelectedItem().equals("Peso a Libra")) {
                modelo.pesoLibra();
                vistaMoneda.cajaResultado.setText(String.valueOf(modelo.getResultado_Moneda()));

            }
        }

        if (e.getSource().equals(vistaMoneda.botonSalir)) {
            int resp = JOptionPane.showConfirmDialog(vistaMoneda,
                    "Desea Terminar la Ejecucion",
                    "salir",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_NO_OPTION) {
                vistaMoneda.dispose();

            }

        }
        //--------------------------------------------------------------------
        if (e.getSource().equals(vistaTemperatura.comboTemperatura)) {
            modelo.setValor_Temperatura(Double.valueOf(vistaTemperatura.cajaValorTemperatura.getText()));
            if(vistaTemperatura.comboTemperatura.getSelectedItem().equals("De celcius a fahrenheit")){
            modelo.celciusfahrenheit();
            vistaTemperatura.cajaResultadoTemp.setText(String.valueOf(modelo.getResultado_Temperatura()));
            }else if(vistaTemperatura.comboTemperatura.getSelectedItem().equals("De celcius a kelvin")){
                modelo.celciuskelvin();
                vistaTemperatura.cajaResultadoTemp.setText(String.valueOf(modelo.getResultado_Temperatura()));
            }else if(vistaTemperatura.comboTemperatura.getSelectedItem().equals("De fahrenheit a celcius")){
                modelo.fahrenheitcelcius();
                vistaTemperatura.cajaResultadoTemp.setText(String.valueOf(modelo.getResultado_Temperatura()));
            }else if(vistaTemperatura.comboTemperatura.getSelectedItem().equals("De fahrenheit a kelvin")){
                modelo.fahrenheitkelvin();
                vistaTemperatura.cajaResultadoTemp.setText(String.valueOf(modelo.getResultado_Temperatura()));
            }else if(vistaTemperatura.comboTemperatura.getSelectedItem().equals("De kelvin a celcius")){
                modelo.kelvincelcius();
                vistaTemperatura.cajaResultadoTemp.setText(String.valueOf(modelo.getResultado_Temperatura()));
            }else if(vistaTemperatura.comboTemperatura.getSelectedItem().equals("De kelvin a fahrenheit")){
                modelo.kelvinfahrenheit();
                vistaTemperatura.cajaResultadoTemp.setText(String.valueOf(modelo.getResultado_Temperatura()));
            }
        }
         //----------BOTON SALIR-----
        if(e.getSource().equals(vistaTemperatura.botonSalirTemp)){
            int resp = JOptionPane.showConfirmDialog(vistaTemperatura,
                    "Desea Terminar la Ejecucion",
                      "salir",
                   JOptionPane.YES_NO_OPTION,
                   JOptionPane.QUESTION_MESSAGE);
            if(resp == JOptionPane.YES_NO_OPTION){
                vistaTemperatura.dispose();
                
            }
            
        }

    }

}
