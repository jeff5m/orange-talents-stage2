package com.orangetalents.challenge.model.requests;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class UserPostRequestBody {
    @NotBlank(message = "User must have a name")
    @Size(message = "Name length must be between 1 and 100", min = 1, max = 120)
    private final String name;

    @NotBlank(message = "User must have an email")
    @Size(message = "The length of the email must be a maximum of 60 characters", max = 60)
    @Email(message = "Invalid email format")
    private final String email;

    @NotBlank(message = "User must have a cpf")
    @CPF(message = "Invalid cpf format")
    private final String cpf;

    @NotNull(message = "User must have a birthdate")
    @PastOrPresent(message = "Birthdate cannot be a future date")
    private final LocalDate birthDate;

    public UserPostRequestBody(@NotBlank @Size(min = 1, max = 120) String name,
                               @NotBlank @Size(max = 60) @Email String email,
                               @NotBlank @CPF String cpf,
                               @NotNull @PastOrPresent LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPostRequestBody that = (UserPostRequestBody) o;

        if (!name.equals(that.name)) return false;
        if (!email.equals(that.email)) return false;
        if (!cpf.equals(that.cpf)) return false;
        return birthDate.equals(that.birthDate);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + cpf.hashCode();
        result = 31 * result + birthDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserPostRequestBody{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
