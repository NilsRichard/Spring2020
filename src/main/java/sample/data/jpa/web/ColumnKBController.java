package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.jpa.domain.ColumnKB;
import sample.data.jpa.service.ColumnKBDao;

@RequestMapping("/column")
@Controller
public class ColumnKBController {

  /**
   * GET /create  --> Create a new columnKb and save it in the database.
   */
  @RequestMapping("/create")
  @ResponseBody
  public String create(String title) {
    String columnKbId = "";
    try {
      ColumnKB columnKb = new ColumnKB(title);
      columnKbDao.save(columnKb);
      columnKbId = String.valueOf(columnKb.getId());
    }
    catch (Exception ex) {
      return "Error creating the columnKb: " + ex.toString();
    }
    return "ColumnKB succesfully created with id = " + columnKbId;
  }
  
  /**
   * GET /delete  --> Delete the columnKb having the passed id.
   */
  @RequestMapping("/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      ColumnKB columnKb = new ColumnKB(id);
      columnKbDao.delete(columnKb);
    }
    catch (Exception ex) {
      return "Error deleting the columnKb:" + ex.toString();
    }
    return "ColumnKB succesfully deleted!";
  }
  
  /**
   * GET /get-by-title  --> Return the id for the columnKb having the passed
   * title.
   */
  @RequestMapping("/get-by-title/{title}")
  @ResponseBody
  public String getByTitle(@PathVariable("title") String title) {
    String columnKbId = "";
    try {
      ColumnKB columnKb = columnKbDao.findByTitle(title);
      columnKbId = String.valueOf(columnKb.getId());
    }
    catch (Exception ex) {
      return "ColumnKB not found";
    }
    return "The columnKb id is: " + columnKbId;
  }
  
  /**
   * GET /update  --> Update the title and the name for the columnKb in the 
   * database having the passed id.
   */
  @RequestMapping("/update")
  @ResponseBody
  public String updateColumnKB(long id, String title) {
    try {
      ColumnKB columnKb = columnKbDao.findById(id).get();
      columnKb.setTitle(title);
      columnKbDao.save(columnKb);
    }
    catch (Exception ex) {
      return "Error updating the columnKb: " + ex.toString();
    }
    return "ColumnKB succesfully updated!";
  }

  // Private fields

  @Autowired
  private ColumnKBDao columnKbDao;
  
}