package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.UserKB;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
@Transactional
public interface UserKBDao extends JpaRepository<UserKB, Long> {

}