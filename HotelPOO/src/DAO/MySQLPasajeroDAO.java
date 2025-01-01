package DAO;

import Persistencia.Conexion;
import hotelpoo.Pasajeros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MySQLPasajeroDAO implements PasajeroDAO {

    private Connection conn;
    final String INSERT = "INSERT INTO pasajeros(nombre, apellido, documento, telefono, correoElectronico) VALUES(?,?,?,?,?)";
    final String UPDATE = "UPDATE pasajeros SET nombre=?,apellido=?,documento=?,telefono=?,correoElectronico=? WHERE id=?";
    final String DELETE = "DELETE FROM pasajeros WHERE id =?";
    final String GETALL = "SELECT id, nombre,apellido,documento, telefono,correoElectronico FROM pasajeros ";
    final String GETONE = "SELECT id, nombre,apellido,documento, telefono,correoElectronico FROM pasajeros  WHERE id=?";

 public MySQLPasajeroDAO() throws SQLException {
        
        this.conn = Conexion.getConnection();
    }

    @Override
public void insertar(Pasajeros a) throws DAOException {
    PreparedStatement stat = null;
    try {
        stat = conn.prepareStatement(INSERT);
        stat.setString(1, a.getNombre());
        stat.setString(2, a.getApellido());
        stat.setInt(3, a.getDocumento());
        stat.setLong(4, a.getTelefono());
        stat.setString(5, a.getCorreoElectronico());

        if (stat.executeUpdate() == 0) {
            throw new DAOException("Puede No haberse guardado.");
        }
    } catch (SQLException ex) {
        System.out.println("Código de error: " + ex.getErrorCode());
        System.out.println("Mensaje: " + ex.getMessage());
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
public void modificar(Pasajeros a) throws DAOException {
    PreparedStatement checkStat = null;
    PreparedStatement stat = null;
    ResultSet rs = null;

    try {
        
        checkStat = conn.prepareStatement("SELECT * FROM pasajeros WHERE id = ?");
        checkStat.setLong(1, a.getId());
        rs = checkStat.executeQuery();
        if (!rs.next()) {
            throw new DAOException("El pasajero no existe.");
        }

       
        stat = conn.prepareStatement(UPDATE);
        stat.setString(1, a.getNombre());
        stat.setString(2, a.getApellido());
        stat.setInt(3, a.getDocumento());
        stat.setLong(4, a.getTelefono());
        stat.setString(5, a.getCorreoElectronico());
        stat.setLong(6, a.getId());

        if (stat.executeUpdate() == 0) {
            throw new DAOException("Puede que el pasajero no haya sido modificado.");
        }
    } catch (SQLException ex) {
        throw new DAOException("Error en SQL", ex);
    } finally {
        if (rs != null) try { rs.close(); } catch (SQLException ex) {}
        if (checkStat != null) try { checkStat.close(); } catch (SQLException ex) {}
        if (stat != null) try { stat.close(); } catch (SQLException ex) {}
    }
}

   
  @Override
public void eliminar(Pasajeros a) throws DAOException {
    PreparedStatement stat = null;
    try {
        stat = conn.prepareStatement(DELETE);
        stat.setLong(1, a.getId());
        if(stat.executeUpdate() == 0) {
            throw new DAOException("Puede que el pasajero no haya sido eliminado.");
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
    private Pasajeros convertir(ResultSet rs) throws SQLException{
       String nombre=rs.getString("nombre");
       String apellido=rs.getString("apellido");
       int documento= rs.getInt("documento");
      long telefono= rs.getLong("telefono");
       String correoElectronico= rs.getNString("correoElectronico");
       Pasajeros pasajeros =new Pasajeros(nombre, apellido,documento,telefono,correoElectronico);
       pasajeros.setId(rs.getLong("id"));
       return pasajeros;
    }
            
    @Override
    public Pasajeros obtener(Long id) throws DAOException{
       PreparedStatement stat= null;
       ResultSet rs=null;
      Pasajeros a=null;
       try{
           stat=conn.prepareStatement(GETONE);
           stat.setLong(1,id);
           rs= stat.executeQuery();
           if(rs.next()){
               a=convertir(rs);
           }else{
               throw new DAOException("No se ha encontrado ese registro");
           }
       }catch(SQLException ex){
           throw new DAOException("Error de SQL",ex);
       }finally{
          if(rs !=null){
              try{
                  rs.close();
              }catch(SQLException ex){
                  new DAOException("Error en SQL",ex);
              }
          } 
          if(stat != null){
              try{
                  stat.close();
              }catch(SQLException ex){
                  new DAOException("Error en SQL",ex);
              }
          }
       }
       return a;
    }
    
 @Override
    public List<Pasajeros> obtenerTodos() throws DAOException {
       PreparedStatement stat= null;
       ResultSet rs=null;
      Pasajeros a=null;
      List<Pasajeros> pasajeros =new ArrayList<>();
       try{
           stat=conn.prepareStatement(GETALL);
           rs= stat.executeQuery();//extrae el cursor de la bdd
           while(rs.next()){
               pasajeros.add(convertir(rs));
           }
       }catch(SQLException ex){
           throw new DAOException("Error de SQL",ex);
       }finally{
          if(rs !=null){
              try{
                  rs.close();
              }catch(SQLException ex){
                  new DAOException("Error en SQL",ex);
              }
          } 
          if(stat != null){
              try{
                  stat.close();
              }catch(SQLException ex){
                  new DAOException("Error en SQL",ex);
              }
          }
       }
       return pasajeros;
    }
}
