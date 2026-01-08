package com.repair.machinemanagement.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ClientRequest {
    @NotBlank(message = "Nom est obligatoire")
    private String nom;
    
    @NotBlank(message = "Prénom est obligatoire")
    private String prenom;
    
    @NotBlank(message = "Adresse est obligatoire")
    private String adresse;
    
    @NotBlank(message = "Numéro est obligatoire")
    private String numero;
    
    @Email(message = "Email invalide")
    private String email;
    
    private String autres;
}
