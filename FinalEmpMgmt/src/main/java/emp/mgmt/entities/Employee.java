package emp.mgmt.entities;

import java.io.InputStream;
import java.sql.Date;

public class Employee {

	private int id;
	private String name;
	private double salary;
	private Date dateOfJoining;
	private String bio;
	private boolean isOnLeave;
	private InputStream profileImage;

	public Employee() {
		super();
	}

	public Employee(String name, double salary, Date dateOfJoining, String bio, boolean isOnLeave,
			InputStream profileImage) {
		super();
		this.name = name;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
		this.bio = bio;
		this.isOnLeave = isOnLeave;
		this.profileImage = profileImage;
	}

	public Employee(int id, String name, double salary, Date dateOfJoining, String bio, boolean isOnLeave,
			InputStream profileImage) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
		this.bio = bio;
		this.isOnLeave = isOnLeave;
		this.profileImage = profileImage;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public boolean isOnLeave() {
		return isOnLeave;
	}

	public void setOnLeave(boolean isOnLeave) {
		this.isOnLeave = isOnLeave;
	}

	public InputStream getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(InputStream profileImage) {
		this.profileImage = profileImage;
	}

	@Override
	public String toString() {
		return "\n Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", dateOfJoining=" + dateOfJoining
				+ ", bio=" + bio + ", isOnLeave=" + isOnLeave + "]";
	}

}
