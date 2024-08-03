package hn.examen2.examen2.Repositorios;

import hn.examen2.examen2.Modelos.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByClienteDni(String dni);
}
