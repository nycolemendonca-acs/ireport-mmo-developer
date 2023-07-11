package com.ireport.mmodev.model;

import java.io.Serializable;

public abstract class AbstratctModel<Id extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;

    public abstract Id getId();

    public abstract void setId(Id id);

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
