package com.boyuanitsm.echinfo.module.mine.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.UserBean;
import com.boyuanitsm.echinfo.module.mine.presenter.MineMsgPre;
import com.boyuanitsm.echinfo.module.mine.presenter.MineMsgPreImpl;
import com.boyuanitsm.echinfo.module.mine.view.IMineMsgView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.MineItemView;
import com.boyuanitsm.echinfo.widget.crop.CropImageActivity;
import com.boyuanitsm.tools.utils.MyBitmapUtils;
import com.boyuanitsm.tools.utils.MyLogUtils;
import com.boyuanitsm.tools.view.CircleImageView;
import com.boyuanitsm.tools.view.MySelfSheetDialog;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的界面
 * Created by Yang on 2016/12/27 0027.
 */
public class MineAct extends BaseAct<MineMsgPre> implements IMineMsgView{
    @BindView(R.id.civ_head)
    CircleImageView civ_head;//头像
    @BindView(R.id.miv_phone)
    MineItemView miv_phone;//电话
    @BindView(R.id.miv_changePwd)
    MineItemView miv_changePwd;//改密码
    @BindView(R.id.miv_name)
    MineItemView miv_name;//姓名
    @BindView(R.id.miv_company)
    MineItemView miv_company;//公司
    @BindView(R.id.miv_profession)
    MineItemView miv_profession;//职业
    UserBean userBean;

    private String photoSavePath;//图片路径
    private String photoSaveName;//图片名字
    public static final int PHOTOZOOM = 0;//相册
    public static final int PHOTOTAKE = 1;//相机
    public static final int IMAGE_COMPLETE = 2; // 结果
    Uri imageUri = null;
    @Override
    public int getLayout() {
        return R.layout.act_mine;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("修改资料");
        mPresenter=new MineMsgPreImpl(this);
        userBean=new UserBean();
        userBean = EchinfoUtils.getCurrentUser();
        //填充个人资料
        initData(userBean);
        //与上传图片有关的
        photoSavePath = Environment.getExternalStorageDirectory().getPath() + "/ClipHeadPhoto/cache/";
        File tempFile = new File(photoSavePath);
        if (!tempFile.exists()) {
            tempFile.mkdirs();
        }
    }

    /**
     * 填充个人资料
     * @param userBean
     */
    private void initData(UserBean userBean) {
        if (!TextUtils.isEmpty(userBean.getIcon())){

        }
        if (!TextUtils.isEmpty(userBean.getPhone())){
            miv_phone.setLeftText(userBean.getPhone());
        }
        if (!TextUtils.isEmpty(userBean.getName())){
            miv_name.setRightText(userBean.getName());
        }
        if (!TextUtils.isEmpty(userBean.getCompanyName())){
            miv_company.setRightText(userBean.getCompanyName());
        }
        if (!TextUtils.isEmpty(userBean.getJob())){
            miv_profession.setRightText(userBean.getJob());
        }
    }

    @OnClick({R.id.ll_head, R.id.miv_phone, R.id.miv_changePwd, R.id.miv_name, R.id.miv_company
            , R.id.miv_profession})
    public void OnClick(View v) {
        Bundle bundle;
        switch (v.getId()) {
            case R.id.ll_head://头像
                headIconDialog();//上传图片
                break;
            case R.id.miv_phone:
                break;
            case R.id.miv_changePwd:
                bundle = new Bundle();
                bundle.putInt(EditAct.USER_TYPE,1);
                openActivity(EditAct.class,bundle);
                break;
            case R.id.miv_name:
                bundle = new Bundle();
                bundle.putInt(EditAct.USER_TYPE,2);
                openActivity(EditAct.class,bundle);
                break;
            case R.id.miv_company:
                bundle = new Bundle();
                bundle.putInt(EditAct.USER_TYPE,3);
                openActivity(EditAct.class,bundle);
                break;
            case R.id.miv_profession:
                bundle = new Bundle();
                bundle.putInt(EditAct.USER_TYPE,4);
                openActivity(EditAct.class,bundle);
                break;
        }
    }

    /**
     * 上传图片
     */
    private void headIconDialog() {
        MySelfSheetDialog dialog = new MySelfSheetDialog(MineAct.this);
        dialog.builder().addSheetItem("拍照", MySelfSheetDialog.SheetItemColor.Blue, new MySelfSheetDialog.OnSheetItemClickListener() {
            @Override
            public void onClick(int which) {
                String state = Environment.getExternalStorageState();
                if(state.equals(Environment.MEDIA_MOUNTED)){
                    photoSaveName = String.valueOf(System.currentTimeMillis()) + ".png";
                    Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    imageUri = Uri.fromFile(new File(photoSavePath, photoSaveName));
//                        openCameraIntent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
                    openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(openCameraIntent, PHOTOTAKE);


                }else {
                    toast("储存卡不存在");
                }

            }
        }).addSheetItem("从相册取", MySelfSheetDialog.SheetItemColor.Blue, new MySelfSheetDialog.OnSheetItemClickListener() {
            @Override
            public void onClick(int which) {
                Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
                openAlbumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(openAlbumIntent, PHOTOZOOM);
            }
        }).show();
    }
    /**
     * 返回的Path
     */
    private String temppath;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = null;
        Intent intent = null;
        switch (requestCode){
            case PHOTOZOOM:// 相册
                if (resultCode != RESULT_OK) {
                    return;
                }
                if (data == null) {
                    return;
                }
                uri = data.getData();
                Bitmap userbitmap = MyBitmapUtils.decodeUriAsBitmap(this, uri);
                if (userbitmap==null){
                  toast("图片有误，请重新选择！");
                    return;
                }
                File user_head =MyBitmapUtils.saveBitmap(MyBitmapUtils.zoomImgKeepWH(userbitmap, 400, 400, true), "user_head.jpeg");
                intent = new Intent(this, CropImageActivity.class);
                intent.putExtra("path", Environment.getExternalStorageDirectory() + "/" + "user_head.jpeg");
                MyLogUtils.info("相册图片地址是：" + Environment.getExternalStorageDirectory() + "/" + "user_head.jpeg");
                startActivityForResult(intent, IMAGE_COMPLETE);
                break;
            case PHOTOTAKE:// 拍照
                if (resultCode != RESULT_OK) {
                    return;
                }
                String path = photoSavePath + photoSaveName;
                Intent intent2 = new Intent(this, CropImageActivity.class);
                intent2.putExtra("path", path);
                MyLogUtils.info("拍照地址是=====："+path);
                startActivityForResult(intent2, IMAGE_COMPLETE);
                break;
            case IMAGE_COMPLETE:// 完成
                if(data!=null) {
                    temppath = data.getStringExtra("path");
                    mPresenter.upLoadIcon(temppath);
                    civ_head.setImageBitmap(MyBitmapUtils.LoadBigImg(temppath, 120, 120));//展示大图片
                }
                break;
        }
    }


    private MyReceiver myReceiver;
    public static final String USER_INFO = "com.update.userinfo";

    @Override
    public void upLoadHeadSucess(String sucessMsg) {

    }

    @Override
    public void upLoadHeadFaild(int status, String errorMsg) {

    }

    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            userBean = EchinfoUtils.getCurrentUser();
            initData(userBean);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
//        getKnowSomebody();//获取可能认识的人列表
        if (myReceiver == null) {
            myReceiver = new MyReceiver();
            registerReceiver(myReceiver, new IntentFilter(USER_INFO));
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (myReceiver != null) {
            unregisterReceiver(myReceiver);
            myReceiver = null;
        }
    }

}
