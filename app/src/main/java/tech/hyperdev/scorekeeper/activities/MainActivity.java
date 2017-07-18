package tech.hyperdev.scorekeeper.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.*;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;

public class MainActivity extends AppCompatActivity {

    Context context;
    TextView textView2;
    ImageButton btnPlus;
    ImageButton btnMinus;
    TextView tvTeamName;
    FragmentManager team1;
    FragmentManager team2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView2 = (TextView)findViewById(R.id.textView2);
        btnPlus = (ImageButton)findViewById(R.id.btnPlus);
        btnMinus = (ImageButton) findViewById(R.id.btnMinus);
        tvTeamName = (TextView)findViewById(R.id.tvTeamName);

        context=this;

//            team1= getSupportFragmentManager();
//
//            team1.beginTransaction()
//                 .replace(R.id.team1,ScoreFragment.newInstance(Integer.parseInt(("Team 1")),0))
//                    .addToBackStack("team1")
//                    .commit();
//
//
//        team2= getSupportFragmentManager();
//
//        team2.beginTransaction()
//                .replace(R.id.team2,ScoreFragment.newInstance(Integer.parseInt("Team 2"),0))
//                .addToBackStack("team2")
//                .commit();




        btnPlus.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String present_value_string = textView2.getText().toString();
                int present_value_int = Integer.parseInt(present_value_string);
                present_value_int++;

                textView2.setText(String.valueOf(present_value_int));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String present_value_string = textView2.getText().toString();
                int present_value_int = Integer.parseInt(present_value_string);
                present_value_int--;
                if(present_value_int<=0)
                {
                    btnMinus.setEnabled(false);
                }
                else{
                    btnMinus.setEnabled(true);

                }

                textView2.setText(String.valueOf(present_value_int));
            }
        });

    }





    public void changeText(View num) {
        ScoreFragment scoreFragment = (ScoreFragment) getSupportFragmentManager().findFragmentById(R.id.team1);
        scoreFragment.plusOnclick(num);


  }
}
