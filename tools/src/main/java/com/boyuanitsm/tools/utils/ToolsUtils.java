package com.boyuanitsm.tools.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Util类
 * Created by wangbin on 16/6/1.
 */
public class ToolsUtils {

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
    /**
     * 几年以内
     *
     * @return
     */
    public static String getCurrent(int n) {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd");
//        Date date = new Date();
        int year = Calendar.getInstance().get(Calendar.YEAR);
//        int year = date.getYear();
         int newYear = year - n;
        return newYear+"-"+format.format(new Date());
    }
    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentYmd() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }
    /**
     * 时间戳转化成时间
     *
     * @param time
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String timeToDate(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date(time));

    }



    /**
     * 格式化时间格式
     * @param date
     * @return
     */
    public static String formatTime(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(new Date(date));
    }
    public static String formatOrderTime(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(new Date(date));
    }

    /**
     * 格式化时间格式
     * @return
     */
    public static String formatMyTime(Long time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        String nowTime= format.format(new Date(time));
        int nowDay=Integer.valueOf(nowTime.substring(8,nowTime.length()-1));
        String myDay="";
        if(nowDay+2<10){
            myDay="0"+(nowDay+2);
        }else{
            myDay=(nowDay+2)+"";
        }
        return nowTime.substring(0,8)+myDay+"日";
    }


    /**
     * 时间转成时间戳
     *
     * @return
     */
    public static long dateToTime(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            return 0;
        }
        return date.getTime();
    }


    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     *
     * @param strDate
     * @return
     */
    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }
    /**
     * 获取新增一个月
     * */
    public static List<String> getMonthList(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<String> dateList = new ArrayList<>();
        Date date = new Date();
        dateList.add(formatter.format(date));
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        calendar.add(Calendar.MONTH, 1);
        dateList.add(formatter.format(calendar.getTime()));
        return  dateList;
    }
    /**
     * 获取最近7/30天时间集合
     * @param
     * */
    public static List<String> getDateLists(int day){
        List<String> lists = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();//取时间,今天
        Calendar   calendar   =   new GregorianCalendar();
        for(int i=0;i<day;i++){
            calendar.setTime(date);
            calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
            date=calendar.getTime();   //这个时间就是日期往后推一天的结果
            String daytime = format.format(date);
            calendar.clear();
            lists.add(daytime);
        }
        return lists;
    }
    /**
     * 根据两个时间获取两张中间时间
     * */
    public static List<String> getTimeList(String starTime,String endTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        try {
            Date date1 = sdf.parse(starTime);
            Date date2 = sdf.parse(endTime);
            start.setTime(date1);
            end.setTime(date2);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<String> result = new ArrayList<String>();
        start.add(Calendar.DAY_OF_YEAR, 1);
        while (start.before(end)) {
            result.add(sdf.format(start.getTime()));
            start.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }
    /**
     * 获得手机唯一IMEI
     */
    public static String getPhoneIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String IMEI = telephonyManager.getDeviceId();
        return IMEI;
    }

    /**
     * 获取手机屏幕宽
     *
     * @param activity
     */
    public static int getScreenWidth(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        // float density = metrics.density; // 屏幕密度（0.75 / 1.0 / 1.5）
        // int densityDpi = metrics.densityDpi; // 屏幕密度DPI（120 / 160 / 240）
        return metrics.widthPixels;
    }

    /**
     * @param activity
     */
    public static int getPhoneDensityDpi(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int densityDpi = metrics.densityDpi; // 屏幕密度DPI（120 / 160 / 240）
        return densityDpi;
    }

    /**
     * 获取手机屏幕高
     *
     * @param activity
     */
    public static int getScreenHeight(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);

        return metrics.heightPixels;

    }

    /**
     * 获取屏幕密度 (单位 px)
     */
    public static Point getScreenMeture(Context context) {
        Display mDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
        return new Point(mDisplay.getWidth(), mDisplay.getHeight());
    }

    /**
     * 获取手机状态栏的高度
     */
    public static int getStatusHeight(Context context) {
        // Rect frame = new Rect();
        // activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        // return frame.top;

        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            return context.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return 0;
    }

    /**
     * 获取当前屏幕旋转角度
     *
     * @param activity
     * @return 0表示是竖屏; 90表示是左横屏; 180表示是反向竖屏; 270表示是右横屏
     */
    public static int getScreenRotationOnPhone(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        // final Display display = ((WindowManager)
        // context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        switch (display.getRotation()) {
            case Surface.ROTATION_0:
                return 0;

            case Surface.ROTATION_90:
                return 90;

            case Surface.ROTATION_180:
                return 180;

            case Surface.ROTATION_270:
                return -90;
        }
        return 0;
    }

    /**
     * 判断当前是否有可用的网络以及网络类型 0：无网络 1：WIFI 2：CMWAP 3：CMNET
     *
     * @param context
     * @return
     */
    public static int isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return 0;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        NetworkInfo netWorkInfo = info[i];
                        if (netWorkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                            return 1;
                        } else if (netWorkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                            String extraInfo = netWorkInfo.getExtraInfo();
                            if ("cmwap".equalsIgnoreCase(extraInfo) || "cmwap:gsm".equalsIgnoreCase(extraInfo)) {
                                return 2;
                            }
                            return 3;
                        }
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 将指定byte数组转换成16进制字符串
     *
     * @param b
     * @return
     */
    @SuppressLint("DefaultLocale")
    public static String byteToHexString(byte[] b) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            hexString.append(hex.toUpperCase());
        }
        return hexString.toString();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     *
     * @param context 上下文
     * @param dpValue dp值
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     *
     * @param context 上下文
     * @param pxValue 像素值
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 生成0-9的随机数
     *
     * @param count 生成几位数（6位）
     * @return random 随机数
     */

    public static String getRandomNumber(int count) {
        String random = "";
        for (int i = 0; i < count; i++) {
            String str = String.valueOf((int) (Math.random() * 10 - 1));
            random = random + str;
        }
        return random;
    }

    /***
     * 获取MAC地址
     *
     * @return
     */
