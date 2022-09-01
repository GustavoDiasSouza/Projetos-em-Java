package br.com.SpringDataJPA.SpringDataJPA.repository;

import br.com.SpringDataJPA.SpringDataJPA.orm.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
}
