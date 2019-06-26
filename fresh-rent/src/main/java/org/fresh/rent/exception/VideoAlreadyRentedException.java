package org.fresh.rent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="video already rented")
public class VideoAlreadyRentedException extends Exception {
}
