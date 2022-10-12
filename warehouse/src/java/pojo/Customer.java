package pojo;
// Generated Oct 12, 2022 12:23:08 AM by Hibernate Tools 4.3.1

import DAO.DAOcustomer;
import java.util.List;
import javax.faces.bean.ManagedBean;


/**
 * Customer generated by hbm2java
 */
@ManagedBean
public class Customer  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String email;
     private String password;
     
     public String save_customer() {
        DAOcustomer add = new DAOcustomer();
        return add.add_customer(this);
    }
    
    public String login_customer() {
        DAOcustomer uDao = new DAOcustomer();
        List<Customer> us = uDao.getBy(email, password);
        try {
            if (us != null) {
                email = us.get(0).email;
                password = us.get(0).password;
                return "loginSukses";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "gagalLogin";
    }

    public Customer() {
    }

    public Customer(String name, String email, String password) {
       this.name = name;
       this.email = email;
       this.password = password;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


