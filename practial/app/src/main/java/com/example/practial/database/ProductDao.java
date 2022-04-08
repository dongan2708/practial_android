package com.example.practial.database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.practial.entity.Product;

import java.util.List;

@Dao
public interface ProductDao {
    @Insert(onConflict = REPLACE)
    void insertProduct(Product product);

    @Query("SELECT * FROM products")
    List<Product> findAll();
}