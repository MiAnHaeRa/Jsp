package co.yedam.vo;
//tbl_student(std_no, std_name, phone, bld_type, create_date)

import java.util.Date;

import lombok.Data;

@Data

public class Student {
	private String stdNo;
	private String stdName;
	private String phone;
	private String bldType;
	private Date createDate;


}
