package com.londonappbrewery.destini;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStory;
    Button mButtonTop;
    Button mButtonBottom;
    int StoryIndex = 0;

    private stories[] mStories = new stories[]{
            new stories(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new stories(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new stories(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStory = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);

        mStory.setText(mStories[StoryIndex].getmStory());
        mButtonTop.setText(mStories[StoryIndex].getmAns1());
        mButtonBottom.setText(mStories[StoryIndex].getmAns2());

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updater(StoryIndex,1);
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updater(StoryIndex,2);
            }
        });

    }

    public void updater(int storyIndex, int choice){
        if(storyIndex == 0 && choice == 1){
            StoryIndex = 2;
        }
        else if(storyIndex == 0 && choice == 2){
            StoryIndex = 1;
        }
        else if(storyIndex == 1 && choice == 1){
            StoryIndex = 2;
        }
        else if(storyIndex == 1 && choice == 2){
            end(4);
            return;
        }
        else if(storyIndex == 2 && choice == 1) {
            end(6);
            return;
        }
        else if(storyIndex == 2 && choice == 2){
            end(5);
            return;
        }
        mStory.setText(mStories[StoryIndex].getmStory());
        mButtonTop.setText(mStories[StoryIndex].getmAns1());
        mButtonBottom.setText(mStories[StoryIndex].getmAns2());
    }

    public void end(int endNum){
        if(endNum == 4){
            mStory.setText(R.string.T4_End);
            Toast.makeText(this,"Whoa!!!",Toast.LENGTH_SHORT).show();
        }
        else if(endNum == 5){
            mStory.setText(R.string.T5_End);
            Toast.makeText(this,"Nice!!!",Toast.LENGTH_SHORT).show();
        }
        else{
            mStory.setText(R.string.T6_End);
            Toast.makeText(this,"Damn!!!",Toast.LENGTH_SHORT).show();
        }
        mButtonTop.setVisibility(View.GONE);
        mButtonBottom.setVisibility(View.GONE);
    }
}
