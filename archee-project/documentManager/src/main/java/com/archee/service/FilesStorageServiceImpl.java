package com.archee.service;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.archee.model.FileInfo;
import com.archee.repository.FileRepository;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {

  private Logger logger = LoggerFactory.getLogger(FilesStorageServiceImpl.class);
  private final Path root = Paths.get("uploads");
  @Autowired
  private FileRepository repository;

  @Override
  public void init() {
	
    try {
      Files.createDirectory(root);
    } catch (IOException e) {
      throw new RuntimeException("Could not initialize folder for upload!");
    }
  }

  @Override
  public void save(MultipartFile file) {
	FileInfo fileInfo = null;
    try {
      fileInfo = new FileInfo();
      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
      fileInfo.setName(file.getOriginalFilename().toString());
      fileInfo.setProfil_id(0);
      fileInfo.setUrl(this.root.resolve(file.getOriginalFilename()).toString());
      fileInfo.setType(null);
      fileInfo.setDate(new Date());
      repository.save(fileInfo);
      logger.info(new StringBuilder().append("File info = ").append(fileInfo.toString()).toString());
      logger.info(file.getOriginalFilename().toString());
      
    } catch (Exception e) {
      throw new RuntimeException(new StringBuilder().append("Could not store the file. Error: ").append(e.getMessage()).toString());
    }
  }

  @Override
  public Resource load(String filename) {
    try {
      Path file = root.resolve(filename);
      Resource resource = new UrlResource(file.toUri());

      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read the file!");
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }

  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(root.toFile());
  }

  @Override
  public Stream<Path> loadAll() {
    try {
      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
    } catch (IOException e) {
      throw new RuntimeException("Could not load the files!");
    }
  }

public FileRepository getRepository() {
	return repository;
}

public void setRepository(FileRepository repository) {
	this.repository = repository;
}

public Path getRoot() {
	return root;
}
  
}