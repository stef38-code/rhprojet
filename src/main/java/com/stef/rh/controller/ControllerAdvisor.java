package com.stef.rh.controller;

import com.stef.rh.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The type Controller advisor.
 */
@ControllerAdvice
@Slf4j
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    /**
     * Handle regions not found exception response model.
     *
     * @param ex      the ex
     * @param request the request
     * @return the response model
     */
    @ExceptionHandler(RegionsNotFoundException.class)
    public ResponseEntity< Object > handleRegionsNotFoundException(
            RegionsNotFoundException ex, WebRequest request) {
        Map< String, Object > body = getBody("Région spécifiée est introuvable", ex, request);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }


    /**
     * Handle countries not found exception response model.
     *
     * @param countriesNotFoundException the countries not found exception
     * @param request                    the request
     * @return the response model
     */
    @ExceptionHandler(CountriesNotFoundException.class)
    public ResponseEntity< Object > handleCountriesNotFoundException(
            CountriesNotFoundException countriesNotFoundException, WebRequest request) {
        Map< String, Object > body = getBody("le pays  spécifiée est introuvable", countriesNotFoundException, request);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle departments not found exception response model.
     *
     * @param departmentsNotFoundException the departments not found exception
     * @param request                      the request
     * @return the response model
     */
    @ExceptionHandler(DepartmentsNotFoundException.class)
    public ResponseEntity< Object > handleDepartmentsNotFoundException(
            DepartmentsNotFoundException departmentsNotFoundException, WebRequest request) {
        Map< String, Object > body = getBody("le pays  spécifiée est introuvable", departmentsNotFoundException, request);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle dependants not found exception response model.
     *
     * @param dependantsNotFoundException the dependants not found exception
     * @param request                     the request
     * @return the response model
     */
    @ExceptionHandler(DependantsNotFoundException.class)
    public ResponseEntity< Object > handleDependantsNotFoundException(
            DependantsNotFoundException dependantsNotFoundException, WebRequest request) {
        Map< String, Object > body = getBody("le pays  spécifiée est introuvable", dependantsNotFoundException, request);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle employees not found exception response model.
     *
     * @param employeesNotFoundException the employees not found exception
     * @param request                    the request
     * @return the response model
     */
    @ExceptionHandler(EmployeesNotFoundException.class)
    public ResponseEntity< Object > handleEmployeesNotFoundException(
            EmployeesNotFoundException employeesNotFoundException, WebRequest request) {
        Map< String, Object > body = getBody("le pays  spécifiée est introuvable", employeesNotFoundException, request);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle jobs not found exception response model.
     *
     * @param jobsNotFoundException the jobs not found exception
     * @param request               the request
     * @return the response model
     */
    @ExceptionHandler(JobsNotFoundException.class)
    public ResponseEntity< Object > handleJobsNotFoundException(
            JobsNotFoundException jobsNotFoundException, WebRequest request) {
        Map< String, Object > body = getBody("le pays  spécifiée est introuvable", jobsNotFoundException, request);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle locations not found exception response model.
     *
     * @param locationsNotFoundException the locations not found exception
     * @param request                    the request
     * @return the response model
     */
    @ExceptionHandler(LocationsNotFoundException.class)
    public ResponseEntity< Object > handleLocationsNotFoundException(
            LocationsNotFoundException locationsNotFoundException, WebRequest request) {
        Map< String, Object > body = getBody("le pays  spécifiée est introuvable", locationsNotFoundException, request);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    /**
     * Getter du body de la reponse
     *
     * @param message le message
     * @param ex      l'erreur
     * @param request WebRequest
     * @return Map<String, Object>
     */
    private Map< String, Object > getBody(String message, IPersonnalNotFoundException ex, WebRequest request) {
        Map< String, Object > body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", message);
        log.error("message erreur:{}", ex.getMessage());
        log.error("url:{}", request.getContextPath());
        return body;
    }
}
