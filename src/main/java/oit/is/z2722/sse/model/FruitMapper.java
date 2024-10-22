package oit.is.z2722.sse.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface FruitMapper {
  @Select("SELECT ID, NAME, PRICE FROM FRUIT")
  ArrayList<Fruit> selectAllFruit();

  @Delete("DELETE FROM FRUIT WHERE ID =#{id}")
  boolean deleteById(int id);

  @Select("select ID, NAME,PRICE from FRUIT WHERE ID = #{id}")
  Fruit selectById(int id);
}
