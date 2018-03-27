package com.legend.cloud.dao.mapper.base;

        import com.legend.cloud.entity.base.BaseType;
        import com.legend.cloud.entity.base.BaseTypeExample;
        import com.legend.module.core.dao.mapper.LegendMapper;
        import org.apache.ibatis.annotations.Mapper;
        import org.springframework.stereotype.Component;

/**
 * BaseType的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-26 22:03:53
 */
@Mapper
@Component
public interface BaseTypeMapper extends LegendMapper<BaseType> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(BaseTypeExample example);
}