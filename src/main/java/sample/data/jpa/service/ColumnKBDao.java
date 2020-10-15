package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.ColumnKB;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
@Transactional
public interface ColumnKBDao extends JpaRepository<ColumnKB, Long> {

	public ColumnKB findByTitle(String title);

}