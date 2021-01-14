package com.atexo.test.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RedirectErrorController implements ErrorController {

    private static final Logger logger = LogManager.getLogger(RedirectErrorController.class);
    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(PATH)
    @ResponseBody
    public ResponseEntity<Map> handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        return errorJson(String.format("Status code: %s. Exception Message: %s",
                statusCode, exception==null? "N/A": exception.getMessage()));
    }

    private ResponseEntity<Map> errorJson(String message) {
        Map responseJson = new HashMap();
        responseJson.put("status", "fail");
        responseJson.put("message", message);
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseJson);
    }
}


