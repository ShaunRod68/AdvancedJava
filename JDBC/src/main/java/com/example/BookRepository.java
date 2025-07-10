package com.example;

import java.sql.*;

public class BookRepository {
    private final String URL ="jdbc:mysql://localhost:3306/jdbc_prac1";
    private final String USERNAME ="root";
    private final String PASSWORD ="";
    public Connection getConnection() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("CONNECTION SUCCESSFUL");
            return connection;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
    public int addBook(String name, String author, String progress){
        try {
            Connection conn = getConnection();
            String query = "INSERT INTO books(name, author, progress) VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,name);
            pstmt.setString(2,author);
            pstmt.setString(3,progress);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }
    public ResultSet showBooks(){
        try{
            Connection conn = getConnection();
            String query = "SELECT * FROM books";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet showbook(String id){
        try{
            Connection conn = getConnection();
            String query = "Select * from books where id=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,Integer.parseInt(id));
            return pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int updateBook(String id, String name, String author, String progress) {
        try {
            Connection conn = getConnection();
            String query = "UPDATE books SET name = ?, author = ?, progress = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,name);
            pstmt.setString(2,author);
            pstmt.setString(3,progress);
            pstmt.setString(4,id);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }

    public int deleteBook(String id) {
        try{
            Connection conn = getConnection();
            String query = "delete from books where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,Integer.parseInt(id));
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public class DatabaseInitializer{
        public void initialize() throws SQLException {
            Connection con = getConnection();
            String query = """
            CREATE TABLE IF NOT EXISTS books (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(255) NOT NULL,
                author VARCHAR(255) NOT NULL,
                progress VARCHAR(50)
            );
            """;
            Statement stmt = con.createStatement();
            boolean execute = stmt.execute(query);
            if (!execute){
                System.out.println("TABLE CREATION FAILED");
            }
        }
    }

}
