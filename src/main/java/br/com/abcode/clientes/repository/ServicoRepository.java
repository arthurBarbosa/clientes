package br.com.abcode.clientes.repository;

import br.com.abcode.clientes.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    @Query(" SELECT s FROM Servico s join s.cliente c " +
            "WHERE UPPER(c.nome) LIKE UPPER (:nome) " +
            "AND MONTH(s.data) = :mes")
    List<Servico> findByNomeClienteAndMes(
            @Param("nome") String nome,
            @Param("mes") Integer mes);
}
