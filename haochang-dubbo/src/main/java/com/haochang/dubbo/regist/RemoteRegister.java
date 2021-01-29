package com.haochang.dubbo.regist;

import com.haochang.dubbo.util.URL;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 描述：远程注册
 * @author: youzhi.gao
 * @date: 2021-01-28 17:18
 */
public class RemoteRegister {
    private static Map<String, List<URL>> remoteMap = new HashMap<>();

    public static void regist(String interfaceName, URL url){
        List<URL> urls = remoteMap.get(interfaceName);
        if(null == urls){
            urls = new ArrayList();
        }

        urls.add(url);
        remoteMap.put(interfaceName, urls);

        saveFile();
    }

    private static void saveFile() {
        try {
            FileOutputStream outputStream = new FileOutputStream("/temp.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(remoteMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<URL> get(String interfaceName){
        remoteMap = getFile();
        List<URL> urls = remoteMap.get(interfaceName);
        return urls;
    }

    private static Map<String, List<URL>> getFile() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("/temp.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj = objectInputStream.readObject();
            return (Map<String, List<URL>>) obj;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null != fileInputStream){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
