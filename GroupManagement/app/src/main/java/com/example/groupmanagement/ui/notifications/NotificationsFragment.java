package com.example.groupmanagement.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.groupmanagement.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private List<Notification> mListNotification = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        // get data tư api
        prepareNotificationData();
        final ListView listView = (ListView) root.findViewById(R.id.lvNotification);
        listView.setAdapter(new AdapterNotification(getContext(), mListNotification));

        return root;
    }

    private void prepareNotificationData() {
        for (int i = 0; i < 15; i++) {
            Notification notification = new Notification("Notification " + i);
            mListNotification.add(notification);
        }
    }
}