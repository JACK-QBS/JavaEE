package com.qbs.bean;

/**
 * 将数据库中的表映射成 Java对象，库表名称映射出 java类的名称
 * （Java 中的属性名和数据库中的字段名保持一致）
 */
public class Student {
    private Integer SID;
    private String Sname;
    private String Ssex;
    private Integer Sage;

    public Integer getSID() {
        return SID;
    }

    public void setSID(Integer SID) {
        this.SID = SID;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public Integer getSage() {
        return Sage;
    }

    public void setSage(Integer sage) {
        Sage = sage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "SID=" + SID +
                ", Sname='" + Sname + '\'' +
                ", Ssex='" + Ssex + '\'' +
                ", Sage=" + Sage +
                '}';
    }
}
