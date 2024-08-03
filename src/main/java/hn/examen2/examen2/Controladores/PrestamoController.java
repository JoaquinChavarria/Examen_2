package hn.examen2.examen2.Controladores;

import hn.examen2.examen2.Modelos.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @SuppressWarnings("unused")
    @Autowired
    private Prestamo PrestamoService;

    @PostMapping
    public ResponseEntity<Prestamo> crearPrestamo(@RequestParam String dni, @RequestBody Prestamo prestamo) {
        Prestamo nuevoPrestamo = Prestamo.crearPrestamo(prestamo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPrestamo);
    }

    @GetMapping("/{codigoprestamo}")
    public ResponseEntity<Prestamo> obtenerPrestamo(@PathVariable Long codigoprestamo) {
        return Prestamo.obtenerPrestamoPorCodigo(codigoprestamo)
            .map(prestamo -> ResponseEntity.ok(prestamo))
            .orElse(ResponseEntity.notFound().build());
    }
}
