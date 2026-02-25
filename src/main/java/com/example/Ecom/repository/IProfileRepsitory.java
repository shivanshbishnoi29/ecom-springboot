package com.example.Ecom.repository;

import com.example.Ecom.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfileRepsitory extends JpaRepository<Profile, Integer> {
}
