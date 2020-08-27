package br.com.abcode.clientes.repository;

import br.com.abcode.clientes.entity.Cliente;
import br.com.abcode.clientes.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
