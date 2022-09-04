package br.com.SpringDataJPA.SpringDataJPA.service;

import br.com.SpringDataJPA.SpringDataJPA.orm.Funcionario;
import br.com.SpringDataJPA.SpringDataJPA.repository.FuncionarioRepository;
import br.com.SpringDataJPA.SpringDataJPA.Specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioFuncionarioDinamico {

    private final FuncionarioRepository funcionarioRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner){

        System.out.print("Nome do Funcionario:");
        String nome = scanner.next();
        if (nome.equalsIgnoreCase("NULL")){
            nome = null;
        }

        System.out.print("CPF:");
        String cpf = scanner.next();
        if ( cpf.equalsIgnoreCase("NULL") ){
            cpf = null;
        }

        System.out.print("Salario:");
        Double salario = scanner.nextDouble();

        if (salario == 0 ){
            salario = null;
        }

        System.out.print("Data:");
        String data = scanner.next();

        LocalDate dataContratacao;
        if ( data.equalsIgnoreCase("NULL") ){
            dataContratacao = null;
        } else {
            dataContratacao = LocalDate.parse(data, formatter);

        }


        List<Funcionario> funcionarios = funcionarioRepository
                .findAll( Specification
                        .where(
                                SpecificationFuncionario.nome(nome) )
                        .or(SpecificationFuncionario.cpf(cpf))
                        .or(SpecificationFuncionario.salario(salario))
                        .or(SpecificationFuncionario.dataContratacao(dataContratacao))
                );
        funcionarios.forEach(System.out::println);

    }


}
