package com.airbnb.airbnb_assignment.Service.IMPL;

import com.airbnb.airbnb_assignment.Exception.ResourceNotFoundException;
import com.airbnb.airbnb_assignment.Model.Property;
import com.airbnb.airbnb_assignment.Repository.PropertyRepo;
import com.airbnb.airbnb_assignment.Service.PropertyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {


    private  PropertyRepo propertyRepo;

    public PropertyServiceImpl(PropertyRepo propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    @Override
    public Property getProperty(Long name) {
       return    propertyRepo.findById(name).orElseThrow(() -> new ResourceNotFoundException("Property is not found id : ", name));

    }

    @Override
    public List<Property> getProperties() {
        return propertyRepo.findAll();
    }

    @Override
    public Property addProperty(Property property) {
        return  propertyRepo.save(property);
    }

    @Override
    public Property updateProperty(Property property , Long id) {
        Property property1 = propertyRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Property is not found id : ", id));


        property1.setAddress(property.getAddress());
        property1.setName(property.getName());
        property1.setDescription(property.getDescription());
        property1.setAvailable(property.isAvailable());
        property1.setOwner(property.getOwner());
        property1.setDrinkAllowed(property.isDrinkAllowed());
        property1.setExtraCharges(property.getExtraCharges());
        property1.setPetAllowed(property.isPetAllowed());
        property1.setMaxCheckoutTimeInNights(property.getMaxCheckoutTimeInNights());
        property1.setNumberOfBathrooms(property.getNumberOfBathrooms());
        property1.setNumberOfBedrooms(property.getNumberOfBedrooms());
        property1.setPricePerNight(property.getPricePerNight());


        return propertyRepo.save(property1);

    }

    @Override
    public void deleteProperty(Long id) {
        Property property1 = propertyRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Property is not found id : ", id));

        propertyRepo.delete(property1);

    }

    @Override
    public List<Property> getByUser(Long userId) {

      return  propertyRepo.findByOwnerId(userId);


    }
}
