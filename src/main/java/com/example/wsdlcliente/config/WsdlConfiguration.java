package com.example.wsdlcliente.config;

import com.example.wsdlcliente.client.PaisClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class WsdlConfiguration {

    private static final String WSDL_SOURCE_CLASS_PACKAGE = "com.example.wsdlcliente.wsdl";
    private static final String CORREIOS_WEB_SERVICE_API_URI = "https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente";

    @Bean()
    public WebServiceTemplate correiosWebServiceTemplate(Jaxb2Marshaller marshaller) {
        var webservice = new WebServiceTemplate(marshaller);
        webservice.setDefaultUri(CORREIOS_WEB_SERVICE_API_URI);
        return webservice;
    }

    @Bean()
    public Jaxb2Marshaller marshaller() {
        var marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(WSDL_SOURCE_CLASS_PACKAGE);
        return marshaller;
    }

    @Bean
    public PaisClient countryClient(Jaxb2Marshaller marshaller) {
        PaisClient client = new PaisClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
