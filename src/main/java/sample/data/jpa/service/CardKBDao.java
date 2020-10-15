package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.CardKB;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
@Transactional
public interface CardKBDao extends JpaRepository<CardKB, Long> {

}



