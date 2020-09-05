package ac.za.cput.service.generic.impl;

import ac.za.cput.entity.generic.University;
import ac.za.cput.repository.generic.UniversityRepository;
import ac.za.cput.repository.generic.impl.UniversityRepositoryImpl;
import ac.za.cput.service.generic.UniversityService;

import java.util.Set;

public class UniversityServiceImpl implements UniversityService {

    private static UniversityService service = null;
    private UniversityRepository repository;

    private UniversityServiceImpl() { this.repository = UniversityRepositoryImpl.getRepository(); }

    public static UniversityService getService() {
        if (service == null) service = new UniversityServiceImpl();
        return  service;
    }

    @Override
    public Set<University> getAll() {
        return this.repository.getAll();
    }

    @Override
    public University create(University university) {
        return  this.repository.create(university);
    }

    @Override
    public University read(String s) {
        return this.repository.read(s);
    }

    @Override
    public University update(University university) {
        return this.repository.update(university);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }
}
