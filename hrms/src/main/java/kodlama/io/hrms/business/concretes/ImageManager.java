package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.ImageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.dataAccess.abstracts.ImageDao;
import kodlama.io.hrms.entities.Image;

@Service
public class ImageManager implements ImageService {
	//Later
	private ImageDao imageDao;

	@Autowired
	public ImageManager(ImageDao imageDao) {
		super();
		this.imageDao = imageDao;
	}

	@Override
	public DataResult<Image> getByCandidateId(int candidateId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Image>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Image> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(Image image, MultipartFile imageFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(Image image) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(Image image) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
