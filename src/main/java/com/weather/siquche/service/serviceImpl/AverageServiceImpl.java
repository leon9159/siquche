package com.weather.siquche.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weather.siquche.mapper.AverageMapper;
import com.weather.siquche.povo.po.AverageData;
import com.weather.siquche.povo.vo.AqiVo;
import com.weather.siquche.povo.vo.LargeVO;
import com.weather.siquche.service.IAverageService;
import com.weather.siquche.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AverageServiceImpl extends ServiceImpl<AverageMapper, AverageData> implements IAverageService {
    @Autowired
    private AverageMapper averageMapper;

    /**
     * 获取大数据图
     * @return
     */
    public Object getLarge(){
        QueryWrapper<AverageData> qw = new QueryWrapper<>();
        qw.select("pm25","pm10","so2","no2","co","o3","aqi","date");
        List<AverageData> ls = averageMapper.selectList(qw);
        LargeVO largeVO = new LargeVO();
        largeVO.setPm25(ls.stream().map(datas ->datas.getPm25())
                .collect(Collectors.toList()));
        largeVO.setPm10(ls.stream().map(datas -> datas.getPm10())
                .collect(Collectors.toList()));
        largeVO.setSo2(ls.stream().map(datas -> datas.getSo2())
                .collect(Collectors.toList()));
        largeVO.setNo2(ls.stream().map(datas -> datas.getNo2())
                .collect(Collectors.toList()));
        largeVO.setCo(ls.stream().map(datas -> datas.getCo())
                .collect(Collectors.toList()));
        largeVO.setO3(ls.stream().map(datas -> datas.getO3())
                .collect(Collectors.toList()));
        largeVO.setAQI(ls.stream().map(datas -> datas.getAqi())
                .collect(Collectors.toList()));
        largeVO.setDate(ls.stream().map(datas-> datas.getDate())
                .collect(Collectors.toList()));
        return largeVO;
    }

    /**
     * 按年分类统计
     * @return
     */
    public Object getAqiByYear(){
        LocalDate start = LocalDate.parse("2012-12-31");
        LocalDate end = LocalDate.parse("2017-12-31");
        LocalDate date = LocalDate.parse("2013-01-01");
        QueryWrapper<AverageData> qw =null;
        List<AqiVo> aqiVos = new ArrayList<>();
        while(date.isAfter(start)&&date.isBefore(end)){
            Double aqi = 0.00;
            String dateStart = date.toString();
            String dateEnd = date.plusYears(1).toString();
            qw = new QueryWrapper<>();
            qw.select("id","date","aqi").ge("date",dateStart).lt("date",dateEnd);
            List<AverageData> ave = averageMapper.selectList(qw);
            AqiVo aqiVo = new AqiVo();
            for(int i=0;i<ave.size();i++){
                aqi = aqi+ave.get(i).getAqi();
            }
            aqiVo.setAqi(Util.doubleTwo(aqi/ave.size()));
            aqiVo.setDate(String.valueOf(date.getYear()));
            aqiVos.add(aqiVo);
            date = date.plusYears(1);
        }
        return  aqiVos;
    }

    /**
     * 根据季节对AQI分类
     * @return
     */
    public Object getAqiByMonth(){
        QueryWrapper<AverageData> qw = new QueryWrapper<>();
        qw.select("date","aqi");
        List<AverageData> averageData = averageMapper.selectList(qw);
        List<AqiVo> aqiVos = new ArrayList<>();
        int a,b,c,d;
        a=b=c=d=0;
        Double aa,bb,cc,dd;
        aa=bb=cc=dd=0.00;
        for(int i=0;i<averageData.size();i++){
            if(Util.season(LocalDate.parse(averageData.get(i).getDate()))=="春"){
                a++;
                aa = aa+averageData.get(i).getAqi();
            }else if (Util.season(LocalDate.parse(averageData.get(i).getDate()))=="夏"){
                b++;
                bb = bb +averageData.get(i).getAqi();
            }else if (Util.season(LocalDate.parse(averageData.get(i).getDate()))=="秋"){
                c++;
                cc = cc +averageData.get(i).getAqi();
            }else if (Util.season(LocalDate.parse(averageData.get(i).getDate()))=="冬"){
                d++;
                dd = dd +averageData.get(i).getAqi();
            }
        }
        AqiVo aqiVoa = new AqiVo();
        aqiVoa.setDate("春");
        aqiVoa.setAqi(Util.doubleTwo(aa/a));
        aqiVos.add(aqiVoa);
        AqiVo aqiVob = new AqiVo();
        aqiVob.setDate("夏");
        aqiVob.setAqi(Util.doubleTwo(bb/b));
        aqiVos.add(aqiVob);
        AqiVo aqiVoc = new AqiVo();
        aqiVoc.setDate("秋");
        aqiVoc.setAqi(Util.doubleTwo(cc/c));
        aqiVos.add(aqiVoc);
        AqiVo aqiVod = new AqiVo();
        aqiVod.setDate("冬");
        aqiVod.setAqi(Util.doubleTwo(dd/d));
        aqiVos.add(aqiVod);
        return  aqiVos;
    }

    /**
     * 根据周分类
     * @return
     */
    public Object getAqiByWeek(){
        List<AqiVo> aqiVos = new ArrayList<>();
        QueryWrapper<AverageData> qw = new QueryWrapper<>();
        qw.select("aqi","week");
        List<AverageData> averageData = averageMapper.selectList(qw);
        Double a,b,c,d,e,f,g;
        a=b=c=d=e=f=g=0.00;
        for(int i=0;i<averageData.size();i++){
            if (averageData.get(i).getWeek().equals("星期一")){
                a = a+averageData.get(i).getAqi();
            }else if(averageData.get(i).getWeek().equals("星期二")){
                b = b +averageData.get(i).getAqi();
            }else if(averageData.get(i).getWeek().equals("星期三")){
                c = c +averageData.get(i).getAqi();
            }else if(averageData.get(i).getWeek().equals("星期四")){
                d = d +averageData.get(i).getAqi();
            }else if(averageData.get(i).getWeek().equals("星期五")){
                e = e +averageData.get(i).getAqi();
            }else if(averageData.get(i).getWeek().equals("星期六")){
                f = f +averageData.get(i).getAqi();
            }else if(averageData.get(i).getWeek().equals("星期日")){
                g = g +averageData.get(i).getAqi();
            }
        }
        AqiVo aqiVoa = new AqiVo();
        AqiVo aqiVob = new AqiVo();
        AqiVo aqiVoc = new AqiVo();
        AqiVo aqiVod = new AqiVo();
        AqiVo aqiVoe = new AqiVo();
        AqiVo aqiVof = new AqiVo();
        AqiVo aqiVog = new AqiVo();
        aqiVoa.setDate("星期一");
        aqiVoa.setAqi(Util.doubleTwo(a/209));
        aqiVos.add(aqiVoa);
        aqiVob.setDate("星期二");
        aqiVob.setAqi(Util.doubleTwo(b/209));
        aqiVos.add(aqiVob);
        aqiVoc.setDate("星期三");
        aqiVoc.setAqi(Util.doubleTwo(c/208));
        aqiVos.add(aqiVoc);
        aqiVod.setDate("星期四");
        aqiVod.setAqi(Util.doubleTwo(d/208));
        aqiVos.add(aqiVod);
        aqiVoe.setDate("星期五");
        aqiVoe.setAqi(Util.doubleTwo(e/209));
        aqiVos.add(aqiVoe);
        aqiVof.setDate("星期六");
        aqiVof.setAqi(Util.doubleTwo(f/209));
        aqiVos.add(aqiVof);
        aqiVog.setDate("星期日");
        aqiVog.setAqi(Util.doubleTwo(g/209));
        aqiVos.add(aqiVog);
        return aqiVos;
    }
}
