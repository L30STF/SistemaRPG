package com.SitemaRPG.SitemaRPG.Repositories;

import com.SitemaRPG.SitemaRPG.Models.personagemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository  extends JpaRepository<personagemModel,Integer > {
}
