package sample.data.jpa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
@Entity
@XmlRootElement(name = "BoardKB")
public class BoardKB implements Serializable {

	private static final long serialVersionUID = 1517205058451738936L;

	private Long id;

	private String name;

	private List<ColumnKB> columns = new ArrayList<ColumnKB>();

	public BoardKB() {
	}

	public BoardKB(Long id) {
		this.id = id;
	}

	public BoardKB(String name) {
		this.name = name;
	}

	public void addColumn(ColumnKB col) {
		this.columns.add(col);
		col.setBoard(this);
	}

	@XmlElementWrapper(name = "columns")
	@OneToMany(mappedBy = "board", cascade = CascadeType.PERSIST)
	public List<ColumnKB> getColumns() {
		return columns;
	}

	@Id
	@GeneratedValue
	@XmlElement(name = "id")
	public Long getId() {
		return id;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setColumns(List<ColumnKB> colums) {
		this.columns = colums;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
