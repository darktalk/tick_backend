package com.tick.util;

import com.google.common.base.Supplier;

public class MybatisSupplier implements Supplier<MybatisUtil>  {

    @Override
    public MybatisUtil get() {
        return new MybatisUtil();
    }
}
