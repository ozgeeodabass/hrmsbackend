package kodlama.io.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
	
	private String jobPositionName;
	private String companyName;
	private int numberOfOpenPositions; 
	private LocalDate createdDate; 
	private LocalDate applicationDeadline;

}
