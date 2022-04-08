package com.example.practial.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.practial.MainActivity;
import com.example.practial.entity.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static  AppDatabase appDatabase;

    public abstract ProductDao productDao();

    public static AppDatabase getAppDatabase(MainActivity context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context,
                    AppDatabase.class, "Product").allowMainThreadQueries().build();
        }
        System.out.println(appDatabase);
        return appDatabase;
    }
}