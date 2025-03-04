package com.aa.Model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Question_Table")
@Data
public class QuestionModel {
	
	@SequenceGenerator(name = "g1", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "g1", strategy = GenerationType.SEQUENCE)
	@Id
	private Long id;
	
	@NonNull
	@Column(name="Ques")
	private String question;
	
	@NonNull
	@Column(name="Options")
	private String options; // Store as "A,B,C,D" in DB
	
	@NonNull
	@Column(name="RightAns")
	private String correctAnswer;
	
	@Transient
	private long qId;

	// Convert comma-separated options into List<String>
//	public List<String> getOptionsAsList() {
//	    return Arrays.asList(options.split(","));
	
}
