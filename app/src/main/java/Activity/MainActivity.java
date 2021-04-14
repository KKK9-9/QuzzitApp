package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quzzitapp.R;

import java.util.ArrayList;

import ModelClass.QuestionClass;

public class MainActivity extends AppCompatActivity {

    //set controls
    TextView tvCounterQuestion, tvTimer, tvQuestion;
    int counter=0;
    CountDownTimer tm;

    Button btOpt1, btOpt2, btOpt3, btOpt4;

    //list for que
    ArrayList<QuestionClass> queList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find view by ids
        tvQuestion=findViewById(R.id.tvQuestion);
        tvCounterQuestion=findViewById(R.id.tvCounterQuestion);
        tvTimer=findViewById(R.id.tvTimer);

        btOpt1=findViewById(R.id.btOpt1);
        btOpt2=findViewById(R.id.btOpt2);
        btOpt3=findViewById(R.id.btOpt3);
        btOpt4=findViewById(R.id.btOpt4);


        //load data
        queList.add(new QuestionClass("It is a sub-discipline of project management in which software projects are planned and monitored.", "Software Project Management", "Project Planning",
                "Deployment", "Stakeholders", "Software Project Management"));
        queList.add(new QuestionClass("These are included in 4P's Project Management Spectrum except:", "People", "Product",
                "Planning", "Process", "Planning"));
        queList.add(new QuestionClass("It is the foundation for all project plannig activities", "Money", "Resources",
                "Estimation", "End-users", "Estimation"));
        queList.add(new QuestionClass("The most valuable resource in a project", "Time", "Duration",
                "Task", "Weightage", "Time"));
        queList.add(new QuestionClass("Git automatically performs _______ when enough loose objects have been created in the repository.", "Version Control Systems", "Repository",
                "Git", "Garbage Collection", "Garbage Collection"));

        //init counter
        counter=0;

        //load que and answers
        loadQuestions(counter);

        tvTimer.setText("12");
        //countdown time
         tm =  new CountDownTimer(12 * 1000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText(""+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

                Toast.makeText(MainActivity.this, "Quiz over!", Toast.LENGTH_SHORT).show();
            }
        };


    }
    public void loadQuestions(int n){
        final QuestionClass q = queList.get(n);

        tvCounterQuestion.setText((n+1) + "/" +queList.size());

        tvTimer.setText(""+12);
        if (tm !=null){
            tm.start();
        }

        tvQuestion.setText("#" + (n + 1) +" " + q.getQue());
        btOpt1.setText("" + q.getOpt1());
        btOpt2.setText("" +q.getOpt2());
        btOpt3.setText("" + q.getOpt3());
        btOpt4.setText("" + q.getOpt4());

        //btOpt1
        btOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt1.getText().equals(q.getRightOpt())) {
                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();

                    if (counter < (queList.size()-1)) {
                        tm.cancel();
                        counter++;
                        loadQuestions(counter);
                    } else {
                        Toast.makeText(MainActivity.this, "All Questions Completed!", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                }


            }
        });
        //btOpt2
        btOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt2.getText().equals(q.getRightOpt())){

                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();

                    if (counter < (queList.size()-1)) {
                        tm.cancel();
                        counter++;
                        loadQuestions(counter);
                    } else {
                        Toast.makeText(MainActivity.this, "All Questions Completed!", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //btOpt3
        btOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt3.getText().equals(q.getRightOpt())){

                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();

                    if (counter < (queList.size()-1)) {
                        tm.cancel();
                        counter++;
                        loadQuestions(counter);
                    } else {
                        Toast.makeText(MainActivity.this, "All Questions Completed!", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //btOpt4
        btOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt4.getText().equals(q.getRightOpt())){

                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();

                    if (counter < (queList.size()-1)) {
                        tm.cancel();
                        counter++;
                        loadQuestions(counter);
                    } else {
                        Toast.makeText(MainActivity.this, "All Questions Completed!", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}