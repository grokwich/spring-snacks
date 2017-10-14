# web-thymeleaf-JSR303-validation  (Part #2)

Snack-sample that demonstrates JSR303-validation (bean validation annotations).

The Command pattern is used and most form elements have been demonstrated.

## Blog Discussion
https://medium.com/@grokwich/spring-boot-thymeleaf-html-form-handling-part-2-b4c9e83a189c

## Validation error messages.

The code demonstrates Validation message configuration options:
* messages.properties vs. validationMessages.properties

Recommendation is to use validationMessages.properties (JSR-303 native).
Using (default) messages.properties will only provide simple localization message 
configuration for validation messages (only numeric param interpolation).   

## Unit Tests
MockMVC tests that demonstrate happy-case and expected validation errors.

