package modelo;

public class moneda {
    private String nombreMonedaBase;
    private String nombreMonedaFinal;
    private double valor;
    private double cantidadUsuario;

    public moneda(monedas monedaIngresada, double cantidad){
        this.nombreMonedaBase = monedaIngresada.base_code();
        this.nombreMonedaFinal = monedaIngresada.target_code();
        this.valor = monedaIngresada.conversion_result();
        this.cantidadUsuario = cantidad;
    }
    public String getNombreMonedaBase() {
        return nombreMonedaBase;
    }
    public String getNombreMonedaFinal() {
        return nombreMonedaFinal;
    }
    public double getValor() {
        return valor;
    }
    public double getCantidadUsuario() {
        return cantidadUsuario;
    }
    public void setNombreMonedaBase(String nombreMonedaBase) {
        this.nombreMonedaBase = nombreMonedaBase;
    }
    public void setNombreMonedaFinal(String nombreMonedaFinal) {
        this.nombreMonedaFinal = nombreMonedaFinal;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public void setCantidadUsuario(double cantidadUsuario) {
        this.cantidadUsuario = cantidadUsuario;
    }

    @Override
    public String toString() {
        return String.format("%.2f [%s] equivalen a %.2f [%s]", cantidadUsuario, nombreMonedaBase, valor, nombreMonedaFinal);
    }
}
