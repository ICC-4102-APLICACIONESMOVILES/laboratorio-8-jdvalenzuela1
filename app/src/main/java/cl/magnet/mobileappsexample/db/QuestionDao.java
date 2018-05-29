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
public interface QuestionDao {
    @Insert
    void insertOnlySingleQuestion (Question question);

    @Insert
    void insertMultipleQuestions (List<Question> questionsList);

    @Query("SELECT * FROM Question WHERE questionId = :questionId")
    Question fetchOneFormbyQuestionId (int questionId);

    @Query("SELECT * FROM Question")
    LiveData<List<Question>> getAllQuestion();

    @Update
    void updateQuestion (Question question);

    @Delete
    void deleteQuestion (Question question);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Question... question);
}
