package com.surelabs.wisataternate.ui.galeri;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.surelabs.wisataternate.R;

import java.util.ArrayList;

public class GaleriWisata extends Fragment {

    private ArrayList<String> imageList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_galeri, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageList.add("https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-1-Indonesia-Kaya.jpg");
        imageList.add("https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-2-Lelungan.jpg");
        imageList.add("https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-3-Hipwee.jpeg");
        imageList.add("https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-3-Hipwee.jpeg");
        imageList.add("https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-5-Tribunnews.jpg");
        imageList.add("https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-6-Kompas.jpg");
        imageList.add("https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-7-Indonesia-Tourism-Forum.jpg");
        imageList.add("https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-8-Situs-Budaya.jpg");
        imageList.add("https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-9-Indonesia-Kaya.jpg");
        imageList.add("https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-10-Wisata-Lengkap.jpg");

        AdapterGaleri adapter = new AdapterGaleri(imageList);
        RecyclerView rv = view.findViewById(R.id.rvGaleri);

        rv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}