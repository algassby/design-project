package com.archee;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.archee.service.FilesStorageService;

@SpringBootApplication
public class DocumentManagerApplication implements CommandLineRunner {
	@Resource
	FilesStorageService storageService;
	public static void main(String[] args) {
		SpringApplication.run(DocumentManagerApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		storageService.deleteAll();
	    storageService.init();
		
	}

}
