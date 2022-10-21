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
public class GetCustomer extends AppCompatActivity implements View.OnClickListener{
    private Button bName;
    private EditText eNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_customer);
        eNumber = (EditText) findViewById(R.id.etNumber);
        bName = (Button) findViewById(R.id.btName);
        bName.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String id = eNumber.getText().toString();
        RequestQueue queue = new Volley().newRequestQueue(GetCustomer.this);
        String url = "https://mustafaalomari11930844.000webhostapp.com/GetCustomer.php?id="+ id;
        StringRequest sr = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(GetCustomer.this, response,
                                Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(GetCustomer.this, error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(sr);
    }
    public void addEmployee(View view) {
        Intent i =new Intent(this, AddEmployee.class);
        startActivity(i);
    }
    public void addBooking(View view) {
        Intent i =new Intent(this, AddBooking.class);
        startActivity(i);
    }
    public void listBookings(View view) {
        Intent i =new Intent(this, ListBookings.class);
        startActivity(i);
    }
    public void listEmployees(View view) {
        Intent i =new Intent(this, ListEmployees.class);
        startActivity(i);
    }
    public void deleteEmployee(View view) {
        Intent i =new Intent(this, DeleteEmployee.class);
        startActivity(i);
    }    public void deleteBooking(View view) {
        Intent i =new Intent(this, DeleteBooking.class);
        startActivity(i);
    } }