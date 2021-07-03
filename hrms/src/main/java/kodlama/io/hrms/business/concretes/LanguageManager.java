package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.LanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.LanguageDao;
import kodlama.io.hrms.entities.Language;
import net.bytebuddy.asm.Advice.This;

@Service
public class LanguageManager implements LanguageService {
	
	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult();
	}

	@Override
	public Result addAll(List<Language> languages) {
		
		for (Language language : languages) {
			this.languageDao.save(language);
		}
		
		return new SuccessResult();
	}

	@Override
	public Result delete(Language language) {
		this.languageDao.delete(language);
		return new SuccessResult();
	}

	@Override
	public Result update(Language language) {
		this.languageDao.save(language);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Language>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<Language>>(this.languageDao.getAllByCandidate_Id(id));
	}
	
	

}
