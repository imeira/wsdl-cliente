# Cliente WebService SOAP
Cliente web utilizando SOAP com Java e Spring Boot.  
Esse cliente consome os dados disponibilizados pelo servidor implementado em https://github.com/imeira/wsdl-servidor
### Como executar a aplicação
Certifique-se de possuir o Git instalado.
```
git clone https://github.com/imeira/wsdl-cliente.git
cd wsdl-cliente
./mvnw clean install -DskipTests
./mvnw spring-boot:run
```
Será impresso no console dois exemplos de chamadas ao servidor mencionado acima.
