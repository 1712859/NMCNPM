package com.example.groupmanagement.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


import com.example.groupmanagement.MainActivity;
import com.example.groupmanagement.R;
import com.example.groupmanagement.main_app;

public class DashboardFragment extends Fragment {
Button logout;
    private DashboardViewModel dashboardViewModel;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        // get data tư api
        setHasOptionsMenu(true);
        logout = root.findViewById(R.id.account_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(root.getContext(), MainActivity.class);

                startActivity(intent);
            }
        });
        return root;
    }
}