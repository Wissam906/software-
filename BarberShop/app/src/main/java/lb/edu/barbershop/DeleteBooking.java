package lb.edu.barbershop;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
public class DeleteBooking extends AppCompatActivity {
    private EditText eNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_booking);
        eNumber = (EditText) findViewById(R.id.etNumber);
    }

    public void deleteBooking(View view) {
        String id = eNumber.getText().toString();
        RequestQueue queue = new Volley().newRequestQueue(DeleteBooking.this);
        String url = "https://mustafaalomari11930844.000webhostapp.com/DeleteBooking.php?id="+ id;
        StringRequest sr = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(DeleteBooking.this, response,
                                Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DeleteBooking.this, error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(sr);
    }
}