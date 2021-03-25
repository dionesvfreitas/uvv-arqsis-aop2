/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqsis.aop2.dao;

import arqsis.aop2.model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author freit
 */
public class ClienteDao {
    
    public static List<Cliente> clientes = new ArrayList<Cliente>();
    
    public static List<Cliente> list() {
        return clientes;
    }

    public static List<Cliente> findByName(String text) {
        List<Cliente> retorno = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (!cliente.getNome().trim().toLowerCase().contains(text.trim().toLowerCase())) {
                continue;
            }
            retorno.add(cliente);
        }
        return retorno;
    }
 
    public static void create (Cliente cliente) {
        clientes.add(cliente);
    }
    
    public static Cliente findByMatricula(int matricula) {
        for (Cliente cliente : clientes) {
            if (cliente.getMatricula() == matricula) {
                return cliente;
            }
        }
        return null;
    }
    
    public static void update(int matricula, Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getMatricula() == matricula) {
                System.out.println("arqsis.aop2.dao.ClienteDao.update()");
                clientes.set(i, cliente);
            }
            
        }
    }
    
    public static void delete(int matricula) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getMatricula() == matricula) {
                clientes.remove(i);
            }
        }
    }

    public static void save(Cliente cliente) {
        Cliente cl = findByMatricula(cliente.getMatricula());
        if (cl != null) {
            update(cliente.getMatricula(), cliente);
        } else {
            create(cliente);
        }
    }
}
