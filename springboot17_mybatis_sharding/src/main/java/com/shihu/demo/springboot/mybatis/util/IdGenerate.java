package com.shihu.demo.springboot.mybatis.util;

public class IdGenerate extends IdGenerateAbstract {
    private static IdGenerate idGenerate=new IdGenerate();

    @Override
    protected Integer getServerId() {
        return 1;
    }

    public static long getUid(){
        return idGenerate.getUniqueID();
    }
}
