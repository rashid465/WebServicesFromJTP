package com.WebServicesFromJTP.Service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WebServicesFromJTP.Bean.Dummy;
import com.WebServicesFromJTP.Repository.DummyRepository;
import com.WebServicesFromJTP.Service.DummyService;
@Service
public class DummyServiceImpl implements DummyService{
	
	@Autowired
	private DummyRepository dummyRepository;

	@Override
	public Dummy savePersonDeatails(Dummy dummy) {
		return dummyRepository.save(dummy);
	}

	@Override
	public List<Dummy> getAllPerson() {
		return dummyRepository.findAll();
	}

	@Override
	public Dummy deletePerson(Long id) {
		Optional<Dummy> dummy=dummyRepository.findById(id);
		if (dummy.isPresent()) {
			Dummy delete=dummy.get();
			dummyRepository.delete(delete);
			return delete;
		}
		else {
			return null;
		}
		
	}

	@Override
	public Dummy updatePersonFromId(Dummy dummy,Long id) {
		Optional<Dummy> up=dummyRepository.findById(id);
		if (up.isPresent()) {
			Dummy updatePerson=up.get();
			updatePerson.setName(dummy.getName());
			updatePerson.setRollNo(dummy.getRollNo());
			return dummyRepository.save(updatePerson);
		}
		else {
			return null;
		}
	}

}
