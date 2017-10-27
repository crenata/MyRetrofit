package com.hafiizh.myretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.hafiizh.myretrofit.adapter.FlowerAdapter;
import com.hafiizh.myretrofit.data.Injector;
import com.hafiizh.myretrofit.model.Flowers;
import com.hafiizh.myretrofit.presenter.FlowersPresenter;
import com.hafiizh.myretrofit.view.FlowerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements FlowerView {
    FlowerAdapter adapter;
    FlowersPresenter presenter;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FlowerAdapter();
        presenter = new FlowersPresenter(Injector.getService(), this);
        presenter.getFlower();

        rv = (RecyclerView) findViewById(R.id.recycler_main);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

    }

    @Override
    public void onProgress() {
        Toast.makeText(this, "Progress running", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(List<Flowers> flowers) {
        adapter.clear();
        for (Flowers flower : flowers) {
            adapter.addFlowers(flower);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailed() {
        Toast.makeText(this, "Progress failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
