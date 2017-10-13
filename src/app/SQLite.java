package app;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
public class SQLite {
    //Static Variables
    static java.sql.Connection conn  = null;
    static java.sql.Statement stmt = null;
    static java.sql.Statement stmt1 = null;
    static java.sql.Statement stmt2 = null;
    static String url = "jdbc:sqlite:C:\\Users\\joshua\\Desktop\\Dream Circuits Inventory System\\src\\app\\tblInventory.sqlite";
    static String username = "";
    static String password = "";
    static String className = "";
    static String error = "";
    
    //Open DB Session Method
    public static boolean openDB(){
        boolean result = false;
        try{
            Class.forName("org.sqlite.JDBC");
            conn = java.sql.DriverManager.getConnection(url);

            System.out.println("OK! SQLite DB session connected.");
            result = true;
        }
        catch(Exception e){
            error = e.getMessage();
            System.out.println("Open DB Error:" + e.getMessage());
        } 
        return result;
    }

    //Close DB Session Method
    public static boolean closeDB(){
        boolean result = false;
        try{
            conn.close();

            System.out.println("OK! SQLite DB session closed.");
            result = true;
        }
        catch(Exception e){
            error = e.getMessage();
            System.out.println("Close DB Error: " + e.getMessage());
        }
        return result;
    }
    
    
     public static String[][] read(String table, String[] columns){
        String[][] records = null;
        try{
            SQLite.stmt = conn.createStatement();

            //Count total rows
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM " + table);
            int totalRows = rs.getInt(1);

            //Count total columns
            int totalColumns = columns.length;
            String cols = "";
            for(int i=0;i<totalColumns;i++){
                cols += columns[i];
                if((i+1)!=totalColumns)cols+=", ";
            }
            rs = stmt.executeQuery("SELECT "+ cols +" FROM " + table);

            //Initialize 2D Array "records" with totalRows by totalColumns
            records = new String[totalRows][totalColumns];

            //Retrieve the record and store it to 2D Array "records"
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }
     public static String[][] readS(String table, String where){
        String[][] records = null;
        try{
            SQLite.stmt = conn.createStatement();
            //Count total rows
            ResultSet rs = stmt.executeQuery("SELECT quantity FROM " + table + " WHERE " + where);
            int totalRows = rs.getInt(1);

            //Count total columns
            rs = stmt.executeQuery("SELECT quantity FROM " + table + " WHERE " + where);
            ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();

            //Initialize 2D Array "records" with totalRows by totalColumns
            records = new String[totalRows][totalColumns];

            //Retrieve the record and store it to 2D Array "records"
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }  
     
     public static String[][] readItem(String table, String where){
        String[][] records = null;
        try{
            SQLite.stmt = conn.createStatement();
            //Count total rows
            ResultSet rs = stmt.executeQuery("SELECT quantity FROM " + table + " WHERE " + where);
            int totalRows = rs.getInt(1);

            //Count total columns
            rs = stmt.executeQuery("SELECT itemName FROM " + table + " WHERE " + where);
            ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();

            //Initialize 2D Array "records" with totalRows by totalColumns
            records = new String[totalRows][totalColumns];

            //Retrieve the record and store it to 2D Array "records"
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    } 
     
     public static String[][] read(String table, String where){
        String[][] records = null;
        try{
            SQLite.stmt = conn.createStatement();

            //Count total rows
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM " + table + " WHERE " + where);
            int totalRows = rs.getInt(1);

            //Count total columns
            rs = stmt.executeQuery("SELECT * FROM " + table + " WHERE " + where);
            ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();

            //Initialize 2D Array "records" with totalRows by totalColumns
            records = new String[totalRows][totalColumns];

            //Retrieve the record and store it to 2D Array "records"
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }  
    //Create Record Method
    public static boolean create(String table, String values){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "INSERT INTO "+ table +" VALUES(" + values + ")";
            stmt.executeUpdate(query);
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }    

    //Update Record Method
    public static boolean update(String table, String set, int itemNo)
    {
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "UPDATE "+ table +" SET " + set + " WHERE serialNumber=" + itemNo;
            stmt.executeUpdate(query);
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }
    
    public static boolean updateProjects(String table, String set, int projectID)
    {
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "UPDATE "+ table +" SET " + set + " WHERE projectID=" + projectID;
            stmt.executeUpdate(query);
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }
    
     public static boolean updateRepair(String table, String set, int repairID)
    {
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "UPDATE "+ table +" SET " + set + " WHERE repairID=" + repairID;
            stmt.executeUpdate(query);
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }
    
    
    public static boolean updateBrand(String table, String set, int brandID)
    {
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "UPDATE "+ table +" SET " + set + " WHERE brandNo=" + brandID;
            stmt.executeUpdate(query);
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }
    
    public static boolean updateCategory(String table, String set, int categoryID)
    {
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "UPDATE "+ table +" SET " + set + " WHERE categoryID=" + categoryID;
            stmt.executeUpdate(query);
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }
    
    public static boolean updateStocks(String table, String set, int itemNo)
    {
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "UPDATE "+ table +" SET " + set + " WHERE itemID=" + itemNo;
            stmt.executeUpdate(query);
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }
    public static boolean updateItem(String table, String set, int itemNo){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "UPDATE "+ table +" SET " + set + " WHERE itemID=" + itemNo;
            stmt.executeUpdate(query);
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }    
    public static boolean updateSupplier(String table, String set, int id){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "UPDATE "+ table +" SET " + set + " WHERE supplierID=" + id;
            stmt.executeUpdate(query);
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }  
    //Delete Record Method
    public static boolean delete(String table, int id){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "DELETE FROM "+ table + " WHERE id=" + id;
            stmt.executeUpdate(query);
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }
    
    public static boolean Truncate(String table){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "DELETE FROM "+ table;
            stmt.executeUpdate(query);
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }
    
    public static boolean deleteProject(String table, int id){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "DELETE FROM "+ table + " WHERE projectID=" + id;
            stmt.executeUpdate(query);
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }
    public static boolean deleteUser(String table, int id){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "DELETE FROM "+ table + " WHERE repairID=" + id;
            stmt.executeUpdate(query);
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }
    public static boolean deleteClient(String table, int id){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "DELETE FROM "+ table + " WHERE clientID=" + id;
            stmt.executeUpdate(query);
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }
    public static boolean Catdelete(String table, int id){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "DELETE FROM "+ table + " WHERE categoryID=" + id;
            stmt.executeUpdate(query);
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }
    public static boolean Branddelete(String table, int id){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "DELETE FROM "+ table + " WHERE brandNo=" + id;
            stmt.executeUpdate(query);
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }
    public static boolean deleteSupplier(String table, int id){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "DELETE FROM "+ table + " WHERE supplierID=" + id;
            stmt.executeUpdate(query);
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }
    public static boolean deleteItem(String table, int id){
        boolean result = false;
        try{
            SQLite.stmt = conn.createStatement();
            String query = "DELETE FROM "+ table + " WHERE itemID=" + id;
            stmt.executeUpdate(query);
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }

    //Read Record Method
    public static String[][] read(String table){
        String[][] records = null;
        try{
            SQLite.stmt = conn.createStatement();

            //Count total rows
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM " + table);
            int totalRows = rs.getInt(1);

            //Count total columns
            rs = stmt.executeQuery("SELECT * FROM " + table);
            ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();

            //Initialize 2D Array "records" with totalRows by totalColumns
            records = new String[totalRows][totalColumns];

            //Retrieve the record and store it to 2D Array "records"
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }
    
    
    public static String[][] LeftJoin(String table){
         String[][] records = null;
        try{
            SQLite.stmt = conn.createStatement();
            SQLite.stmt1 = conn.createStatement();
            SQLite.stmt2 = conn.createStatement();
            //Count total rows
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM " + table);
            int totalRows = rs.getInt(1);

            //Count total columns
            rs = stmt.executeQuery("SELECT * FROM " + table);
            ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();
             //JOptionPane.showMessageDialog(null, totalColumns);
            totalColumns = totalColumns + 1;
             //JOptionPane.showMessageDialog(null, totalColumns);

            //Initialize 2D Array "records" with totalRows by totalColumns
            records = new String[totalRows][totalColumns];
            ResultSet rss;
            ResultSet rss1;
            //Retrieve the record and store it to 2D Array "records"
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<(totalColumns-1);col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                    //JOptionPane.showMessageDialog(null, records[row][0]);
                }
                
                
               rss = stmt1.executeQuery("SELECT SUM(quantity) FROM tblStockIn WHERE itemNo = "+records[row][0]);
               rss1 = stmt2.executeQuery("SELECT SUM(quantity) FROM tblStockOut WHERE itemNo = "+records[row][0]);
               String test = rss1.toString();
              int num1 = Integer.parseInt(rss.getObject(1).toString());
//              JOptionPane.showMessageDialog(null, rss1);
              //JOptionPane.showMessageDialog(null, "hello1");
              while(rss1.next()){
                int num2 = Integer.parseInt(rss1.getObject(1).toString());
                //JOptionPane.showMessageDialog(null, num2);  
                //int num2 = Integer.parseInt(rss1.getObject(1).toString());
                //JOptionPane.showMessageDialog(null, "hello2");
                int total = num1-num2;
                records[row][totalColumns-1] = Integer.toString(total);
                row++;
               }
              
//              else{
//                JOptionPane.showMessageDialog(null, "Error");
//              }
              
              
             
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }
    public void getIDtblBrand(){
        
    }
    
    /**
     * JDBC Routine
     * 
     * 1. Open a DB Session
     * 2. Execute a query
     * 3. Expect Return Value/s
     * 4. Close DB Session
     ***/
    
    public static void main(String[] args) {
        /*
        //Test a openDB and closeDB Methods
        if(SQLite.openDB()){
            //Execute a query...
            //Expect Return Value/s
            SQLite.closeDB();
        }
        */
        
        /*
        if(SQLite.openDB()){
            String id = "3";
            String name = "Mark";
            String values = id + "," + "'" + name + "'"; // 3,'Mark'
            SQLite.create("tblGuestbook", values);
            SQLite.closeDB();
        }
        */
        
        /** github.com/clydeatuic/java-todo
         * tblGuestbook
         *  ID          INT             Primary Key
         *  NAME        VARCHAR(50)     Not Null
         *  CONTACTNO   VARCHAR(50)     Not Null
         *  EMAIL       VARCHAR(50)     Not Null
         *  GENDER      CHAR(1)         Not Null
         */
        
        /*
        if(SQLite.openDB()){
            String updatedName = "Marky";
            String set = "name=" + "'" + updatedName + "'";
            SQLite.update("tblGuestbook", set, 3);
            SQLite.closeDB();
        }
        */
    }
   
}
