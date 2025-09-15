package br.com.mercearia.gerenciador.controller.dto;

import br.com.mercearia.gerenciador.model.Address;

import java.time.LocalDate;

public record RegisterRequestDTO(String name, String email, String password, String phone, LocalDate birthDate,
                                 String cpf, String cnpj, Address address) {
}
