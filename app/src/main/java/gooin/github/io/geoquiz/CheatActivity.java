package gooin.github.io.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    //    添加extra常量
    private static final String EXTRA_ANSWER_IS_TRUE=
            "gooin.github.io.geoquiz.answer_is_true";

//    从extra中获取信息
    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;



    public static Intent newIntent(Context context,boolean answerIsTrue){
        Intent intent = new Intent(context, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);
        mShowAnswer=(Button) findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
            }
        });


    }
}
