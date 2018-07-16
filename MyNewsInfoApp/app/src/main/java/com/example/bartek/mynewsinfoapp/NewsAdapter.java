package com.example.bartek.mynewsinfoapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * return list item view which shows information about news at the given position in the list
     */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list, parent, false);

            //Find the news at given posiotion in the list
            News currentNews = getItem(position);

            //Find the text wit id title

            TextView titleText = listItemView.findViewById(R.id.title);
            titleText.setText(currentNews.getTitle());

            // Find the TextView with view ID section_name
            TextView sectionNameView = listItemView.findViewById(R.id.section_name);
            // Display the section name of the current news in that TextView
            sectionNameView.setText(currentNews.getSectionName());



            // Find the TextView with view ID author_name
            TextView authorNameView = listItemView.findViewById(R.id.author_name);
            // Display the author name of the current news in that TextView
            if (currentNews.getAuthorName() != "") {
                authorNameView.setText(currentNews.getAuthorName());

                //Set author name view as visible
                authorNameView.setVisibility(View.VISIBLE);
            } else {
                //Set author name view as gone
                authorNameView.setVisibility(View.GONE);
            }

            // Find the TextView with view ID date
            TextView dateView = null;
            TextView timeView = null;
            if (currentNews.getDate() != null) {
                dateView = listItemView.findViewById(R.id.publicationDate_text_view);
                // Format the date string (i.e. "Mar 3, 1984")
                String formattedDate = formatDate(currentNews.getDate()).concat(",");
                // Display the date of the current earthquake in that TextView
                dateView.setText(formattedDate);


                //Set date & time views as visible
                dateView.setVisibility(View.VISIBLE);
            } else {
                //Set date & time views as gone
                dateView.setVisibility(View.GONE);
            }
        }
        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }


}
