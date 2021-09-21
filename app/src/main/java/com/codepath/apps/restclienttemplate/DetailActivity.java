package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.models.User;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    ImageView ivProfileImage;
    TextView tvBody;
    TextView tvName;
    TextView tvScreenName;
    TextView tvRetweets;
    TextView tvFavs;
    TextView tvCreation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivProfileImage = findViewById(R.id.ivProfileImage);
        tvBody = findViewById(R.id.tvBody);
        tvName = findViewById(R.id.tvName);
        tvScreenName = findViewById(R.id.tvScreenName);
        tvRetweets = findViewById(R.id.tvRetweets);
        tvFavs = findViewById(R.id.tvFavs);
        tvCreation = findViewById(R.id.tvCreation);

        Tweet tweet = Parcels.unwrap(getIntent().getParcelableExtra("tweet"));
        tvBody.setText(tweet.body);
        tvName.setText(tweet.user.name);
        tvScreenName.setText("@" + tweet.user.screenName);
        Glide.with(this).load(tweet.user.profileImageUrl).into(ivProfileImage);
        tvRetweets.setText(tweet.retweetCount + " Retweets");
        tvFavs.setText(tweet.favCount + " Likes");
        tvCreation.setText(tweet.createdAt);
    }
}