## web-thymeleaf-forms
Snack-sample that demonstrates integration of HTML Form workflow between Spring Boot and Thymeleaf.

Most form elements have been demonstrated. 
* `<input type="text" ...`   // simple text field
* `<textarea ...`     // multiline textarea
* `<input type="datetime-local" ...`   // datetime field
* `<input type="color" ...`   // color selector
* `<input type="checkbox" ...`  // single checkbox
* `<ul><li><input type="checkbox" ...`  // set of checkboxes
* `<ul><li><input type="radio" ...` // set of mutually exclusive checkboxes.
* `<select ...><option value=" ...` // dropdown list of values.

## @ModelAttribute 

Also demonstrate 2 usecases to apply @ModelAttribute...
1. Pre-populating the Model with the set of values needed for multi-select form elements.
    * example: selectable values for checkbox sets, radio sets, dropdown lists. 
2. Application of the Command Pattern to represent the MVC state (the 'FormCommand' object).


## Lombok
https://projectlombok.org/

Lombok is a Java annotation library that reduces common java boilerplate code.
 
The FormCommand demonstrates the use of the Lombok @Data annotation that drastically reduces code-noise for simple data beans.

The same could be done by renaming to FormCommand.groovy, but Lombok allows you to stay pure Java.

The installation of Eclipse-support is not as simple as it should be.  Here is a good guide... 
 
http://codeomitted.com/setup-lombok-with-stseclipse-based-ide/

## Unit Tests
Simple unit tests demonstrate validation of GET and POST of Command data.


