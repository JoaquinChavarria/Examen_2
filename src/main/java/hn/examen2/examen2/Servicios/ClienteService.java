package hn.examen2.examen2.Servicios;

import hn.examen2.examen2.Modelos.Cliente;
import hn.examen2.examen2.Repositorios.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarPorDni(String dni) {
        return clienteRepository.findById(dni).orElse(null);
    }

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public boolean clienteExiste(String dni) {
        return clienteRepository.existsById(dni);
    }
}
