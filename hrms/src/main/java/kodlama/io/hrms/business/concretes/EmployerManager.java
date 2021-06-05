package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> gettAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.getById(id));
	}

	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("İşveren eklendi");
	}

	@Override
	public Result delete(int id) {
		this.employerDao.deleteById(id);
		return new SuccessResult("İşveren silindi");
		
	}

	@Override
	public Result update(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("İşveren güncellendi");
	}

	@Override
	public DataResult<Employer> getEmployerByNationalalityId(String nationalityId) {
		return new SuccessDataResult<Employer>(this.employerDao.findEmployerByNationalityId(nationalityId));
		
	}

	@Override
	public Result register(Employer employer) {
		if(employer.getCompanyName().isEmpty() || employer.getWebSite().isEmpty() || employer.getDomainMail().isEmpty()
				|| employer.getPhoneNumber().isEmpty() || employer.getPassword().isEmpty()
				|| employer.getPasswordAgain().isEmpty() ) {
			
			return new ErrorResult("Bilgilerin tümü girilmiş olmalı");
			
		}
		if(!employer.getDomainMail().contains(employer.getWebSite())) {
			return new ErrorResult("Lütfen domain adresinizi içeren mail adresiniz ile kayıt olunuz");
		
		}
		
		if(!(existWithEmail(employer.getEmail()).isSuccess())){
			return new ErrorResult("Farklı bir email adresi deneyiniz");
		}

		add(employer);
		return new SuccessResult("Kayıt olundu. Email ve Personel onayı bekleniyor.");
		
		
	}

	@Override
	public boolean checkPasswordIsTrue(Employer employer) {
		if(employer.getPassword()!= employer.getPasswordAgain()) {
			return false;
		}
		return true;
	}

	

	@Override
	public Result existWithEmail(String eMail) {
		if(employerDao.findEmployerByEmail(eMail)!=null) {
			return new ErrorResult("Bu email ile zaten bit kayıt var!");
		}
		return new SuccessResult();
	}
	
	
	
}
