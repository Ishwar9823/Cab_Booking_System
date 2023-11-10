package com.cabbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({CabBookingException.class})
    public ResponseEntity<String> handleCabBookingException(CabBookingException cabBookingException) {
    	return new ResponseEntity<>(cabBookingException.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({CustomerBookingException.class})
    public ResponseEntity<String> handleCustomerBookingException(CustomerBookingException customerBookingException) {
    	return new ResponseEntity<>(customerBookingException.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({DriverBookingException.class})
    public ResponseEntity<String> handleDriverBookingException(DriverBookingException driverBookingException) {
    	return new ResponseEntity<>(driverBookingException.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({RideBookingException.class})
    public ResponseEntity<String> handleRideBookingException(RideBookingException rideBookingException) {
    	return new ResponseEntity<>(rideBookingException.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({TripBookingException.class})
    public ResponseEntity<String> handleTripBookingException(TripBookingException tripBookingException) {
    	return new ResponseEntity<>(tripBookingException.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({UserBookingException.class})
    public ResponseEntity<String> handleUserBookingException(UserBookingException userBookingException) {
    	return new ResponseEntity<>(userBookingException.getMessage(),HttpStatus.NOT_FOUND);
    }
	
}
