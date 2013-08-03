package com.rabbit.pm2d5.core.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-8-3
 * Time: 下午9:04
 * To change this template use File | Settings | File Templates.
 */
public class City {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
