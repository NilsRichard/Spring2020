package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.BoardKB;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
@Transactional
public interface BoardKBDao extends JpaRepository<BoardKB, Long> {

    public BoardKB findByName(String name);

}

