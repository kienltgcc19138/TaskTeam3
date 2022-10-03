package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.task1.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.z3737762248376_92df9489a5a796d856f6fb7120444ce3,R.drawable.z3737762255701_e67fb8b23d61f7ec6cbc6868733b8703,R.drawable.z3737762270649_59c782aabf2505fe45c73f3e9e047b98,R.drawable.z3737762250977_46490c3c2e95eb3b8f93dc6102aa9adc,R.drawable.z3737762273028_c9a265be1064206b308f9f973ae296a7,
                R.drawable.z3737762284385_e3b751ab568d01aee6a01659eb32a152,R.drawable.z3737762289071_cb2988b694feebc762d93f8bce67a36c,R.drawable.z3737762289571_276f4d8de1a59e4848a2b0c6a87e3df6,R.drawable.z3737762299450_2ad948e9927f8ba93fd691f1d6a8771f};
        String[] name = {"Christopher","Craig","Sergio","Mubariz","Mike","Michael","Tom","Ivana","Alex"};
        String[] lastMessage = {"Hey", "Supp", "Let's Catchup ", " Dinner tonight ? " , " Gotta go ",
                "I'm in meeting " , " Gotcha " , " Let's Go " , " any weekend Plans ? "};
        String[] lastmsgTime = {" 8:45 pm " , "9:00 am", " 7:34 pm " , "6:32 am", "5:76 am",
                " 5:00 am " , "7:34 pm" , "2:32 am", "7:76 am"};
        String[] phoneNo = {" 7656610000 " , " 9999043232 " , " 7834354323 " , " 9876543211 " , " 5434432343 " ,
                " 9439043232 " , " 7534354323 " , " 6545543211 " , " 7654432343 "};
        String[] country = {" United States " , " Russia " , " India " , " Israel " , " Germany " , " Thailand " , " Canada " , " France " , " Switzerland "};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i =0; i< imageId.length;i++){
            User user = new User(name[i], lastMessage[i],lastmsgTime[i],phoneNo[i],country[i],imageId[i]);

            userArrayList.add(user);

        }

        ListAdapter listAdapter = new ListAdapter(MainActivity.this, userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this,UserActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("phone",phoneNo[position]);
                i.putExtra("country",country[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });
    }
}