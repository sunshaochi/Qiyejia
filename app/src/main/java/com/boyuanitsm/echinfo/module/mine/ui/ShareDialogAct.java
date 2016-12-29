package com.boyuanitsm.echinfo.module.mine.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;

import butterknife.OnClick;

/**
 * 分享
 * Created by Yang on 2016/12/29 0029.
 */
public class ShareDialogAct extends BaseAct {
    String title = "测试分享标题";
    String content = "测试分享内容";
    String url = "http://www.baidu.com";
//    private UMImage image;

    @Override
    public int getLayout() {
        return R.layout.act_sharedialog;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = (int) (defaultDisplay.getWidth() * 1.0);
        getWindow().setGravity(Gravity.BOTTOM);
//        image=new UMImage(this,
//                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
    }

    @OnClick({R.id.tvWx, R.id.tvWxFri, R.id.tvWb, R.id.tvCancel})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvCancel:
                finish();
                break;
            case R.id.tvWx:
//                new ShareAction(this)
//                        .setPlatform(SHARE_MEDIA.WEIXIN)
//                        .setCallback(umShareListener)
//                        .withText(content)
//                        .withTargetUrl(url)
//                        .withMedia(image)
//                        .withTitle(title)
//                        .share();
                break;
            case R.id.tvWxFri:
//                new ShareAction(this)
//                        .setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
//                        .setCallback(umShareListener)
//                        .withText(content)
//                        .withTargetUrl(url)
//                        .withMedia(image)
//                        .withTitle(title)
//                        .share();
                break;
            case R.id.tvWb:
//                new ShareAction(this)
//                        .setPlatform(SHARE_MEDIA.SINA)
//                        .setCallback(umShareListener)
//                        .withText(content)
//                        .withTargetUrl(url)
//                        .withTitle(title)
//                        .share();
                break;
        }
    }

//    private UMShareListener umShareListener = new UMShareListener() {
//        @Override
//        public void onResult(SHARE_MEDIA platform) {
//            MyToastUtils.showShortToast(getApplicationContext(), "分享成功");
//        }
//
//        @Override
//        public void onError(SHARE_MEDIA platform, Throwable t) {
//            MyToastUtils.showShortToast(getApplicationContext(), "分享失败");
//        }
//
//        @Override
//        public void onCancel(SHARE_MEDIA platform) {
////            MyToastUtils.showShortToast(getApplicationContext(), "分享取消");
//        }
//    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /** attention to this below ,must add this**/
//        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

}
