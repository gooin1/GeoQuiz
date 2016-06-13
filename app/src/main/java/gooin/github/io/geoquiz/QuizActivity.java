package gooin.github.io.geoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {


    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";


    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private Button mCheatButton;
    private TextView mQuestionTextView;

//    把问题列为一个数组，调用string里面的值
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_nice, true),
            new Question(R.string.question_gis, true),
            new Question(R.string.question_driver,false),
            new Question(R.string.question_css, true),
            new Question(R.string.question_mdzz, true),
    };
    private int mCurrentIndex;

    //    使用updateQuestion 封装公共代码
    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    //    创建checkAnswer方法，传入Question的boolean参数  判断问题对错
    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAanswerTrue();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        }else{
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: OK");
//        在 onCreate(...) 方法中检查存储的bundle信息（
        if(savedInstanceState!=null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }


        setContentView(R.layout.activity_quiz);
//        使用TextView
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

//        为TextView添加点击事件，可以实现nextButton的功能
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        updateQuestion();


        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //R.string.correct_toast   调用string里面的值，感觉方便多语言吧
//                Toast.makeText(QuizActivity.this,R.string.correct_toast, Toast.LENGTH_SHORT).show();
                checkAnswer(true);
            }
        });
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //R.string.correct_toast   调用string里面的值，感觉方便多语言吧
//                Toast.makeText(QuizActivity.this,R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                checkAnswer(false);

            }
        });
//        nextButton 到下一个问题
        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;

//                使用封装后的代码
//                int question = mQuestionBank[mCurrentIndex].getTextResId();
//                mQuestionTextView.setText(question);
                updateQuestion();
            }
        });

//        这个上一个按钮不能在第一个问题处返回到最后一个问题
        mPrevButton = (Button) findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                updateQuestion();
            }
        });


        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                添加cheat Activity的内容
//                Intent intent = new Intent(QuizActivity.this, CheatActivity.class);
                boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAanswerTrue();
                Intent intent = CheatActivity.newIntent(QuizActivity.this, answerIsTrue);
                startActivity(intent);

            }
        });

        updateQuestion();
    }




    //        添加更多生命周期
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: OK");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: OK");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: OK");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: OK");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestory: OK");
    }


    //    添加方法用于存储mCurrentIndex值
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState: ");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }


}
