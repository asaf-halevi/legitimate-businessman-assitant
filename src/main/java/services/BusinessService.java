package services;

import entities.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.BusinessRepository;

@Service
public class BusinessService {

    private BusinessRepository businessRepository;

    @Autowired
    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public Business createBusiness(String name) {
        return businessRepository.save(new Business(name));
    }

    public Iterable<Business> lookup() {
        return businessRepository.findAll();
    }
}
