import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView storyTextView;
    private Button choice1Button;
    private Button choice2Button;
    private Button choice3Button;
    private RequestQueue requestQueue;
    private String currentPrompt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storyTextView = findViewById(R.id.storyTextView);
        choice1Button = findViewById(R.id.choice1Button);
        choice2Button = findViewById(R.id.choice2Button);
        choice3Button = findViewById(R.id.choice3Button);
        requestQueue = Volley.newRequestQueue(this);

        makeApiCall();
    }

    private void makeApiCall() {
        String url = "https://example.com/api/story";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String story = response.getString("story");
                            String choice1 = response.getString("choice1");
                            String choice2 = response.getString("choice2");
                            String choice3 = response.getString("choice3");
                            currentPrompt = response.getString("prompt");
                            storyTextView.setText(story);
                            choice1Button.setText(choice1);
                            choice2Button.setText(choice2);
                            choice3Button.setText(choice3);
                            setOnClickListeners();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    private void setOnClickListeners() {
        choice1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendPrompt(choice1Button.getText().toString());
            }
        });

        choice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendPrompt(choice2Button.getText().toString());
            }
        });

        choice3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendPrompt(choice3Button.getText().toString());
            }
        });
    }

    private void sendPrompt(String choice) {
        String url = "https://example.com/api/story?prompt=" + choice;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String story = response.getString("story");
                            String choice1 = response.getString("choice1");
                            String choice2 = response.getString("choice2");
                            String choice3 = response.getString("choice3");
                            currentPrompt = response.getString("prompt");
                            storyTextView.setText(story);
                            choice1Button.setText(choice1);
                            choice2Button.setText(choice2);
                            choice3Button.setText(choice3);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
