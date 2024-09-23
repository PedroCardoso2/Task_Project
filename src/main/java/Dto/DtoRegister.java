package Dto;

import java.time.LocalDate;

public record DtoRegister(
        String name, String email, String password, LocalDate dataNascimento
) {
}
