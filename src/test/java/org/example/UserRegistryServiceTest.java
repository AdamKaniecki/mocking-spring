package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserRegistryServiceTest {

    @InjectMocks
    UserRegistryService userRegistryService;

    @Mock
    UsersRepository usersRepository;


    //    w tym teście sprawdzam czy jeśli zarejestruję użytkownika to do repozytorium zostanie dodany użytkownik
    @Test
    @DisplayName("Adding users to the registry works successfully")
    void test1() {
//        given
        final var user = User.builder()
                .name("Roman")
                .surname("Adamski")
                .phone("12345")
                .build();
        BDDMockito.given(usersRepository.contains(user.getPhone())).willReturn(false);

//        when
        userRegistryService.register(user);

//        then
        BDDMockito.then(usersRepository)
                .should()
                .put(user);
    }

    //    ten test polega na tym że jeśli mamy już użutkownika z tym numerem telefonu to
//    nie może zostać zarejestrowany
    @Test
    @DisplayName("Adding users with the same phone numbers twice fails")
    void test2() {
//        given
        final var user = User.builder()
                .name("Roman")
                .surname("Adamski")
                .phone("12345")
                .build();

//        jeżeli willReeturn zwraca true to metoda w kodzie żródłowym zwraca wyjątek(bo 5cyfr)
//        a jeśli zostanie rzucony wyjątek to nie powinno się zarejestrować użytkownika
        BDDMockito.given(usersRepository.contains(user.getPhone())).willReturn(true);


//        when
        try {
            userRegistryService.register(user);
            Assertions.fail("should throw exception"); // ta linijka celowo failuje test bo użytkownik nie powinien
//            być zarejestrowany
        } catch (RuntimeException ignore) {

        }

// then
        BDDMockito.then(usersRepository)
                .should(Mockito.never())
                .put(user);


    }

    @Test
    @DisplayName("Adding users with to long phone number fails")
    void test3() {

        //        given
        final var user = User.builder()
                .name("Roman")
                .surname("Adamski")
                .phone("12345")
                .build();

        BDDMockito.given(usersRepository.contains(user.getPhone())).willReturn(false);//mockujemy to repozytorium
//        jesli w trakcie wykonywania testu zostanie na repozutorium wywołana metoda put to zostanie rzucony wyjątek
        BDDMockito.willThrow(new RuntimeException("Phone number is too long"))
                .given(usersRepository)
                .put(user);

        // when
        try {
            userRegistryService.register(user);
            Assertions.fail("should throw exception"); // ta linijka celowo failuje test bo użytkownik nie powinien
//            być zarejestrowany
        } catch (RuntimeException ignore) {

        }
// then
        BDDMockito.then(usersRepository)
                .should()
                .put(user);


    }



}