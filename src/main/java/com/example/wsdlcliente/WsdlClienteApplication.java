package com.example.wsdlcliente;

//import com.example.wsdlcliente.wsdl.ConsultaCEPResponse;
//import com.example.wsdlcliente.wsdl.GetPaisResponse;
//import com.example.wsdlcliente.wsdl.Pais;
//import org.springframework.boot.CommandLineRunner;
import java.util.concurrent.ExecutionException;
import com.example.wsdlcliente.service.CorreiosService;
import com.example.wsdlcliente.wsdl.EnderecoERP;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WsdlClienteApplication {

//	public static void main(String[] args){
//		SpringApplication.run(WsdlClienteApplication.class, args);
//	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		var applicationContext = SpringApplication.run(WsdlClienteApplication.class, args);
		var correiosService    = applicationContext.getBean(CorreiosService.class);

		String request = "04617015";

		correiosService.consultarCepAsync(request).whenComplete((response, exception) -> {
			if (exception != null) System.err.println(exception.getMessage());
			System.out.println("=========  Async Result =============== CEP = " + request);
			System.out.println(response.getCep());
			System.out.println(response.getCidade());
			System.out.println(response.getBairro());
			System.out.println(response.getEnd());
			System.out.println(response.getComplemento2());
		});
	}

		@Bean
		CommandLineRunner lookup(CorreiosService quoteClient) {
			return args -> {
				String request = "04601000";
				EnderecoERP response = quoteClient.consultarCep(request);
				System.out.println("=========  Sync Result =============== CEP = " + request);
				System.out.println(response.getCep());
				System.out.println(response.getCidade());
				System.out.println(response.getBairro());
				System.out.println(response.getEnd());
				System.out.println(response.getComplemento2());
			};
		}



	//	@Bean
//	CommandLineRunner lookupOld(PaisClient quoteClient) {
//		return args -> {
//			String pais = "Brasil";
//			GetPaisResponse response = quoteClient.getPais(pais);
//			System.out.println(response.getPais().getCapital());
//			System.out.println(response.getPais().getMoeda());
//			System.out.println(response.getPais().getPopulacao());
//
//			response = quoteClient.getPais("Reino Unido");
//			System.out.println(response.getPais().getCapital());
//			System.out.println(response.getPais().getMoeda());
//			System.out.println(response.getPais().getPopulacao());
//		};
//	}


}
