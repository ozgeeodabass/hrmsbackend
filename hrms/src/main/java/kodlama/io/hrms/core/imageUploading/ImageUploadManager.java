package kodlama.io.hrms.core.imageUploading;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;

@Service
public class ImageUploadManager implements ImageUploadService{
	
	private Cloudinary cloudinary;

	@Autowired
	public ImageUploadManager(Cloudinary cloudinary) {
		super();
		this.cloudinary = cloudinary;
	}

	@Override
	public DataResult<Map> uploadImageFile(MultipartFile file) {
		try {
			Map<String,String> map= (Map<String,String>) cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
			
			return new SuccessDataResult<Map>(map);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return new ErrorDataResult<Map>("Image can not added!");
		
		
	}
	
	
	
	
	
	
	

}
