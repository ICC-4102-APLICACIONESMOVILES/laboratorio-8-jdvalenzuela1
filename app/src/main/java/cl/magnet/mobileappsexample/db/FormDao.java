package cl.magnet.mobileappsexample.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface FormDao {

    @Query("SELECT * FROM form")
    LiveData<List<Form>> getAllForms();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Form... forms);

    @Insert
    void insertOnlySingleForm(Form form);

    @Query("DELETE FROM form")
    void deleteAll();
}