package com.airbnb.airbnb_assignment.Repository;

import com.airbnb.airbnb_assignment.Model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepo extends JpaRepository<Property, Long> {
    List<Property> findByOwnerId(Long ownerId);
}
