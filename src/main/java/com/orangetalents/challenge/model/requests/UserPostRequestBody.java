package com.orangetalents.challenge.model.requests;

import com.orangetalents.challenge.validations.Unique;
import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class UserPostRequestBody {

    @NotBlank(message = "User must have a name")
    @Size(message = "Name length must be between 1 and 100", min = 1, max = 120)
    @Schema(description = "This is the User name",
            example = "Jane Doe",
            required = true)
    private String name;

    @NotBlank(message = "User must have an email")
    @Size(message = "The length of the email must be a maximum of 60 characters", max = 60)
    @Email(message = "Invalid email format")
    @Unique(message = "There is already an registered User with this email")
    @Schema(description = "This is the User email",
            example = "jane@email.com",
            required = true)
    private String email;

    @NotBlank(message = "User must have a cpf")
    @CPF(message = "Invalid cpf format")
    @Pattern(message = "Cpf must contain only numbers", regexp = "[\\d]{11}")
    @Unique(message = "There is already an registered User with this cpf")
    @Schema(description = "This is the User cpf",
            example = "12345678910",
            required = true)
    private String cpf;

    @NotNull(message = "User must have a birthdate")
    @PastOrPresent(message = "Birthdate cannot be a future date")
    @Schema(description = "This is the User birth date. Must be a past or present date",
            example = "1990-05-10",
            required = true)
    private LocalDate birthDate;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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
