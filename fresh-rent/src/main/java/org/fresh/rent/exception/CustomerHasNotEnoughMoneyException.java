package org.fresh.rent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.PAYMENT_REQUIRED, reason="customer has not enough money")
public class CustomerHasNotEnoughMoneyException extends Exception {
}
