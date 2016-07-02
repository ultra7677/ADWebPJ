package com.adweb.app.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adweb.app.entity.Files;
import com.adweb.app.entity.User;
import com.adweb.app.model.AddImageForm;
import com.adweb.app.model.LoginForm;
import com.adweb.app.model.SendLoginForm;
import com.adweb.app.service.FilesService;
import com.adweb.app.service.UserService;

@Controller

public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private FilesService filesService;
	
	private static String fileUrl = "/Users/ultra/Documents/images";
	
	@RequestMapping(value="/login")
	public @ResponseBody SendLoginForm loginRequest(@RequestBody LoginForm loginForm){
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		SendLoginForm sendLoginForm = new SendLoginForm();
		
		if (!this.userService.exist(username)){
			sendLoginForm.setStatus(0);
			return sendLoginForm;
		}
			
		User user = this.userService.findByUsername(username);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		if(passwordEncoder.matches(password, user.getPassword())){
			sendLoginForm.setStatus(1);
		}else sendLoginForm.setStatus(-1);
		
		return sendLoginForm;
	}
	
	@RequestMapping(value="/register")
	public @ResponseBody SendLoginForm registerRequest(@RequestBody LoginForm registerForm){
		String username = registerForm.getUsername();
		String password = registerForm.getPassword();
		SendLoginForm sendRegisterForm = new SendLoginForm();
		
		if(this.userService.exist(username)){
			sendRegisterForm.setStatus(-1);
			return sendRegisterForm;
		}
		
		User user = new User();
		user.setUsername(username);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(password));
		
		this.userService.create(user);
		
		sendRegisterForm.setStatus(1);
	    return sendRegisterForm;
	}
	
	@RequestMapping(value = "/addImage",produces =  MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void addImage(@RequestBody AddImageForm addImageForm) throws FileNotFoundException, IOException{
		String username = addImageForm.getUsername();
		String filename = addImageForm.getFilename();
		String data = addImageForm.getData();
		
		String imageDataBytes = data.substring(data.indexOf(",")+1);
		byte[] image = Base64.decodeBase64(imageDataBytes);
		Files files = new Files();
		files.setFilename(filename);
		files.setFilelocation(fileUrl+"/"+filename);
		files.setFiletype("image");
		this.filesService.create(files);
		
		User user = this.userService.findByUsername(username);
		user.setAvatarid(files.getId());
		this.userService.create(user);
		
		try (OutputStream stream = new FileOutputStream(fileUrl+"/"+filename)) {
		    stream.write(image);
		}
	}
	
	@RequestMapping(value="/getImage/{username}")
	public @ResponseBody void getImage(@PathVariable String username,HttpServletResponse response) throws IOException{
		User user = this.userService.findByUsername(username);
		String fileUrl = this.filesService.findById(user.getAvatarid());
		if (fileUrl != null){
			FileInputStream file = new FileInputStream(fileUrl);
			  int i=file.available(); //得到文件大小   
		       byte data[]=new byte[i];   
		       file.read(data);  //读数据   
		       response.setContentType("image/*"); //设置返回的文件类型   
		       OutputStream outStream=response.getOutputStream(); //得到向客户端输出二进制数据的对象   
		       outStream.write(data);  //输出数据      
		       outStream.flush();  
		       outStream.close();   
		       file.close();   
		} 
	}
	
	@RequestMapping(value="/thirdPartyLogin/{username}")
	public @ResponseBody int thirdPartyLogin(@PathVariable String username){
		if (this.userService.exist(username))
			return 1;
		
		User user = new User();
		user.setUsername(username);
		user.setAvatarid(1);
		this.userService.create(user);
		
		return 0;
	}
	
}
