package com.airbnb.airbnb_assignment.Service;

import com.airbnb.airbnb_assignment.Model.Property;
import com.airbnb.airbnb_assignment.Model.User;

import java.util.List;

public interface PropertyService {


    Property getProperty(Long name);
   List<Property> getProperties();

   Property addProperty(Property property);
   Property updateProperty(Property property , Long id);
   void deleteProperty(Long name);
   List<Property> getByUser(Long id);


}
