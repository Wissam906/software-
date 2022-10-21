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
public class ListEmployees extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_employees);
        ListView ls = findViewById(R.id.lsEmployees);
        ArrayList<Employees> employees = new ArrayList<Employees>();
        ArrayAdapter<Employees> adapter = new ArrayAdapter<Employees>(this, android.R.layout.simple_list_item_1, employees);
        ls.setAdapter(adapter);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url   ="https://mustafaalomari11930844.000webhostapp.com/ListEmployees.php";
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0;i < response.length();i++) {
                    try {
                        JSONObject row = response.getJSONObject(i);
                        int ID = row.getInt("id");
                        String Name = row.getString("name");
                        employees.add(new Employees(ID, Name));
                    }
                    catch (Exception ex) {
                        Toast.makeText(ListEmployees.this, "error", Toast.LENGTH_SHORT).show();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, null);
        queue.add(request);
    }
}
