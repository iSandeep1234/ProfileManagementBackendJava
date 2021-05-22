package com.profile.developer.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	
	public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException{
		
	}

	public boolean uploadFile(MultipartFile multipartFile) {
		boolean isFalse = false;
		
		try {
			Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.pathSeparator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			System.out.println(multipartFile.getOriginalFilename());
			isFalse = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isFalse;
	}
	
}
