package br.com.abcode.clientes.repository;

import br.com.abcode.clientes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Cliente, Integer> {
}
