package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 // 0 = o
 // 1 = x

    int[] gamestates = {2,2,2,2,2,2,2,2,2};
    int turn = 1;
    int [][] wpons ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean  gameActive = true;


//      for (int[] wpos : wpons)
//
//    {
//        if (gamestates[wpos[0]] == gamestates[wpos[1]] && gamestates[wpos[1]] == gamestates[wpos[2]] && gamestates[wpos[0]] != 2);
//    }

    public void dropin (View view) {
        ImageView counter = (ImageView) view;
        Log.i("tag;",counter.getTag().toString());
           int tapcounter = Integer.parseInt(counter.getTag().toString());
           if(gamestates[tapcounter] ==2 && gameActive) {
               gamestates[tapcounter] = turn;

               counter.setTranslationY(-1500);


               if (turn == 1) {
                   counter.setImageResource(R.drawable.x);
                   turn = 0;
               } else {
                   counter.setImageResource(R.drawable.o);
                   turn = 1;
               }

               counter.animate().translationYBy(1500).setDuration(200);

               for (int[] wpos : wpons) {
                   if (gamestates[wpos[0]] == gamestates[wpos[1]] && gamestates[wpos[1]] == gamestates[wpos[2]] && gamestates[wpos[0]] != 2) {

                       gameActive = false;

                       String winner = "";
                       if (turn == 1) {
                           winner = "0";
                       } else {
                           winner = "x";
                       }
                       //Toast.makeText(this, winner + "has won", Toast.LENGTH_LONG).show();
                       TextView toper = (TextView) findViewById(R.id.winner);
                       Button again = (Button)findViewById(R.id.playAgain);
                       toper.setText("congratulation  "+winner + "  has won");
                       toper.setVisibility(View.VISIBLE);
                       again.setVisibility(View.VISIBLE);
                   }

               }
           }

    }
    public void againn (View view) {

        TextView toper = (TextView) findViewById(R.id.winner);
        Button again = (Button)findViewById(R.id.playAgain);
        toper.setVisibility(View.INVISIBLE);
        again.setVisibility(View.INVISIBLE);
        GridLayout gridlayout = (GridLayout) findViewById(R.id.gridLayout);
        for(int i = 0; i<gridlayout.getChildCount();i++) {
            ImageView tap = (ImageView) gridlayout.getChildAt(i);
            tap.setImageDrawable(null);
        }
          for(int i = 0;i<gamestates.length; i++) {
               gamestates[i] = 2;
          }

        //int[] gamestates = {2,2,2,2,2,2,2,2,2};
        int turn = 1;
        boolean  gameActive = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
