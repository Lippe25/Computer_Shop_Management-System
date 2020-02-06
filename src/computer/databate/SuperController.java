package computer.databate;


import computer.classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PropertyResourceBundle;

public class SuperController {

    private connection c = new connection();
/*
    public boolean testConnection(){
        boolean bool = false;
        while (!bool){
            c = new connection();
            System.out.println("Pas de connection a la base de données");
            if (c.getTestConnection()){
                bool = true;
                System.out.println("CONNECTION OKAY !");
            }
        }
        return bool;
    }
*/
    public Object[] testSignIN(String email, String password) {

        Statement stmt;
        PreparedStatement preStmt;
        ResultSet res;

        Employee employee = new Employee();
        Store store;
        List<Store> storeListEmp = new ArrayList<>();
        Object[] employeeInfos = new Object[2];

        String query = "SELECT * FROM employee WHERE EMPLOYEE_EMAIL = ? AND EMPLOYEE_PASSWORD = ?";
        try {
            preStmt = c.getCon().prepareStatement(query);
            preStmt.setString(1, email);
            preStmt.setString(2, password);
            res = preStmt.executeQuery();
            if (res.next()) {
                employee = new Employee(
                        res.getInt("EMPLOYEE_ID")
                        ,res.getString("EMPLOYEE_FIRST_NAME")
                        , res.getString("EMPLOYEE_LAST_NAME")
                        , res.getString("EMPLOYEE_GENDER")
                        , res.getInt("EMPLOYEE_PHONE_NUMBER")
                        , res.getString("EMPLOYEE_EMAIL")
                        , res.getString("EMPLOYEE_PICTURE")
                        , res.getString("EMPLOYEE_PASSWORD")
                        , res.getString("EMPLOYEE_ROLE"));
                employee.setId(res.getInt("EMPLOYEE_ID"));
                res.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (employee.getEmail() != null) {
            String req = "SELECT * FROM store NATURAL RIGHT JOIN work WHERE work.EMPLOYEE_ID = "+ employee.getId();
            try {
                stmt = c.getCon().createStatement();
                res = stmt.executeQuery(req);
                while (res.next()){
                    store = new Store(res.getInt("STORE_ID"), res.getString("STORE_NAME"), res.getString("STORE_ADDRESS")
                    , res.getInt("STORE_PHONE_NUMBER"), res.getString("STORE_EMAIL"), res.getString("DESCRIPTION"));
                    storeListEmp.add(store);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            employeeInfos[0] = employee;
            employeeInfos[1] = storeListEmp;
        }

        return employeeInfos;
    }

    public Manufactury getManufactury(int id){

        Statement stmt;
        PreparedStatement preStmt;
        ResultSet res = null;

        Manufactury manu = new Manufactury("MAN",0);

        String query = "SELECT * FROM manufactury WHERE MANUFACTURY_ID = ?";
        try {
            preStmt  = c.getCon().prepareStatement(query);
            preStmt.setInt(1,id);
            res = preStmt.executeQuery();
            if (res.next()){
                manu.setId(res.getInt("MANUFACTURY_ID"));
                manu.setName(res.getString("MANUFACTURY_NAME"));
                manu.setQtyStock(res.getInt("QUANTITY_STOCK"));
                manu.setQtyAlert(res.getInt("QUANTITY_ALERT"));
                manu.setSellingCount(res.getInt("SELLING_COUNT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return manu;
    }

    public Employee getEmployee(int id){

        Statement stmt;
        PreparedStatement preStmt;
        ResultSet res = null;

        Employee emp = new Employee();

        String query = "SELECT * FROM employee WHERE EMPLOYEE_ID = ?";
        try {
            preStmt  = c.getCon().prepareStatement(query);
            preStmt.setInt(1,id);
            res = preStmt.executeQuery();
            if (res.next()){
                emp.setId(res.getInt("EMPLOYEE_ID"));
                emp.setPassword(res.getString("EMPLOYEE_PASSWORD"));
                emp.setRole(res.getString("EMPLOYEE_ROLE"));
                emp.setFirstName(res.getString("EMPLOYEE_FIRST_NAME"));
                emp.setLastName(res.getString("EMPLOYEE_LAST_NAME"));
                emp.setGender(res.getString("EMPLOYEE_GENDER"));
                emp.setPhoneNumber(res.getInt("EMPLOYEE_PHONE_NUMBER"));
                emp.setEmail(res.getString("EMPLOYEE_EMAIL"));
                emp.setPicture(res.getString("EMPLOYEE_PICTURE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emp;
    }

    public Customer getCustomer(int id){

        Statement stmt;
        PreparedStatement preStmt;
        ResultSet res = null;

        Customer cust = new Customer();

        String query = "SELECT * FROM customer WHERE CUSTOMER_ID = ?";
        try {
            preStmt  = c.getCon().prepareStatement(query);
            preStmt.setInt(1,id);
            res = preStmt.executeQuery();
            if (res.next()){
                cust.setPicture(res.getString("CUSTOMER_PICTURE"));
                cust.setId(res.getInt("CUSTOMER_ID"));
                cust.setAddress(res.getString("CUSTOMER_ADDRESS"));
                cust.setFirstName(res.getString("CUSTOMER_FIRST_NAME"));
                cust.setLastName(res.getString("CUSTOMER_LAST_NAME"));
                cust.setGender(res.getString("CUSTOMER_GENDER"));
                cust.setPhoneNumber(res.getInt("CUSTOMER_PHONE_NUMBER"));
                cust.setEmail(res.getString("CUSTOMER_EMAIL"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cust;
    }

    public ObservableList<Customer> getCustomer(){

        Statement stmt;
        PreparedStatement preStmt;
        ResultSet res = null;

        Customer customer;
        ObservableList<Customer> listCostumer = FXCollections.observableArrayList();

        String query = "SELECT * FROM customer";
        try {
            stmt  = c.getCon().createStatement();
            res = stmt.executeQuery(query);
            while (res.next()){
                int id = res.getInt("CUSTOMER_ID");
                String adress = res.getString("CUSTOMER_ADDRESS");
                String fname = res.getString("CUSTOMER_FIRST_NAME");
                String lname = res.getString("CUSTOMER_LAST_NAME");
                String gender = res.getString("CUSTOMER_GENDER");
                int pnum = res.getInt("CUSTOMER_PHONE_NUMBER");
                String email = res.getString("CUSTOMER_EMAIL");
                String pic = res.getString("CUSTOMER_PICTURE");

                customer = new Customer(fname,lname,gender,pnum,email,pic,adress);
                customer.setId(id);

                listCostumer.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCostumer;
    }

    public ObservableList<Transport> getTransport(){

        Statement stmt;
        ResultSet res = null;

        Transport transport;
        ObservableList<Transport> listTransport = FXCollections.observableArrayList();

        String query = "SELECT * FROM transport";
        try {
            stmt  = c.getCon().createStatement();
            res = stmt.executeQuery(query);
            while (res.next()){
                int id = res.getInt("TRANSPORT_ID");
                String type = res.getString("TRANSPORT_TYPE");
                int price = res.getInt("TRANSPORT_PRICE");

                transport = new Transport(id,type,price);
                listTransport.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listTransport;
    }

    public Provider getProvider(int id){

        Statement stmt;
        PreparedStatement preStmt;
        ResultSet res = null;

        Provider prov = new Provider();

        String query = "SELECT * FROM provider WHERE PROVIDER_ID = ?";
        try {
            preStmt  = c.getCon().prepareStatement(query);
            preStmt.setInt(1,id);
            res = preStmt.executeQuery();
            if (res.next()){
                prov.setId(res.getInt("PROVIDER_ID"));
                prov.setCompanyName(res.getString("PROVIDER_COMPANY_NAME"));
                prov.setFirstName(res.getString("PROVIDER_FIRST_NAME"));
                prov.setLastName(res.getString("PROVIDER_LAST_NAME"));
                prov.setGender(res.getString("PROVIDER_GENDER"));
                prov.setPhoneNumber(res.getInt("PROVIDER_PHONE_NUMBER"));
                prov.setEmail(res.getString("PROVIDER_EMAIL"));
                prov.setPicture(res.getString("PROVIDER_PICTURE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prov;
    }

    public Procurement getProcurement(int id){

        Statement stmt;
        PreparedStatement preStmt;
        ResultSet res = null;

        Procurement pro = new Procurement();

        String query = "SELECT * FROM procurement WHERE PROCUREMENT_ID = ?";
        try {
            preStmt  = c.getCon().prepareStatement(query);
            preStmt.setInt(1,id);
            res = preStmt.executeQuery();
            if (res.next()){
                pro.setId(res.getInt("PROCUREMENT_ID"));

                pro.setEmployee(getEmployee(res.getInt("EMPLOYEE_ID")));
                pro.setProvider(getProvider(res.getInt("PROVIDER_ID")));

                pro.setQuantity(res.getInt("PROCUREMENT_QUANTITY"));
                pro.setTotalPrice(res.getInt("PROCUREMENT_TOTAL_PRICE"));
                pro.setDate(res.getString("PROCUREMENT_DATE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pro;
    }

    public Procurement getProcurement(Procurement procurement){
        Statement stmt;

        PreparedStatement preStmt;
        ResultSet res = null;
        Procurement pro = new Procurement();
        String query = "SELECT * FROM procurement WHERE PROCUREMENT_DATE = ?";
        //Comment recuperer un produit de maniere unique
        try {
            preStmt  = c.getCon().prepareStatement(query);
            preStmt.setString(1, procurement.getDate());
            res = preStmt.executeQuery();
            if (res.next()){
                pro.setDate(res.getString("PROCUREMENT_DATE"));
                pro.setId(res.getInt("PROCUREMENT_ID"));
                pro.setEmployee(getEmployee(res.getInt("EMPLOYEE_ID")));
                pro.setProvider(getProvider(res.getInt("PROVIDER_ID")));
                pro.setQuantity(res.getInt("PROCUREMENT_QUANTITY"));
                pro.setTotalPrice(res.getInt("PROCUREMENT_TOTAL_PRICE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pro;
    }

    public Category getCategory(int id){

        Statement stmt;
        PreparedStatement preStmt;
        ResultSet res = null;

        Category cat = new Category();

        String query = "SELECT * FROM category WHERE CATEGORY_ID = ?";
        try {
            preStmt  = c.getCon().prepareStatement(query);
            preStmt.setInt(1,id);
            res = preStmt.executeQuery();
            if (res.next()){
                cat.setId(res.getInt("CATEGORY_ID"));
                cat.setName(res.getString("CATEGORY_NAME"));
                cat.setSurplus(res.getInt("SURPLUS"));
                cat.setQtyAlert(res.getInt("QTY_ALERT"));
                cat.setSurplusCount(Integer.parseInt(res.getString("SURPLUS_START")));
                cat.setDescription(res.getString("CATEGORY_DESCRIPTION"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cat;
    }

    public Bill getBill(int id){

        Statement stmt;
        PreparedStatement preStmt;
        ResultSet res = null;

        Bill bill = new Bill();

        String query = "SELECT * FROM bill WHERE BILL_ID = ?";
        try {
            preStmt = c.getCon().prepareStatement(query);
            preStmt.setInt(1,id);
            res = preStmt.executeQuery();
            if (res.next()){
                bill.setId(res.getInt("BILL_ID"));
                bill.setCustomer(getCustomer(res.getInt("CUSTOMER_ID")));
                bill.setEmployee(getEmployee(res.getInt("EMPLOYEE_ID")));
                bill.setReceiveMoney(res.getInt("RECEIVE_MONEY"));
                bill.setBillDate(res.getString("BILL_DATE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bill;
    }

    public List<Bill> getBill(){

        Statement stmt;
        PreparedStatement preStmt;
        ResultSet res = null;

        Bill bill = new Bill();
        List<Bill> bills = new ArrayList<>();

        String query = "SELECT * FROM bill";
        try {
            preStmt = c.getCon().prepareStatement(query);
            res = preStmt.executeQuery();
            while (res.next()){
                bill.setBillDate(res.getString("BILL_DATE"));
                bill.setId(res.getInt("BILL_ID"));
                bill.setCustomer(getCustomer(res.getInt("CUSTOMER_ID")));
                bill.setEmployee(getEmployee(res.getInt("EMPLOYEE_ID")));
                bill.setReceiveMoney(res.getInt("RECEIVE_MONEY"));

                bills.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bills;
    }

    public Article getArticle(String sn){

        Statement stmt;
        PreparedStatement preStmt;
        ResultSet res = null;

        Article article = null;
        String query = "SELECT * FROM article WHERE BILL_ID IS NULL AND SERIAL_NUMBER = ?";
        try {
            preStmt = c.getCon().prepareStatement(query);
            preStmt.setString(1,sn);
            res = preStmt.executeQuery();
            if (res.next()){
                int id = res.getInt("ARTICLE_ID");

                Manufactury manufactury = getManufactury(res.getInt("MANUFACTURY_ID"));
                Procurement procurement = getProcurement(res.getInt("PROCUREMENT_ID"));
                //Bill bill = getBill(res.getInt("BILL_ID"));
                Bill bill = new Bill();
                Category category = getCategory(res.getInt("CATEGORY_ID"));
                float discount = res.getFloat("DISCOUNT");

                String serialNumber = res.getString("SERIAL_NUMBER");
                String modelname = res.getString("MODEL_NAME");
                int sellingPrice = res.getInt("SELLING_PRICE");
                int realSellingPrice = res.getInt("REAL_SELLING_PRICE");
                float tva = res.getFloat("TVA");
                String picture = res.getString("ARTICLE_PICTURE");
                String desc = res.getString("ARTICLE_DESCRIPTION");

                article = new Article(id,manufactury,procurement,bill,category,discount,serialNumber,modelname,
                        sellingPrice, realSellingPrice,tva,picture,desc);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    public Article getArticle(int sn){

        Statement stmt;
        PreparedStatement preStmt;
        ResultSet res = null;

        Article article = null;
        String query = "SELECT * FROM article WHERE ARTICLE_ID = ?";
        try {
            preStmt = c.getCon().prepareStatement(query);
            preStmt.setInt(1,sn);
            res = preStmt.executeQuery();
            if (res.next()){
                int id = res.getInt("ARTICLE_ID");

                Manufactury manufactury = getManufactury(res.getInt("MANUFACTURY_ID"));
                Procurement procurement = getProcurement(res.getInt("PROCUREMENT_ID"));
                Bill bill = getBill(res.getInt("BILL_ID"));
                Category category = getCategory(res.getInt("CATEGORY_ID"));
                float discount = res.getFloat("DISCOUNT");

                String serialNumber = res.getString("SERIAL_NUMBER");
                String modelname = res.getString("MODEL_NAME");
                int sellingPrice = res.getInt("SELLING_PRICE");
                int realSellingPrice = res.getInt("REAL_SELLING_PRICE");
                float tva = res.getFloat("TVA");
                String picture = res.getString("ARTICLE_PICTURE");
                String desc = res.getString("ARTICLE_DESCRIPTION");

                article = new Article(id,manufactury,procurement,bill,category,discount,serialNumber,modelname,
                        sellingPrice, realSellingPrice,tva,picture,desc);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    public List<Article> getAllArticle(){

        Statement stmt;
        PreparedStatement preStmt;
        ResultSet res = null;

        Article article;
        List<Article> listArticle = new ArrayList<>();
        String query = "SELECT * FROM article WHERE BILL_ID IS NULL";
        try {
            stmt = c.getCon().createStatement();
            res = stmt.executeQuery(query);
            while (res.next()){
                int id = res.getInt("ARTICLE_ID");

                Manufactury manufactury = getManufactury(res.getInt("MANUFACTURY_ID"));
                Procurement procurment = getProcurement(res.getInt("PROCUREMENT_ID"));
                Bill bill = getBill(res.getInt("BILL_ID"));
                Category category = getCategory(res.getInt("CATEGORY_ID"));
                float discount = res.getInt("DISCOUNT");

                String serialNumber = res.getString("SERIAL_NUMBER");
                String modelname = res.getString("MODEL_NAME");
                int sellingPrice = res.getInt("SELLING_PRICE");
                int realSellingPrice = res.getInt("REAL_SELLING_PRICE");
                float tva = res.getFloat("TVA");
                String picture = res.getString("ARTICLE_PICTURE");
                String desc = res.getString("ARTICLE_DESCRIPTION");

                article = new Article(id,manufactury,procurment,bill,category,discount,serialNumber,modelname,
                        sellingPrice, realSellingPrice,tva,picture,desc);
                listArticle.add(article);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listArticle;
    }

    public List<Feature> getArticleFeature(int id){

        PreparedStatement preStmt;
        ResultSet res;

        Feature feature = new Feature();
        List<Feature> ft = new ArrayList<>();

        String query = "SELECT * FROM feature WHERE ARTICLE_ID = ?";
        try {
            preStmt = c.getCon().prepareStatement(query);
            preStmt.setInt(1,id);
            res = preStmt.executeQuery();
            while (res.next()){
                feature.setId(res.getInt("FEATURE_ID"));
                feature.setArticle(getArticle(res.getInt("ARTICLE_ID")));
                feature.setName(res.getString("FEATURE_NAME"));
                feature.setValue(res.getString("FEATURE_VALUE"));
                feature.setDescription(res.getString("FEATURE_DESCRIPTION"));
                ft.add(feature);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ft;
    }

    public void setBill(Bill bill, List<Article> listArticle){
        PreparedStatement preStmt;
        int idBill = 0;

        System.out.println(bill.getId());
        System.out.println(bill.getCustomer().getId());
        System.out.println(bill.getEmployee().getId());
        System.out.println(bill.getTransport().getId());
        System.out.println(bill.getReceiveMoney());
        System.out.println(bill.getTotalMoney());
        System.out.println(bill.getBillDate());

        String query = "INSERT INTO bill(CUSTOMER_ID, EMPLOYEE_ID, TRANSPORT_ID, RECEIVE_MONEY, TOTAL_MONEY, BILL_DATE) VALUES(?,?,?,?,?,?)";
        String[] generatedColumns = {"ARTICLE_ID"};

        try {
            preStmt = c.getCon().prepareStatement(query, generatedColumns);
            preStmt.setInt(1, bill.getCustomer().getId());
            preStmt.setInt(2, bill.getEmployee().getId());
            preStmt.setInt(3, bill.getTransport().getId());
            preStmt.setInt(4, bill.getReceiveMoney());
            preStmt.setInt(5, bill.getTotalMoney());
            preStmt.setString(6, bill.getBillDate());

            preStmt.execute();
            ResultSet res = preStmt.getGeneratedKeys();
            if (res.next()){
                idBill = (int) res.getInt(1);
                System.out.println("Bill created !");
            }

            preStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("ID bill = " + idBill);

        for (Article art: listArticle) {
            PreparedStatement preStm;

            String qry = "UPDATE article SET BILL_ID = ?, REAL_SELLING_PRICE = ? WHERE SERIAL_NUMBER = ?";
            try {
                preStm = c.getCon().prepareStatement(qry);
                preStm.setInt(1, idBill);
                preStm.setInt(2, art.getRealSellingPrice());
                preStm.setString(3, art.getSerialNumber());

                preStm.execute();
                System.out.println("Article " + art.toString() + " Updated !");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void setCustomer(Customer customer){
        PreparedStatement preStmt;
        String query = "INSERT INTO customer(CUSTOMER_ADDRESS, CUSTOMER_FIRST_NAME, CUSTOMER_LAST_NAME, CUSTOMER_GENDER," +
                " CUSTOMER_PHONE_NUMBER, CUSTOMER_EMAIL, CUSTOMER_PICTURE) VALUES (?,?,?,?,?,?,?)";
        try {
            preStmt = c.getCon().prepareStatement(query);
            preStmt.setString(1, customer.getAddress());
            preStmt.setString(2, customer.getFirstName());
            preStmt.setString(3, customer.getLastName());
            preStmt.setString(4, customer.getGender());
            preStmt.setInt(5, customer.getPhoneNumber());
            preStmt.setString(6, customer.getEmail());
            preStmt.setString(7, customer.getPicture());
            preStmt.execute();
            System.out.println("User added !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean setCustomerIsAdded(Customer customer){
        PreparedStatement preStmt;
        String query = "SELECT * FROM customer WHERE CUSTOMER_EMAIL = ? AND CUSTOMER_FIRST_NAME = ? AND CUSTOMER_LAST_NAME = ?";
        try {
            preStmt = c.getCon().prepareStatement(query);
            preStmt.setString(1, customer.getEmail());
            preStmt.setString(2, customer.getFirstName());
            preStmt.setString(3, customer.getLastName());
            ResultSet res = preStmt.executeQuery();
            return res.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void setProcurement(Procurement procurement, List<Article> listArticle){
        PreparedStatement preStmt;

        String query = "INSERT INTO procurement(EMPLOYEE_ID, PROVIDER_ID, PROCUREMENT_QUANTITY, PROCUREMENT_TOTAL_PRICE," +
                " PROCUREMENT_DATE) VALUES (?,?,?,?,?)";

        try {
            preStmt = c.getCon().prepareStatement(query);
            preStmt.setInt(1, procurement.getEmployee().getId());
            preStmt.setInt(2, procurement.getProvider().getId());
            preStmt.setInt(3, procurement.getQuantity());
            preStmt.setInt(4, procurement.getTotalPrice());
            preStmt.setString(5, procurement.getDate());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        getProcurement(procurement);
    }

}
