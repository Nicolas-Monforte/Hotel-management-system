package hotelpoo;

import DAO.DAOException;
import DAO.MYSQLHabitacionDAO;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador para gestionar las operaciones CRUD relacionadas con
 * habitaciones. Se encarga de interactuar con la capa DAO y actualizar la
 * vista.
 *
 * @author monfo
 * @version 1.0
 */
public class HabitacionController {

    private MYSQLHabitacionDAO habitacionDAO;
    private Long idSeleccionado;

    /**
     * Constructor que inicializa el DAO de habitaciones. Muestra un mensaje de
     * error en caso de fallo en la conexión.
     */
    public HabitacionController() {
        try {
            habitacionDAO = new MYSQLHabitacionDAO();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al inicializar el DAO de Habitacion.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Valida los campos necesarios para realizar operaciones con habitaciones.
     *
     * @param numeroHabitacion Número de la habitación (como cadena).
     * @param camasSingle Número de camas individuales (como cadena).
     * @param camasDoble Número de camas dobles (como cadena).
     * @param precioPorDia Precio por día (como cadena).
     * @return true si todos los campos son válidos, false en caso contrario.
     */
    private boolean validarCampos(String numeroHabitacion, String camasSingle, String camasDoble, String precioPorDia) {
        if (numeroHabitacion.isEmpty() || camasSingle.isEmpty() || camasDoble.isEmpty() || precioPorDia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(numeroHabitacion);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El Numero de Habitacion debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(camasSingle);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El total de camas Singles debe ser número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(camasDoble);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El total de camas Dobles debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Double.parseDouble(precioPorDia);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El precio debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Agrega una nueva habitación a la base de datos y actualiza la tabla en la
     * interfaz.
     *
     * @param numeroHabitacion Número de la habitación.
     * @param camasSingle Número de camas individuales.
     * @param camasDoble Número de camas dobles.
     * @param precioPorDia Precio por día.
     * @param tabla Tabla de la interfaz para actualizar.
     */
    public void agregarHabitacion(String numeroHabitacion, String camasSingle, String camasDoble, String precioPorDia, JTable tabla) {
        if (!validarCampos(numeroHabitacion, camasSingle, camasDoble, precioPorDia)) {
            return;
        }

        int numeroHabitaciones = Integer.parseInt(numeroHabitacion);
        int camasSingles = Integer.parseInt(camasSingle);
        int camasDobles = Integer.parseInt(camasDoble);
        double precio = Double.parseDouble(precioPorDia);
        Habitaciones habitacion = new Habitaciones(numeroHabitaciones, camasSingles, camasDobles, precio);

        try {
            habitacionDAO.insertar(habitacion);
            JOptionPane.showMessageDialog(null, "Habitacion agregada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTablaPasajeros(tabla);
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la habitacion.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Modifica una habitación seleccionada en la tabla.
     *
     * @param numeroHabitacion Número de la habitación.
     * @param camasSingle Número de camas individuales.
     * @param camasDoble Número de camas dobles.
     * @param precioPorDia Precio por día.
     * @param tabla Tabla de la interfaz para actualizar.
     */
    public void modificarPasajero(String numeroHabitacion, String camasSingle, String camasDoble, String precioPorDia, JTable tabla) {
        if (idSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningúna Habitacion.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!validarCampos(numeroHabitacion, camasSingle, camasDoble, precioPorDia)) {
            return;
        }

        int numeroHabitaciones = Integer.parseInt(numeroHabitacion);
        int camasSingles = Integer.parseInt(camasSingle);
        int camasDobles = Integer.parseInt(camasDoble);
        double precio = Double.parseDouble(precioPorDia);
        Habitaciones habitacion = new Habitaciones(numeroHabitaciones, camasSingles, camasDobles, precio);
        habitacion.setId(idSeleccionado);

        try {
            habitacionDAO.modificar(habitacion);
            JOptionPane.showMessageDialog(null, "Habitacion modificada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTablaPasajeros(tabla);
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar la habitacion.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Elimina una habitación seleccionada de la base de datos y actualiza la
     * tabla.
     *
     * @param tabla Tabla de la interfaz para actualizar.
     */
    public void eliminarPasajero(JTable tabla) {
        if (idSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningúna habitacion.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Habitaciones habitacion = habitacionDAO.obtener(idSeleccionado);
            if (habitacion != null) {
                habitacionDAO.eliminar(habitacion);
                JOptionPane.showMessageDialog(null, "Habitacion eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarTablaPasajeros(tabla);
            }
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la habitacion.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Carga todas las habitaciones de la base de datos en la tabla de la
     * interfaz.
     *
     * @param tabla Tabla de la interfaz para actualizar.
     */
    public void cargarTablaPasajeros(JTable tabla) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);

        try {
            List<Habitaciones> habitaciones = habitacionDAO.obtenerTodos();
            for (Habitaciones p : habitaciones) {
                Object[] row = new Object[]{
                    p.getNumeroHabitacion(),
                    p.getCamasSingle(),
                    p.getCamasDoble(),
                    p.getPrecioPorDia(),
                    p.getId()
                };
                model.addRow(row);
            }
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los pasajeros.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Establece el ID de la habitación seleccionada desde la tabla.
     *
     * @param tabla Tabla de la interfaz de la cual obtener el ID seleccionado.
     */
    public void establecerIdSeleccionadoFromTable(JTable tabla) {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            idSeleccionado = (Long) tabla.getValueAt(filaSeleccionada, 4);
        }
    }
}
