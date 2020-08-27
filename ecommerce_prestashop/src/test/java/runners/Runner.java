package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\features\\comprar_produto.feature",
        glue = "steps", // informa onde esta os steps, qual o codigo sera utlizado para  interpretar os passos definitos na classe feature																							
		tags = "@fluxopadrao", // executa apenas a tag informada
		plugin = {"pretty",
				  "html:target/cucumber.html",//especifica o tipo de relatorio, a pasta que sera armazenada( target), e o nome do arquivo gerado(cucumber.html)
				  "json:target/cucumber.json",
				  "junit:target/cucumber.xml"
				   
		             },  
		monochrome = true // É utilizado para definir a formatação do resultado dos testes na saída da
							// console. Se marcado como ”true”, o resultado dos testes sai na forma legível
)

public class Runner {

}
