package com.hha.heinhtetaung.charlesandkeith.persistence.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.hha.heinhtetaung.charlesandkeith.data.vo.NewProductVO;
import com.hha.heinhtetaung.charlesandkeith.persistence.dao.ProductDao;

/**
 * Created by E5 on 7/3/2018.
 */

@Database(entities = {NewProductVO.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase objInstance;
    private static String DB_NAME = "Product_DB";

    public abstract ProductDao productDAO();

    public static AppDatabase getObjInstance(Context context) {
        if (objInstance == null) {
            objInstance = Room.databaseBuilder(context, AppDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return objInstance;
    }
}
