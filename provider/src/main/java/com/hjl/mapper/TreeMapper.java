package com.hjl.mapper;

import com.hjl.model.Area;
import com.hjl.model.Dictionary;
import com.hjl.model.Info;
import com.hjl.model.Tree;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TreeMapper {

    @Select("select id,text,pid,href from t_oneTree where pid =#{id}")
    List<Tree> selectNodeId(Integer id);


    @Select("<script>\n" +
            "select count(1)from t_info t1,t_dictionary t2,t_dictionary t3 ,t_area t4,t_area t5 \n" +
            "where 1=1 and t1.typeId= t3.code and t3.pcode =t2.code\n" +
            " and t1.areaId=t4.areacode and t4.areacode = t5.pcode and t1.areaId2 = t5.areacode\n" +
            "<if test='name !=null and name.length >0'>\n" +
            "  and t1.name1 like concat('%',#{name},'%')\n" +
            "  </if>\n" +
            "</script>")
    Long selectCount(@Param("name")String name);

    @Select("<script>\n" +
            "select count(1)from t_info t1,t_dictionary t2,t_dictionary t3 ,t_area t4,t_area t5 \n" +
            "where 1=1 and t1.typeId= t3.code and t3.pcode =t2.code\n" +
            " and t1.areaId=t4.areacode and t4.areacode = t5.pcode and t1.areaId2 = t5.areacode\n" +
            "<if test='name !=null and name.length >0'>\n" +
            "  and t1.name1 = #{name}" +
            "  </if>\n" +
            "</script>")
    Long selectCount1(@Param("name")String name);


    @Select("<script>\n" +
            "select  id,name1,t3.areaname as jigoujibie,t4.AREANAME as sheng,t5.AREANAME as shi,handled,contacts,auditStatus \n" +
            "from t_info t1,t_dictionary t2,t_dictionary t3 ,t_area t4 ,t_area t5 where 1=1 \n" +
            "and t1.typeId= t3.code and t3.pcode =t2.code and t1.areaId=t4.areacode and t4.areacode = t5.pcode and t1.areaId2 = t5.areacode \n" +
            "  <if test='name !=null and name.length >0'>\n" +
            "  and t1.name1 like concat('%',#{name},'%')\n" +
            "  </if>\n" +
            "limit #{page},#{rows}\n" +
            "</script>")
    List<Info> selectList(@Param("page")Integer page, @Param("rows")Integer rows,@Param("name")String name);

    @Select("SELECT * from t_dictionary where pcode=2000")
    List<Dictionary> selectInfoType();

    @Select("SELECT * from t_area where pcode =#{pid}")
    List<Area> queryArea(Integer pid);


    @Select("select * from t_area where pcode=-1")
    List<Area> queryArea3();


    @Insert("INSERT into t_info\n" +
            "(\n" +
            "name1,\n" +
            "typeId,\n" +
            "areaId,\n" +
            "areaId2,\n" +
            "handled,\n" +
            "contacts,\n" +
            "phone,youbian,eamin\n" +
            ") values(#{name1},#{typeId},#{areaId},#{areaId2},#{handled},#{contacts},#{phone},#{youbian},#{eamin})")
    List<Info> saveInfo(Info info);


    @Delete("delete from t_info where id=#{id}")
    String deleteInfo(Integer id);
}
