package com.adweb.app.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adweb.app.entity.Comment;
import com.adweb.app.entity.Image;
import com.adweb.app.entity.Item;
import com.adweb.app.model.ImageBaseForm;
import com.adweb.app.model.ImageToItemForm;
import com.adweb.app.service.CommentService;
import com.adweb.app.service.FilesService;
import com.adweb.app.service.ImageService;
import com.adweb.app.service.ItemService;

@Controller
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired 
	private FilesService fileService;
	
	@Autowired 
	private CommentService commentService;
	
	private static String fileUrl = "/Users/ultra/Documents/images";
	
	//放入item图片库
	@RequestMapping(value = "/addImageToItem")
	public @ResponseBody void addImageToItem(@RequestBody ImageToItemForm imageToItemForm) throws FileNotFoundException, IOException{
		String filename = imageToItemForm.getImagename();
		String data = imageToItemForm.getData();
		String description = imageToItemForm.getDescription();
		
		Item item = this.itemService.findById(imageToItemForm.getItemid());

		String imageDataBytes = data.substring(data.indexOf(",")+1);
		byte[] image = Base64.decodeBase64(imageDataBytes);
		
		Image imageObj = new Image();
		imageObj.setFilename(filename);
		imageObj.setFilelocation(fileUrl+"/"+filename);
		imageObj.setDescription(description);
		imageObj.setItem(item);
		
		this.imageService.create(imageObj);
		try (OutputStream stream = new FileOutputStream(fileUrl+"/"+filename)) {
		    stream.write(image);
		}
	}
	
	//返回item图片库内的图片
	@RequestMapping(value="getAllItemImage/{itemid}")
	public @ResponseBody List<ImageBaseForm> getAllItemImageById(@PathVariable long itemid){
		Item item = this.itemService.findById(itemid);
		List<Image> imageList = this.imageService.findByItem(item);
		List<ImageBaseForm> imageBaseList = new ArrayList<ImageBaseForm>();
		for (Image image : imageList){
			ImageBaseForm imageBaseForm = new ImageBaseForm();
			imageBaseForm.setDescription(image.getDescription());
			imageBaseForm.setImagename(image.getFilename());
			imageBaseList.add(imageBaseForm);
		}
		return imageBaseList;
	}
	
	//根据图片库内filename返回图片
	@RequestMapping(value="getImageByName/{filename}/{type}")
	public @ResponseBody void getImageByName(@PathVariable String filename,@PathVariable String type,HttpServletResponse response)throws IOException{
		System.out.println(filename+"."+type);
		
		String fileUrl = this.imageService.findByFilename(filename+"."+type).getFilelocation();
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
	//根据itemId返回item的属性图片
	@RequestMapping(value="/getItemImage/{itemId}")
	public @ResponseBody void getImage(@PathVariable long itemId,HttpServletResponse response) throws IOException{
		Item item = this.itemService.findById(itemId);
		long avatarid = item.getAvatarid();
		String fileUrl = this.fileService.findById(avatarid);
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
}
