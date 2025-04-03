/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.quickpass;

/**
 *
 * @author User
 */
public class QuickPass {
    //los atributos
    private String filial;
    private String codigo;
    private String placa;
    private boolean activo;

    //el constructor
    public QuickPass(String pFilial, String pCodigo, String pPlaca) {
        this.filial = pFilial;
        this.codigo = pCodigo;
        this.placa = pPlaca;
        this.activo = true;
    }

    //getter y setter

    //filial
    public void setFilial(String pFilial) {
        this.filial = pFilial;
    }

    public String getFilial() {
        return filial;
    }

    //codigo
    public void setCodigo(String pCodigo) {
        this.codigo = pCodigo;
    }

    public String getCodigo() {
        return codigo;
    }

    //placa
    public void setPlaca(String pPlaca) {
        this.placa = pPlaca;
    }

    public String getPlaca() {
        return placa;
    }

    //estado
    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        String estado = (activo) ? "activo" : "inactivo";
        return """
               Informacion del Quickpass:
               El numero de filial es:  """ + filial + 
                " , el codigo es:  " + codigo + 
                " , el numero de placa es:  " + placa + 
                " , estado:  " + estado;
    }
    
    public String toFormattedString(String fecha) {
        String condicion = activo ? "Activo" : "Inactivo";
        return "Codigo:  " + codigo + "; Placa:  " + placa + "; Filial:  " + filial + " ; Condicion:  " + condicion + "; Fecha:  " + fecha;
    }
}