package es.iesjandula.Universidad;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class UniversidadApplication implements CommandLineRunner
{

	public static void main(String[] args)
	{
		SpringApplication.run(UniversidadApplication.class, args);
	}

	@Transactional(readOnly = true)
	public void run(String... args) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

}
