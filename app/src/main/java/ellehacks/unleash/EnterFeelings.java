package ellehacks.unleash;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class EnterFeelings extends AppCompatActivity {

    private String caller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_feelings);

        caller = getIntent().getExtras().getString("calledFrom");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchFeelingsResultsActivity();
            }
        });

        ImageButton home = (ImageButton) findViewById(R.id.home_btn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnHome();
            }
        });

    }

    public void launchFeelingsResultsActivity() {
        Intent intent = new Intent(this, FeelingsResults.class);
        intent.putExtra("calledFrom", "EnterFeelings");
        startActivity(intent);
    }

    public void returnHome(){
        startActivity(new Intent(this, Unleash.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}
