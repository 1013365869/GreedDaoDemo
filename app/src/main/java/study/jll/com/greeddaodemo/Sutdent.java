package study.jll.com.greeddaodemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by jll on 2018/11/30.
 *
 *
 * 实体@Entity注解

 schema：告知GreenDao当前实体属于哪个schema
 active：标记一个实体处于活跃状态，活动实体有更新、删除和刷新方法
 nameInDb：在数据库中使用的别名，默认使用的是实体的类名
 indexes：定义索引，可以跨越多个列
 createInDb：标记创建数据库表

 基础属性注解

 @Id：主键 Long 型，可以通过@Id(autoincrement = true)设置自增长
 @Property：设置一个非默认关系映射所对应的列名，默认是使用字段名，例如：@Property(nameInDb = "name")
 @NotNull：设置数据库表当前列不能为空
 @Transient：添加此标记后不会生成数据库表的列

 索引注解

 @Index：使用@Index作为一个属性来创建一个索引，通过name设置索引别名，也可以通过unique给索引添加约束
 @Unique：向数据库添加了一个唯一的约束

 关系注解

 @ToOne：定义与另一个实体（一个实体对象）的关系
 @ToMany：定义与多个实体对象的关系

 */
@Entity
public class Sutdent {

    @Id(autoincrement = true)
    private Long id;

    @Unique
    String uuid;
    private String waypointList;
    private int waypointStatu;

    @Generated(hash = 1846463053)
    public Sutdent(Long id, String uuid, String waypointList, int waypointStatu) {
        this.id = id;
        this.uuid = uuid;
        this.waypointList = waypointList;
        this.waypointStatu = waypointStatu;
    }
    @Generated(hash = 1303725622)
    public Sutdent() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUuid() {
        return this.uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getWaypointList() {
        return this.waypointList;
    }
    public void setWaypointList(String waypointList) {
        this.waypointList = waypointList;
    }
    public int getWaypointStatu() {
        return this.waypointStatu;
    }
    public void setWaypointStatu(int waypointStatu) {
        this.waypointStatu = waypointStatu;
    }

    @Override
    public String toString() {
        return "Sutdent{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", waypointList='" + waypointList + '\'' +
                ", waypointStatu=" + waypointStatu +
                '}';
    }
}
