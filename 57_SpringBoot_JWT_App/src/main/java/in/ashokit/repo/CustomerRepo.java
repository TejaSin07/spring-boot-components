package in.ashokit.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import in.ashokit.entity.CustomerA;

@Repository
public interface CustomerRepo extends CrudRepository<CustomerA, Integer> {

	public CustomerA findByUname(String cuname);

}
