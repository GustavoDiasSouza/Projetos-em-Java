package br.com.SpringDataJPA.SpringDataJPA.service;

import br.com.SpringDataJPA.SpringDataJPA.orm.UnidadeTrabalho;
import br.com.SpringDataJPA.SpringDataJPA.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudUnidadeTrabalhoService {


	private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
	
	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}
	
	public void inicial(Scanner scanner) {
		boolean system = true;

		while(system) {


			System.out.println("\n Menu Unidade de Trabalho ");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");
			System.out.println("0 - Sair");
			System.out.println("Escolha:");
			
			int action = scanner.nextInt();

			switch (action) {
				case 1 -> salvar(scanner);
				case 2 -> atualizar(scanner);
				case 3 -> visualizar();
				case 4 -> deletar(scanner);
				case 0 -> system = false;
			}
			
		}
		
	}
	
	private void salvar(Scanner scanner) {
		System.out.print("Digite o nome da unidade:");
        String nome = scanner.next();

        System.out.print("Digite o endereco:");
        String endereco = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setDescricao(nome);
        unidadeTrabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Salvo com sucesso!");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.print("Digite o id:");
        Integer id = scanner.nextInt();

        System.out.print("Digite o nome da unidade:");
        String nome = scanner.next();

        System.out.print("Digite o endereco:");
        String endereco = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setId(id);
        unidadeTrabalho.setDescricao(nome);
        unidadeTrabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Alterado com sucesso!");
	}
	
	private void visualizar() {
		Iterable<UnidadeTrabalho> unidades = unidadeTrabalhoRepository.findAll();
		unidades.forEach(unidade -> System.out.println(unidade));
	}
	
	private void deletar(Scanner scanner) {
		System.out.print("\nId:");
		int id = scanner.nextInt();
		unidadeTrabalhoRepository.deleteById(id);
		System.out.println("Deletado com sucesso!");
	}
	
}
