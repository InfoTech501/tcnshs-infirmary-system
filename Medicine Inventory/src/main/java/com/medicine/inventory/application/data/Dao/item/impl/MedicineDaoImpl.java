package com.medicine.inventory.application.data.Dao.item.impl;

import com.medicine.inventory.application.model.item.Item;
import com.medicine.inventory.application.data.Dao.item.MedicineDao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.medicine.inventory.application.data.connection.ConnectionHelper.getConnection;

public class MedicineDaoImpl implements MedicineDao {

    @Override
    public Item findItemByMedicine_Id(int medicine_Id) {
        Item item = null;

        try (Connection con = getConnection()) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM INVENTORY WHERE Med_Id = ?");
            stmt.setInt(1, medicine_Id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                item = new Item();
                item.setMedicine_Id(rs.getString("Medicine_Id"));
                item.setMedicine_Name(rs.getString("Medicine_Name"));
                item.setBrand(rs.getString("Brand"));
                item.setDosage(rs.getString("Dosage"));
                item.setMed_Description(rs.getString("Med_Description"));
                item.setQuantity_Available(rs.getInt("Quantity_Available"));
                item.setQuantity_Used(rs.getInt("Quantity_Used"));
                item.setMed_Total_Usage(rs.getInt("Med_Total_Usage"));
                item.setExpiration_Date(rs.getTimestamp("Expiration_Date"));
            }

        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }

        return item;
    }



    @Override
    public List<Item> findAllItems() {
        List<Item> itemList = new ArrayList<>();
        try (Connection con = getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM INVENTORY");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Item item = new Item();
                item.setMedicine_Id(rs.getString("medicine_Id"));
                item.setMedicine_Name(rs.getString("medicine_Name"));
                item.setBrand(rs.getString("brand"));
                item.setDosage(rs.getString("dosage"));
                item.setMed_Description(rs.getString("Med_Description"));
                item.setQuantity_Available(rs.getInt("Quantity_Available"));
                item.setQuantity_Used(rs.getInt("Quantity_Used"));
                item.setMed_Total_Usage(rs.getInt("Med_Total_Usage"));
                item.setExpiration_Date(rs.getTimestamp("Expiration_Date"));
                itemList.add(item);
            }
        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }


        return List.of();
    }

    @Override
    public boolean addItem(Item item) {
        try (Connection con = getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO INVENTORY (MEDICINE_ID,MEDICINE_NAME, BRAND, DOSAGE, MED_DESCRIPTION,QUANTITY_AVAILABLE,QUANTITY_USED,MED_TOTAL_USAGE,EXPIRATION_DATE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, item.getMedicine_Id());
            stmt.setString(2, item.getMedicine_Name());
            stmt.setString(3, item.getBrand());
            stmt.setString(4, item.getDosage());
            stmt.setString(5, item.getMed_Description());
            stmt.setInt(6, item.getQuantity_Available());
            stmt.setInt(7, item.getQuantity_Used());
            stmt.setInt(8, item.getMed_Total_Usage());
            stmt.setTimestamp(9, item.getExpiration_Date());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        return false;
        }


    }

    @Override
    public boolean updateItem(Item item) {
        return false;
    }

    @Override
    public boolean deleteItemByMedicine_Id(int medicine_id) {
        return false;
    }

    @Override
    public boolean deleteItemById(String id) {
        return false;
    }

}



