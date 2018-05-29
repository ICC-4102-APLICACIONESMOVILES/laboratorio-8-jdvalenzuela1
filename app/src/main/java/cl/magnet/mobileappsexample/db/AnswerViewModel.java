package cl.magnet.mobileappsexample.db;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by lenovo on 29-05-2018.
 */

public class AnswerViewModel extends AndroidViewModel {

    private AnswerRepository mRepository;

    private LiveData<List<Answer>> mAllAnswer;

    public AnswerViewModel(@NonNull Application application) {
        super(application);
        mRepository = new AnswerRepository(application);
        mAllAnswer = mRepository.getmAllAnswer();
    }

    public LiveData<List<Answer>> getAllQuestion() {
        return mAllAnswer;
    }

    public void insert(List<Answer> answer) {
        mRepository.insert(answer);
    }
}