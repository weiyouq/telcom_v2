package cn.xs.sh.telcom.utils;


import cn.xs.sh.telcom.bean.IdentifyUser;

import java.io.File;
import java.util.List;

import static java.lang.System.out;

/**
 * @author kenny_peng
 * @created 2019/7/22 10:53
 */
@SuppressWarnings("unchecked")
public class Test {
    public static void main(String[] args) {
//        File file = new File("F://cms/1/1.txt");
//        String fileName =file.getName();
//        System.out.println(file.getName());
//
//        System.out.println(fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()));
//        IdentifyUser identifyUser = new IdentifyUser();
//        identifyUser.setUserNo("22222222222222222");
//        Test t = new Test();
//        List<IdentifyUser> list = new ArrayList<>();
//        list.add(identifyUser);
//        t.test(list);



//        for (int i =0; i<10; i ++){
//
//        }
        File file1 = new File("F://cms/2.txt");
        out.println(file1.length());

//        System.out.println(identifyUser.getId() == null);

    }


    public static <T> Class obtainParentByTargetClass(Class<T> currentClass) {

        Class<? super T> superclass = currentClass.getSuperclass();
        return superclass;


    }




    public void test(Object supplier){
        for (IdentifyUser identifyUser : (List<IdentifyUser>)supplier){
            out.println(identifyUser.getUserNo());
        }


    }



}
