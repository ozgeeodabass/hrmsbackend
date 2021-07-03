package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer> {

	
	List<Skill> getAllByCandidateId(int candidateId);
}
