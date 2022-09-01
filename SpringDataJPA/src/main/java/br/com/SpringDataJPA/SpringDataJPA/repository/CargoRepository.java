package br.com.SpringDataJPA.SpringDataJPA.repository;

import br.com.SpringDataJPA.SpringDataJPA.orm.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {



}
