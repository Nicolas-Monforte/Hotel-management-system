
package hotelpoo;

import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Reservas {
    private Long id;
    private Date fechaCheckIn;
    private Date fechaCheckOut;
    private Pasajeros pasajero;  
    private double senia;
    private List<Habitaciones> habitaciones; 

    public Reservas(Date fechaCheckIn, Date fechaCheckOut, Pasajeros pasajero, double senia, List<Habitaciones> habitaciones) {
       
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.pasajero = pasajero;
        this.senia = senia;
        this.habitaciones = habitaciones;
    }

    public Reservas() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaCheckIn() {
        return fechaCheckIn;
    }

    public void setFechaCheckIn(Date fechaCheckIn) {
        this.fechaCheckIn = fechaCheckIn;
    }

    public Date getFechaCheckOut() {
        return fechaCheckOut;
    }

    public void setFechaCheckOut(Date fechaCheckOut) {
        this.fechaCheckOut = fechaCheckOut;
    }

    public Pasajeros getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajeros pasajero) {
        this.pasajero = pasajero;
    }

    public double getSenia() {
        return senia;
    }

    public void setSenia(double senia) {
        this.senia = senia;
    }

    public List<Habitaciones> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitaciones> habitaciones) {
        this.habitaciones = habitaciones;
    }

    @Override
    public String toString() {
        return "Reservas{" + "id=" + id + ", fechaCheckIn=" + fechaCheckIn + ", fechaCheckOut=" + fechaCheckOut + ", pasajero=" + pasajero + ", senia=" + senia + ", habitaciones=" + habitaciones + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.fechaCheckIn);
        hash = 89 * hash + Objects.hashCode(this.fechaCheckOut);
        hash = 89 * hash + Objects.hashCode(this.pasajero);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.senia) ^ (Double.doubleToLongBits(this.senia) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.habitaciones);
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
        final Reservas other = (Reservas) obj;
        if (Double.doubleToLongBits(this.senia) != Double.doubleToLongBits(other.senia)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fechaCheckIn, other.fechaCheckIn)) {
            return false;
        }
        if (!Objects.equals(this.fechaCheckOut, other.fechaCheckOut)) {
            return false;
        }
        if (!Objects.equals(this.pasajero, other.pasajero)) {
            return false;
        }
        return Objects.equals(this.habitaciones, other.habitaciones);
    }
    
    
}
