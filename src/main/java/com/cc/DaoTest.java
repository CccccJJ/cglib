package com.cc;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class DaoTest {

    public static void main(String[] args) {
        // 代理类 class 文件存入本地磁盘，可反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/cc/downloads");

        DaoProxy daoProxy = new DaoProxy();
        DaoAnotherProxy daoAnotherProxy = new DaoAnotherProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallbacks(new Callback[]{daoProxy, daoAnotherProxy, NoOp.INSTANCE});
        enhancer.setCallbackFilter(new DaoFilter());

        Dao dao = (Dao) enhancer.create();
        dao.update();
        dao.select();
    }
}
