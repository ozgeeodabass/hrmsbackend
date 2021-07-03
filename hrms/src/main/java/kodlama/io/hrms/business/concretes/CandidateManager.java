package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.abstracts.CoverLetterService;
import kodlama.io.hrms.business.abstracts.ImageService;
import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.business.abstracts.LanguageService;
import kodlama.io.hrms.business.abstracts.LinkService;
import kodlama.io.hrms.business.abstracts.SchoolService;
import kodlama.io.hrms.business.abstracts.SkillService;
import kodlama.io.hrms.core.utilities.adapters.mernis.UserCheckService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.entities.Candidate;
import kodlama.io.hrms.entities.dtos.CvDto;

@Service
public class CandidateManager implements CandidateService {


	private CandidateDao candidateDao;
	private JobExperienceService jobExperienceService;
	private UserCheckService userCheckService;
	private ImageService imageService;
	private LanguageService languageService;
	private LinkService linkService;
	private SkillService skillService;
	private SchoolService schoolService;
	private CoverLetterService coverLetterService;
	
   
	@Autowired
	public CandidateManager(CandidateDao candidateDao, JobExperienceService jobExperienceService,
			UserCheckService userCheckService, ImageService imageService, LanguageService languageService,
			LinkService linkService, SkillService skillService, SchoolService schoolService,
			CoverLetterService coverLetterService) {
		super();
		this.candidateDao = candidateDao;
		this.jobExperienceService = jobExperienceService;
		this.userCheckService = userCheckService;
		this.imageService = imageService;
		this.languageService = languageService;
		this.linkService = linkService;
		this.skillService = skillService;
		this.schoolService = schoolService;
		this.coverLetterService = coverLetterService;
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
		if(!checkIfRealPerson(candidate)) {
			return new ErrorResult("Invalid person!");
			
		}
		if(!existWithEmail(candidate.getEmail())) {
			return new ErrorResult("This email is already exist. Please try another email.");
		}
		
		if(!existWithNationalityId(candidate.getNationalityId())) {
			return new ErrorResult("The user which has this nationality id is already exist.");
		}
	
		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate added successfully. Email verification is waiting..");
	}

	@Override
	public Result delete(Candidate candidate) {
		this.candidateDao.deleteById(candidate.getId());
		return new SuccessResult("Candidate deleted successfully.");
	}

	@Override
	public Result update(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate updated successfully.");
	}

	@Override
	public DataResult<Candidate> getCandidateByNationalityId(String nationalityId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getCandidateByNationalityId(nationalityId));
		
	}


	@Override
	public boolean existWithNationalityId(String nationalityId) {
		if(candidateDao.getCandidateByEmail(nationalityId)!=null) {
			return false;
		}
		return true;
		
	}

	@Override
	public boolean existWithEmail(String email) {
		
		if(candidateDao.getCandidateByEmail(email)!=null) {
			return false;
		}
		return true;
	}
	
	
	private boolean checkIfRealPerson(Candidate candidate) {
		   if(!this.userCheckService.checkUser(Long.parseLong(candidate.getNationalityId()), candidate.getFirstName().toUpperCase(new Locale("tr")), candidate.getLastName().toLowerCase(new Locale("tr")),
				   candidate.getDateOfBirth())) {
			   
			   return false;
		   }
		   return true;
			
		}
		

	@Override
	public DataResult<Candidate> getByEmail(String email) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getCandidateByEmail(email));
	}

	@Override
	public DataResult<CvDto> getCvDtoById(int candidateId) {
		CvDto cv = new CvDto();
		
		cv.candidate=this.candidateDao.getById(candidateId);
		cv.coverLetters=this.coverLetterService.getAllByCandidate_Id(candidateId).getData();
		cv.image=this.imageService.getById(candidateId).getData();
		cv.jobExperiences=this.jobExperienceService.getByCandidateId(candidateId).getData();
		cv.languages=this.languageService.getAllByCandidateId(candidateId).getData();
		cv.links=this.linkService.getAllByCandidateId(candidateId).getData();
		cv.schools=this.schoolService.getAllByCandidateId(candidateId).getData();
		cv.skills=this.skillService.getAllByCandidateId(candidateId).getData();
		
		
		return new SuccessDataResult<CvDto>(cv);
		
	}

	
	
}
