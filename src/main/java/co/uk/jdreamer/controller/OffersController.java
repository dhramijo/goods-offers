package co.uk.jdreamer.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.uk.jdreamer.model.Offers;
import co.uk.jdreamer.service.OffersService;
import co.uk.jdreamer.utils.FieldErrorMessage;

@RestController
@RequestMapping("api/v1/")
public class OffersController {

	@Autowired
	private OffersService offersService;

	@GetMapping("offer")
	public List<Offers> readActiveOffers() {
		List<Offers> listOffers = offersService.findAll();
		listOffers.removeIf(el -> el.isExpired());
		return listOffers;
	}

	@GetMapping("offer/{id}")
	public Offers readActiveOfferById(@PathVariable Integer id) {
		if(!offersService.findById(id).get().isExpired())
			return offersService.findById(id).get();
		else 
			throw new ValidationException("The offer you are looking for is expired");
	}

	@GetMapping("wrong_url")
	public Offers wrongUrl() {
		throw new ValidationException("The URL is wrong");
	}

	@PostMapping("offer")
	public Offers createOffer(@Valid @RequestBody Offers offer) {
		return offersService.save(offer);
	}

	@DeleteMapping("offer/{id}")
	public void deleteOffer(@PathVariable Integer id) throws ValidationException {
		if(!offersService.findById(id).get().isExpired())
			offersService.deleteById(id);
		else {
			throw new ValidationException("You cannot remove an expired offer");
		}
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e) {
		List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
		List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream().map(fieldError -> new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage())).collect(Collectors.toList());

		return fieldErrorMessages;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidationException.class)
	public  String exceptionHandler(ValidationException e) {
		return e.getMessage();
	}

}
