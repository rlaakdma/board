package kr.or.ddit.student.model;

import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentVo implements HttpSessionBindingListener {

	private Logger logger = LoggerFactory.getLogger(StudentVo.class);
	
	private int id;
	private String name;
	private int call_cnt;
	private Date reg_dt;
	private String addr1;
	private String addr2;
	private String zipcd;
	private String pic;
	private String picpath;
	private String picname;
	private String std_id;
	private String pass;
	
	public StudentVo() {}

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

	public int getCall_cnt() {
		return call_cnt;
	}

	public void setCall_cnt(int call_cnt) {
		this.call_cnt = call_cnt;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipcd() {
		return zipcd;
	}

	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public String getStd_id() {
		return std_id;
	}

	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public boolean vaildateUser(String studentId, String pass){
		String password = KISA_SHA256.encrypt(pass);
		System.out.println(pass);
		System.out.println(password);
		if(this.getStd_id().equals(studentId) && password.equals(this.getPass()))
			return true;		
		else
			return false;
	}

	@Override
	public String toString() {
		return "StudentVo [id=" + id + ", name=" + name + ", call_cnt="
				+ call_cnt + ", reg_dt=" + reg_dt + ", addr1=" + addr1
				+ ", addr2=" + addr2 + ", zipcd=" + zipcd + ", pic=" + pic
				+ ", picpath=" + picpath + ", picname=" + picname + ", std_id="
				+ std_id + ", pass=" + pass + "]";
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// session객체에서 session.setAttribute("userVo", userVo)가 호출 되었을 때		
		logger.debug("httpSessionBinding valueBound : " + event.getName());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// session객체에서 session.removeAttribute("userVo")가 호출 되었을 때
		logger.debug("httpSessionBinding valueUnBound : " + event.getName());
	}	
}