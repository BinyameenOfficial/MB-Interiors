package com.blogspot.happyclub896.mbinteriors;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class DesignYourRoomActivity extends AppCompatActivity implements View.OnClickListener {

    ArFragment arFragment;

    private ModelRenderable bedRenderable,
                            clockRenderable,
                            drawerRenderable,
                            flatScreenTvRenderable,
                            roundTableRenderable,
                            singleSofaRenderable,
                            sofaRenderable,
                            stoolRenderable,
                            tableRenderable,
                            toiletRenderable;
    ImageView bed,clock,drawer,flatScreenTv,roundTable,singleSofa,sofa,stool,table,toilet;
    View arrayView[];
    ViewRenderable name_product;

    int selected=1; //default bed is choosed


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_your_room);


        ///View
        bed=(ImageView)findViewById(R.id.bed);
        clock=(ImageView)findViewById(R.id.clock);
        drawer=(ImageView)findViewById(R.id.drawer);
        flatScreenTv=(ImageView)findViewById(R.id.flat_screen_tv);
        roundTable=(ImageView)findViewById(R.id.round_table);
        singleSofa=(ImageView)findViewById(R.id.singlesofa);
        sofa=(ImageView)findViewById(R.id.sofa);
        stool=(ImageView)findViewById(R.id.stool);
        table=(ImageView)findViewById(R.id.table);
        toilet=(ImageView)findViewById(R.id.toilet);

        setArrayView();
        setClickListner();

        setUpModel();

        arFragment=(ArFragment)getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);
        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
             //where user tap on plane we will add model
            if(selected==1){
                Anchor anchor=hitResult.createAnchor();
                AnchorNode anchorNode=new AnchorNode(anchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());
                createModel(anchorNode,selected);
            }
        });
    }

    private void setUpModel() {
        ModelRenderable.builder()
                .setSource(this,R.raw.bed)
                .build().thenAccept(renderable -> bedRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Bed Model",Toast.LENGTH_LONG).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.clock)
                .build().thenAccept(renderable -> bedRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Clock Model",Toast.LENGTH_LONG).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.drawer)
                .build().thenAccept(renderable -> bedRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Drawer Model",Toast.LENGTH_LONG).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.flat_screen_tv)
                .build().thenAccept(renderable -> bedRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Flat Screen Television Model",Toast.LENGTH_LONG).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.round_table)
                .build().thenAccept(renderable -> bedRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Round Table Model",Toast.LENGTH_LONG).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.singlesofa)
                .build().thenAccept(renderable -> bedRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Single Seat Sofa Model",Toast.LENGTH_LONG).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.sofa)
                .build().thenAccept(renderable -> bedRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Sofa Model",Toast.LENGTH_LONG).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.stool)
                .build().thenAccept(renderable -> bedRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Stool Model",Toast.LENGTH_LONG).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.table)
                .build().thenAccept(renderable -> bedRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Table Model",Toast.LENGTH_LONG).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.toilet)
                .build().thenAccept(renderable -> bedRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Toilet Model",Toast.LENGTH_LONG).show();
                    return null;
                });
    }

    private void createModel(AnchorNode anchorNode, int selected) {
        if(selected==1){
            TransformableNode bed=new TransformableNode(arFragment.getTransformationSystem());
            bed.setParent(anchorNode);
            bed.setRenderable(bedRenderable);
            bed.select();
        }
    }

    private void setClickListner() {
        for(int i=0;i<arrayView.length;i++){
            arrayView[i].setOnClickListener(this);
        }
    }

    private void setArrayView() {
        arrayView=new View[]{
                bed,clock,drawer,flatScreenTv,roundTable,singleSofa,sofa,stool,table,toilet
        };
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bed){
            selected=1;
            setBackground(v.getId());
        }else if(v.getId()==R.id.drawer){
            selected=2;
            setBackground(v.getId());
        }else if(v.getId()==R.id.round_table){
            selected=3;
            setBackground(v.getId());
        }else if(v.getId()==R.id.singlesofa){
            selected=4;
            setBackground(v.getId());
        }else if(v.getId()==R.id.sofa){
            selected=5;
            setBackground(v.getId());
        }else if(v.getId()==R.id.stool){
            selected=6;
            setBackground(v.getId());
        }else if(v.getId()==R.id.table){
            selected=7;
            setBackground(v.getId());
        }else if(v.getId()==R.id.flat_screen_tv){
            selected=8;
            setBackground(v.getId());
        }else if(v.getId()==R.id.clock){
            selected=9;
            setBackground(v.getId());
        }else if(v.getId()==R.id.toilet){
            selected=10;
            setBackground(v.getId());
        }
    }

    private void setBackground(int id) {
        for(int i=0;i<arrayView.length;i++){
            if(arrayView[i].getId()==id){
                //set color for selected model
                arrayView[i].setBackgroundColor(Color.parseColor("#80333639"));
            }else{
                arrayView[i].setBackgroundColor(Color.TRANSPARENT);
            }
        }
    }
}