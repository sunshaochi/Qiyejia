package com.boyuanitsm.echinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangbin on 17/2/23.
 */
public class ConstantValue {

    public static List<String> datas;

    public static Map<String, List<String>> map;

    /**
     * 行业一级
     *
     * @return
     */
    public static List<String> getIndustyList() {
        if (datas == null) {
            datas = new ArrayList<>();
            datas.add("不限行业");
            datas.add("农、林、牧、渔业");
            datas.add("采矿业");
            datas.add("制造业");
            datas.add("电力、热力、燃气及水生产和供应业");
            datas.add("建筑业");
            datas.add("批发和零售业");
            datas.add("交通运输、仓储和邮政业");
            datas.add("住宿和餐饮业");
            datas.add("信息传输、软件和信息技术服务业");
            datas.add("金融业");
            datas.add("房地产业");
            datas.add("租赁和商务服务业");
            datas.add("科学研究和技术服务业");
            datas.add("水利、环境和公共设施管理业");
            datas.add("居民服务、修理和其他服务业");
            datas.add("教育");
            datas.add("卫生和社会工作");
            datas.add("文化、体育和娱乐业");
            datas.add("公共管理、社会保障和社会组织");
            datas.add("国际组织");
        }
        return datas;
    }

    /**
     * 获取整体
     *
     * @return
     */
    public static Map<String, List<String>> getIndustyMap() {
        if (map == null) {

            map = new HashMap<>();
            List<String> list0 = new ArrayList<>();
            list0.add("不限行业");
            map.put("不限行业", list0);


            List<String> list1 = new ArrayList<>();
            list1.add("农业");
            list1.add("林业");
            list1.add("畜牧业");
            list1.add("渔业");
            list1.add("农、林、牧、渔服务业");
            map.put("农、林、牧、渔业", list1);

            List<String> list2 = new ArrayList<>();
            list2.add("煤炭开采和洗选业");
            list2.add("石油和天然气开采业");
            list2.add("黑色金属矿采选业");
            list2.add("有色金属矿采选");
            list2.add("非金属矿采选业");
            list2.add("开采辅助活动");
            list2.add("其他采矿业");
            map.put("采矿业", list2);

            List<String> list3 = new ArrayList<>();
            list3.add("农副食品加工业");
            list3.add("食品制造业");
            list3.add("酒、饮料和精制茶制造业");
            list3.add("烟草制品业");
            list3.add("纺织业");
            list3.add("纺织服装、服饰业");
            list3.add("皮革、毛皮、羽毛及其制品和制鞋业");
            list3.add("木材加工和木、竹、藤、棕、草制品业");
            list3.add("家具制造业");
            list3.add("造纸和纸制品业");
            list3.add("印刷和记录媒介复制业");
            list3.add("文教、工美、体育和娱乐用品制造业");
            list3.add("石油加工、炼焦和核燃料加工业");
            list3.add("化学原料和化学制品制造业");
            list3.add("医药制造业");
            list3.add("化学纤维制造业");
            list3.add("橡胶和塑料制品业");
            list3.add("非金属矿物制品业");
            list3.add("黑色金属冶炼和压延加工业");
            list3.add("有色金属冶炼和压延加工业");
            list3.add("金属制品业");
            list3.add("通用设备制造业");
            list3.add("专用设备制造业");
            list3.add("汽车制造业");
            list3.add("铁路、船舶、航空航天和其他运输设备制造业");
            list3.add("电气机械和器材制造业");
            list3.add("计算机、通信和其他电子设备制造业");
            list3.add("仪器仪表制造业");
            list3.add("其他制造业");
            list3.add("废弃资源综合利用业");
            list3.add("金属制品、机械和设备修理业");
            map.put("制造业", list3);


            List<String> list4 = new ArrayList<>();
            list4.add("电力、热力生产和供应业");
            list4.add("燃气生产和供应业");
            list4.add("水的生产和供应业");
            map.put("电力、热力、燃气及水生产和供应业", list4);

            List<String> list5 = new ArrayList<>();
            list5.add("房屋建筑业");
            list5.add("土木工程建筑业");
            list5.add("建筑安装业");
            list5.add("建筑装饰和其他建筑业");
            map.put("建筑业", list5);

            List<String> list6 = new ArrayList<>();
            list6.add("批发业");
            list6.add("零售业");
            map.put("批发和零售业", list6);

            List<String> list7 = new ArrayList<>();
            list7.add("铁路运输业");
            list7.add("道路运输业");
            list7.add("航空运输业");
            list7.add("管道运输业");
            list7.add("装卸搬运和运输代理业");
            list7.add("仓储业");
            list7.add("邮政业");
            map.put("交通运输、仓储和邮政业", list7);

            List<String> list8 = new ArrayList<>();
            list8.add("住宿业");
            list8.add("餐饮业");
            map.put("住宿和餐饮业", list8);

            List<String> list9 = new ArrayList<>();

            list9.add("电信、广播电视和卫星传输服务");
            list9.add("互联网和相关服务");
            list9.add("软件和信息技术服务业");
            map.put("信息传输、软件和信息技术服务业", list9);

            List<String> list10 = new ArrayList<>();
            list10.add("货币金融服务");
            list10.add("资本市场服务");
            list10.add("保险业");
            list10.add("其他金融业");
            map.put("金融业", list10);


            List<String> list11 = new ArrayList<>();
            list11.add("租赁业");
            list11.add("商务服务业");
            map.put("租赁和商务服务业", list11);

            List<String> list12 = new ArrayList<>();
            list12.add("研究和试验发展");
            list12.add("专业技术服务业");
            list12.add("科技推广和应用服务业");
            map.put("科学研究和技术服务业", list12);

            List<String> list13 = new ArrayList<>();
            list13.add("水利管理业");
            list13.add("生态保护和环境治理业");
            list13.add("公共设施管理业");
            map.put("水利、环境和公共设施管理业", list13);

            List<String> list14 = new ArrayList<>();
            list14.add("居民服务业");
            list14.add("机动车、电子产品和日用产品修理业");
            list14.add("其他服务业");
            map.put("居民服务、修理和其他服务业", list14);

            List<String> list15 = new ArrayList<>();
            list15.add("卫生");
            list15.add("社会工作");
            map.put("卫生和社会工作", list15);

            List<String> list16 = new ArrayList<>();
            list16.add("新闻和出版业");
            list16.add("广播、电视、电影和影视录音制作业");
            list16.add("文化艺术业");
            list16.add("体育");
            list16.add("娱乐业");
            map.put("文化、体育和娱乐业", list16);

            List<String> list17 = new ArrayList<>();
            list17.add("中国共产党机关");
            list17.add("国家机构");
            list17.add("人民政协、民主党派");
            list17.add("社会保障");
            list17.add("群众团体、社会团体和其他成员组织");
            list17.add("基层群众自治组织");
            map.put("公共管理、社会保障和社会组织", list17);

            List<String> list18 = new ArrayList<>();
            list18.add("国际组织");
            map.put("国际组织", list18);


        }
        return map;
    }
}
