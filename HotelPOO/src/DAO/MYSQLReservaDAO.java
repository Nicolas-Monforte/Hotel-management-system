package DAO;

import Persistencia.Conexion;
import hotelpoo.Habitaciones;
import hotelpoo.Pasajeros;
import hotelpoo.Reservas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MYSQLReservaDAO implements ReservaDAO {

    private Connection conn;

    private static final String INSERT = "INSERT INTO reservas(fecha_check_in, fecha_check_out, pasajero_id, senia) VALUES(?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE reservas SET fecha_check_in=?, fecha_check_out=?, pasajero_id=?, senia=? WHERE id=?";
    private static final String DELETE = "DELETE FROM reservas WHERE id=?";
    private static final String GETALL = "SELECT * FROM reservas";
    private static final String GETONE = "SELECT * FROM reservas WHERE id=?";
    private static final String INSERT_HABITACION_RESERVA = "INSERT INTO reserva_habitacion (reserva_id, habitacion_id) VALUES (?, ?)";
    private static final String DELETE_HABITACIONES = "DELETE FROM reserva_habitacion WHERE reserva_id=?";
    private static final String VERIFICAR_DISPONIBILIDAD = "SELECT COUNT(*) FROM reserva_habitacion rh "
            + "JOIN reservas r ON rh.reserva_id = r.id "
            + "WHERE rh.habitacion_id = ? "
            + "AND ((r.fecha_check_in <= ? AND r.fecha_check_out >= ?) "
            + "OR (r.fecha_check_in <= ? AND r.fecha_check_out >= ?) "
            + "OR (r.fecha_check_in >= ? AND r.fecha_check_out <= ?))";
    private static final String OBTENER_DATOS_RESERVAS
            = "SELECT reservas.id AS reserva_id, pasajeros.nombre, pasajeros.apellido, "
            + "pasajeros.documento, reservas.fecha_check_in, reservas.fecha_check_out, "
            + "reservas.senia, habitaciones.numeroHabitacion "
            + "FROM reservas "
            + "JOIN pasajeros ON reservas.pasajero_id = pasajeros.id "
            + "JOIN reserva_habitacion ON reservas.id = reserva_habitacion.reserva_id "
            + "JOIN habitaciones ON reserva_habitacion.habitacion_id = habitaciones.id";

    public MYSQLReservaDAO() throws SQLException {
        this.conn = Conexion.getConnection();
    }

    @Override
    public void insertar(Reservas reserva) throws DAOException {
        PreparedStatement stat = null;
        ResultSet generatedKeys = null;
        try {

            for (Habitaciones habitacion : reserva.getHabitaciones()) {
                boolean disponible = verificarDisponibilidad(habitacion.getId(), reserva.getFechaCheckIn(), reserva.getFechaCheckOut());
                if (!disponible) {
                    throw new DAOException("La habitación no está disponible en las fechas seleccionadas.");
                }
            }

            stat = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            stat.setDate(1, new java.sql.Date(reserva.getFechaCheckIn().getTime()));
            stat.setDate(2, new java.sql.Date(reserva.getFechaCheckOut().getTime()));
            stat.setLong(3, reserva.getPasajero().getId());
            stat.setDouble(4, reserva.getSenia());

            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que la reserva no se haya guardado.");
            }

            generatedKeys = stat.getGeneratedKeys();
            if (generatedKeys.next()) {
                reserva.setId(generatedKeys.getLong(1));
                agregarHabitaciones(reserva);
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL al insertar reserva", ex);
        } finally {
            if (stat != null) try {
                stat.close();
            } catch (SQLException ex) {
            }
            if (generatedKeys != null) try {
                generatedKeys.close();
            } catch (SQLException ex) {
            }
        }
    }

    private void agregarHabitaciones(Reservas reserva) throws SQLException, DAOException {
        if (reserva.getHabitaciones() == null || reserva.getHabitaciones().isEmpty()) {
            throw new DAOException("No hay habitaciones para asociar a la reserva.");
        }

        try (PreparedStatement stmt = conn.prepareStatement(INSERT_HABITACION_RESERVA)) {
            for (Habitaciones habitacion : reserva.getHabitaciones()) {
                stmt.setLong(1, reserva.getId());
                stmt.setLong(2, habitacion.getId());
                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void modificar(Reservas reserva) throws DAOException {
        PreparedStatement stat = null;
        try {

            stat = conn.prepareStatement(UPDATE);
            stat.setDate(1, new java.sql.Date(reserva.getFechaCheckIn().getTime()));
            stat.setDate(2, new java.sql.Date(reserva.getFechaCheckOut().getTime()));
            stat.setLong(3, reserva.getPasajero().getId());
            stat.setDouble(4, reserva.getSenia());
            stat.setLong(5, reserva.getId());

            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que la reserva no se haya modificado.");
            }

            actualizarHabitaciones(reserva);
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL al modificar reserva", ex);
        } finally {
            if (stat != null) try {
                stat.close();
            } catch (SQLException ex) {
            }
        }
    }

    private void actualizarHabitaciones(Reservas reserva) throws SQLException, DAOException {

        try (PreparedStatement stmtDelete = conn.prepareStatement(DELETE_HABITACIONES)) {
            stmtDelete.setLong(1, reserva.getId());
            stmtDelete.executeUpdate();
        }

        agregarHabitaciones(reserva);
    }

    @Override
    public void eliminar(Reservas reserva) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, reserva.getId());

            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que la reserva no se haya eliminado.");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL al eliminar reserva", ex);
        } finally {
            if (stat != null) try {
                stat.close();
            } catch (SQLException ex) {
            }
        }
    }

    @Override
    public Reservas obtener(Long id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Reservas reserva = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setLong(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                reserva = convertir(rs);
            } else {
                throw new DAOException("No se ha encontrado la reserva con ID " + id);
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL al obtener reserva", ex);
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException ex) {
            }
            if (stat != null) try {
                stat.close();
            } catch (SQLException ex) {
            }
        }
        return reserva;
    }

    @Override
    public List<Reservas> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Reservas> reservas = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                reservas.add(convertir(rs));
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL al obtener todas las reservas", ex);
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException ex) {
            }
            if (stat != null) try {
                stat.close();
            } catch (SQLException ex) {
            }
        }
        return reservas;
    }

    private Reservas convertir(ResultSet rs) throws SQLException, DAOException {
        Long id = rs.getLong("id");
        Date fechaCheckIn = rs.getDate("fecha_check_in");
        Date fechaCheckOut = rs.getDate("fecha_check_out");
        double senia = rs.getDouble("senia");

        Pasajeros pasajero = obtenerPasajero(rs.getLong("pasajero_id"));

        Reservas reserva = new Reservas(fechaCheckIn, fechaCheckOut, pasajero, senia, new ArrayList<>());
        reserva.setId(id);
        return reserva;
    }

    private Pasajeros obtenerPasajero(Long id) throws SQLException, DAOException {
        MySQLPasajeroDAO pasajeroDAO = new MySQLPasajeroDAO();
        return pasajeroDAO.obtener(id);
    }

    public boolean verificarDisponibilidad(Long idHabitacion, Date fechaInicio, Date fechaFin) throws DAOException {
        try (PreparedStatement stmt = conn.prepareStatement(VERIFICAR_DISPONIBILIDAD)) {
            stmt.setLong(1, idHabitacion);
            stmt.setDate(2, new java.sql.Date(fechaFin.getTime()));
            stmt.setDate(3, new java.sql.Date(fechaInicio.getTime()));
            stmt.setDate(4, new java.sql.Date(fechaInicio.getTime()));
            stmt.setDate(5, new java.sql.Date(fechaFin.getTime()));
            stmt.setDate(6, new java.sql.Date(fechaInicio.getTime()));
            stmt.setDate(7, new java.sql.Date(fechaFin.getTime()));

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
        } catch (SQLException ex) {
            throw new DAOException("Error al verificar disponibilidad de habitación", ex);
        }
        return false;
    }

    public List<Object[]> obtenerDatosReservas() throws DAOException {
        List<Object[]> listaReservas = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(OBTENER_DATOS_RESERVAS); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] fila = new Object[]{
                    rs.getInt("reserva_id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getInt("documento"),
                    rs.getDate("fecha_check_in"),
                    rs.getDate("fecha_check_out"),
                    rs.getBigDecimal("senia"),
                    rs.getInt("numeroHabitacion")
                };
                listaReservas.add(fila);
            }
        } catch (SQLException ex) {
            throw new DAOException("Error al obtener los datos de reservas", ex);
        }
        return listaReservas;
    }
}
