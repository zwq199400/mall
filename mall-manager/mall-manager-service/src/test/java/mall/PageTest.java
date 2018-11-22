package mall;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.mapper.TbItemCatMapper;
import com.mall.mapper.TbItemMapper;
import com.mall.pojo.TbItem;
import com.mall.pojo.TbItemCat;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author zwq
 * @date 2018/11/21 13:53
 */
public class PageTest {


    @Test
    public void tt1(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
//        //获得Mapper的代理对象
//        TbItemCatMapper itemCatMapper = applicationContext.getBean(TbItemCatMapper.class);
//        //设置分页信息
//        PageHelper.startPage(1, 30);
//        //执行查询
//        List<TbItemCat> list = itemCatMapper.selectByParentId(1L);
//        //取分页信息
//        PageInfo<TbItemCat> pageInfo = new PageInfo<>(list);
//        System.out.println(pageInfo.getTotal());
//        System.out.println(pageInfo.getPages());
//        System.out.println(pageInfo.getPageNum());
//        System.out.println(pageInfo.getPageSize());

    }
}
