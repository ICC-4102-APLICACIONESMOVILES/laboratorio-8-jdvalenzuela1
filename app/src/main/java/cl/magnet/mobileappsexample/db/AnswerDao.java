package cl.magnet.mobileappsexample.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by lenovo on 29-05-2018.
 */

@Dao
public interface AnswerDao {
    @Insert
    void insertOnlySingleAnswer (Answer answer);

    @Insert
    void insertMultipleAnswers (List<Answer> answersList);

    @Query("SELECT * FROM Answer WHERE answerId = :answerId")
    Answer fetchOneFormbyAnswerId (int answerId);

    @Query("SELECT * FROM Answer")
    LiveData<List<Answer>> getAllAnswer();
    @Update
    void updateAnswer (Answer answer);

    @Delete
    void deleteAnswer (Answer answer);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Answer... answers);
}

