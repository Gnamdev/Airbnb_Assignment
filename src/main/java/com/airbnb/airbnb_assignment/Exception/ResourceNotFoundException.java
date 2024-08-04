package com.airbnb.airbnb_assignment.Exception;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class ResourceNotFoundException extends  RuntimeException {
        private String message;
        private Long resourceId;

        public ResourceNotFoundException(String message ,  Long fieldValue) {

            super(String.format("%s not found with  : %s " , message, fieldValue));


        }
    }


