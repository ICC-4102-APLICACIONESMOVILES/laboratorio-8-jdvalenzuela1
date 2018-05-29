package cl.magnet.mobileappsexample.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by lenovo on 29-05-2018.
 */

@Entity
public class Answer {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int answerId;

    private String content;
    @ForeignKey(entity = Question.class, parentColumns = "questionId", childColumns = "question")
    private int questionId;

    public Answer() {
    }
    public int getAnswerId() {return answerId;}
    public void setAnswerId(int answerId) {this.answerId = answerId;}


    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}

    public int getQuestionId() {return questionId;}
    public void setQuestionId(int questionId) {this.questionId = questionId;}

}
