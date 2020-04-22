package vn.edu.gmaillayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    List<ContactModel> items;
    Button buttonFavorite;
    EditText search;
    ContactAdapter adapter;
    RecyclerView recyclerView;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonFavorite = findViewById(R.id.button_favorite);
        search = findViewById(R.id.edit_text);

        items = new ArrayList<>();
        items.add(new ContactModel("GitHub", "A personal access token (git: https://github.com/ on DELL_5577 at 01-Apr-2020 21:37)", "2:00AM"));
        items.add(new ContactModel("Google", "Tìm hiểu thêm về Điều khoản dịch vụ cập nhật của chúng tôi", "5:10AM"));
        items.add(new ContactModel("Youtube", "Những điểm thay đổi trong Điều khoản dịch vụ của YouTube", "6:30AM"));
        items.add(new ContactModel("Sony Show", "Sony Show 2019! Các Hoạt Động và Những Giải Thưởng Không Thể Bỏ Lỡ", "7:00AM"));
        items.add(new ContactModel("Trang Nguyễn", "[MISA Software] - Thư thông báo kết quả Test đầu vào", "7:30AM"));
        items.add(new ContactModel("Duolingo ", "3 mẹo học hay vào xem ngay bạn nhé!", "10:00AM"));
        items.add(new ContactModel("Drop Box", "Updates to our Terms of Service and Privacy Policy", "1:20PM"));
        items.add(new ContactModel("UNITOP.VN", "Làm thế nào để học lập trình web đi làm?", "3:45PM"));
        items.add(new ContactModel("Design Research", "Dropbox Research Wants to Hear from You!", "9:20PM"));

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ContactAdapter(items);
        recyclerView.setAdapter(adapter);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        buttonFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count == 0){
                    filterFavorite();
                    count ++;
                }
                else {
                    filterFavorite1();
                    count --;
                }
            }
        });
    }

    private void filter(String text) {
        List<ContactModel> items2 = new ArrayList<>();
        for(ContactModel t : items){
            if(t.getName().toLowerCase().contains(text.toLowerCase())||t.getContent().toLowerCase().contains(text.toLowerCase()))
                items2.add(t);
        }
        adapter.CopyAdapter(items2);
    }

    private void filterFavorite(){
        List<ContactModel> items2 = new ArrayList<>();
        for(ContactModel t : items){
            if(t.isFavorite)
                items2.add(t);
        }
        adapter.CopyAdapter(items2);
    }
    private void filterFavorite1(){
        adapter.CopyAdapter(items);
    }
}
