package cn.xs.sh.telcom.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 遍历mod文件夹存放位置，找出所有mod文件
 * @author kenny_peng
 * @created 2019/7/22 10:41
 */
public class FindAllMods {

    public static List<File> getAllMods(File file){

        List<File> modsList = new ArrayList<File>();

        if(file.exists()){
            if (file.isFile()) {
                //获取文件名
                String fileName = file.getName();
                //获取文件名后缀
                String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
                //如果文件是mod文件，则添加到modsList中
                if(suffix == "mod"){
                    modsList.add(file);
                }
            }else{
                File[] listFile = file.listFiles();

                //listFile长度为0，改文件夹是空文件夹，否则就遍历改文件夹
                if (listFile.length == 0) {
//                    System.out.println(file.getAbsolutePath() + " is null");
                } else {
                    for (int i = 0; i < listFile.length; i++) {
                        getAllMods(listFile[i]);
                    }
                }
            }
        }else{
            System.out.println("文件不存在！");
        }

        return modsList;
    }

}
