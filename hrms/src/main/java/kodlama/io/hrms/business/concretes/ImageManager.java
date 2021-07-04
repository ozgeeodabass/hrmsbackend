package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import kodlama.io.hrms.business.abstracts.ImageService;
import kodlama.io.hrms.core.imageUploading.ImageUploadService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ImageDao;
import kodlama.io.hrms.entities.Image;

@Service
public class ImageManager implements ImageService {
	
	private ImageDao imageDao;
	private ImageUploadService imageUploadService;

	@Autowired
	public ImageManager(ImageDao imageDao, ImageUploadService imageUploadService) {
		super();
		this.imageDao = imageDao;
		this.imageUploadService = imageUploadService;
	}
	
	@Override
	public Result add(Image image, MultipartFile imageFile) {
		@SuppressWarnings("unchecked")
		Map<String,String> uploadImage = this.imageUploadService.uploadImageFile(imageFile).getData();
		image.setUrl(uploadImage.get("url"));
		this.imageDao.save(image);
		return new SuccessResult("Image added.");
	}
	
	@Override
	public Result delete(Image image) {
		this.imageDao.delete(image);
		return new SuccessResult("Image deleted");
	}

	@Override
	public Result update(Image image) {
		this.imageDao.save(image);
		return new SuccessResult("Image updated");
	}
	
	
	@Override
	public DataResult<Image> getByCandidateId(int candidateId) {
		return new SuccessDataResult<Image>(this.imageDao.getByCandidate_Id(candidateId));
	}


	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll());
	}

	@Override
	public DataResult<Image> getById(int id) {
		return new SuccessDataResult<Image>(this.imageDao.getById(id));
	}

	

	
	
	

}
