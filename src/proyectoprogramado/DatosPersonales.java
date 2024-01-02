/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogramado;

/**
 *
 * @author cgari
 */
public class DatosPersonales {
    
    //Declaración de las variables de instancia
    protected String nombre, identificacion, tipoVehiculo;
    protected int edad, annioVehiculo, montoVehiculo, numeroCotizacion;
    protected static int idAutonumerado = 0;

    //Constructor
    public DatosPersonales() {
    }

    //Constructor
    public DatosPersonales(String nombre, String identificacion, String tipoVehiculo, int edad, int annioVehiculo, int montoVehiculo) {
        this.setNumeroCotizacion();
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.tipoVehiculo = tipoVehiculo;
        this.edad = edad;
        this.annioVehiculo = annioVehiculo;
        this.montoVehiculo = montoVehiculo;
    }

    //Método para obtener valor de variable de intancia
    public int getNumeroCotizacion() {
        return numeroCotizacion;
    }

    //Método para establecer valor de variable de intancia
    public void setNumeroCotizacion() {
        this.numeroCotizacion = ++idAutonumerado;
    }

    //Método para obtener valor de variable de intancia
    public String getNombre() {
        return nombre;
    }

    //Método para establecer valor de variable de intancia
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Método para obtener valor de variable de intancia
    public String getIdentificacion() {
        return identificacion;
    }

    //Método para establecer valor de variable de intancia
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    //Método para obtener valor de variable de intancia
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    //Método para establecer valor de variable de intancia
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    //Método para obtener valor de variable de intancia
    public int getEdad() {
        return edad;
    }

    //Método para establecer valor de variable de intancia
    public void setEdad(int edad) {
        this.edad = edad;
    }

    //Método para obtener valor de variable de intancia
    public int getAnnioVehiculo() {
        return annioVehiculo;
    }

    //Método para establecer valor de variable de intancia
    public void setAnnioVehiculo(int annioVehiculo) {
        this.annioVehiculo = annioVehiculo;
    }

    //Método para obtener valor de variable de intancia
    public int getMontoVehiculo() {
        return montoVehiculo;
    }

    //Método para establecer valor de variable de intancia
    public void setMontoVehiculo(int montoVehiculo) {
        this.montoVehiculo = montoVehiculo;
    }

}
