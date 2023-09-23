class Boleto {
    private String atraccion;
    private int cantidad;

    public Boleto(String atraccion, int cantidad) {
        this.atraccion = atraccion;
        this.cantidad = cantidad;
    }

    public String getAtraccion() {
        return atraccion;
    }

    public int getCantidad() {
        return cantidad;
    }
}

