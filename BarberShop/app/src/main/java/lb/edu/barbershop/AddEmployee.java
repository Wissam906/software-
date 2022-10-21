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
public class AddEmployee extends AppCompatActivity {
    EditText id,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        id=(EditText)findViewById(R.id.etID);
        name=(EditText)findViewById(R.id.etName);
    }
    public void saveEmployee(View view) {
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://mustafaalomari11930844.000webhostapp.com/AddEmployee.php";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(AddEmployee.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AddEmployee.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", id.getText().toString());
                params.put("name", name.getText().toString());
                params.put("key", "cuBubcDE");
                return params;
            }
        };
        queue.add(request);
    }
}
