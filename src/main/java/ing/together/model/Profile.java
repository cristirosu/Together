package ing.together.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="Profile")
public class Profile {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String job;
	private int age;
	private String image;
	
	public Profile(){
		
	}
	
	public Profile(int id, String name, String job, int age) {
		super();
		this.id = id;
		this.name = name;
		this.job = job;
		this.age = age;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
