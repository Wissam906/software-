package lb.edu.barbershop;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
public class ListBookings extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bookings);
        ListView ls = findViewById(R.id.lsBookings);
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        ArrayAdapter<Booking> adapter = new ArrayAdapter<Booking>(this, android.R.layout.simple_list_item_1, bookings);
        ls.setAdapter(adapter);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url   ="https://mustafaalomari11930844.000webhostapp.com/ListBookings.php";
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0;i < response.length();i++) {
                    try {
                        JSONObject row = response.getJSONObject(i);
                        int number = row.getInt("number");
                        String name = row.getString("name");
                        String time = row.getString("time");
                        int barberid = row.getInt("barberid");
                        bookings.add(new Booking(number,name,time,barberid));
                    }
                    catch (Exception ex) {
                        Toast.makeText(ListBookings.this, "error", Toast.LENGTH_SHORT).show();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, null);
        queue.add(request);
    }
}
