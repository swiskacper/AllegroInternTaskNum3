package com.swiskacper.AllegroInternTask.LanguagesInRepos;

import com.swiskacper.AllegroInternTask.utils.MapUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class LanguagesInRepoModel {
    final ArrayList<String> nameList = new ArrayList<>();
    ArrayList<Integer> bytesList = new ArrayList<>();
    final Map<String, Integer> result = new HashMap<>();

    public LanguagesInRepoModel() {}

    public void countBytes(String name, int bytes) {
        if (nameList.contains(name)) {
            int idx = nameList.indexOf(name);
            bytesList.set(idx, bytesList.get(idx) + bytes);
        } else {
            nameList.add(name);
            bytesList.add(bytes);
        }
    }

    public Map<String, Integer> getResult() {
        for (int i = 0; i < nameList.size(); i++) {
            result.put(nameList.get(i), bytesList.get(i));
        }
        return MapUtil.sortByValue(result);
    }

    public ArrayList<Integer> getBytesList() {
        return bytesList;
    }

    public void setBytesList(ArrayList<Integer> bytesList) {
        this.bytesList = bytesList;
    }
}
