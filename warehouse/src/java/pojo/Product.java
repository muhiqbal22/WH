package pojo;

import DAO.DAOcustomer;
import DAO.DAOProduct;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * Product generated by hbm2java
 */
@ManagedBean
public class Product  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String category;
     private String supplier;
     private int stock;
     
public List<Product> getAllRecords() {
        DAOProduct product = new DAOProduct();
        List<Product> listProduct = product.retrveTblproduct();
        return listProduct;
    }
public String getById() {
        String idProduct = id.toString();
        DAOProduct product = new DAOProduct();
        List<Product> listProduct = product.getbyID(idProduct);
        try {
            if (listProduct != null) {
                name = listProduct.get(0).name;
                category = listProduct.get(0).category;
                supplier = listProduct.get(0).supplier;
                stock = listProduct.get(0).stock;
                return "table";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "tableEror";
    }
public String saveProduct() {
        DAOProduct product = new DAOProduct();
        product.addProduct(this);
        name = "";
        category = "";
        supplier = "";
        stock = 0;
        return "table";
    }
public String editProduct() {
        DAOProduct product = new DAOProduct();
        product.editUser(this);
        name = "";
        category = "";
        supplier = "";
        stock = 0;
        return "table";
    }
public String deleteProduct() {
        DAOProduct product = new DAOProduct();
        product.deleteUser(id);
        name = "";
        category = "";
        supplier = "";
        stock = 0;
        return "table";
    }

    public Product() {
    }

    public Product(String name, String category, String supplier, int stock) {
       this.name = name;
       this.category = category;
       this.supplier = supplier;
       this.stock = stock;
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
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    public String getSupplier() {
        return this.supplier;
    }
    
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public int getStock() {
        return this.stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }




}


