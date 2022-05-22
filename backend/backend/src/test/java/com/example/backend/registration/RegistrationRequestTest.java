package com.example.backend.registration;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class RegistrationRequestTest {

    RegistrationRequest underTestRequest=new RegistrationRequest(
            "sachithra",
            "manamperi",
            "sachithrabandara49@gmail.com",
            "Hello");

    String expectedFirstName="sachithra";
    String expectedLastName="manamperi";
    String expectedEmail="sachithrabandara49@gmail.com";
    @Test
    void testEquals() {

    }

    @Test
    void canEqual() {

    }

    @Test
    void getFirstName() {

        assertThat(underTestRequest.getFirstName()).isEqualTo(expectedFirstName);

    }

    @Test
    void getLastName() {
        assertThat(underTestRequest.getLastName()).isEqualTo(expectedLastName);

    }

    @Test
    void getEmail() {
        assertThat(underTestRequest.getEmail()).isEqualTo(expectedEmail);

    }

    @Test
    @Disabled
    void getPassword() {


    }

    @Test
    void testEquals1() {
    }

    @Test
    void testCanEqual() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testGetFirstName() {
    }

    @Test
    void testGetLastName() {
    }

    @Test
    void testGetEmail() {
    }

    @Test
    void testGetPassword() {
    }
}