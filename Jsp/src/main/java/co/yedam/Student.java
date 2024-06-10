package co.yedam;
//tbl_student(std_no, std_name, phone, bld_type, create_date)

import java.util.Date;

public class Student {
	private String stdNo;
	private String stdName;
	private String phone;
	private String bldType;
	private Date createDate;

	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBldType() {
		return bldType;
	}

	public void setBldType(String bldType) {
		this.bldType = bldType;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Student [stdNo=" + stdNo + ", stdName=" + stdName + ", phone=" + phone + ", bldType=" + bldType
				+ ", createDate=" + createDate + "]";
	}

}
