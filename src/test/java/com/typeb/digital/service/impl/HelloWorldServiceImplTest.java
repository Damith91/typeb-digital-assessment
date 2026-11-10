package com.typeb.digital.service.impl;

import com.typeb.digital.service.HelloWorldServiceTest;
import com.typeb.digital.util.Enums;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Service
public class HelloWorldServiceImplTest implements HelloWorldServiceTest {

    private HelloWorldServiceImpl helloWorldService;

    @BeforeEach
    void setUp() {
        helloWorldService = new HelloWorldServiceImpl();
    }

    @Test
    void testCheckCharacter_StartingWithA_ReturnsSuccess() {
        String result = helloWorldService.checkCharacter("alice");

        assertEquals(Enums.SUCCESS.value(), result);
    }

    @Test
    void testCheckCharacter_StartingWithM_ReturnsSuccess() {
        String result = helloWorldService.checkCharacter("Michael");

        assertEquals(Enums.SUCCESS.value(), result);
    }

    @Test
    void testCheckCharacter_StartingWithN_ReturnsFailed() {
        String result = helloWorldService.checkCharacter("Nancy");

        assertEquals(Enums.FAILED.value(), result);
    }

    @Test
    void testCheckCharacter_StartingWithZ_ReturnsFailed() {
        String result = helloWorldService.checkCharacter("Zara");

        assertEquals(Enums.FAILED.value(), result);
    }

    @Test
    void testCheckCharacter_NullName_ReturnsEmptyString() {
        String result = helloWorldService.checkCharacter(null);

        assertEquals("", result);
    }

    @Test
    void testCheckCharacter_EmptyName_ReturnsEmptyString() {
        String result = helloWorldService.checkCharacter("");

        assertEquals("", result);
    }
}
