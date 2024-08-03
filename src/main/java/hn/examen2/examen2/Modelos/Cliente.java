package hn.examen2.examen2.Modelos;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
    @Id
    private String dni;
    @SuppressWarnings("unused")
    private String nombre;
    @SuppressWarnings("unused")
    private String apellido;
    @SuppressWarnings("unused")
    private String telefono;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Prestamo> prestamos;

	public Cliente crearCliente(Cliente cliente) {
		throw new UnsupportedOperationException("Unimplemented method 'crearCliente'");
	}

    public Object obtenerClientePorDni(String dni2) {
        throw new UnsupportedOperationException("Unimplemented method 'obtenerClientePorDni'");
    }

    public Object getPrestamos() {
        throw new UnsupportedOperationException("Unimplemented method 'getPrestamos'");
    }

    public String getDni() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDni'");
    }
}
