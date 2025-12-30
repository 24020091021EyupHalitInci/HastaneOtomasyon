package tr.edu.istiklal.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection c = null;

    public Connection connDb() {
        try {
            // 1. Sürücüyü (Driver) manuel olarak yükle
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Bağlantı URL'sini ve kimlik bilgilerini tanımla
            String url = "jdbc:mysql://localhost:3306/hospital";
            String user = "root";
            String pass = "6190";

            // 3. Bağlantıyı kur
            this.c = DriverManager.getConnection(url, user, pass);

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver bulunamadı! JAR dosyasını eklediğinizden emin olun.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Veritabanı bağlantı hatası! Kullanıcı adı, şifre veya DB adını kontrol edin.");
            e.printStackTrace();
        }
        return c;
    }
}