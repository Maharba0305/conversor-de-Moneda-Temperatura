package modelo;

import java.awt.event.KeyAdapter;
import javax.swing.JTextField;

public class Modelo {

    private Double valor_Temperatura;
    private Double resultado_Temperatura;
    private Double valor_Moneda;
    private Double resultado_Moneda;

    public Double getValor_Temperatura() {
        return valor_Temperatura;
    }

    public void setValor_Temperatura(Double valor_Temperatura) {
        this.valor_Temperatura = valor_Temperatura;
    }

    public Double getResultado_Temperatura() {
        return resultado_Temperatura;
    }

    public void setResultado_Temperatura(Double resultado_Temperatura) {
        this.resultado_Temperatura = resultado_Temperatura;
    }

    public Double getValor_Moneda() {
        return valor_Moneda;
    }

    public void setValor_Moneda(Double valor_Moneda) {
        this.valor_Moneda = valor_Moneda;
    }

    public Double getResultado_Moneda() {
        return resultado_Moneda;
    }

    public void setResultado_Moneda(Double resultado_Moneda) {
        this.resultado_Moneda = resultado_Moneda;
    }
    
    //------METODOS DE CONVERCION DE TEMPERATURA------
    public double celciusfahrenheit(){
          resultado_Temperatura =  (valor_Temperatura* 1.8) + 32;
          return resultado_Temperatura;
    }
    public double celciuskelvin(){
        resultado_Temperatura = (valor_Temperatura + 273.15);
        return resultado_Temperatura;
    }
    public double fahrenheitcelcius(){
        resultado_Temperatura = (valor_Temperatura - 32) * 0.5555;
        return resultado_Temperatura;
    }
    public double fahrenheitkelvin(){
        resultado_Temperatura = ((valor_Temperatura- 32) * 0.5555) + 273.15;
        return resultado_Temperatura;
    }
    public double  kelvincelcius(){
        resultado_Temperatura = valor_Temperatura - 273.15;
        return resultado_Temperatura;
    }
    public double kelvinfahrenheit(){
        resultado_Temperatura = ((valor_Temperatura - 273.15) * 9/5) + 32;
        return resultado_Temperatura;
    }
    //-----Metodo de Conversion de Divisas---
    public double pesosDolar(){
        resultado_Moneda = valor_Moneda*18.57;
        return resultado_Moneda;
    }
    public double PesosEuro(){
        resultado_Moneda = valor_Moneda*0.049;
        return resultado_Moneda;
    }
    
    public double pesoYen(){
        resultado_Moneda = valor_Moneda*7.05;
        return resultado_Moneda;
    }
    
    public double pesoLibra(){
        resultado_Moneda = valor_Moneda*453.592;
        return resultado_Moneda;
    }
    
       
    
}
    
    
