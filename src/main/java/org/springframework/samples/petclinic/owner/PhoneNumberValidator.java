package org.springframework.samples.petclinic.owner;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements
	ConstraintValidator<PhoneNumberConstraint, String> {

	// From https://stackoverflow.com/questions/2113908/what-regular-expression-will-match-valid-international-phone-numbers
	private static final String PHONE_REGEX = "\\+(9[976]\\d|8[987530]\\d|6[987]\\d|5[90]\\d|42\\d|3[875]\\d|\n" +
		"2[98654321]\\d|9[8543210]|8[6421]|6[6543210]|5[87654321]|\n" +
		"4[987654310]|3[9643210]|2[70]|7|1)\\d{1,14}$";

	@Override
	public void initialize(PhoneNumberConstraint constraintAnnotation) {
	}

	@Override
	public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
		return s != null &&
			s.matches(PHONE_REGEX);
	}
}
