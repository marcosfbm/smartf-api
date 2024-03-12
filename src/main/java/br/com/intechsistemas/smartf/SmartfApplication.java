package br.com.intechsistemas.smartf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartfApplication {

	public static void main(String[] args) {
		/*System.setProperty("file.encoding", "SQL_ASCII");
		System.setProperty("encoding", "SQL_ASCII");
		System.setProperty("sun.jnu.encoding", "SQL_ASCII");*/
		SpringApplication.run(SmartfApplication.class, args);
	}

}
