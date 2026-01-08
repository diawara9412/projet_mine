package com.repair.machinemanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Nom est obligatoire")
    @Column(nullable = false)
    private String nom;
    
    @NotBlank(message = "Prénom est obligatoire")
    @Column(nullable = false)
    private String prenom;
    
    @NotBlank(message = "Adresse est obligatoire")
    private String adresse;
    
    @NotBlank(message = "Numéro est obligatoire")
    @Column(unique = true)
    private String numero;
    
    @Email(message = "Email invalide")
    private String email;
    
    private String autres;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
