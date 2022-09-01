package br.com.SpringDataJPA.SpringDataJPA.service;


import br.com.SpringDataJPA.SpringDataJPA.orm.Cargo;
import br.com.SpringDataJPA.SpringDataJPA.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {

    private Boolean system = true;
    private final CargoRepository cargoRepository;

    public CrudCargoService(CargoRepository cargoRepository){
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scanner) {

        while (system){

            System.out.println("\n1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("0 - Sair");
            System.out.print("Qual a escolha:");

            int action = scanner.nextInt();

            switch (action){
                case 1 -> salvar(scanner);
                case 2 -> atualizar(scanner);
                case 0 -> system = false;
            }
        }

    }

    public void salvar( Scanner scanner ) {
        System.out.println("Descricao do cargo:");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println("Salvo!");

    }

    public void atualizar( Scanner scanner ){

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

}
