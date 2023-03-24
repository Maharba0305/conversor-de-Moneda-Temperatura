
package principal;

import controlador.Controlador;
import modelo.Modelo;
import vista.ventanMoneda;
import vista.ventanTemperatura;
import vista.ventanaPrincipal;



public class Principal {
    public static void main(String[] args) {
        ventanaPrincipal vistaPrincipal = new ventanaPrincipal();
        ventanMoneda vistaMoneda = new ventanMoneda();
        ventanTemperatura vistaTemperatura = new ventanTemperatura();
        Modelo modelo = new Modelo();
        
        Controlador controladro = new Controlador(vistaPrincipal, vistaMoneda, vistaTemperatura, modelo);
        controladro.iniciar();
       
    }
}