//    public static String getMacAddress(Context context) {
//        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
//        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
//        if (wifiInfo.getMacAddress() != null) {
//            return wifiInfo.getMacAddress();
//        } else {
//            return "";
//        }
//    }

    /**
     * 获取运行时间
     *
     * @return 运行时间(单位/s)
     */
    public static long getRunTimes() {
        long ut = SystemClock.elapsedRealtime() / 1000;
        if (ut == 0) {
            ut = 1;
        }
        return ut;
    }

    /**
     * 获取当前版本号
     *
     * @return
     */
    public static String getVersion(Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(context.getPackageName(), 0);
            return info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    /**
     * sdcard是否可读写
     */
    public static boolean IsCanUseSdCard() {
        try {
            return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * sim卡是否可读
     *
     * @param context
     * @return
     */
    public static boolean isCanUseSim(Context context) {
        try {
            TelephonyManager mgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

            return TelephonyManager.SIM_STATE_READY == mgr.getSimState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 隐藏软键盘
     *
     * @param context
     */
    public static void hideSoftKeyboard(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        View view = ((Activity) context).getWindow().getDecorView();
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * 根据某个固定的View隐藏软键盘
     *
     * @param context
     * @param v
     */
    public void hideSoftKeyboard(Context context, View v) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    /**
     * 作用：获取当前设备的内核数目
     *
     * @return
     */
    public static int getAvailableProcessorsNum() {
        return Runtime.getRuntime().availableProcessors();
    }

    /**
     * 从下载文件的url中截取文件名
     *
     * @param path
     * @return
     */
    public static String getFileName(String path) {
        if (path == null) {
            return null;
        }
        String fileName = path.substring(path.lastIndexOf("/") + 1, path.length());
        if (fileName == null || "".equals(fileName.trim())) {
            fileName = UUID.randomUUID().toString() + ".tmp"; // 默认名
        }
        return fileName;
    }

    /**
     * 加载本地小图片
     *
     * @param url
     * @return
     */
    public static Bitmap getLocalBitmap(String url) {
        try {
            FileInputStream fis = new FileInputStream(url);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            // return BitmapFactory.decodeStream(fis); //把流转化为Bitmap图片
            return BitmapFactory.decodeStream(fis, null, options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static DisplayMetrics getWindowDisplay(Context context) {

        DisplayMetrics dm = context.getResources().getDisplayMetrics();

        // float density = dm.density; // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
        // int densityDPI = dm.densityDpi; // 屏幕密度（每寸像素：120/160/240/320）
        // float xdpi = dm.xdpi;
        // float ydpi = dm.ydpi;

        return dm;
    }

    /**
     * 获取手机串号，需要权限：
     * <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
     *
     * @param context
     * @return
     */
    public static String getImei(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }

    /**
     * 获取手机系统的版本号
     *
     * @return
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取应用的版本号,默认值为1.0
     *
     * @return 当前应用的版本号
     */
    public static String getAppVersion(Context context) {
        String version = "1.0";
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            version = info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return version;

    }

    /**
     * 获取版本
     *
     * @param context
     * @return
     */
    public static int getAppVer(Context context) {
        int version = 1;
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            version = info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return version;

    }

    /**
     * 调用系统的分享控件
     *
     * @param activity
     * @param content
     */
    public static void shareContent(Context activity, String content) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, content);
        activity.startActivity(intent);
    }

    /**
     * 判断应用是否安装
     *
     * @param context
     * @param packName
     * @return
     */
    public static boolean appInstalled(Context context, String packName) {
        PackageInfo packageInfo;

        try {
            packageInfo = context.getPackageManager().getPackageInfo(packName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        }

        return packageInfo == null ? false : true;
    }

    /**
     * 判断某个服务是不是活着
     *
     * @param mContext
     * @param serviceName
     * @return
     */
    public static boolean isServiceWork(Context mContext, String serviceName) {

        boolean isWork = false;
        ActivityManager myAM = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> myList = myAM.getRunningServices(50);
        if (myList.size() <= 0) {
            return false;
        }
        for (int i = 0; i < myList.size(); i++) {
            String mName = myList.get(i).service.getClassName().toString();
            if (mName.equals(serviceName)) {
                isWork = true;
                break;
            }
        }
        return isWork;
    }

    /**
     * @param context 上下文
     *                要校验Activity的名称
     * @return true Activity还运行，false
     */
    public static boolean isRunningActivity(Context context, String actName) {
        // ActivityManager
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTasks = am.getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                String name = runningTaskInfo.topActivity.getClassName();
                if (actName.equals(name)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 提供精确的加法运算。
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */

    public static double add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 检查手机上是否安装了指定的软件
     * @param context
     * @param packageName：应用包名
     * @return
     */
    public static boolean isAvilible(Context context, String packageName){
        //获取packagemanager
        final PackageManager packageManager = context.getPackageManager();
        //获取所有已安装程序的包信息
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        //用于存储所有已安装程序的包名
        List<String> packageNames = new ArrayList<String>();
        //从pinfo中将包名字逐一取出，压入pName list中
        if(packageInfos != null){
            for(int i = 0; i < packageInfos.size(); i++){
                String packName = packageInfos.get(i).packageName;
                packageNames.add(packName);
            }
        }
        //判断packageNames中是否有目标程序的包名，有TRUE，没有FALSE
        return packageNames.contains(packageName);
    }

    /**
     * 判断输入是否是中文
     * @param input
     * @return
     */
    public static boolean isInputChinese(String input){
        Pattern pattern = Pattern.compile("^[\u4e00-\u9fa5]*$");
        Matcher matcher = pattern.matcher(input);
        return  matcher.matches();//true全部为汉字，否则是false
    }
    /**
     * 验证手机号是否正确
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles){
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 判断邮箱是否合法
     * @param email
     * @return
     */
    public static boolean isEmail(String email){
        if (null==email || "".equals(email))
            return false;
        //Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
        Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 打开输入法
     * @param context
     * @param editText
     */
    public static void openKeyboard(Context context, View editText){
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(editText, 0);
    }

    /**
     * 关闭软键盘
     * @param context
     * @param editText
     */
    public static void closeKeyboard(Context context, View editText){
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }



}
