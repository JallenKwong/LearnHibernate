# LearnHibernate #

[Hibernate Reference Documentation](http://docs.jboss.org/hibernate/orm/4.3/manual/en-US/html_single/)

# 预备工作 #

MySQL 5.5 

创建learnhibernate数据库

# Hibernate基础教程目录 #

- [ORM与Hibernate](#)

- [Hibernate入门](#)

- [Hibernate体系结构](#)

- [深入Hibernate配置文件](#)

- [深入理解持久化对象](#)

- [深入Hibernate的映射文件](#)

- [映射组件属性](#)

- [使用注解标注实体](#)

# Hibernate高级教程目录 #



# 为了使用Hibernate进行持久化操作 #

- 开发持久类，由POJO加映射文件组成
- 获取Configuration
- 获取SessionFactory
- 获取Session，打开事务
- 用面向对象的方式操作数据库
- 关闭事务，关闭Session

# 随PO与Session的关联关系，PO有三个状态 #

- 瞬时Transient：PO实例未与Session关联过
- 持久化Persistent：若PO实例与Session关联起来，且该实例对应到数据库记录
- 脱管Detached：若PO实例曾与Session关联过，但因为Session关闭，PO脱离了Session管理

![](image/state.png)

# Hibernate与JDBC操作数据库的方式，有两个显著优点： #

- 无需使用过多SQL语句，而且允许OO方式访问数据库
- JDBC访问构成中大量checked异常被包装成Hibernate的Runtime异常，从而不再要求程序必须处理所有异常。

# Hibernate 架构 #

![](image/overview.png)

![](image/lite.png)

![](image/full_cream.png)

# Hibernate配置方式 #

- hibernate.properties
- hibernate.cfg.xml
- 不使用任何配置文件，以硬编码方式创建Configuration

# load()方法和get()方法的主要区别在于是否延迟加载 #

load()方法将具有延迟加载功能，load()方法不会立即访问数据库，当试图加载的记录不存在的，load()方法可能返回一个未初始化的代理对象

get()方法总是立即访问数据库，当试图加载记录不存在时，get()方法将直接返回null

lock()跟事务处理transaction handling




# 代码示例 #

[Hello Hibernate](src/main/java/com/lun/helloworld/StoreData.java) hibernate的简单用例

[StoreData2](src/main/java/com/lun/helloworld/StoreData2.java) 不用配置文件，使用硬编码方式配置

[Formula](src/main/java/com/lun/light/mapfile/formula) 映射主键MySQL 自增 indentity, @Formula运用，formula指定该属性值没有对应的实际数据列该属性值将由系统根据表达式来生成

[Generated](src/main/java/com/lun/light/mapfile/generated) @Generated(GenerationTime.ALWAYS)表述的属性值由数据库生成（如触发器），而Hibernate会在每次插入、更新之后执行select语句来查询该属性值

映射集合属性，（集合的可以不用添加多个实体类，数据库会创建多个库）

[List](src/main/java/com/lun/light/mapfile/list) 映射List集合属性

[Array](src/main/java/com/lun/light/mapfile/array) 映射数组集合属性（同List相似）

[Set](src/main/java/com/lun/light/mapfile/set) 映射Set集合属性（无需使用list-index元素来映射集合元素的索引值）

<bag/&gt; 可映射List，Set，Collection无序集合，集合属性对应的表没有主键

[Map](src/main/java/com/lun/light/mapfile/map) 映射Map属性

## 集合属性性能分析 ##

lazy = "true",懒加载

1——N关联的1的一端通常带有**inverse="true"**,对于这种关联映射，1的一端不再控制关联关系，**所有更新操作将会在N的一端进行处理**，这种情况下使用list和bag映射属性将有较好的性能，因为我们可以在未初始化集合元素的情况下直接向bag或list添加新元素

# 有序集合映射 #

[SortedSet](src/main/java/com/lun/light/mapfile/sortedset) TreeSet的实现

[OrderBy](src/main/java/com/lun/light/mapfile/orderby) @OrderBy("training_name desc") 和 HashSet


有时候希望在映射文件中创建和删除触发器、存储过程等数据库对象、Hibernate提供<database-object/&gt;

[data-object](src/main/java/com/lun/light/mapfile/dataobject) 用<database-object/&gt; 创建触发器

SchemaExport

The SchemaExport tool writes a DDL script to standard out and/or executes the DDL statements.


CDMQ 长岛迷情 授权新用户-创建表-插入数据-查数据

>数据控制语言DCL control - grant commit
>数据定义语言DDL define - create table
>数据操纵语言DML manipulate - insert
>数据查询语言DQL Query - select

TODO:5.6还有书上没有提及的源码，稍后再跑

# 映射组件属性 #

[Person-Name](src/main/java/com/lun/light/component/componentcollection) 基本使用

组件属性的意思是：持久化类的属性并不是基本数据类型，也不是字符串，日期等标量类型的变量，而是一个复合类型的对象，在持久化的过程中，它仅仅被当作值的类型，而并非引用另一个持久化实体。

<component/&gt; @Embeddable @Parent

## 组件属性为集合 ##

如果组件类再次包括了List、Set、Map等集合属性，在<component/&gt;元素里使用<list/&gt;、<set/&gt;、<map/&gt;


[Person-Name](src/main/java/com/lun/light/component/componentcollection) component里有Map

[Person-Name-Score](src/main/java/com/lun/light/component/collectioncomponent)


## 集合属性的元素为组件 ##

<composite-element/&gt; 已弃用

## 组件作为Map的索引 ##

[map key component](src/main/java/com/lun/light/component/mapkeycomponent/Name.java)


## 组件作为符合主键 ##

[embeddedid](src/main/java/com/lun/light/component/embeddedid)

[ids](/LearnHibernate/src/main/java/com/lun/light/component/compositeid)

## 嵌套类@Embeddable、@EmbeddedId ##

[embeddedid2](src/main/java/com/lun/light/component/embeddable2)

[embedded](src/main/java/com/lun/light/component/embedded)

# 深入使用Hibernate #