package br.com.SpringDataJPA.SpringDataJPA;

import br.com.SpringDataJPA.SpringDataJPA.orm.Cargo;
import br.com.SpringDataJPA.SpringDataJPA.service.CrudCargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	private Boolean system = true;

	private final CrudCargoService cargoService;

	public SpringDataJpaApplication(CrudCargoService cargoService){
		this.cargoService = cargoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		while(system){
			System.out.println("\n1 - Cargo");
			System.out.println("0 - Sair");
			System.out.print("Qual a escolha:");

			int action = scanner.nextInt();

			if(action == 1){
				cargoService.inicial(scanner);
			}else {
				system = false;
			}
		}



	}
}
