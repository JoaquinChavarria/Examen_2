package hn.examen2.examen2.Servicios;

import hn.examen2.examen2.Modelos.Cliente;
import hn.examen2.examen2.Modelos.Prestamo;
import hn.examen2.examen2.Repositorios.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @SuppressWarnings("unused")
    @Autowired
    private PrestamoService prestamoService;

    public Cliente crearCliente(Cliente cliente) {
        if (clienteRepository.existsByDni(cliente.getDni())) {
            return null; 
        }

        cliente.getPrestamos().forEach(prestamo -> prestamo.setCliente(cliente));
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> obtenerClientePorDni(String dni) {
        return clienteRepository.findById(dni);
    }
}
