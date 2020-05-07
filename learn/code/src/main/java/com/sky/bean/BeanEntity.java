package com.sky.bean;

/**
 * @Auther: HJH
 * @Date: 2019/8/27
 * @Description: TODO
 */
public class BeanEntity {

    private Integer a;

    private Integer b;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BeanEntity)) return false;

        BeanEntity that = (BeanEntity) o;

        if (a != null ? !a.equals(that.a) : that.a != null) return false;
        return b != null ? b.equals(that.b) : that.b == null;
    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        return result;
    }
}
