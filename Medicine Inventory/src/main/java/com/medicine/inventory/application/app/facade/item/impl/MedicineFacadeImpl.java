package com.medicine.inventory.application.app.facade.item.impl;

import com.medicine.inventory.application.app.facade.item.MedicineFacade;
import com.medicine.inventory.application.data.Dao.item.MedicineDao;
import com.medicine.inventory.application.data.Dao.item.impl.MedicineDaoImpl;
import com.medicine.inventory.application.model.item.Item;
import java.util.List;

public class MedicineFacadeImpl implements MedicineFacade {

private MedicineDao medicineDao =  new MedicineDaoImpl();
@Override
    public Item getItemByMedicine_Id(int Medicine_Id){
    Item item = this.medicineDao.findItemByMedicine_Id(Medicine_Id);
    return item;
}
    @Override
    public List<Item> getAllItems() {
        List<Item> itemList = this.medicineDao.findAllItems();
        return itemList;
    }
    @Override
    public boolean addItem(Item item) {
        return this.medicineDao.addItem(item);
    }

    @Override
    public boolean updateItem(Item item) {
        return this.medicineDao.updateItem(item);
    }

    @Override
    public boolean deleteItemByMedicine_Id(int medicine_id) {
        return this.medicineDao.deleteItemByMedicine_Id(medicine_id);
    }
}

