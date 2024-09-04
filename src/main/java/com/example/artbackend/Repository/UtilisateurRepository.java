package com.example.artbackend.Repository;

import com.example.artbackend.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur , Integer> {
}
