package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeTrabalhoService;
import br.com.alura.spring.data.service.RelatorioFuncionarioDinamico;
import br.com.alura.spring.data.service.RelatoriosService;

@SpringBootApplication
@EntityScan("br.com.alura.spring.data.orm")
public class SpringDataApplication implements CommandLineRunner{

	private Boolean system = true;

	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadesTrabahoService;
	private final RelatoriosService relatoriosService;
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;

	public SpringDataApplication(
			CrudCargoService cargoService, 
			CrudFuncionarioService funcionarioService, 
			CrudUnidadeTrabalhoService unidadeTrabalhoService,
			RelatoriosService relatoriosService,
			RelatorioFuncionarioDinamico relatorioFuncionarioDinamico
		) 
		{
			this.cargoService = cargoService;
			this.funcionarioService = funcionarioService;
			this.unidadesTrabahoService = unidadeTrabalhoService;
			this.relatoriosService = relatoriosService;
			this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
		}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while(system){
			System.out.println("Qual ação você quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionário");
			System.out.println("3 - Unidade de trabalho");
			System.out.println("4 - Relatórios da aplicação");
			System.out.println("5 - Relatório dinâmico");

			int action = scanner.nextInt();

			if(action == 1){
				cargoService.inicial(scanner);
			} else if(action == 2){
				funcionarioService.inicial(scanner);
			} else if(action == 3){
				unidadesTrabahoService.inicial(scanner);
			} else if(action == 4){
				relatoriosService.inicial(scanner);
			} else if(action == 5){
				relatorioFuncionarioDinamico.inicial(scanner);
			} else {
				system = false;
			}
		}
	}

}