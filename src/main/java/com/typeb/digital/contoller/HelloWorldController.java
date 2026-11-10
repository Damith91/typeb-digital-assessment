package com.typeb.digital.contoller;

import com.typeb.digital.model.Response;
import com.typeb.digital.service.HelloWorldService;
import com.typeb.digital.util.Enums;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    @GetMapping("/hello-world")
    public ResponseEntity<Object> checkCharacter(@RequestParam("name") String name) {
        log.info("HelloWorldController => checkCharacter() => method execution started");
        Response response = new Response();
        try {
            String str = helloWorldService.checkCharacter(name);

            if (str != null && !str.isEmpty()) {
                if (str.equals(Enums.SUCCESS.value())) {

                    response.setMessage("Hello " + name);
                    return new ResponseEntity<>(response, HttpStatus.OK);

                } else if (str.equals(Enums.FAILED.value())) {
                    response.setError("Invalid Input");
                    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
                }
            } else {
                response.setError("Invalid Input");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setError("Internal Server Error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
