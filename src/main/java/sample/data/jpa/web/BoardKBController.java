package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.jpa.domain.BoardKB;
import sample.data.jpa.domain.ColumnKB;
import sample.data.jpa.service.BoardKBDao;
import sample.data.jpa.service.ColumnKBDao;

@RequestMapping("/board")
@Controller
public class BoardKBController {

  /**
   * GET /create  --> Create a new boardKb and save it in the database.
   */
  @RequestMapping("/create")
  @ResponseBody
  public String create(String email, String name) {
    String boardKbId = "";
    try {
      BoardKB boardKb = new BoardKB(name);
      boardKbDao.save(boardKb);
      boardKbId = String.valueOf(boardKb.getId());
    }
    catch (Exception ex) {
      return "Error creating the boardKb: " + ex.toString();
    }
    return "BoardKB succesfully created with id = " + boardKbId;
  }
  
  /**
   * GET /delete  --> Delete the boardKb having the passed id.
   */
  @RequestMapping("/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      BoardKB boardKb = new BoardKB(id);
      boardKbDao.delete(boardKb);
    }
    catch (Exception ex) {
      return "Error deleting the boardKb:" + ex.toString();
    }
    return "BoardKB succesfully deleted!";
  }
  
  /**
   * GET /get-by-name  --> Return the id for the boardKb having the passed
   * name.
   */
  @RequestMapping("/get-by-name/{name}")
  @ResponseBody
  public String getByName(@PathVariable("name") String name) {
    String boardKbId = "";
    try {
      BoardKB boardKb = boardKbDao.findByName(name);
      boardKbId = String.valueOf(boardKb.getId());
    }
    catch (Exception ex) {
    	ex.printStackTrace();
      return "BoardKB not found";
    }
    return "The boardKb id is: " + boardKbId;
  }
  
  /**
   * GET /update  --> Update the name for the boardKb in the 
   * database having the passed id.
   */
  @RequestMapping("/update")
  @ResponseBody
  public String updateBoardKB(long id, String name) {
    try {
      BoardKB boardKb = boardKbDao.findById(id).get();
      boardKb.setName(name);
      boardKbDao.save(boardKb);
    }
    catch (Exception ex) {
      return "Error updating the boardKb: " + ex.toString();
    }
    return "BoardKB succesfully updated!";
  }
  
  /**
   * GET /addColumn  --> add a column to the boardKb in the 
   * database having the passed id.
   */
  @RequestMapping("/addColumn")
  @ResponseBody
  public String addColumn(long id, long column) {
    try {
      BoardKB boardKb = boardKbDao.findById(id).get();
      ColumnKB columnKb = columnKbDao.findById(column).get();
      boardKb.addColumn(columnKb);
      boardKbDao.save(boardKb);
    }
    catch (Exception ex) {
      return "Error adding column to the boardKb: " + ex.toString();
    }
    return "BoardKB has now a new ColumnKB!";
  }

  // Private fields

  @Autowired
  private BoardKBDao boardKbDao;
  
  @Autowired
  private ColumnKBDao columnKbDao;
  
}