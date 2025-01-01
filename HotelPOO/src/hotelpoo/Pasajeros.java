package hotelpoo;

import java.util.Objects;

public class Pasajeros {

    private Long id;
    private String nombre;
    private String apellido;
    private int documento;
    private long telefono;
    private String correoElectronico;

    public Pasajeros(String nombre, String apellido, int documento, long telefono, String correoElectronico) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public Pasajeros() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return "Pasajeros{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento + ", telefono=" + telefono + ", correoElectronico=" + correoElectronico + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.nombre);
        hash = 31 * hash + Objects.hashCode(this.apellido);
        hash = 31 * hash + this.documento;
        hash = 31 * hash + Objects.hashCode(this.telefono);
        hash = 31 * hash + Objects.hashCode(this.correoElectronico);
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
        final Pasajeros other = (Pasajeros) obj;
        if (this.documento != other.documento) {
            return false;
        }
        if (this.telefono != other.telefono) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.correoElectronico, other.correoElectronico)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

}
