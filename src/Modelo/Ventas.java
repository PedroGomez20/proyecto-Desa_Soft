package Modelo;

public class Ventas {
    
    int idVentas, idCliente, idVendedor;
    String fecha, serie, estado;
    Double monto;

    public Ventas() {
    }

    public Ventas(int idVentas, int idCliente, int idVendedor, String fecha, String serie, String estado, Double monto) {
        this.idVentas = idVentas;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.fecha = fecha;
        this.serie = serie;
        this.estado = estado;
        this.monto = monto;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
    

}
