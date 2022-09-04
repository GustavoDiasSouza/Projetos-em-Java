package br.com.SpringDataJPA.SpringDataJPA.service;


import br.com.SpringDataJPA.SpringDataJPA.orm.Cargo;
import br.com.SpringDataJPA.SpringDataJPA.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {


    private final CargoRepository cargoRepository;

    public CrudCargoService(CargoRepository cargoRepository){
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scanner) {
        boolean system = true;

        while (system){

            System.out.println("\n Menu Cargos ");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Sair");
            System.out.print("Qual a escolha:");

            int action = scanner.nextInt();

            switch (action){
                case 1 -> salvar(scanner);
                case 2 -> atualizar(scanner);
                case 3 -> visualizar();
                case 4 -> deletar(scanner);
                case 0 -> system = false;
            }
        }

    }

    private void salvar( Scanner scanner ) {
        System.out.print("Descricao do cargo:");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println("Salvo!");

    }

    private void atualizar( Scanner scanner ){

        Cargo cargo = new Cargo();

        System.out.print("ID do cargo:");
        int id = scanner.nextInt();
        cargo.setId(id);

        System.out.print("Nova descricao do cargo:");
        String DESC = scanner.next();
        cargo.setDescricao(DESC);

        cargoRepository.save(cargo);
        System.out.println("Atualizado!");
    }

    private void visualizar(){

        Iterable<Cargo> cargos = cargoRepository.findAll();
        cargos.forEach(cargo -> System.out.println(cargo.toString()));

    }

    private void deletar(Scanner scanner){

        System.out.println("ID:");
        int id = scanner.nextInt();

        cargoRepository.deleteById(id);
        System.out.println("Deletado!");

    }

}
