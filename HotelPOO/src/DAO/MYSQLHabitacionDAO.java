package DAO;


import Persistencia.Conexion;
import hotelpoo.Habitaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MYSQLHabitacionDAO implements HabitacionDAO {

 private Connection conn;
    private static final String INSERT = "INSERT INTO habitaciones(numeroHabitacion, camasSingle, camasDobles, precioPorDia) VALUES(?,?,?,?)";
    private static final String UPDATE = "UPDATE habitaciones SET numeroHabitacion=?, camasSingle=?, camasDobles=?, precioPorDia=? WHERE id=?";
    private static final String DELETE = "DELETE FROM habitaciones WHERE id=?";
    private static final String GETALL = "SELECT id, numeroHabitacion, camasSingle, camasDobles, precioPorDia FROM habitaciones";
    private static final String GETONE = "SELECT id, numeroHabitacion, camasSingle, camasDobles, precioPorDia FROM habitaciones WHERE id=?";

    public MYSQLHabitacionDAO() throws SQLException {
        this.conn = Conexion.getConnection();
    }

    @Override
    public void insertar(Habitaciones habitacion) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1, habitacion.getNumeroHabitacion());
            stat.setInt(2, habitacion.getCamasSingle());
            stat.setInt(3, habitacion.getCamasDoble()); // Cambiado a camasDobles
            stat.setDouble(4, habitacion.getPrecioPorDia());

            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que la habitación no se haya guardado.");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error al cerrar el PreparedStatement", ex);
                }
            }
        }
    }

    @Override
    public void modificar(Habitaciones habitacion) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setInt(1, habitacion.getNumeroHabitacion());
            stat.setInt(2, habitacion.getCamasSingle());
            stat.setInt(3, habitacion.getCamasDoble()); // Cambiado a camasDobles
            stat.setDouble(4, habitacion.getPrecioPorDia());
            stat.setLong(5, habitacion.getId());

            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que la habitación no haya sido modificada.");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error al cerrar el PreparedStatement", ex);
                }
            }
        }
    }

    @Override
    public void eliminar(Habitaciones habitacion) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, habitacion.getId());

            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que la habitación no haya sido eliminada.");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error al cerrar el PreparedStatement", ex);
                }
            }
        }
    }

    private Habitaciones convertir(ResultSet rs) throws SQLException {
       
        int numeroHabitacion = rs.getInt("numeroHabitacion");
        int camasSingle = rs.getInt("camasSingle");
        int camasDobles = rs.getInt("camasDobles"); 
        double precioPorDia = rs.getDouble("precioPorDia");

        Habitaciones habitacion = new Habitaciones(numeroHabitacion, camasSingle, camasDobles, precioPorDia);
        habitacion.setId(rs.getLong("id"));
        return habitacion;
    }

    @Override
    public Habitaciones obtener(Long id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Habitaciones habitacion = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setLong(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                habitacion = convertir(rs);
            } else {
                throw new DAOException("No se ha encontrado esa habitación.");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error al cerrar ResultSet", ex);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error al cerrar PreparedStatement", ex);
                }
            }
        }
        return habitacion;
    }

    @Override
    public List<Habitaciones> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Habitaciones> habitaciones = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                habitaciones.add(convertir(rs));
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error al cerrar ResultSet", ex);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error al cerrar PreparedStatement", ex);
                }
            }
        }
        return habitaciones;
    }
}

