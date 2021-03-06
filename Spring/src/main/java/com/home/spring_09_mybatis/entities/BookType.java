package com.home.spring_09_mybatis.entities;

public class BookType {
    /**
     * 编号
     */
    private int id;
    /**
     * 类型名
     */
    private String typeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    @Override
    public String toString() {
        return this.getId()+"\t"+this.getTypeName();
    }
}
