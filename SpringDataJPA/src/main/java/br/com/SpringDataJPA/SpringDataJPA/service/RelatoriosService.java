package br.com.SpringDataJPA.SpringDataJPA.service;

import br.com.SpringDataJPA.SpringDataJPA.orm.Funcionario;
import br.com.SpringDataJPA.SpringDataJPA.orm.FuncionarioProjecao;
import br.com.SpringDataJPA.SpringDataJPA.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {


    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final FuncionarioRepository funcionarioRepository;

    public RelatoriosService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }


    public void inicial(Scanner scanner) {
        boolean system = true;

        while (system){

            System.out.println("\n Menu Relatorios ");
            System.out.println("1 - Busca funcionario nome");
            System.out.println("2 - Busca funcionario nome, salario e data");
            System.out.println("3 - Busca funcionario data");
            System.out.println("4 - Pesquisa Funcionario Salario");
            System.out.println("0 - Sair");
            System.out.print("Qual a escolha:");

            int action = scanner.nextInt();

            switch (action){

                case 1 -> buscaFuncionarioNome(scanner);
                case 2 -> buscaFuncionarioNomeSalarioMaiorData(scanner);
                case 3 -> buscaFuncionarioDataContratacao(scanner);
                case 4 -> pesquisaFuncionarioSalario();
                case 0 -> system = false;
            }
        }

    }

    private void buscaFuncionarioNome(Scanner scanner){

        System.out.print("Nome para pesquisar:");
        String name = scanner.next();

        List<Funcionario> list = funcionarioRepository.findByNome(name);
        list.forEach(System.out::println);

    }

    private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner){
        System.out.print("Qual nome:");
        String nome = scanner.next();

        System.out.print("Data no formato dia/mes/ano:");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        System.out.print("Salario:");
        Double salario = scanner.nextDouble();

        List<Funcionario> list = funcionarioRepository
                .findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
        list.forEach(System.out::println);

    }

    private void buscaFuncionarioDataContratacao(Scanner scanner){
        System.out.print("Data de Contratacao:");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        List<Funcionario> list = funcionarioRepository.findDataContratacaoMaior(localDate);
        list.forEach(System.out::println);

    }

    private void pesquisaFuncionarioSalario(){
        List<FuncionarioProjecao> list = funcionarioRepository.findFuncionarioSalario();
        list.forEach(f -> System.out.println("Funcionario: " +
                "id:"+f.getId()+
                " Nome:"+f.getNome()+
                " Salario: "+f.getSalario()

        ));

    }


}
