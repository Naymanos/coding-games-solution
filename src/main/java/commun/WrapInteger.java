package commun;

public class WrapInteger {
    private Integer integer;

    public WrapInteger() {

    }

    public WrapInteger(Integer integer) {
        this.integer = integer;
    }

    public WrapInteger(WrapInteger wrapInteger) {
        if (wrapInteger != null) {
            this.integer = wrapInteger.getInteger();
        } else {
            this.integer = null;
        }
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public void setWrapInteger(WrapInteger wrapInteger) {
        if (wrapInteger != null) {
            this.integer = wrapInteger.getInteger();
        } else {
            this.integer = null;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof WrapInteger) {
            return ((WrapInteger) obj).getInteger() == this.getInteger();
        } else {
            return false;
        }
    }
}

