package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.dao.OutilRepository;
import com.example.demo.entities.Outil;

@SpringBootApplication
@EnableDiscoveryClient
public class MsOutilApplication implements CommandLineRunner {
	@Autowired
	OutilRepository outilRepository;
	@Autowired

	RepositoryRestConfiguration repositoryRestConfig;

	public static void main(String[] args) {
		SpringApplication.run(MsOutilApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfig.exposeIdsFor(Outil.class);
		Outil outil1 = new Outil("service oriented architecture", null, "book");
		outilRepository.save(outil1);
		Outil outil2 = new Outil("bitcoin", null, "white paper");
		outilRepository.save(outil2);

	}

}
