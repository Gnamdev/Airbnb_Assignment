package com.airbnb.airbnb_assignment.Controller;

import com.airbnb.airbnb_assignment.Model.Property;
import com.airbnb.airbnb_assignment.Payload.ApiRespons;
import com.airbnb.airbnb_assignment.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {


    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public ResponseEntity<Property> createEmployee( @RequestBody Property property){
        Property property1 = propertyService.addProperty(property);

        return new ResponseEntity<>(property1 , HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Property> updateEmployee(  @RequestBody   Property property , @PathVariable  Long id){

        Property property1 = this.propertyService.updateProperty(property, id);
        return new ResponseEntity<>(property1 , HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Property> getEmployee( @PathVariable  Long id){

        Property property = this.propertyService.getProperty(id);
        return new ResponseEntity<>(property , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Property>> getAllEmployee(){
        List<Property> properties = this.propertyService.getProperties();

        return new ResponseEntity<>(properties , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiRespons> deleteEmployee(@PathVariable  Long id){
            this.propertyService.deleteProperty(id);

        return new ResponseEntity<>(new ApiRespons("Property deleted successfully  " ,true) , HttpStatus.OK);
    }

}
