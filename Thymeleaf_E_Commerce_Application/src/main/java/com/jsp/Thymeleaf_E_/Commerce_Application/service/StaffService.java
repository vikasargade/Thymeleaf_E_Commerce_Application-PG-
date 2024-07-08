package com.jsp.Thymeleaf_E_.Commerce_Application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.Thymeleaf_E_.Commerce_Application.entity.PgDetails;
import com.jsp.Thymeleaf_E_.Commerce_Application.entity.Staff;
import com.jsp.Thymeleaf_E_.Commerce_Application.repository.PgRepository;
import com.jsp.Thymeleaf_E_.Commerce_Application.repository.StaffRepository;

@Service
public class StaffService {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private PgRepository pgRepository;

	public PgDetails addStaffToPg(int pgId, Staff staff) {

		PgDetails pgDetailsFromDB = pgRepository.findById(pgId).orElse(null);
		
		if (pgDetailsFromDB != null) {
			staff.setPg(pgDetailsFromDB);
			Staff staffFromDB = addStaffToPg(staff);
			
//			staffFromDB.setPg(pgDetailsFromDB);
//			if (staffFromDB != null) {
//				List<Staff> list = new ArrayList<Staff>();
//				list.add(staff);
//				pgDetailsFromDB.setStaffList(list);
//				adminRepository.save(pgDetailsFromDB);
//			} else {
//				return null;
//			}
		} else
			return null;

		return pgDetailsFromDB; 
	}

	private Staff addStaffToPg(Staff staff) {
		return staffRepository.save(staff);
	}

	public List<Staff> findAllStaff() {
		return staffRepository.findAll() ;
	}

	public Staff findStaffById(int id) {
		return staffRepository.findById(null).orElse(null) ;
	}

	public void deleteStaffById(int id) {
		 staffRepository.deleteById(id); ;
	}

}
