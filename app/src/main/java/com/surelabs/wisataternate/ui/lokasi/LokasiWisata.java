package com.surelabs.wisataternate.ui.lokasi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.surelabs.wisataternate.R;

public class LokasiWisata extends Fragment implements OnMapReadyCallback {

    private SupportMapFragment smp;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_lokasi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        smp = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapFragment);

        smp.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng bentengTolukko, pantaiBobaneIci, pantaiJikomalamo;
        final Marker markerbentengTolukko, markerpantaiBobaneIci, markerpantaiJikomalamo;

        bentengTolukko = new LatLng(0.8139152, 127.387834);
        markerbentengTolukko = googleMap.addMarker(new MarkerOptions().position(bentengTolukko).title("Benteng Tolukko").snippet("Benteng Tolukko"));
        markerbentengTolukko.showInfoWindow();


        pantaiBobaneIci = new LatLng(0.7947089, 127.2940025);
        markerpantaiBobaneIci = googleMap.addMarker(new MarkerOptions().position(pantaiBobaneIci).title("Pantai Bobane Ici").snippet("Pantai Bobane Ici"));
        markerpantaiBobaneIci.showInfoWindow();


        pantaiJikomalamo = new LatLng(0.8626167, 127.3200885);
        markerpantaiJikomalamo = googleMap.addMarker(new MarkerOptions().position(pantaiJikomalamo).title("Pantai Jikomalamo").snippet("Pantai Jikomalamo"));
        markerpantaiJikomalamo.showInfoWindow();

        LatLngBounds bounds;
        bounds = new LatLngBounds(pantaiBobaneIci, bentengTolukko);
        googleMap.setPadding(100, 0, 100, 0);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 17));

        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                if (marker == markerpantaiBobaneIci) {
                    Toast.makeText(getActivity(), "Pantai Bobane Ici", Toast.LENGTH_SHORT).show();
                } else if (marker == markerbentengTolukko) {
                    Toast.makeText(getActivity(), "Benteng Tolukko", Toast.LENGTH_SHORT).show();
                } else if (marker == markerpantaiJikomalamo) {
                    Toast.makeText(getActivity(), "Pantai Jikomalamo", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}