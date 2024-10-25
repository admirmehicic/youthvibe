package com.example.youthvibe.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/loginProcess")
    public String loginProcess(@RequestParam String email, @RequestParam String password, Model model) throws SQLException {
        String fetchedPassword = null;
        if (email.equals("admin") && password.equals("admin")) {

            String url = "jdbc:mysql://localhost:3306/youthvibe";
            String user = "root";
            String pass = "admir";


            try (Connection conn = DriverManager.getConnection(url, user, pass)) {
                System.out.println("Connected to the MySQL server.");
                Statement statement = conn.createStatement();
                String query = "SELECT user_id, username, password, email, first_name, last_name, age FROM users";
                ResultSet resultSet = statement.executeQuery(query);
                List<Integer> user_IdList = new ArrayList<>();
                List<String> usernameList = new ArrayList<>();
                List<String> passwordLis = new ArrayList<>();
                List<String> emailList = new ArrayList<>();
                List<String> first_nameList = new ArrayList<>();
                List<String> last_nameList = new ArrayList<>();
                List<Integer> ageList = new ArrayList<>();

                // Process the result set
                while (resultSet.next()) {
                    int user_ID = resultSet.getInt("user_ID");
                    user_IdList.add(user_ID);
                    String username = resultSet.getString("username");
                    usernameList.add(username);
                    String password1 = resultSet.getString("password");
                    passwordLis.add(password1);
                    String email1 = resultSet.getString("email");
                    emailList.add(email1);
                    String first_name = resultSet.getString("first_name");
                    first_nameList.add(first_name);
                    String last_name = resultSet.getString("last_name");
                    last_nameList.add(last_name);
                    int age = resultSet.getInt("age");
                    ageList.add(age);

                }

                model.addAttribute("IDlista", user_IdList);
                model.addAttribute("usernameLista", usernameList);
                model.addAttribute("passwordList", passwordLis);
                model.addAttribute("emailList", emailList);
                model.addAttribute("firstnameList", first_nameList);
                model.addAttribute("lastnameList", last_nameList);
                model.addAttribute("ageList", ageList);

            }

            return "adminAccess";

        } else {
            String url = "jdbc:mysql://localhost:3306/youthvibe";
            String user = "root";
            String pass = "admir";


            try (Connection conn = DriverManager.getConnection(url, user, pass)) {
                System.out.println("Connected to the MySQL server.");

                String query = "SELECT password FROM users WHERE username = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, password); // assuming you meant to set the username, not the password

                ResultSet resultSet = pstmt.executeQuery();

                String fetchedPass = null;
                if (resultSet.next()) {
                    fetchedPass = resultSet.getString("password");
                }

                if (fetchedPass != null && fetchedPass.equals(password)) {
                    model.addAttribute("username", email);
                    return "registerSuccess";
                } else {
                    return "index";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return "error";
            }


        }

    }



        @GetMapping("/registerPage")

        public String registerPage(){
        return "register";
        }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password, @RequestParam String email, @RequestParam String name, @RequestParam String lastname, @RequestParam int godine, Model model) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/youthvibe";
        String user = "root";
        String pass = "admir";


        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Connected to the MySQL server.");
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO users (username, password, email, first_name, last_name, age) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, name);
            pstmt.setString(5, lastname);
            pstmt.setInt(6, godine);

            pstmt.executeUpdate();
        }


        model.addAttribute("username", username);
        return "registerSuccess";
    }

    @GetMapping("/registracija")
    public String registracija() {
        return "register";
    }

    @GetMapping("/dodajClanak")
    public String dodajClanak() {
        return "dodajClanak";
    }

    @PostMapping("/unosClanakBaza")
    public String register(@RequestParam String naslov, @RequestParam String opis, @RequestParam String sadrzaj, Model model) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/youthvibe";
        String user = "root";
        String pass = "admir";


        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Connected to the MySQL server.");
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO News (title, descr, content) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, naslov);
            pstmt.setString(2, opis);
            pstmt.setString(3, sadrzaj);

            pstmt.executeUpdate();
        }

