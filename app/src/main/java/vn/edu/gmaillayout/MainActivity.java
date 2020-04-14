package vn.edu.gmaillayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<ContactModel> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        contacts = new ArrayList<>();
        contacts.add(new ContactModel("GitHub","A personal access token (git: https://github.com/ on DELL_5577 at 01-Apr-2020 21:37)",false,"#00ff00"));
        contacts.add(new ContactModel("Google","Tìm hiểu thêm về Điều khoản dịch vụ cập nhật của chúng tôi",false,"#F5F5DC"));
        contacts.add(new ContactModel("Youtube","Những điểm thay đổi trong Điều khoản dịch vụ của YouTube",false,"#0000ff"));
        contacts.add(new ContactModel("Sony Show","Sony Show 2019! Các Hoạt Động và Những Giải Thưởng Không Thể Bỏ Lỡ",false,"#7FFFD4"));
        contacts.add(new ContactModel("Trang Nguyễn","[MISA Software] - Thư thông báo kết quả Test đầu vào",false,"#00ffff"));
        contacts.add(new ContactModel("Duolingo ","3 mẹo học hay vào xem ngay bạn nhé!",false,"#FFE4C4"));
        contacts.add(new ContactModel("Drop Box","Updates to our Terms of Service and Privacy Policy",false,"#00ff00"));
        contacts.add(new ContactModel("UNITOP.VN","Làm thế nào để học lập trình web đi làm?",false,"#F0FFFF"));
        contacts.add(new ContactModel("Design Research","Dropbox Research Wants to Hear from You!",false,"#FFE4C4"));


        ContactAdapter adapter = new ContactAdapter(contacts);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
