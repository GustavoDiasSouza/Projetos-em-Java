package br.com.SpringDataJPA.SpringDataJPA.repository;

import br.com.SpringDataJPA.SpringDataJPA.orm.UnidadeTrabalho;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeTrabalhoRepository extends CrudRepository<UnidadeTrabalho, Integer> {
}
