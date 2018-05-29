package cl.magnet.mobileappsexample.db;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;
/**
 * Created by lenovo on 29-05-2018.
 */

public class QuestionViewModel extends AndroidViewModel {

    private QuestionRepository mRepository;

    private LiveData<List<Question>> mAllQuestion;

    public QuestionViewModel(@NonNull Application application) {
        super(application);
        mRepository = new QuestionRepository(application);
        mAllQuestion = mRepository.getAllQuestion();
    }

    public LiveData<List<Question>> getAllQuestion() {
        return mAllQuestion;
    }

    public void insert(List<Question> question) {
        mRepository.insert(question);
    }
}