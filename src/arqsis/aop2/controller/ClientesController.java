/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqsis.aop2.controller;

import arqsis.aop2.dao.ClienteDao;
import arqsis.aop2.model.Cliente;
import java.util.List;

/**
 *
 * @author freit
 */
public class ClientesController {

    public List<Cliente> findByName(String text) {
        return ClienteDao.findByName(text);
    }

    public List<Cliente> listAll() {
        return ClienteDao.list();
    }
    
    public void save(Cliente cliente) {
        ClienteDao.save(cliente);
    }

    public Cliente findByMatricula(int matricula) {
        return ClienteDao.findByMatricula(matricula);
    }

    public void delete(int matricula) {
        ClienteDao.delete(matricula);
    }
    
}
