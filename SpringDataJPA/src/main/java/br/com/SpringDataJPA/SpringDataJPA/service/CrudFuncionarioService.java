package br.com.SpringDataJPA.SpringDataJPA.service;

import br.com.SpringDataJPA.SpringDataJPA.orm.Cargo;
import br.com.SpringDataJPA.SpringDataJPA.orm.Funcionario;
import br.com.SpringDataJPA.SpringDataJPA.orm.UnidadeTrabalho;
import br.com.SpringDataJPA.SpringDataJPA.repository.CargoRepository;
import br.com.SpringDataJPA.SpringDataJPA.repository.FuncionarioRepository;
import br.com.SpringDataJPA.SpringDataJPA.repository.UnidadeTrabalhoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudFuncionarioService {


    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final CargoRepository cargoRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;


    public CrudFuncionarioService(FuncionarioRepository funcionarioRepository,
                                  CargoRepository cargoRepository,
                                  UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
        this.cargoRepository = cargoRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
    }

    public void inicial(Scanner scanner) {

        boolean system = true;

        while(system) {

            System.out.println("\n Menu Funcionarios ");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Sair");
            System.out.print("Escolha:");


            int action = scanner.nextInt();

            switch (action) {
                case 1 -> salvar(scanner);
                case 2 -> atualizar(scanner);
                case 3 -> visualizar(scanner);
                case 4 -> deletar(scanner);
                case 0 -> system = false;
            }

        }

    }

    private void salvar(Scanner scanner) {
        System.out.print("\nDigite o nome:");
        String nome = scanner.next();

        System.out.print("\nDigite o cpf:");
        String cpf = scanner.next();

        System.out.print("\nDigite o salario:");
        Double salario = scanner.nextDouble();

        System.out.print("\nDigite a data de contracao:");
        String dataContratacao = scanner.next();

        System.out.print("\nDigite o cargoId:");
        Integer cargoId = scanner.nextInt();

        List<UnidadeTrabalho> unidades = unidade(scanner);

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setDataContratacao(dataContratacao);
        Optional<Cargo> cargo = cargoRepository.findById(cargoId);
        funcionario.setCargo(cargo.get());
        funcionario.setUnidadeTrabalhos(unidades);

        funcionarioRepository.save(funcionario);
        System.out.println("Salvo");
    }

    private List<UnidadeTrabalho> unidade(Scanner scanner) {
        boolean isTrue = true;
        List<UnidadeTrabalho> unidades = new ArrayList<>();

        while (isTrue) {
            System.out.println("Digite o unidadeId (Para sair digite 0)");
            int unidadeId = scanner.nextInt();

            if(unidadeId != 0) {
                Optional<UnidadeTrabalho> unidade = unidadeTrabalhoRepository.findById(unidadeId);
                unidades.add(unidade.get());
            } else {
                isTrue = false;
            }
        }

        return unidades;
    }

    private void atualizar(Scanner scanner) {
        System.out.print("\nDigite o id:");
        Integer id = scanner.nextInt();

        System.out.print("\nDigite o nome:");
        String nome = scanner.next();

        System.out.print("\nDigite o cpf:");
        String cpf = scanner.next();

        System.out.print("\nDigite o salario:");
        Double salario = scanner.nextDouble();

        System.out.print("\nDigite a data de contracao:");
        String dataContratacao = scanner.next();

        System.out.print("\nDigite o cargoId:");
        Integer cargoId = scanner.nextInt();

        Funcionario funcionario = new Funcionario();
        funcionario.setId(id);
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setDataContratacao(dataContratacao);
        Optional<Cargo> cargo = cargoRepository.findById(cargoId);
        funcionario.setCargo(cargo.get());

        funcionarioRepository.save(funcionario);
        System.out.println("Alterado");
    }

    private void visualizar(Scanner scanner) {
        System.out.print("Pagina para visualizar:");
        int page = scanner.nextInt();

        PageRequest pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.ASC, "nome") );

        Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);

        System.out.println(funcionarios);
        System.out.println("Pagina Atual:" + funcionarios.getNumber() );
        System.out.println("Total:" + funcionarios.getTotalElements());
        funcionarios.forEach(System.out::println);
    }

    private void deletar(Scanner scanner) {
        System.out.println("Id");
        int id = scanner.nextInt();
        funcionarioRepository.deleteById(id);
        System.out.println("Deletado");
    }

}
