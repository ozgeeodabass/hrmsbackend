package kodlama.io.hrms;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;


@SpringBootApplication
@EnableSwagger2

public class HrmsApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(HrmsApplication.class, args);
		
		
		
		//File file = new File("my_image.jpg");
		//Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		
		//System.out.println(uploadResult.get("url"));
		
	}
	
	@Bean
	public ModelMapper modelMapper() {
			
		return new ModelMapper();
	}
	
	@Bean
		public Cloudinary cloudinary() {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", "dazkfy3xj",
				"api_key", "714473983954749",
				"api_secret", "bUrW7UHNM-dDutZPU0S5z5OZc-Y"));
	}
				
	
	 @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("kodlama.io.hrms"))                                      
	          .build();                                           
	    }

}
