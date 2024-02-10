package com.WebServicesFromJTP.Service;

import java.util.List;

import com.WebServicesFromJTP.Bean.Dummy;

public interface DummyService {

	public Dummy savePersonDeatails(Dummy dummy);

	public List<Dummy> getAllPerson();

	public Dummy deletePerson(Long id);

	public Dummy updatePersonFromId(Dummy dummy,Long id);

}
