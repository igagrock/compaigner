import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import com.initgrep.compaigner.compaign.Compaign;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
public class Template {

	@Id @GeneratedValue
	private Long id;
	
	@NonNull
	private String title;
	
	@NonNull
	private String Content;
	
}
