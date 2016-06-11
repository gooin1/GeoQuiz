package gooin.github.io.geoquiz;

/**
 * Created by gooin on 2016/6/11.
 */
public class Question {
    private int mTextResId;
    private boolean mAanswerTrue;

    public int getTextResId() { 
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAanswerTrue() {
        return mAanswerTrue;
    }

    public void setAanswerTrue(boolean aanswerTrue) {
        mAanswerTrue = aanswerTrue;
    }

    public Question(int textResId, boolean answerTrue) {
        mTextResId = textResId;
        mAanswerTrue = answerTrue;

    }
    }