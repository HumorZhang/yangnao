package com.example.lkx.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.lkx.pojo.Good;
import com.example.lkx.service.goodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/good")
public class goodController {

    @Autowired
    goodService goodService;

    @RequestMapping("/list")
    public String getGood(Model model){

        List<Good> listgood = goodService.selectAll();
        model.addAttribute("list",listgood);

//        System.out.println(typeJsonArray1);

        return "goodList";

    }

    @RequestMapping("/detail/{id}")
    @ResponseBody
    public JSONObject detail(@PathVariable("id")int id) {


        Good typegood = goodService.selectById(id);
        JSONObject jsonArray = JSONArray.parseObject(JSON.toJSONString(typegood));

   return jsonArray;
    }

    @RequestMapping("/json")
    @ResponseBody
    public JSONArray wxjson(){
        JSONArray array = new JSONArray();
        for(int i = 1;i <= 5;i++) {
            List<Good> typegood = goodService.selectByType(i);//
            JSONArray typeJsonArray = JSONArray.parseArray(JSON.toJSONString(typegood));
            System.out.println(typeJsonArray);

            if(i == 1) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", "lingshi");
                map.put("banner", "http://120.78.189.49:8080/image/c1.png");
                map.put("cate", "零食");
                map.put("detail", typeJsonArray);
                JSONObject typeJsonArray1 = JSONArray.parseObject(JSON.toJSONString(map));
                array.add(typeJsonArray1);
            }
            if(i == 2) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", "shucai");
                map.put("banner", "http://120.78.189.49:8080/image/c1.png");
                map.put("cate", "蔬菜");
                map.put("detail", typeJsonArray);
                JSONObject typeJsonArray2 = JSONArray.parseObject(JSON.toJSONString(map));
                array.add(typeJsonArray2);
            }
            if(i == 3) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", "shuiguo");
                map.put("banner", "http://120.78.189.49:8080/image/c1.png");
                map.put("cate", "水果");
                map.put("detail", typeJsonArray);
                JSONObject typeJsonArray3 = JSONArray.parseObject(JSON.toJSONString(map));
                array.add(typeJsonArray3);
            }
            if(i == 4) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", "yingpin");
                map.put("banner", "http://120.78.189.49:8080/image/c1.png");
                map.put("cate", "饮品");
                map.put("detail", typeJsonArray);
                JSONObject typeJsonArray4 = JSONArray.parseObject(JSON.toJSONString(map));
                array.add(typeJsonArray4);
            }
            if(i == 5) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", "yongpin");
                map.put("banner", "http://120.78.189.49:8080/image/c1.png");
                map.put("cate", "生活用品");
                map.put("detail", typeJsonArray);
                JSONObject typeJsonArray5 = JSONArray.parseObject(JSON.toJSONString(map));
                array.add(typeJsonArray5);
            }



        }
        System.out.println(array);

    return array;
    }

}
