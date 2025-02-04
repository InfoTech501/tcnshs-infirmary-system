import java.sql.*;

public class InventoryUpdateConnection {
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:oracleDB";
    public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String USERNAME = "sys";
    public static final String PASSWORD = "Changeme0";

    public static Connection getConnection() {
        try {
            Class.forName(ORACLE_DRIVER);
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception ex) {
            throw new RuntimeException("Error connecting to the database.", ex);
        }
    }

    public static void displayInventory() {
        String query = "SELECT medicine_id, medicine_name, brand, dosage, quantity_available, expiration_date FROM inventory";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Inventory List:");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Brand: %s | Dosage: %s | Stock: %d | Expiry: %s%n",
                        rs.getInt("medicine_id"), rs.getString("medicine_name"),
                        rs.getString("brand"), rs.getString("dosage"),
                        rs.getInt("quantity_available"), rs.getTimestamp("expiration_date"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving inventory: " + e.getMessage());
        }
    }

    public static void updateInventory(int id, String name, String brand, String dosage, int quantity, String expiry) {
        String updateQuery = "UPDATE inventory SET medicine_name = ?, brand = ?, dosage = ?, quantity_available = ?, expiration_date = TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS') WHERE medicine_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement prprdstmnt = conn.prepareStatement(updateQuery)) {

            prprdstmnt.setString(1, name);
            prprdstmnt.setString(2, brand);
            prprdstmnt.setString(3, dosage);
            prprdstmnt.setInt(4, quantity);
            prprdstmnt.setString(5, expiry);
            prprdstmnt.setInt(6, id);

            int rowsUpdated = prprdstmnt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Inventory updated successfully!");
            } else {
                System.out.println("No record found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating inventory: " + e.getMessage());
        }
    }
}
