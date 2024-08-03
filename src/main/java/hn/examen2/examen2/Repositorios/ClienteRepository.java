package hn.examen2.examen2.Repositorios;

import hn.examen2.examen2.Modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
    boolean existsByDni(String dni);
}