model.addAttribute("naslov", naslov);
        return "articleAdded";
    }

    @GetMapping("/vijesti")
    public String pregledajVijesti(){
        return "Unews";
    }

    @GetMapping("/pregledajVijesti")
    public String vijesti(Model model){
        String url = "jdbc:mysql://localhost:3306/youthvibe";
        String user = "root";
        String pass = "admir";


        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Connected to the MySQL server.");

            Statement statement = conn.createStatement();
            String query = "SELECT news_id, title, descr, content FROM news";
            ResultSet resultSet = statement.executeQuery(query);

            List<Integer> idList = new ArrayList<>();
            List<String> titleList = new ArrayList<>();
            List<String> descrList = new ArrayList<>();


            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("news_id");
                idList.add(id);
                System.out.println("ID: " + id);
                String title = resultSet.getString("title");
                titleList.add(title);
                String descr = resultSet.getString("descr");
                descrList.add(descr);


            }

            System.out.println("ok");


            model.addAttribute("idLista", idList);
            model.addAttribute("nasloviLista", titleList);
            model.addAttribute("opisiLista", descrList);

            return "news";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/register")
        public String register(){
            return "register";
        }


    @GetMapping("/pregledajPrilike")
    public String pregledajPrilike(Model model){
            String url = "jdbc:mysql://localhost:3306/youthvibe";
            String user = "root";
            String pass = "admir";


            try (Connection conn = DriverManager.getConnection(url, user, pass)) {
                System.out.println("Connected to the MySQL server.");

                Statement statement = conn.createStatement();
                String query = "SELECT prilikaID, naslov, opis, datum, lokacija FROM prilike";
                ResultSet resultSet = statement.executeQuery(query);

                List<Integer> idList = new ArrayList<>();
                List<String> naslovList = new ArrayList<>();
                List<String> opisList = new ArrayList<>();
                List<String> datumList = new ArrayList<>();
                List<String> lokacijaList = new ArrayList<>();


                // Process the result set
                while (resultSet.next()) {
                    int id = resultSet.getInt("prilikaID");
                    idList.add(id);
                    String title = resultSet.getString("naslov");
                    naslovList.add(title);
                    String opis = resultSet.getString("opis");
                    opisList.add(opis);
                    String datum = resultSet.getString("datum");
                    datumList.add(datum);
                    String lokacija = resultSet.getString("lokacija");
                    lokacijaList.add(lokacija);


                }

                System.out.println("ok");


                model.addAttribute("idLista", idList);
                model.addAttribute("naslovList", naslovList);
                model.addAttribute("opisList", opisList);
                model.addAttribute("datumList", datumList);
                model.addAttribute("lokacijaList", lokacijaList);

                return "prilike";

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        @GetMapping("/dodajPriliku")
    public String dodajPriliku(){
        return "dodajPriliku";
        }


    @PostMapping("/unosPrilikaBaza")
    public String unosPrilika(@RequestParam String naslov, @RequestParam String opis, @RequestParam String datum, @RequestParam String lokacija, Model model) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/youthvibe";
        String user = "root";
        String pass = "admir";


        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Connected to the MySQL server.");
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO prilike (naslov, opis, datum, lokacija ) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, naslov);
            pstmt.setString(2, opis);
            pstmt.setString(3, datum);
            pstmt.setString(4, lokacija);



            pstmt.executeUpdate();
        }

        model.addAttribute("naslov", naslov);
        model.addAttribute("kategorija", opis);
        return "prilikaAdded";
    }

    @GetMapping("/logout")
    public String logout (){
        return "index";
    }

    @PostMapping("/obrisiPriliku")
    public String obrisi(@RequestParam String index) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/youthvibe";
        String user = "root";
        String pass = "admir";


        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            String sql = "DELETE FROM prilike WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, Integer.parseInt(index));
                int rowsAffected = statement.executeUpdate();
                System.out.println("Rows affected: " + rowsAffected);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "prilikaObrisana";
    }

}



