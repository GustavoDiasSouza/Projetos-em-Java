package br.com.SpringDataJPA.SpringDataJPA;

import br.com.SpringDataJPA.SpringDataJPA.service.CrudCargoService;
import br.com.SpringDataJPA.SpringDataJPA.service.CrudFuncionarioService;
import br.com.SpringDataJPA.SpringDataJPA.service.CrudUnidadeTrabalhoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	private Boolean system = true;

	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;

	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;

	public SpringDataJpaApplication(CrudCargoService cargoService,
									CrudFuncionarioService funcionarioService,
									CrudUnidadeTrabalhoService unidadeTrabalhoService){
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		while(system){
			System.out.println("Qual Menu deseja executar?");

			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionarios");
			System.out.println("3 - Unidade");
			System.out.println("0 - Sair");
			System.out.print("Escolha:");

			int function = scanner.nextInt();

			switch (function) {
				case 1 -> cargoService.inicial(scanner);
				case 2 -> funcionarioService.inicial(scanner);
				case 3 -> unidadeTrabalhoService.inicial(scanner);
				case 0 -> {
					System.out.println("Finalizando");
					system = false;
				}
			}
		}
	}
}
