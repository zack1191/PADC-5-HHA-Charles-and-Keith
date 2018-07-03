package com.hha.heinhtetaung.charlesandkeith.persistence.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.hha.heinhtetaung.charlesandkeith.data.vo.NewProductVO;

import java.util.List;

/**
 * Created by E5 on 6/30/2018.
 */

@Dao
public interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProducts(List<NewProductVO> newProductVOList);

    @Query("SELECT * From products")
    List<NewProductVO> getAllProduct();

    @Query("SELECT * FROM products Where productId=:productId")
    List<NewProductVO> getProductById(String productId);

    @Query("SELECT * From products")
    LiveData<List<NewProductVO>> getAllLiveData();

    @Query("SELECT * FROM products Where productId=:productId")
    LiveData<List<NewProductVO>> getLiveDataProductById(String productId);

}
