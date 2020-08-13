package com.blogspot.happyclub896.mbinteriors;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class DesignYourRoomActivity extends AppCompatActivity implements View.OnClickListener {

    ArFragment arFragment;

    private ModelRenderable bedRenderable,
                            drawerRenderable,
                            roundTableRenderable,
                            singleSofaRenderable,
                            sofaRenderable,
                            stoolRenderable,
                            tableRenderable,
                            flatScreenTvRenderable,
                            clockRenderable,
                            toiletRenderable;
    ImageView bed,clock,drawer,flatScreenTv,roundTable,singleSofa,sofa,stool,table,toilet;
    View arrayView[];


    int selected=1; //default bed is choosed


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_your_room);


        ///View
        bed=(ImageView)findViewById(R.id.bed);
        drawer=(ImageView)findViewById(R.id.drawer);
        roundTable=(ImageView)findViewById(R.id.round_table);
        singleSofa=(ImageView)findViewById(R.id.singlesofa);
        sofa=(ImageView)findViewById(R.id.sofa);
        stool=(ImageView)findViewById(R.id.stool);
        table=(ImageView)findViewById(R.id.table);
        flatScreenTv=(ImageView)findViewById(R.id.flat_screen_tv);
        clock=(ImageView)findViewById(R.id.clock);
        toilet=(ImageView)findViewById(R.id.toilet);

        setArrayView();
        setClickListner();

        setUpModel();

        arFragment=(ArFragment)getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);
        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
             //where user tap on plane we will add model
                Anchor anchor=hitResult.createAnchor();
                AnchorNode anchorNode=new AnchorNode(anchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());
                createModel(anchorNode,selected);
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
                .setSource(this,R.raw.drawer)
                .build().thenAccept(renderable -> drawerRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Drawer Model",Toast.LENGTH_LONG).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.round_table)
                .build().thenAccept(renderable -> roundTableRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Round Table Model",Toast.LENGTH_LONG).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.singlesofa)
                .build().thenAccept(renderable -> singleSofaRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Single Seat Sofa Model",Toast.LENGTH_LONG).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.sofa)
                .build().thenAccept(renderable -> sofaRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Sofa Model",Toast.LENGTH_LONG).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.stool)
                .build().thenAccept(renderable -> stoolRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Stool Model",Toast.LENGTH_LONG).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.table)
                .build().thenAccept(renderable -> tableRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Table Model",Toast.LENGTH_LONG).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.flat_screen_tv)
                .build().thenAccept(renderable -> flatScreenTvRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Flat Screen Television Model",Toast.LENGTH_LONG).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this,R.raw.clock)
                .build().thenAccept(renderable -> clockRenderable=renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Clock Model",Toast.LENGTH_LONG).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this,R.raw.toilet)
                .build().thenAccept(renderable -> toiletRenderable=renderable)
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
            
            addName(anchorNode,bed,"Bed");
        }else if(selected==2){
            TransformableNode bed=new TransformableNode(arFragment.getTransformationSystem());
            bed.setParent(anchorNode);
            bed.setRenderable(drawerRenderable);
            bed.select();

            addName(anchorNode,bed,"Drawer");
        }else if(selected==3){
            TransformableNode bed=new TransformableNode(arFragment.getTransformationSystem());
            bed.setParent(anchorNode);
            bed.setRenderable(roundTableRenderable);
            bed.select();

            addName(anchorNode,bed,"Round  Table");
        }else if(selected==4){
            TransformableNode bed=new TransformableNode(arFragment.getTransformationSystem());
            bed.setParent(anchorNode);
            bed.setRenderable(singleSofaRenderable);
            bed.select();

            addName(anchorNode,bed,"Single Sofa");
        }else if(selected==5){
            TransformableNode bed=new TransformableNode(arFragment.getTransformationSystem());
            bed.setParent(anchorNode);
            bed.setRenderable(sofaRenderable);
            bed.select();

            addName(anchorNode,bed,"Sofa");
        }else if(selected==6){
            TransformableNode bed=new TransformableNode(arFragment.getTransformationSystem());
            bed.setParent(anchorNode);
            bed.setRenderable(stoolRenderable);
            bed.select();

            addName(anchorNode,bed,"Stool");
        }else if(selected==7){
            TransformableNode bed=new TransformableNode(arFragment.getTransformationSystem());
            bed.setParent(anchorNode);
            bed.setRenderable(tableRenderable);
            bed.select();

            addName(anchorNode,bed,"Table");
        }else if(selected==8){
            TransformableNode bed=new TransformableNode(arFragment.getTransformationSystem());
            bed.setParent(anchorNode);
            bed.setRenderable(flatScreenTvRenderable);
            bed.select();

            addName(anchorNode,bed,"Flat Screen TV");
        }else if(selected==9){
            TransformableNode bed=new TransformableNode(arFragment.getTransformationSystem());
            bed.setParent(anchorNode);
            bed.setRenderable(clockRenderable);
            bed.select();

            addName(anchorNode,bed,"Clock");
        }else if(selected==10){
            TransformableNode bed=new TransformableNode(arFragment.getTransformationSystem());
            bed.setParent(anchorNode);
            bed.setRenderable(toiletRenderable);
            bed.select();

            addName(anchorNode,bed,"Toilet");
        }
    }

    private void addName(AnchorNode anchorNode, TransformableNode model, String name) {

        ///each model we will create name
        ViewRenderable.builder().setView(this,R.layout.name_model)
                .build()
                .thenAccept(viewRenderable -> {
                    TransformableNode nameView=new TransformableNode(arFragment.getTransformationSystem());
                    nameView.setLocalPosition(new Vector3(0f,model.getLocalPosition().y+0.5f,0));
                    nameView.setParent(anchorNode);
                    nameView.setRenderable(viewRenderable);
                    nameView.select();


                    /////SET TEXT
                    TextView text_name=(TextView) viewRenderable.getView();
                    text_name.setText(name);
                    /////click to textview to remove animal
                    text_name.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            anchorNode.setParent(null);
                        }
                    });

                });

            }

    private void setClickListner() {
        for(int i=0;i<arrayView.length;i++){
            arrayView[i].setOnClickListener(this);
        }
    }

    private void setArrayView() {
        arrayView=new View[]{
                bed,drawer,roundTable,singleSofa,sofa,stool,table,flatScreenTv,clock,toilet
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