package mugs.assignment;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import mugs.assignment.UI.ChartFragment;
import mugs.assignment.UI.HomeFragment;
import mugs.assignment.databinding.ActivityHomeBinding;
import mugs.assignment.utils.change;
import mugs.assignment.utils.changeHelper;

public class HomeActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mugs.assignment.databinding.ActivityHomeBinding binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bottomNavigationView = binding.bottomBar;
        bottomNavigationView.setOnItemSelectedListener(this);
            bottomNavigationView.setSelectedItemId(R.id.home);
    }
    HomeFragment Home = new HomeFragment();
    ChartFragment chart = new ChartFragment();
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.MainFrame, Home).commit();
                return true;
            case R.id.chart:
                getSupportFragmentManager().beginTransaction().replace(R.id.MainFrame, chart).commit();
                return true;
        }
        return false;
    }
}