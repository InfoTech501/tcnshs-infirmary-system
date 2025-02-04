package com.medicine.inventory.application.data.Dao.item;

import com.medicine.inventory.application.model.item.Item;

import java.util.List;

public interface MedicineDao {

    /**
     * Returns the Item with a given id.
     *
     * @param Medicine_Id the id of the Item.
     * @return the Item with a given id.
     * */
    Item findItemByMedicine_Id(int Medicine_Id);

    List<Item> findAllItems();

    boolean addItem(Item item);

    boolean updateItem(Item item);

    boolean deleteItemByMedicine_Id(int medicine_id);

    boolean deleteItemById(String id);
}

