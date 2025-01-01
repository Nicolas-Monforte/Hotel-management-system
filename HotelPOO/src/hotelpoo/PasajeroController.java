package hotelpoo;

import DAO.MySQLPasajeroDAO;
import DAO.DAOException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador para gestionar las operaciones relacionadas con pasajeros en un hotel.
 * Proporciona métodos para agregar, modificar, eliminar, y cargar pasajeros en la tabla.
 * 
 * @author monfo
 * @version 1.0
 */
public class PasajeroController {

    private MySQLPasajeroDAO pasajeroDAO;
    private Long idSeleccionado;

    /**
     * Constructor que inicializa el DAO de pasajeros.
     */
    public PasajeroController() {
        try {
            pasajeroDAO = new MySQLPasajeroDAO();  
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al inicializar el DAO de pasajero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
  
    /**
     * Valida los campos de entrada para los datos de un pasajero.
     * 
     * @param nombre el nombre del pasajero
     * @param apellido el apellido del pasajero
     * @param documentoStr el documento del pasajero 
     * @param telefonoStr el teléfono del pasajero 
     * @param correo el correo electrónico del pasajero
     * @return {@code true} si los campos son válidos, de lo contrario {@code false}
     */
    private boolean validarCampos(String nombre, String apellido, String documentoStr, String telefonoStr, String correo) {
        if (nombre.isEmpty() || apellido.isEmpty() || documentoStr.isEmpty() || telefonoStr.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(documentoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El documento debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Long.parseLong(telefonoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El teléfono debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Agrega un nuevo pasajero a la base de datos y actualiza la tabla.
     * 
     * @param nombre el nombre del pasajero
     * @param apellido el apellido del pasajero
     * @param documentoStr el documento del pasajero (como cadena)
     * @param telefonoStr el teléfono del pasajero (como cadena)
     * @param correo el correo electrónico del pasajero
     * @param tabla la tabla donde se mostrarán los datos del pasajero
     */
    public void agregarPasajero(String nombre, String apellido, String documentoStr, String telefonoStr, String correo, JTable tabla) {
        if (!validarCampos(nombre, apellido, documentoStr, telefonoStr, correo)) return;

        int documento = Integer.parseInt(documentoStr);
        long telefono = Long.parseLong(telefonoStr);
        Pasajeros pasajero = new Pasajeros(nombre, apellido, documento, telefono, correo);

        try {
            pasajeroDAO.insertar(pasajero);
            JOptionPane.showMessageDialog(null, "Pasajero agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTablaPasajeros(tabla);
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el pasajero.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Modifica los datos de un pasajero existente en la base de datos y actualiza la tabla.
     * 
     * @param nombre el nombre del pasajero
     * @param apellido el apellido del pasajero
     * @param documentoStr el documento del pasajero 
     * @param telefonoStr el teléfono del pasajero 
     * @param correo el correo electrónico del pasajero
     * @param tabla la tabla donde se mostrarán los datos del pasajero
     */
    public void modificarPasajero(String nombre, String apellido, String documentoStr, String telefonoStr, String correo, JTable tabla) {
        if (idSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún pasajero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!validarCampos(nombre, apellido, documentoStr, telefonoStr, correo)) return;

        int documento = Integer.parseInt(documentoStr);
        long telefono = Long.parseLong(telefonoStr);
        Pasajeros pasajero = new Pasajeros(nombre, apellido, documento, telefono, correo);
        pasajero.setId(idSeleccionado);

        try {
            pasajeroDAO.modificar(pasajero);
            JOptionPane.showMessageDialog(null, "Pasajero modificado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTablaPasajeros(tabla);
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el pasajero.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Elimina un pasajero seleccionado de la base de datos y actualiza la tabla.
     * 
     * @param tabla la tabla donde se mostrarán los datos del pasajero
     */
    public void eliminarPasajero(JTable tabla) {
        if (idSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún pasajero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Pasajeros pasajero = pasajeroDAO.obtener(idSeleccionado);
            if (pasajero != null) {
                pasajeroDAO.eliminar(pasajero);
                JOptionPane.showMessageDialog(null, "Pasajero eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarTablaPasajeros(tabla);
            }
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el pasajero.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Carga los datos de los pasajeros en la tabla proporcionada.
     * 
     * @param tabla la tabla donde se mostrarán los datos de los pasajeros
     */
    public void cargarTablaPasajeros(JTable tabla) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0); 

        try {
            List<Pasajeros> pasajeros = pasajeroDAO.obtenerTodos();
            for (Pasajeros p : pasajeros) {
                Object[] row = new Object[]{
                    p.getNombre(),
                    p.getApellido(),
                    p.getDocumento(),
                    p.getTelefono(),
                    p.getCorreoElectronico(),
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
     * Establece el ID del pasajero seleccionado en la tabla.
     * 
     * @param tabla la tabla que contiene los datos de los pasajeros
     */
    public void establecerIdSeleccionadoFromTable(JTable tabla) {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            idSeleccionado = (Long) tabla.getValueAt(filaSeleccionada, 5); 
        }
    }
}

