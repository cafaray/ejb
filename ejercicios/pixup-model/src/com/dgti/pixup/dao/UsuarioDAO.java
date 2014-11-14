package com.dgti.pixup.dao;

import com.dgti.pixup.exception.PixupDAOException;
import com.dgti.pixup.model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, String> {
    /***
     * Metodo que ayuda a un usuario a recuperar su contrasena de acceso al sistema de pixUp
     * @param correoElectronico Objeto usuario que requiere la recuperacion de la contrasenia
     * @throws PixupDAOException 
     */
    void recuperaContrasena(String correoElectronico)throws PixupDAOException;
    
    Usuario actualizaContrasena(Usuario usuario, String contrasena) throws PixupDAOException;
    
}
