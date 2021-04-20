package com.orangetalents.challenge.repository;

import com.orangetalents.challenge.model.domain.User;
import com.orangetalents.challenge.util.UserCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

@DataJpaTest
@DisplayName("Tests for UserRepository")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("findUserById finds user when successful")
    void findUserById_FindsUser_WhenSuccessful() {
        User userToBeSaved = UserCreator.createValidUserToBeSaved();
        User userSaved = this.userRepository.save(userToBeSaved);
        Optional<User> possibleUser = this.userRepository.findById(userSaved.getId());

        Assertions.assertThat(userSaved).isNotNull();
        Assertions.assertThat(possibleUser)
                .isNotNull()
                .isPresent();
        Assertions.assertThat(userSaved.getId())
                .isNotNull()
                .isEqualTo(possibleUser.get().getId());
    }

    @Test
    @DisplayName("findUserById return empty optional when no user is found")
    void findUserById_ReturnsEmptyOptional_WhenNoUserIsFound() {
        Optional<User> possibleUser = this.userRepository.findById(1L);

        Assertions.assertThat(possibleUser)
                .isNotNull()
                .isEmpty();
    }

    @Test
    @DisplayName("Save persists user when successful")
    void save_PersistsUser_WhenSuccessful() {
        User userToBeSaved = UserCreator.createValidUserToBeSaved();
        User userSaved = this.userRepository.save(userToBeSaved);

        Assertions.assertThat(userSaved).isNotNull();
        Assertions.assertThat(userSaved.getId()).isNotNull();
        Assertions.assertThat(userSaved.getName()).isEqualTo(userToBeSaved.getName());
        Assertions.assertThat(userSaved.getCpf()).isEqualTo(userToBeSaved.getCpf());
        Assertions.assertThat(userSaved.getEmail()).isEqualTo(userToBeSaved.getEmail());
        Assertions.assertThat(userSaved.getBirthDate()).isEqualTo(userToBeSaved.getBirthDate());
    }

    @Test
    @DisplayName("findUserByEmail finds user by email when successful")
    void findUserByEmail_ExistsUserByEmail_WhenSuccessful() {
        User userToBeSaved = UserCreator.createValidUserToBeSaved();
        User userSaved = this.userRepository.save(userToBeSaved);
        String email = userToBeSaved.getEmail();

        Assertions.assertThat(userToBeSaved.getEmail()).isEqualTo(userSaved.getEmail());
        Assertions.assertThat(this.userRepository.findByEmail(email))
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    @DisplayName("findUserByEmail return empty optional when no user is found")
    void findUserByEmail_ReturnsEmptyOptional_WhenNoUserIsFound() {
        String email = "test@email.com";

        Assertions.assertThat(this.userRepository.findByEmail(email))
                .isNotNull()
                .isEmpty();
    }

    @Test
    @DisplayName("findUserByCpf finds user by cpf when successful")
    void findUserByCpf_ExistsUserByCpf_WhenSuccessful() {
        User userToBeSaved = UserCreator.createValidUserToBeSaved();
        User userSaved = this.userRepository.save(userToBeSaved);
        String cpf = userToBeSaved.getCpf();

        Assertions.assertThat(userToBeSaved.getCpf()).isEqualTo(userSaved.getCpf());
        Assertions.assertThat(this.userRepository.findByCpf(cpf))
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    @DisplayName("findUserByCpf return empty optional when no user is found")
    void findUserByCpf_ReturnsEmptyOptional_WhenNoUserIsFound() {
        String cpf = "00000000000";

        Assertions.assertThat(this.userRepository.findByCpf(cpf))
                .isNotNull()
                .isEmpty();
    }

    @Test
    @DisplayName("Save throw DataIntegrityViolationException when attributes are null")
    void save_ThrowsDataIntegrityViolationException_WhenSuccessful() {
        User invalidUserToBeSaved = UserCreator.createInvalidUserToBeSaved();

        Assertions.assertThatExceptionOfType(DataIntegrityViolationException.class)
                .isThrownBy(() -> this.userRepository.save(invalidUserToBeSaved));
    }
}