package hotelpoo;

import DAO.DAOException;
import DAO.MYSQLHabitacionDAO;
import DAO.MYSQLReservaDAO;
import DAO.MySQLPasajeroDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador para gestionar las operaciones relacionadas con reservas en el
 * sistema de un hotel. Este controlador interactúa con los DAOs para manejar
 * las entidades de reservas, habitaciones y pasajeros.
 *
 * @author monfo
 * @version 1.0
 */
public class ReservaController {

    private final MYSQLReservaDAO reservaDAO;
    private final MYSQLHabitacionDAO habitacionDAO;
    private final MySQLPasajeroDAO pasajeroDAO;

    /**
     * Constructor de la clase ReservaController. Inicializa los DAOs necesarios
     * para interactuar con la base de datos.
     *
     * @throws SQLException si ocurre un error al inicializar los DAOs.
     */
    public ReservaController() throws SQLException {
        reservaDAO = new MYSQLReservaDAO();
        habitacionDAO = new MYSQLHabitacionDAO();
        pasajeroDAO = new MySQLPasajeroDAO();
    }

    /**
     * Carga todas las habitaciones disponibles en un JList.
     *
     * @param listaHabitaciones componente JList donde se mostrarán las
     * habitaciones.
     */
    public void cargarHabitacionesEnLista(JList<String> listaHabitaciones) {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        try {
            List<Habitaciones> habitaciones = habitacionDAO.obtenerTodos();
            for (Habitaciones habitacion : habitaciones) {
                String infoHabitacion = "ID: " + habitacion.getId() + " - Hab. " + habitacion.getNumeroHabitacion()
                        + " - " + habitacion.getCamasSingle() + " camas single, "
                        + habitacion.getCamasDoble() + " camas dobles, $"
                        + habitacion.getPrecioPorDia() + " por día";
                modelo.addElement(infoHabitacion);
            }
            listaHabitaciones.setModel(modelo);
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar las habitaciones.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Carga todos los pasajeros en un JComboBox.
     *
     * @param comboBoxPasajeros componente JComboBox donde se mostrarán los
     * pasajeros.
     */
    public void cargarPasajerosEnComboBox(JComboBox<String> comboBoxPasajeros) {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        try {
            List<Pasajeros> pasajeros = pasajeroDAO.obtenerTodos();
            for (Pasajeros pasajero : pasajeros) {
                String infoPasajero = "ID: " + pasajero.getId() + " - " + pasajero.getNombre() + " " + pasajero.getApellido();
                modelo.addElement(infoPasajero);
            }
            comboBoxPasajeros.setModel(modelo);
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los pasajeros.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Obtiene una lista de datos de todas las reservas realizadas.
     *
     * @return lista de reservas en formato de objetos.
     * @throws DAOException si ocurre un error al obtener las reservas.
     */
    public List<Object[]> obtenerDatosReservas() throws DAOException {
        return reservaDAO.obtenerDatosReservas();
    }

    /**
     * Convierte una lista de descripciones de habitaciones seleccionadas a una
     * lista de IDs.
     *
     * @param habitacionesSeleccionadas lista de descripciones de habitaciones
     * seleccionadas.
     * @return lista de IDs de habitaciones.
     */
    public List<Long> obtenerIdsHabitaciones(List<String> habitacionesSeleccionadas) {
        List<Long> ids = new ArrayList<>();
        for (String habitacionSeleccionada : habitacionesSeleccionadas) {
            if (habitacionSeleccionada != null && habitacionSeleccionada.startsWith("ID: ")) {
                String[] partes = habitacionSeleccionada.split(" ");
                ids.add(Long.parseLong(partes[1]));
            }
        }
        return ids;
    }

    /**
     * Obtiene el ID de un pasajero a partir de la descripción seleccionada en
     * un JComboBox.
     *
     * @param pasajeroSeleccionado descripción del pasajero seleccionada.
     * @return ID del pasajero.
     */
    public Long obtenerIdPasajero(String pasajeroSeleccionado) {
        if (pasajeroSeleccionado != null && pasajeroSeleccionado.startsWith("ID: ")) {
            String[] partes = pasajeroSeleccionado.split(" ");
            return Long.parseLong(partes[1]);
        }
        return null;
    }

    /**
     * Agrega una nueva reserva al sistema.
     *
     * @param habitacionesSeleccionadas lista de habitaciones seleccionadas.
     * @param pasajeroSeleccionado pasajero seleccionado.
     * @param fechaCheckIn fecha de check-in de la reserva.
     * @param fechaCheckOut fecha de check-out de la reserva.
     * @param seniaText monto de seña en formato String.
     * @param reservasTb tabla donde se mostrarán las reservas actualizadas.
     */
    public void agregarReserva(List<String> habitacionesSeleccionadas, String pasajeroSeleccionado,
            Date fechaCheckIn, Date fechaCheckOut, String seniaText, JTable reservasTb) {
        try {
            List<Long> idsHabitaciones = obtenerIdsHabitaciones(habitacionesSeleccionadas);
            Long idPasajero = obtenerIdPasajero(pasajeroSeleccionado);

            Pasajeros pasajero = new Pasajeros();
            pasajero.setId(idPasajero);

            List<Habitaciones> habitaciones = new ArrayList<>();
            for (Long idHabitacion : idsHabitaciones) {
                Habitaciones habitacion = new Habitaciones();
                habitacion.setId(idHabitacion);
                habitaciones.add(habitacion);
            }

            double senia = Double.parseDouble(seniaText);

            Reservas nuevaReserva = new Reservas(fechaCheckIn, fechaCheckOut, pasajero, senia, habitaciones);
            reservaDAO.insertar(nuevaReserva);
            cargarTablaReserva(reservasTb);

        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la reserva: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Carga todas las reservas en una tabla.
     *
     * @param tabla componente JTable donde se mostrarán las reservas.
     */
    public void cargarTablaReserva(JTable tabla) {
        try {
            String[] columnNames = {"ID Reserva", "Nombre", "Apellido", "Documento", "Check-in", "Check-out", "Seña", "Habitación"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            List<Object[]> reservas = obtenerDatosReservas();
            for (Object[] fila : reservas) {
                model.addRow(fila);
            }
            tabla.setModel(model);
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar las reservas.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Modifica una reserva seleccionada desde una tabla.
     *
     * @param reservasTb tabla con las reservas.
     * @param fechaCheckIn nueva fecha de check-in.
     * @param fechaCheckOut nueva fecha de check-out.
     * @param seniaText nuevo monto de seña en formato String.
     * @param pasajeroSeleccionado nuevo pasajero asociado.
     * @param habitacionesSeleccionadas nuevas habitaciones seleccionadas.
     */
    public void modificarReservaSeleccionada(JTable reservasTb, Date fechaCheckIn, Date fechaCheckOut,
            String seniaText, String pasajeroSeleccionado,
            List<String> habitacionesSeleccionadas) {
        try {
            int filaSeleccionada = reservasTb.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una reserva para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Object idObjeto = reservasTb.getValueAt(filaSeleccionada, 0);
            Long reservaId = (idObjeto instanceof Integer) ? ((Integer) idObjeto).longValue() : (Long) idObjeto;

            List<Long> idsHabitaciones = obtenerIdsHabitaciones(habitacionesSeleccionadas);
            Long pasajeroId = obtenerIdPasajero(pasajeroSeleccionado);

            Pasajeros pasajero = new Pasajeros();
            pasajero.setId(pasajeroId);

            List<Habitaciones> habitaciones = new ArrayList<>();
            for (Long idHabitacion : idsHabitaciones) {
                Habitaciones habitacion = new Habitaciones();
                habitacion.setId(idHabitacion);
                habitaciones.add(habitacion);
            }

            double senia = Double.parseDouble(seniaText);

            Reservas reserva = new Reservas(fechaCheckIn, fechaCheckOut, pasajero, senia, habitaciones);
            reserva.setId(reservaId);

            reservaDAO.modificar(reserva);
            cargarTablaReserva(reservasTb);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar la reserva: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Elimina una reserva seleccionada desde una tabla.
     *
     * @param tabla componente JTable que contiene las reservas.
     * @throws DAOException si ocurre un error al eliminar la reserva.
     */
    public void eliminarReservaDesdeTabla(JTable tabla) throws DAOException {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            Object idObjeto = tabla.getValueAt(filaSeleccionada, 0);
            Long idReserva = (idObjeto instanceof Integer) ? ((Integer) idObjeto).longValue() : (Long) idObjeto;
            Reservas reserva = reservaDAO.obtener(idReserva);
            reservaDAO.eliminar(reserva);
            cargarTablaReserva(tabla);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una reserva para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Muestra la disponibilidad de habitaciones entre dos fechas en una tabla.
     *
     * @param fechaInicio fecha inicial para verificar disponibilidad.
     * @param fechaFin fecha final para verificar disponibilidad.
     * @param tablaDisponibilidad tabla donde se mostrarán las habitaciones y su
     * estado.
     * @throws DAOException si ocurre un error al verificar la disponibilidad.
     */
    public void mostrarDisponibilidad(Date fechaInicio, Date fechaFin, JTable tablaDisponibilidad) throws DAOException {
        List<String[]> disponibilidad = obtenerDisponibilidad(fechaInicio, fechaFin);
        DefaultTableModel model = new DefaultTableModel(new String[]{"Número de Habitación", "Camas", "Precio por Día", "Disponibilidad"}, 0);
        for (String[] habitacion : disponibilidad) {
            model.addRow(habitacion);
        }
        tablaDisponibilidad.setModel(model);
    }

    /**
     * Obtiene la disponibilidad de habitaciones entre dos fechas.
     *
     * @param fechaInicio fecha inicial para verificar disponibilidad.
     * @param fechaFin fecha final para verificar disponibilidad.
     * @return lista de habitaciones con información sobre su disponibilidad.
     * @throws DAOException si ocurre un error al obtener la disponibilidad.
     */
    private List<String[]> obtenerDisponibilidad(Date fechaInicio, Date fechaFin) throws DAOException {
        List<String[]> disponibilidad = new ArrayList<>();
        List<Habitaciones> habitaciones = habitacionDAO.obtenerTodos();

        for (Habitaciones habitacion : habitaciones) {
            boolean disponible = reservaDAO.verificarDisponibilidad(habitacion.getId(), fechaInicio, fechaFin);
            String estado = disponible ? "Disponible" : "Ocupado";

            disponibilidad.add(new String[]{
                String.valueOf(habitacion.getNumeroHabitacion()),
                habitacion.getCamasSingle() + " Single / " + habitacion.getCamasDoble() + " Doble",
                "$" + habitacion.getPrecioPorDia(),
                estado
            });
        }
        return disponibilidad;
    }
}
