package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Brand;

import java.util.List;

public interface BrandMapper {

    List<Brand> selectAll();

    Brand selectById(int id);

/*
    方法一：
    方法二：参数为对象
    方法三：参数为Map
*/
    //List<Brand> selectByCondition(@Param("status") int status,@Param("brandName") String brandName,@Param("companyName") String companyName);

    List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByConditionSingle(Brand brand);

    void add(Brand brand);

    void update(Brand brand);

    int deleteById(int id);

    int deleteByIds(@Param("ids") int[] ids);
}
