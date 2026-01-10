package com.tejas.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejas.entity.Address;
import com.tejas.entity.Emp;
import com.tejas.repo.AddrRepo;
import com.tejas.repo.EmpRepo;

import jakarta.transaction.Transactional;

@Service
public class EmpService {

	@Autowired
	private EmpRepo empRepo;

	@Autowired
	private AddrRepo addrRepo;

	public void deleteEmp() {
		empRepo.deleteById(1); // childs + parent
	}

	public void getAddress() {
		Optional<Address> address = addrRepo.findById(1); // Fetch child + parent
		if (address.isPresent()) {
			Address addr = address.get();
			System.out.println("Address Found: " + addr.getCity() + ", " + addr.getState() + ", " + addr.getCountry());
			System.out.println("Belongs to Employee: " + addr.getEmp().getEname());
		} else {
			System.out.println("Address with ID 1 not found!");
		} // child + parent
	}
//	@Transactional
	public void getEmp() {
		Optional<Emp> findById = empRepo.findById(1); // Fetch only parent
		if (findById.isPresent()) {
			Emp emp = findById.get();
			System.out.println("Employee Found: " + emp.getEname() + ", Salary: " + emp.getEsal());
	
			List<Address> addrList = emp.getAddrList();
			if (addrList != null && !addrList.isEmpty()) {
				System.out.println("Addresses:");
				for (Address addr : addrList) {
					System.out.println(" - " + addr.getCity() + ", " + addr.getState() + ", " + addr.getCountry() + " (" + addr.getType() + ")");
				}
			} else {
				System.out.println("No Address Found for Employee.");
			}
		} else {
			System.out.println("Employee with ID 1 not found!");
		}
	}

	public void saveEmployee() {

		Emp e = new Emp();
		e.setEname("Orlen");
		e.setEsal(12000.00);

		Address a1 = new Address();
		a1.setCity("Hyd");
		a1.setState("TG");
		a1.setCountry("India");
		a1.setType("Present");

		Address a2 = new Address();
		a2.setCity("GNT");
		a2.setState("AP");
		a2.setCountry("India");
		a2.setType("Permanent");

		// association
		a1.setEmp(e); // setting parent to child
		a2.setEmp(e); // setting parent to child

		e.setAddrList(Arrays.asList(a1, a2)); // setting childs to parent

		// save parent record
		empRepo.save(e); // parent + childs

	}

}
