package com.typeb.digital.service.impl;

import com.typeb.digital.service.HelloWorldService;
import com.typeb.digital.util.Enums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String checkCharacter(String name) {
        log.info("HelloWorldServiceImpl => checkCharacter() => method execution started");
        if (name != null && !name.isEmpty()) {
            char firstLetter = Character.toLowerCase(name.charAt(0));
            if (firstLetter >= 'a' && firstLetter <= 'm') {
                return Enums.SUCCESS.value();
            } else if (firstLetter >= 'n' && firstLetter <= 'z') {
                return Enums.FAILED.value();
            }

        } else {
            return "";
        }
        return "";
    }
}
