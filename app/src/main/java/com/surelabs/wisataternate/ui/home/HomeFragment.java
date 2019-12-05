package com.surelabs.wisataternate.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.surelabs.wisataternate.R;
import com.surelabs.wisataternate.ui.galeri.GaleriWisata;
import com.surelabs.wisataternate.ui.lokasi.LokasiWisata;
import com.surelabs.wisataternate.ui.portal.PortalWisata;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeFragment extends Fragment implements View.OnClickListener {

    FragmentManager fm;
    private String[] imageList = {
            "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-1-Indonesia-Kaya.jpg",
            "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-2-Lelungan.jpg",
            "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-3-Hipwee.jpeg",
            "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-3-Hipwee.jpeg",
            "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-5-Tribunnews.jpg",
            "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-6-Kompas.jpg",
            "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-7-Indonesia-Tourism-Forum.jpg",
            "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-8-Situs-Budaya.jpg",
            "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-9-Indonesia-Kaya.jpg",
            "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/01/wisata-ternate-10-Wisata-Lengkap.jpg"
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CarouselView carouselView = view.findViewById(R.id.carouselView);

        TextView profile = view.findViewById(R.id.profile);
        TextView portal = view.findViewById(R.id.portalWisata);
        TextView galeri = view.findViewById(R.id.galeriWisata);
        TextView lokasi = view.findViewById(R.id.lokasi);
        TextView tentang = view.findViewById(R.id.tentangKami);

        //setup carousel
        carouselView.setImageListener(new ImageListener() {
            @Override

            public void setImageForPosition(int position, ImageView imageView) {
                Glide.with(getActivity()).load(imageList[position]).into(imageView);
            }
        });
        carouselView.setPageCount(imageList.length);

        profile.setOnClickListener(this);
        portal.setOnClickListener(this);
        galeri.setOnClickListener(this);
        lokasi.setOnClickListener(this);
        tentang.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile:
                break;
            case R.id.portalWisata:
                fm = getActivity().getSupportFragmentManager();
                getActivity().setTitle("Portal Wisata");
                fm.beginTransaction().replace(R.id.nav_host_fragment, new PortalWisata()).commit();
                break;
            case R.id.galeriWisata:
                fm = getActivity().getSupportFragmentManager();
                getActivity().setTitle("Galeri Wisata");
                fm.beginTransaction().replace(R.id.nav_host_fragment, new GaleriWisata()).commit();
                break;
            case R.id.lokasi:
                fm = getActivity().getSupportFragmentManager();
                getActivity().setTitle("Lokasi Wisata");
                fm.beginTransaction().replace(R.id.nav_host_fragment, new LokasiWisata()).commit();
                break;
            case R.id.tentangKami:

                break;
        }
    }
}