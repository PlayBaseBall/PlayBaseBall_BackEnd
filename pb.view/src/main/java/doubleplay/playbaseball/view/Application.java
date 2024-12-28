package doubleplay.playbaseball.view;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SpringBootApplication
public class Application  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		String openApiUrl = "http://localhost:8080/playBaseBall/v3/api-docs";

		RestTemplate restTemplate = new RestTemplate();
		String openApiSpec = restTemplate.getForObject(openApiUrl, String.class);

		saveOpenApiToFile(openApiSpec);
		System.out.println("saved  openapi.yaml");
	}

	private void saveOpenApiToFile(String openApiSpec) {
		File file = new File("openapi.yaml");
		try (FileWriter writer = new FileWriter(file)) {
			writer.write(openApiSpec);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
