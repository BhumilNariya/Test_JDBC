import java.sql.*;
import java.util.Scanner;
import java.sql.*;


public class Prepared_Statement {
    public static void main(String args[]) {
          String url="jdbc:mysql://localhost:3306/jdbc";
          String username="root";
          String password="Bhumil@123";
//        String query="select *from employees where name=? where job-title=?";
          String query="insert into employees(id, name, job_title,salary) values(?,?,?,?)";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database...");

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            Connection connection= DriverManager.getConnection(url,username,password);
            System.out.println("Connected to database...");
            Scanner scanner =new Scanner(System.in);
            int id=scanner.nextInt();
            scanner.nextLine();
            String name=scanner.nextLine();
            String job_title=scanner.nextLine();
            String salary=scanner.nextLine();

            PreparedStatement preparedstatement= connection.prepareStatement(query);
//            preparedstatement.setString(1,"Bhumil");
            preparedstatement.setInt(1,id);
            preparedstatement.setString(2,name);
            preparedstatement.setString(3,job_title);
            preparedstatement.setString(4,salary);
            int rowaffected=preparedstatement.executeUpdate();
            if (rowaffected >0){
                System.out.println("Data Insertion is Successfully");
            }else{
                System.out.println("Data Insertion is Failed");
            }
//            ResultSet resultset =preparedstatement.executeQuery();
//            while(resultset.next()){
//                int id =resultset.getInt("id");
//                String name=resultset.getString("name");
//                String job_title=resultset.getString("job_title");
//                Double salary=resultset.getDouble("salary");
//                System.out.println("id :" +id);
//                System.out.println("name :" +name);
//                System.out.println("job_title :" +job_title);
//                System.out.println("salary :" +salary);
//
//            }

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
