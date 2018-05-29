package cl.magnet.mobileappsexample.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by lenovo on 29-05-2018.
 */

public class QuestionRepository {
    private QuestionDao mQuestionDao;
    private LiveData<List<Question>> mAllQuestion;

    QuestionRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mQuestionDao = db.daoQuestions();
        mAllQuestion = mQuestionDao.getAllQuestion();
    }

    LiveData<List<Question>> getAllQuestion() {
        return mAllQuestion;
    }

    public void insert (List<Question> question) {
        Question[] questionArray = new Question[question.size()];
        questionArray = question.toArray(questionArray);
        new QuestionRepository.insertAsyncTask(mQuestionDao).execute(questionArray);
    }

    private static class insertAsyncTask extends AsyncTask<Question, Void, Void> {

        private QuestionDao mAsyncTaskDao;

        insertAsyncTask(QuestionDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Question... params) {
            mAsyncTaskDao.insertAll(params);
            return null;
        }
    }
}
