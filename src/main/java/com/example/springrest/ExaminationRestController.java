package com.example.springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/examination")
public class ExaminationRestController {

    @Autowired
    private AppService service;

    @PostMapping("/add/{patientId}")
    public Patient addExamination (@PathVariable("patientId") Long patientId, @Valid @RequestBody Examination examination) {
        return service.addExamination(examination, patientId);
    }

    @GetMapping("/get/{examinationId}")
    public Examination getExamination (@PathVariable("examinationId") Long examinationId) {
        return service.getExamination(examinationId);
    }

    @GetMapping("/")
    public List<Examination> getAllExaminations () {
        return service.findAllExaminations();
    }

    @DeleteMapping("/delete/{examinationId}")
    public void deleteExamination (@PathVariable("examinationId") Long examinationId) {
        service.deleteExamination(examinationId);
    }

    @GetMapping("/getpatient/{examinationId}")
    public Patient getPatientOfExamination (@PathVariable("examinationId") Long examinationId) {
        return service.getPatientOfExamination(examinationId);
    }

    // add with not @Valid patient is BAD_REQUEST and is redirected to this method (MethodArgumentNotValidException)
    // ServiceException are also redirected to this method
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class, ServiceException.class, ResponseStatusException.class})
    public Map<String, String> handleValidationExceptions(Exception ex) {
        Map<String, String> errors = new HashMap<>();
        if (ex instanceof MethodArgumentNotValidException) {
            ((MethodArgumentNotValidException)ex).getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
        }
        else if (ex instanceof ServiceException) {
            errors.put(((ServiceException) ex).getAction(), ex.getMessage());
        }
        else {
            errors.put(((ResponseStatusException)ex).getReason(), ex.getCause().getMessage());
        }
        return errors;
    }

}
