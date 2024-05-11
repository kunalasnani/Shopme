package com.shopme.services;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.util.StringUtils;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.shopme.daos.FileService;



@Transactional
@Service
public class FileUpload implements FileService{

	
	@Autowired
	private AmazonS3Client awsS3CLient;
	
	
	@Override
	public String uploadFile(MultipartFile file) {
		String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
		
		String key = UUID.randomUUID().toString()+"."+extension;
		
		ObjectMetadata metaData =new ObjectMetadata();
		metaData.setContentLength(file.getSize());
		metaData.setContentType(file.getContentType());
		
		try {
			awsS3CLient.putObject("kunalprojectimages1912",key,file.getInputStream(),metaData);
			
		}catch (IOException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error occured while uploading thee file");
			
		}
		awsS3CLient.setObjectAcl("kunalprojectimages1912",key,CannedAccessControlList.PublicRead);
		return awsS3CLient.getResourceUrl("kunalprojectimages1912", key);
	}

}
