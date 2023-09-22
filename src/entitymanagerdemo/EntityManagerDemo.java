/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitymanagerdemo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Address;
import model.Customer;
import model.TableManager;

/**
 *
 * @author sarun
 */
public class EntityManagerDemo {
    public static String line = "---------";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //createData();
        printAllCustomer();
        System.out.println();
        printCustomerByCity("Bangkok");
    }
    public static void createData(){
        TableManager.createData(1L,"John", "Henry", "jh@gmail.com", "123/4 Viphavadee Rd.", "Bangkok", "TH", "10900");
        TableManager.createData(2L,"Mary", "Jane", "mj@gmail.com", "123/5 Viphavadee Rd.", "Bangkok", "TH", "10900");
        TableManager.createData(3L,"Peter", "Parker", "pp@gmail.com", "543/21 Fake Rd.", "Nonthaburi", "TH", "20900");
        TableManager.createData(4L,"Bruce", "Wayne", "bw@gmail.com", "678/90 Unreal Rd.", "Pathumthani", "TH", "30500");
    }
    
    public static void printAllCustomer(){
        List<Customer> list = TableManager.findAllCustomer();
        for(Customer cus: list){
            System.out.println(line);
            System.out.println(cus.getDetail());
            System.out.println(cus.getAddressId().getDetail());
            System.out.println(line);
        }
    }
    
    public static void printCustomerByCity(String city){
        List<Address> list  = TableManager.findAddressByCity(city);
        for(Address adr: list){
            System.out.println(line);
            System.out.println(adr.getCustomerFk().getDetail());
            System.out.println(adr.getDetail());
            System.out.println(line);
        }
    }
}
