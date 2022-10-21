package lb.edu.barbershop;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;
public class AddBooking extends AppCompatActivity {
    EditText name,number,time,barberid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_booking);
        number=(EditText)findViewById(R.id.etNumber);
        name=(EditText)findViewById(R.id.etName);
        time=(EditText)findViewById(R.id.etTime);
        barberid=(EditText)findViewById(R.id.etID);
    }
    public void saveBooking(View view) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://mustafaalomari11930844.000webhostapp.com/AddBooking.php";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(AddBooking.this, response, Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AddBooking.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("number", number.getText().toString());
                params.put("name", name.getText().toString());
                params.put("time", time.getText().toString());
                params.put("barberid", barberid.getText().toString());
                params.put("key", "cuBubcDE");
                return params;
            }
        };
        queue.add(request);
    }
}
