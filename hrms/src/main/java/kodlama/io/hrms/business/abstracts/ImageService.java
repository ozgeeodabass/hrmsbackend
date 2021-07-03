package kodlama.io.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.Image;

public interface ImageService {
	
	DataResult<Image> getByCandidateId(int candidateId);
	
	DataResult<List<Image>> getAll();
	
	DataResult<Image> getById(int id);
	
	Result add(Image image,MultipartFile imageFile);
	
	Result delete(Image image);
	
	Result update(Image image);
	

}
