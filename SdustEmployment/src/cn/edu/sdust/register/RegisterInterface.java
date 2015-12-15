package cn.edu.sdust.register;

public interface RegisterInterface {
	boolean StuRegister(Student student);
	boolean EnRegister(Enterprise enterReg);
	boolean CheckStudentUserName(String studentUserName);
	boolean CheckEnUserName(String enUserName);
}
