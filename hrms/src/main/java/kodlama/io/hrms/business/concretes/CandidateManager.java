package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.entities.Candidate;
import kodlama.io.hrms.entities.dtos.CandidateWithCvDto;
import kodlama.io.hrms.mernis.fakeMernisService;
import net.bytebuddy.asm.Advice.This;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private fakeMernisService mernisService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao,fakeMernisService mernisService) {
		super();
		this.candidateDao = candidateDao;
		this.mernisService= mernisService;
	}

	@Override
	public DataResult<List<Candidate>> gettAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
		
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(id));
	}

	@Override
	public Result add(Candidate candidate) {
		
	
		this.candidateDao.save(candidate);
		return new SuccessResult("İş arayan eklendi. Eposta doğrulaması bekleniyor.");
	}

	@Override
	public Result delete(int id) {
		this.candidateDao.deleteById(id);
		return new SuccessResult("İş arayan silindi");
	}

	@Override
	public Result update(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("İş arayan güncellendi");
	}

	@Override
	public DataResult<Candidate> getCandidateByNationalId(String nationalityId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findCandidateByNationalityId(nationalityId));
		
	}

	@Override
	public Result register(Candidate candidate) {
		if(candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty() || candidate.getNationalityId().isEmpty()
				|| candidate.getDateOfBirth()==null || candidate.getEmail().isEmpty()|| candidate.getPassword().isEmpty()
				|| candidate.getPasswordAgain().isEmpty() ) {
			
			return new ErrorResult("Bilgilerin tümü girilmiş olmalı");
			
			
		}
		
		if(!(existWithEmail(candidate.getEmail()).isSuccess())){
			return new ErrorResult("Farklı bir email adresi deneyiniz");
		}
		
		if(!(existWithTc(candidate.getNationalityId()).isSuccess())){
			return new ErrorResult("TC kimlik numaranızı kontrol ediniz");
		}
		
		
		if(!(this.mernisService.isValid(candidate.getNationalityId(), candidate.getFirstName(), candidate.getLastName(), candidate.getDateOfBirth()))){
			return new ErrorResult("Mernis doğrulaması başarısız");
		}
		
		add(candidate);
		return new SuccessResult("Kullanıcı kayıt oldu. Eposta doğrulamı bekleniyor");
		
		
	}

	@Override
	public boolean checkPasswordIsTrue(Candidate candidate) {
		if(candidate.getPassword()!= candidate.getPasswordAgain()) {
			return false;
		}
		return true;
	}

	@Override
	public Result existWithTc(String Tc) {
		if(candidateDao.findCandidateByNationalityId(Tc)!=null) {
			return new ErrorResult("Bu TC kimlik numarası ile zaten bit kayıt var!");
		}
		return new SuccessResult();
		
	}

	@Override
	public Result existWithEmail(String eMail) {
		
		
		if(candidateDao.findCandidateByEmail(eMail)!=null) {
			return new ErrorResult("Bu email ile zaten bit kayıt var!");
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<CandidateWithCvDto> getCandidateWithCvDetails() {
		return new SuccessDataResult<CandidateWithCvDto>(this.candidateDao.getCandidateWithCvDetails());
		
	}
	
	
	
	
}
