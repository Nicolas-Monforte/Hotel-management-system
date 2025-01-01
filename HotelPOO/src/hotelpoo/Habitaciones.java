
package hotelpoo;

import java.util.Objects;

public class Habitaciones {
    private Long id;
    private int numeroHabitacion;
    private int camasSingle;
    private int camasDoble;
    private double precioPorDia;

    public Habitaciones(int numeroHabitacion, int camasSingle, int camasDoble, double precioPorDia) {
     
        this.numeroHabitacion = numeroHabitacion;
        this.camasSingle = camasSingle;
        this.camasDoble = camasDoble;
        this.precioPorDia = precioPorDia;
    }

    public Habitaciones() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public int getCamasSingle() {
        return camasSingle;
    }

    public void setCamasSingle(int camasSingle) {
        this.camasSingle = camasSingle;
    }

    public int getCamasDoble() {
        return camasDoble;
    }

    public void setCamasDoble(int camasDoble) {
        this.camasDoble = camasDoble;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(double precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    @Override
    public String toString() {
        return "Habitaciones{" + "id=" + id + ", numeroHabitacion=" + numeroHabitacion + ", camasSingle=" + camasSingle + ", camasDoble=" + camasDoble + ", precioPorDia=" + precioPorDia + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + this.numeroHabitacion;
        hash = 23 * hash + this.camasSingle;
        hash = 23 * hash + this.camasDoble;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.precioPorDia) ^ (Double.doubleToLongBits(this.precioPorDia) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Habitaciones other = (Habitaciones) obj;
        if (this.numeroHabitacion != other.numeroHabitacion) {
            return false;
        }
        if (this.camasSingle != other.camasSingle) {
            return false;
        }
        if (this.camasDoble != other.camasDoble) {
            return false;
        }
        if (Double.doubleToLongBits(this.precioPorDia) != Double.doubleToLongBits(other.precioPorDia)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
}
