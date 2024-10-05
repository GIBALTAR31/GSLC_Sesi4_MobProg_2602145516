package com.example.gslc_sesi4;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class second_page extends AppCompatActivity {

    private TextView name, ID, Role;
    GridView gridView;
    Integer[] image = {
            R.drawable.home, R.drawable.calendar, R.drawable.bookmark, R.drawable.round_account_balance_wallet_24, R.drawable.settings, R.drawable.logout
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gridView = findViewById(R.id.gridview);
        name = findViewById(R.id.name_txt);
        ID = findViewById(R.id.Id_Txt);
        Role = findViewById(R.id.Role_Txt);

        gridView.setAdapter(new ImageAdapterGridView(this));

        String userName = getIntent().getStringExtra("Username");
        String userId = getIntent().getStringExtra("Id");
        String userRole = getIntent().getStringExtra("Role");

        name.setText(userName);
        ID.setText(userId);
        Role.setText(userRole);
    }

    private class ImageAdapterGridView extends BaseAdapter {
        private Context mContext;
        @Override
        public int getCount() {
            return image.length;
        }

        public ImageAdapterGridView(Context context ) {
            mContext = context;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            ImageView imageView;

            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(16, 16, 16, 16);
            } else {
                imageView = (ImageView) convertView;

            }
            imageView.setImageResource(image[position]);
            return imageView;
        }
    }
}